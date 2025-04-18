package gui.Driver;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Driver;
import domain.Passenger;
import gui.MainGUI;

import javax.swing.JLabel;
import javax.swing.JButton;

public class DriverGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public DriverGUI(Driver conductor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel(conductor.getName());
		lblNombre.setBounds(237, 10, 166, 25);
		contentPane.add(lblNombre);
		
		JButton btnCreatedRides = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DriverGUI.MyCreatedRides"));
		btnCreatedRides.setBounds(218, 57, 185, 75);
		contentPane.add(btnCreatedRides);
		
		JButton btnCrear = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DriverGUI.CreateRide"));
		btnCrear.setBounds(23, 57, 185, 75);
		contentPane.add(btnCrear);
		
		JButton btnViewReservations = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DriverGUI.ViewReservations"));
		btnViewReservations.setBounds(218, 133, 185, 75);
		contentPane.add(btnViewReservations);
		
		JButton btnHistorial = new JButton(ResourceBundle.getBundle("Etiquetas").getString("DriverGUI.Historial")); //$NON-NLS-1$ //$NON-NLS-2$
		btnHistorial.setBounds(23, 133, 185, 75);
		contentPane.add(btnHistorial);
		BLFacade facade = MainGUI.getBusinessLogic();
		
		btnCreatedRides.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				JFrame a = new MyCreatedRidesGUI(conductor);
				a.setVisible(true);
			
			}

			
		});
		
		btnCrear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				JFrame a = new CreateRideGUI(conductor);
				a.setVisible(true);
				
			}

			
		});
	
		btnViewReservations.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				JFrame a = new ReservedRidesDriverGUI(conductor);
				a.setVisible(true);
				
			}

			
		});
		
		btnHistorial.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				JFrame a = new HistorialGUI(conductor);
				a.setVisible(true);
				
			}

			
		});
		
	}
}
