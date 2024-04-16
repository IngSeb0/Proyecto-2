	package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.inventario.Artista;
import modelo.inventario.Pieza;
import modelo.subastas.Subasta;
import modelo.usuarios.Administrador;
import modelo.usuarios.Empleado;
import modelo.usuarios.Usuario;

public class Galeria {

	/*
	 * Atributos 
	 */
	
	private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	private ArrayList<Artista> artistas = new ArrayList<Artista>();

	private ArrayList<Pieza> piezasInventario = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasPasadas = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();

	private HashMap<String, Subasta> subastas = new HashMap<String, Subasta>();
	
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	private Administrador administrador;
	
	
	
	/*
	 * Constructor
	 */
	
	public Galeria() {
		//TODO Constructor de la galeria
	}
	
	/*
	 * Getters
	 */
	
	public ArrayList<Artista> getArtistas() {
		return artistas;
	}
	
	
	public ArrayList<Pieza> getPiezas() {
		return piezasInventario;
	}
	
	
	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}
	
	
	public ArrayList<Pieza> getPiezasBodega() {
		return piezasBodega;
	}
	
	
	public ArrayList<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}
	
	
	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	public Usuario getAdministrador() {
		return administrador;
	}
	
	
	public void setAdminisrtrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	public Empleado getEmpleado(String numeroCedula) {
		Empleado empleado = null;
		for (Empleado e : empleados) 
		{
        	if(numeroCedula.equals(e.getCedula())) {;
        	empleado = e;
        	}
		}
		return empleado;
	}
	

	/*
	 * Métodos
	 */
	
	public Subasta crearSubasta(String fecha, Empleado operador) {
		Subasta subasta = new Subasta(fecha, operador);
		subastas.put(fecha, subasta);
		return subasta;
	}
	
	public Subasta iniciarSubasta(String fecha) {
		return subastas.get(fecha);
	}

	public void agregarUsuario(String login, Usuario usuario) {
		usuarios.put(login, usuario);
		
	}
	
	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
}
	
	
	
