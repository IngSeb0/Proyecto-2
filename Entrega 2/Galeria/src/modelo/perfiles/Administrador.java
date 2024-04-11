package modelo.perfiles;

import modelo.Galeria;
import modelo.inventario.Pieza;

public class Administrador extends Empleado {

	
	/*
	 * Atributos
	 */
	
	private Galeria galeria;
	
	private Perfil perfil;
	
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
