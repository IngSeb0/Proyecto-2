package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.inventario.Artista;
import modelo.inventario.Pieza;
import modelo.perfiles.Perfil;
import modelo.perfiles.Usuario;

public class Galeria {

	/*
	 * Atirubutos 
	 */
	
	Map<String, Usuario> Usuarios;

	private List<Pieza> piezas;
	
	private List<Pieza> piezasBodega;
	
	private List<Pieza> piezasExhibidas;

	
	/*
	 * Constructor
	 */
	
	
	/*
	 * Getters
	 */
	
	public Galeria() {
		Usuarios = new HashMap<String,Usuario>();
		piezas = new ArrayList<Pieza>();
		piezasBodega = new ArrayList<Pieza>();
		piezasExhibidas = new ArrayList<Pieza>();
	}
	
	public Collection<Usuario> getUsuarios() {
		return Usuarios.values();
	}
	
	public Collection<Pieza> getPiezas() {
		return piezas;
	}
	
	public Collection<Pieza> getPiezasBodega() {
		return piezasBodega;
	}
	
	public Collection<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}

	
}