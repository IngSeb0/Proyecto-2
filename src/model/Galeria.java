package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import model.inventario.Artista;
import model.inventario.Pieza;
import model.persistencia.CentralPersistencia;
import model.usuarios.Administrador;
import model.usuarios.Cajero;
import model.usuarios.Empleado;
import model.usuarios.Usuario;
import model.ventas.Consignacion;
import model.ventas.Subasta;
import model.ventas.Venta;
import view.ViewEmpleado;
import view.ViewLogin;
import view.ViewRegistro;


public class Galeria implements Serializable{
	
	/*
	 * Usuarios 
	 */
	
	private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	private Administrador administrador;
	
	private Cajero cajero;
	
	private HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();
	
	private ArrayList<Empleado> empleadosDisponibles = new ArrayList<Empleado>();
	
	/*
	 * Inventario
	 */
	
	private HashMap<String, HashMap<String, Pieza>> piezasInventario = new HashMap<>();
	
	private ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();

	private ArrayList<Pieza> piezasPasadas = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasDisponibles = new ArrayList<Pieza>();
	
	private HashMap<String, Artista> artistas = new HashMap<String, Artista>();
	
	/*
	 * Ventas
	 */
	
	private HashMap<String, Subasta> subastas = new HashMap<String, Subasta>();

	private HashMap<String, Venta> ventas = new HashMap<String, Venta>();
	
	private ArrayList<Consignacion> consignaciones = new ArrayList<Consignacion>();
	
	/*
	 * Persistencia
	 */
	
	private CentralPersistencia centralPersistencia = new CentralPersistencia();
	
	/*
	 * Views
	 */
	
	private ViewRegistro viewRegistro;
	
	private ViewLogin viewLogin;
	
	/*
	 * Constructor
	 */
	
	public static void main(String[] args) {
		
		Galeria galeria = new Galeria(true);
	}
	
	public Galeria(boolean mostrarView) {
	
	    if (centralPersistencia.getGaleria() != null) {
	        if (mostrarView) {
	            viewLogin.mostrarMenu();
	        }
	    } else {
	        piezasInventario.put("Escultura", (new HashMap<String, Pieza>()));
	        piezasInventario.put("Pintura", (new HashMap<String, Pieza>()));
	        piezasInventario.put("Impresión", (new HashMap<String, Pieza>()));
	        piezasInventario.put("Fotografía", (new HashMap<String, Pieza>()));
	        piezasInventario.put("Vídeos", (new HashMap<String, Pieza>()));
	        ViewLogin viewLogin = new ViewLogin(this);
	        setViewLogin(viewLogin);
	        ViewRegistro viewRegistro = new ViewRegistro(this);
	        setViewRegistro(viewRegistro);
	        if (mostrarView) {
	            viewRegistro.mostrarMenuUsuario("Administrador");
	        }
	    }
	}

	
	/*
	 * Getters + Setters
	 */

	// Usuarios
	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario(String login) {
		Usuario usuario = usuarios.get(login);
		return usuario;
	}

	public void addUsuario(Usuario usuario) { 
		this.usuarios.put(usuario.getLogin(), usuario);
		//TODO Guardar usuarios
//		centralPersistencia.guardarUsuarios();
	}

	// Administrador
	public Administrador getAdminstrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	
		addUsuario(administrador);
	}

	// Cajero
	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	// Empleados
	public HashMap<String, Empleado> getEmpleados() {
		return empleados;
	}

	public void addEmpleado(Empleado empleado) {
		ViewEmpleado viewEmpleado = new ViewEmpleado(empleado);
		empleado.setViewEmpleado(viewEmpleado);
		empleado.setGaleria(this);
		this.empleados.put(empleado.getCedula(), empleado);
		empleadosDisponibles.add(empleado);
		addUsuario(empleado);
//		centralPersistencia.guardarUsuarios();
	}
	
	public Empleado getEmpleado(String numeroCedula) {
		Empleado empleado = empleados.get(numeroCedula);
		return empleado;
	}

	
	public ArrayList<Empleado> getEmpleadosDisponibles() {
		return empleadosDisponibles;
	}

	// Piezas inventario
	public Pieza getPiezaPorID(String tipoPieza, String idPieza) {
        if (piezasInventario.containsKey(tipoPieza)) {
        	
            HashMap<String, Pieza> piezasPorTipo = piezasInventario.get(tipoPieza);
            return piezasPorTipo.get(idPieza);
        }
        return null;
    }
	
	public HashMap<String, HashMap<String, Pieza>> getPiezasInventario() {
		return piezasInventario;
	}
	
	public void setPiezasInventario(HashMap<String, HashMap<String, Pieza>> piezasInventario) {
		this.piezasInventario = piezasInventario;
	}

	public ArrayList<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}

	public void setPiezasExhibidas(ArrayList<Pieza> piezasExhibidas) {
		this.piezasExhibidas = piezasExhibidas;
	}

	public ArrayList<Pieza> getPiezasBodega() {
		return piezasBodega;
	}

	public void setPiezasBodega(ArrayList<Pieza> piezasBodega) {
		this.piezasBodega = piezasBodega;
	}

	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}

	public void setPiezasPasadas(ArrayList<Pieza> piezasPasadas) {
		this.piezasPasadas = piezasPasadas;
	}
	

	public ArrayList<Pieza> getPiezasDisponibles() {
		return piezasDisponibles;
	}

	public void addPiezasDisponibles(Pieza pieza) {
		this.piezasDisponibles.add(pieza);
	}

	public HashMap<String, Artista> getArtistas() {
		return artistas;
	}

	public void addArtista(Artista artista) {
		this.artistas.put(artista.getNombre(), artista);
	}
	
	public Artista getArtista(String nombreArtista) {
		return artistas.get(nombreArtista);
	}

	public HashMap<String, Subasta> getSubastas() {
		return subastas;
	}

	public HashMap<String, Venta> getVentas() {
		return ventas;
	}

	public void setVentas(HashMap<String, Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Consignacion> getConsignaciones() {
		return consignaciones;
	}

	public void setConsignaciones(ArrayList<Consignacion> consignaciones) {
		this.consignaciones = consignaciones;
	}

	public CentralPersistencia getCentralPersistencia() {
		return centralPersistencia;
	}

	public void setCentralPersistencia(CentralPersistencia centralPersistencia) {
		this.centralPersistencia = centralPersistencia;
	}

	public ViewRegistro getViewRegistro() {
		return viewRegistro;
	}

	public void setViewRegistro(ViewRegistro viewRegistro) {
		this.viewRegistro = viewRegistro;
	}
	
	public ViewLogin getViewLogin() {
		return viewLogin;
	}

	public void setViewLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;
	}
	
	/*
	 * Métodos
	 */
	
	public void crearSubasta(String fecha, Empleado empleado) {
		Subasta subasta = new Subasta(fecha, empleado, this.getAdminstrador());
		subastas.put(fecha, subasta);
	}
	
	public void guardarVenta(String idVenta, Venta venta) {
		ventas.put(idVenta , venta);
	}
	
	public String generarLogin(String nombre, String apellido) {
		String login = nombre.substring(0,1).toLowerCase() + "." + apellido.toLowerCase();
		int i = 1;
		while (usuarios.containsKey(login)) {
				login = login + String.valueOf(i);
				i++;
			}
		return login;
	}
	
	public String generarPassword() {
		
		Random random = new Random();
		
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minisculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&*";

        char first = mayusculas.charAt(random.nextInt(mayusculas.length()));
        char second = minisculas.charAt(random.nextInt(minisculas.length()));
        char third = minisculas.charAt(random.nextInt(minisculas.length()));
        char fourth = numeros.charAt(random.nextInt(numeros.length()));
        char fifth = simbolos.charAt(random.nextInt(simbolos.length()));

        String password = "" + first + second + third + fourth + fifth;
		return password;
	}
	

	public void registrarHistoriaPieza(String idPieza, String comprador, int precioVenta, String tipoPieza) {
	    Pieza pieza = getPiezaPorID(tipoPieza, idPieza);
	    if (pieza != null) {
	        ArrayList<HashMap<String, Object>> historia = pieza.getHistoria();
	        if (historia == null) {
	            historia = new ArrayList<>();
	        }
	        
	        // Crear un nuevo registro para la historia de la pieza vendida
	        HashMap<String, Object> registro = new HashMap<>();
	        registro.put("comprador", comprador);
	        registro.put("precioVenta", precioVenta);
	        registro.put("fechaVenta", LocalDate.now().toString()); // Obtener la fecha actual
	        
	        // Agregar el registro a la historia de la pieza
	        historia.add(registro);
	        
	        // Actualizar la historia en la pieza
	        pieza.setHistoria(historia);
	    }
	}


    
	
}