package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.inventario.Artista;
import modelo.inventario.Pieza;
import modelo.perfiles.Perfil;

public class Galeria {

	/*
	 * Atirubutos 
	 */
	
	private ArrayList<Artista> artistas = new ArrayList<Artista>();

	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();

	private HashMap<String, Perfil> perfiles = new HashMap<String, Perfil>();
	
	
	
	/*
	 * Constructor
	 */
	
	
	/*
	 * Getters
	 */
	
	public Galeria() {
		//TODO Constructor de la galeria
	}
	
	public ArrayList<Artista> getArtistas() {
		return artistas;
	}
	
	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}
	
	public ArrayList<Pieza> getPiezasBodega() {
		return piezasBodega;
	}
	
	public ArrayList<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}
	
	public HashMap<String, Perfil> getPerfiles() {
		return perfiles;
	}
	
	
}