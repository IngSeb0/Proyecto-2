package model.inventario;

import java.util.ArrayList;

import model.inventario.Pieza;

public class Artista {

	/* 
	 * Atributos
	 */

	protected String nombre;

	protected ArrayList<Pieza> piezas = new ArrayList<Pieza>(); 

	private ColectivoArtistas colectivo;

	/* 
	 * Constructor
	 */

	public Artista(String nombre) {
		this.nombre = nombre;
	}

	/* 
	 * Getters
	 */

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public ColectivoArtistas getColectivo() {
		return colectivo;
	}

	/* Métodos
	 * 
	 */

	public void agregarColectivo(ColectivoArtistas colectivo) {
		this.colectivo = colectivo;
	}

	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
}