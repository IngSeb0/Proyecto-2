package model.inventario;
import java.util.ArrayList;
import java.util.HashMap;
public class Pintura extends Pieza {
	private int largo;
	private int ancho;
	
	public Pintura(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion,
			String nombreArtista, int costoFijo, String tipoPieza, int largo, int ancho, ArrayList<HashMap<String, Object>> historia) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza,historia );
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