package model.inventario;

import model.ventas.Consignacion;
import model.usuarios.Comprador;

public class Fotografia extends Pieza {
	private int alto;
	private int ancho;
	private String tipoFotografia;
	private String resolucionImagen;
	
	
	public Fotografia(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion,
			String nombreArtista, int costoFijo, String tipoPieza, int alto, int ancho, String tipoFotografia,
			String resolucionImagen) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza);
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