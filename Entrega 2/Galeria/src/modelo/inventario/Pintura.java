package modelo.inventario;

import modelo.perfiles.Propietario;

public class Pintura extends Pieza {
	private int largo;
	private int ancho;
	
	public Pintura(String titulo, String anioCreacion, String lugarCreacion, Artista artista, Propietario propietario,
			Consignacion consignacion, int largo, int ancho) {
		super(titulo, anioCreacion, lugarCreacion, artista, propietario, consignacion);
		this.largo = largo;
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}
	
}