package modelo.perfiles;

import java.util.ArrayList;

import modelo.inventario.Pieza;

public class Propietario extends Perfil {

	/*
	 * Atributos
	 */



	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();

	/*
	 * Constructor
	 */

	public Propietario(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
	}

	/*
	 * Getters
	 */

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}



}