package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.inventario.Artista;
import modelo.inventario.Consignacion;
import modelo.inventario.Pieza;
import modelo.perfiles.Administrador;
import modelo.perfiles.Empleado;
import modelo.perfiles.Perfil;
import modelo.perfiles.Usuario;
import modelo.subastas.Subasta;
import modelo.ventas.Venta;

public class Galeria {

	/*
	 * Atirubutos 
	 */
	
	private Map<String, Usuario> Usuarios;

	private List<Pieza> piezasInventario;
	
	private List<Pieza> piezasBodega;
	
	private List<Pieza> piezasExhibidas;
	
	private List<Pieza> piezasPasadas;
	
	private List<Consignacion>consignaciones;
	
	private List<Usuario>empleados;
	
	private Administrador administrador;
	
	private Empleado cajero;//
	
	private List<Subasta> subastas;
	
	private List<Venta> ventas;
	
	private List<Artista> artistas;
	
	private List<Artista> colectivos;

	
	/*
	 * Constructor
	 */
	
	
	/*
	 * Getters
	 */
	
	public Galeria() {
		Usuarios = new HashMap<String,Usuario>();
		piezasInventario = new ArrayList<Pieza>();
		piezasBodega = new ArrayList<Pieza>();
		piezasExhibidas = new ArrayList<Pieza>();
		piezasPasadas=new ArrayList<Pieza>();
		consignaciones= new ArrayList<Consignacion>();
		empleados= new ArrayList<Usuario>();
		subastas= new ArrayList<Subasta>();
		ventas=new ArrayList<Venta>();
		artistas=new ArrayList<Artista>();
		colectivos=new ArrayList<Artista>();
		administrador=new Administrador(null, null, null, null);
		
	}
	
	public Collection<Usuario> getUsuarios() {
		return Usuarios.values();
	}
	
	public Collection<Pieza> getPiezas() {
		return piezasInventario;
	}
	
	public Collection<Pieza> getPiezasBodega() {
		return piezasBodega;
	}
	
	public Collection<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}

	
}