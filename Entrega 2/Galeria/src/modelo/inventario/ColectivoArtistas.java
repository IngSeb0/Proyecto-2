package modelo.inventario;

import java.util.ArrayList;

public class ColectivoArtistas extends Artista {
	
	/* Atributos
	 * 
	 */
	
	private String nombre;
	
	private ArrayList<Artista> artistas;
	
	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	
	/* Constructor
	 * 
	 */
	
	public ColectivoArtistas(String nombre, Artista artista) {
		super(nombre);
		this.agregarArtista(artista);
		artista.agregarColectivo(this);
	}
	
	/* Getters
	 * 
	 */

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}
	
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
	
	/* Métodos
	 * 
	 */
	
	public void agregarArtista(Artista artista) {
		this.artistas.add(artista);
		setPiezas();
	
	}
	
	public void setPiezas() {
		for (Artista a : this.artistas) {
			ArrayList<Pieza> piezasArtista = a.getPiezas();
			for (Pieza p : piezasArtista) {
				this.piezas.add(p);
			}
		}
		
	}
	
}
