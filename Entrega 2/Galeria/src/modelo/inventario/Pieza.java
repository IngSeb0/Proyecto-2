package modelo.inventario;

import java.util.ArrayList;

import modelo.perfiles.Propietario;

public abstract class Pieza {
	
	protected int id;
	
	protected String titulo;
	
	protected String fechaCreacion;
	
	protected String lugarCreacion;
	
	protected boolean disponibilidad;
	
	protected int costo;
	
	protected ArrayList<Artista> artista;
	
	protected Propietario propietario;
	
	
	/*
	 * Constructor 
	 */
	
	public Pieza(String titulo, String fechaCreacion, String lugarCreacion, Artista artista, Propietario propietario) {
		
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.lugarCreacion = lugarCreacion;
		this.propietario = propietario;
		this.artista.add(artista);
		if (artista instanceof ColectivoArtistas) {
			ArrayList<Artista> artistasColectivo = artista.getColectivo().getArtistas();
			for (Artista a : artistasColectivo) {
				this.artista.add(a);
			}
		} 
	
	}
	
	

}
