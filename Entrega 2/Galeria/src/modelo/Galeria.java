package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.inventario.Artista;
import modelo.inventario.Pieza;
import modelo.subastas.Subasta;
import modelo.usuarios.Administrador;
import modelo.usuarios.Empleado;
import modelo.ventas.Consignación;
import modelo.ventas.Venta;
import modelo.usuarios.Usuario;

public class Galeria {

	/*
	 * Atributos 
	 */
	
	private ArrayList<Consignación> consignaciones = new ArrayList<>();
    private HashMap<String, Usuario> empleados = new HashMap<>();
    private HashMap<String, Subasta> subastas = new HashMap<>();
    private ArrayList<Pieza> piezasPasadas = new ArrayList<>();
    private ArrayList<Pieza> piezasBodega = new ArrayList<>();
    private ArrayList<Pieza> piezasExhibidas = new ArrayList<>();
    private HashMap<String, HashMap<String, Pieza>> piezasInventario = new HashMap<>();
    private HashMap<String, Venta> ventas = new HashMap<>();
    private HashMap<String, Artista> artistas = new HashMap<>();
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private Administrador administrador;
    private Empleado cajero;

	
	/*
	 * Constructor
	 */
	
	public Galeria() {
		//TODO Constructor de la galeria
	}
	
	/*
	 * Getters
	 */

	public ArrayList<Consignación> getConsignaciones() {
		return consignaciones;
	}

	public void setConsignaciones(ArrayList<Consignación> consignaciones) {
		this.consignaciones = consignaciones;
	}

	public HashMap<String, Usuario> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(HashMap<String, Usuario> empleados) {
		this.empleados = empleados;
	}

	public HashMap<String, Subasta> getSubastas() {
		return subastas;
	}

	public void setSubastas(HashMap<String, Subasta> subastas) {
		this.subastas = subastas;
	}

	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}

	public void setPiezasPasadas(ArrayList<Pieza> piezasPasadas) {
		this.piezasPasadas = piezasPasadas;
	}

	public ArrayList<Pieza> getPiezasBodega() {
		return piezasBodega;
	}

	public void setPiezasBodega(ArrayList<Pieza> piezasBodega) {
		this.piezasBodega = piezasBodega;
	}

	public ArrayList<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}

	public void setPiezasExhibidas(ArrayList<Pieza> piezasExhibidas) {
		this.piezasExhibidas = piezasExhibidas;
	}

	public HashMap<String, HashMap<String, Pieza>> getPiezasInventario() {
		return piezasInventario;
	}

	public void setPiezasInventario(HashMap<String, HashMap<String, Pieza>> piezasInventario) {
		this.piezasInventario = piezasInventario;
	}

	public HashMap<String, Venta> getVentas() {
		return ventas;
	}

	public void setVentas(HashMap<String, Venta> ventas) {
		this.ventas = ventas;
	}

	public HashMap<String, Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(HashMap<String, Artista> artistas) {
		this.artistas = artistas;
	}

	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Empleado getCajero() {
		return cajero;
	}

	public void setCajero(Empleado cajero) {
		this.cajero = cajero;
	}

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
	
	
	
	

	/*
	 * Métodos
	 */
	


	

	public Pieza buscarPiezaPorId(String tipoPieza, String idPieza) {
	    // Verifica si existe el HashMap para el tipo de pieza
	    if (piezasInventario.containsKey(tipoPieza)) {
	        // Obtiene el HashMap correspondiente al tipo de pieza
	        HashMap<String, Pieza> piezasPorTipo = piezasInventario.get(tipoPieza);
	        // Busca la pieza en el HashMap usando el ID
	        return piezasPorTipo.get(idPieza);
	    }
	    return null; // Devuelve null si no se encuentra el tipo de pieza
	}
	public void guardarVenta(String idVenta, Venta venta) {
	ventas.put(idVenta , venta);
	}
}

	

	
	
