package modelo.inventario;

import java.util.ArrayList;

import modelo.usuarios.Propietario;

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

	public Escultura(String titulo, String fechaCreacion, String lugarCreacion, Artista artista, Propietario propietario, int alto,
			int ancho, int profundidad, int peso, ArrayList<String > materialesConstruccion, boolean electricidad, int idPieza) {
		super(idPieza, titulo, fechaCreacion, lugarCreacion, artista, propietario);
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