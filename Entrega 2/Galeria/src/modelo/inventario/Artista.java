package modelo.inventario;

import java.util.ArrayList;

public class Artista {
	
	/* Atributos
	 * 
	 */
	
	private String nombre;
	
	private ArrayList<Pieza> piezas = new ArrayList<Pieza>(); 
	
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
	
	public void agregarColectivo(ColectivoArtistas colectivo) {
		this.colectivo = colectivo;
	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
}
