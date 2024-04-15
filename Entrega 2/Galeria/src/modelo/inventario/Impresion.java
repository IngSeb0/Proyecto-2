package modelo.inventario;

import modelo.perfiles.Propietario;

public class Impresion extends Pieza {
	private String tipoHoja;
	private int largo;
	private int ancho;
	
	public Impresion(String titulo, String anioCreacion, String lugarCreacion, Artista artista, Propietario propietario,
			Consignacion consignacion, String tipoHoja, int largo, int ancho) {
		super(titulo, anioCreacion, lugarCreacion, artista, propietario, consignacion);
		this.tipoHoja = tipoHoja;
		this.largo = largo;
		this.ancho = ancho;
	}

	public String getTipoHoja() {
		return tipoHoja;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}
	
}