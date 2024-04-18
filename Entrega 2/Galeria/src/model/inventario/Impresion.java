package model.inventario;

import model.ventas.Consignacion;
import model.usuarios.Comprador;;

public class Impresion extends Pieza {
	private String tipoHoja;
	private int largo;
	private int ancho;
	
	public Impresion(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion,
			String nombreArtista, int costoFijo, String tipoPieza, String tipoHoja, int largo, int ancho) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza);
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