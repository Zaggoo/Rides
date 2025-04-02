package domain;

import javax.persistence.*;

@Entity
public class Reservation {
	
	@Override
	public String toString() {
		return "IdRide: " + idRide + "   Procesado: " + procesado + "   Estado: " + estado;
	}

	@Id
	private final int idRes;
	private static int count;
	private boolean procesado = false;
	private boolean estado;
	private int idRide;
	private String pasEmail;
	
	
	public Reservation(int idRides, String p) {
		idRes=count;
		count++;
		idRide=idRides;
		pasEmail=p;
	}
	
	public int getIdRes() {
		return idRes;
	}
	
	public int getIdRide() {
		return idRide;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}
