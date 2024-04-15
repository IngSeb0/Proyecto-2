package modelo.inventario;

import java.util.ArrayList;

import modelo.perfiles.Propietario;

public class Escultura extends Pieza {

	/*Atributos
	 * 
	 */

	private int alto;

	private int ancho;

	private int profundidad;

	private int peso;

	private ArrayList<String > materialesConstruccion = new ArrayList<String>();

	private boolean electricidad;

	/* Constructor
	 * 
	 */
	public Escultura(String titulo, String anioCreacion, String lugarCreacion, Artista artista, Propietario propietario,
			Consignacion consignacion, int alto, int ancho, int profundidad, int peso,
			ArrayList<String> materialesConstruccion, boolean electricidad) {
		super(titulo, anioCreacion, lugarCreacion, artista, propietario, consignacion);
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.peso = peso;
		this.materialesConstruccion = materialesConstruccion;
		this.electricidad = electricidad;
	}


	/* Getters
	 * 
	 */

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public int getPeso() {
		return peso;
	}

	public ArrayList<String> getMaterialesConstruccion() {
		return materialesConstruccion;
	}

	public boolean isElectricidad() {
		return electricidad;
	}

}