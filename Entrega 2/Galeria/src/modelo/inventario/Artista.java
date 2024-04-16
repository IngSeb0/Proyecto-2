package modelo.inventario;

import java.util.ArrayList;
import modelo.Galeria;

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

	
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}


	public ColectivoArtistas getColectivo() {
		return colectivo;
	}


	/* Métodos
	 * 
	 */
	
	public void agregarColectivo(ColectivoArtistas Colectivo, Galeria galeria) {

	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}

}
