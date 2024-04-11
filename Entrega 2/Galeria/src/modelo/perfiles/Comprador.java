package modelo.perfiles;

import java.util.ArrayList;

import modelo.inventario.Pieza;
import modelo.ventas.MetodoPago;

public class Comprador extends Usuario {

	/*
	 * Atributos
	 */
	
	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	
	private MetodoPago metodoPago;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		
	}

	/*
	 * Getters
	 */

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
}

