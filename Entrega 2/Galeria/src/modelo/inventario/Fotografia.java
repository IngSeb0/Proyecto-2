package modelo.inventario;

import modelo.perfiles.Propietario;

public class Fotografia extends Pieza {
	private int alto;
	private int ancho;
	private String tipoFotografia;
	private String resolucionImagen;
	
	public Fotografia(String titulo, String anioCreacion, String lugarCreacion, Artista artista,
			Propietario propietario, Consignacion consignacion, int alto, int ancho, String tipoFotografia,
			String resolucionImagen) {
		super(titulo, anioCreacion, lugarCreacion, artista, propietario, consignacion);
		this.alto = alto;
		this.ancho = ancho;
		this.tipoFotografia = tipoFotografia;
		this.resolucionImagen = resolucionImagen;
	}
	public int getAlto() {
		return alto;
	}
	public int getAncho() {
		return ancho;
	}
	public String getTipoFotografia() {
		return tipoFotografia;
	}
	public String getResolucionImagen() {
		return resolucionImagen;
	}

}