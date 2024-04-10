package modelo.perfiles;

import modelo.Galeria;
import modelo.inventario.Pieza;

public class Administrador extends Perfil {

	
	/*
	 * Atributos
	 */
	
	private Galeria galeria;
	
	/*
	 * Constructor 
	 */
	
	public Administrador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
	
	}

	/*
	 * Gettters
	 */
	
	/*
	 * Métodos
	 */
	
	public void ingresarPieza(Pieza pieza) {
		galeria.getPiezas().add(pieza);
	}
	
	
	
}
