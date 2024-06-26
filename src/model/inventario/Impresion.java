package model.inventario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Impresion extends Pieza implements Serializable {
	private String tipoHoja;
	private int largo;
	private int ancho;
	
	public Impresion(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion,
			String nombreArtista, int costoFijo, String tipoPieza, String tipoHoja, int largo, int ancho,ArrayList<HashMap<String, Object>> historia) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, historia);
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
