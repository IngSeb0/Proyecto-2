package model.inventario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Escultura extends Pieza implements Serializable {

	/*Atributos
	 * 
	 */

	private String dimensiones;

	private String peso;

	private String materialesConstruccion;

	private boolean requiereElectricidad;

	/* Constructor
	 * 
	 */

	public Escultura(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion, String nombreArtista, int costoFijo, String tipoPieza,
			String dimensiones, String peso, String materialesConstruccion, boolean requiereElectricidad, ArrayList<HashMap<String, Object>> historia) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, historia);
		this.dimensiones = dimensiones;
		this.peso = peso;
		this.materialesConstruccion = materialesConstruccion;
		this.requiereElectricidad = requiereElectricidad;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public String getPeso() {
		return peso;
	}

	public String getMaterialesConstruccion() {
		return materialesConstruccion;
	}

	public boolean isRequiereElectricidad() {
		return requiereElectricidad;
	}

}