package modelo.inventario;

import java.util.ArrayList;

public class Artista {

	/* Atributos
	 * 
	 */

	protected String nombre;

	protected ArrayList<Pieza> piezas = new ArrayList<Pieza>(); 

	private ColectivoArtistas colectivo;

	/* Constructor
	 * 
	 */

	public Artista(String nombre) {

		if (nombre != null) {
			this.nombre = nombre;
		} else {
			nombre = "Anónimo";
			//TODO	
			//Diferencia un anónimo de otro	
		}

	}

	/* Getters
	 * 
	 */

	public String getNombre() {
		return nombre;
	}


	public ColectivoArtistas getColectivo() {
		return colectivo;
	}

	/* Métodos
	 * 
	 */

}