package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rating {
	
	//Atributos//
	
	private static int count;
	@Id
	private int idRating;
	private String email;
	private int idRide;
	private int rating;
	private String mensaje;
	
	//Metodos//
	
	public Rating(String p_email, int p_idRide, int p_rating, String p_mensaje) {
		idRating=count;
		count++;
		email=p_email;
		idRide=p_idRide;
		mensaje=p_mensaje;
	}
	
	public Rating(String p_email, int p_idRide, int p_rating) {
		idRating=count;
		count++;
		email=p_email;
		idRide=p_idRide;
		mensaje="Sin comentario añadido";
	}
	
	@Override
	public String toString() {
		return "Valoracion por el usuario "+email+": \n Rating: "+rating+"/10 \n Comentarios: " +mensaje;  
	}
	
	public int getIdRating() {
		return idRating;
	}
	

}
