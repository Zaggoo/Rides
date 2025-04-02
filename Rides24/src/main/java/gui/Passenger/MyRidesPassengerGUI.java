package gui.Passenger;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Driver;
import domain.Passenger;
import domain.Reservation;
import domain.Ride;
import gui.MainGUI;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class MyRidesPassengerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public MyRidesPassengerGUI(Passenger pasajero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(34, 43, 376, 151);
		contentPane.add(list);
		DefaultListModel rides = new DefaultListModel();
		list.setModel(rides);
		
		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
		
		btnClose.setBounds(231, 200, 119, 33);
		contentPane.add(btnClose);
		
		BLFacade facade = MainGUI.getBusinessLogic();
		
		List<Ride> viajes = facade.acceptedReservation(pasajero.getEmail());
		
		for (Ride aux : viajes) {
			rides.addElement(aux);
		}
		
		
		JButton btnCancelar = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MyRidesPassengerGUI.Cancelar")); //$NON-NLS-1$ //$NON-NLS-2$
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(85, 200, 119, 33);
		contentPane.add(btnCancelar);
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClose_actionPerformed(e);
				}
			});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ride aux= (Ride) list.getSelectedValue();
				Calendar currentCalendar = Calendar.getInstance();
				currentCalendar.add(Calendar.DAY_OF_YEAR, 7);
				Calendar rideDate = Calendar.getInstance();
				rideDate.setTime(aux.getDate());
				if(rideDate.after(currentCalendar)) {
					facade.eraseReservation(pasajero.getEmail(),aux);
					actualizarLista(viajes,rides,pasajero, facade);
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido cancelar la reserva, viaje demasiado próximo");
				}
			}
		});
		
		
		
		
	}
	private void actualizarLista(List<Ride> viajes, DefaultListModel rides, Passenger pasajero, BLFacade facade) {
		rides.removeAllElements();
		viajes= facade.acceptedReservation(pasajero.getEmail());
		for(Ride aux:viajes) {
			rides.addElement(aux);
		}
	}
	private void btnClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
