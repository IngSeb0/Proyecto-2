package modelo.inventario;

import java.util.ArrayList;

public class ColectivoArtistas extends Artista {

	/* Atributos
	 * 
	 */

	private String nombreColectivo;

	private ArrayList<Artista> artistas;

	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();

	/* Constructor
	 * 
	 */
	
	public ColectivoArtistas(String nombre, String nombreColectivo, ArrayList<Artista> artistas) {
		super(nombre);
		this.nombreColectivo = nombreColectivo;
		this.artistas = artistas;
	}


	/* Getters
	 * 
	 */

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}


	/* Métodos
	 * 
	 */

	public void agregarArtista(Artista artista) {
		this.artistas.add(artista);

	}

	/*public void setPiezas() {
		for (Artista a : this.artistas) {
			ArrayList<Pieza> piezasArtista = a.getPiezas();
			for (Pieza p : piezasArtista) {
				this.piezas.add(p);
			}
		}

	}
*/
}