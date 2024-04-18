package model.usuarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

import model.inventario.Pieza;
import model.ventas.Consignacion;
import model.ventas.Oferta;
import model.ventas.Subasta;
import model.ventas.Venta;
import view.ViewComprador;

public class Comprador extends Usuario {

	/*
	 * Atributos
	 */
	
	private ArrayList<Pieza> piezasActuales = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasPasadas = new ArrayList<Pieza>();
	
//	private HashMap<String, String> facturas = new HashMap<String, String>();
	
	private int valorMaximoCompras;
	
	private int totalComprasRealizadas;
	
	private int saldoDisponible;
	
	private Subasta subastaEnCurso;
	
	private Pieza piezaSubastaEnCurso;
	
	private ArrayList<Consignacion> consignaciones = new  ArrayList<Consignacion>();
	
	private ArrayList<Oferta> ofertasPendientes = new  ArrayList<Oferta>();
	
	/*
	 * Views
	 */
	
	private ViewComprador viewComprador;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido,  String cedula ,String login, String password, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
	}

	/*
	 * Getters + Setters
	 */

	public ArrayList<Pieza> getPiezasActuales() {
		return piezasActuales;
	}
	
	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}
	
//	public HashMap<String, String> getFacturas() {
//		return facturas;
//	}
	
	public int getValorMaximoCompras() {
		return valorMaximoCompras;
	}

	public void setValorMaximoCompras(int valorMaximoCompras) {
		this.valorMaximoCompras = valorMaximoCompras;
	}
	
	public int getTotalComprasRealizadas() {
		return totalComprasRealizadas;
	}
	
	public void setgetTotalComprasRealizadas(int valorCompra) {
		this.totalComprasRealizadas += valorCompra;
	}
	
	public void setPiezaSubastaEnCurso(Pieza pieza) {
		this.piezaSubastaEnCurso = pieza;
	}
	
	public Pieza getPiezaSubastaEnCurso() {
		return piezaSubastaEnCurso;
	}
	
	public int getSaldoDisponible() {
		return saldoDisponible;
	}
	
	public void setSaldoDisponible() {
		int valorMaximoCompras = getValorMaximoCompras();
		int totalComprasRealizadas = getTotalComprasRealizadas();
		this.saldoDisponible = valorMaximoCompras - totalComprasRealizadas;
	}
	
	
	public Subasta getSubastaEnCurso() {
		return subastaEnCurso;
	}

	public void setSubastaEnCurso(Subasta subastaEnCurso) {
		this.subastaEnCurso = subastaEnCurso;
	}
	
	

	public ViewComprador getViewComprador() {
		return viewComprador;
	}

	public void setViewComprador(ViewComprador viewComprador) {
		this.viewComprador = viewComprador;
	}
	
	
	public ArrayList<Oferta> getOfertasPendientes() {
		return ofertasPendientes;
	}

	/*
	 * Métodos
	 */

	public void comprarPieza(String tipoPieza, String idPieza, int valorOferta, String peticion, String metodoPago) {
		Pieza pieza = galeria.getPiezaPorID(tipoPieza, idPieza);
		Oferta oferta = new Oferta(pieza, this, valorOferta, peticion, metodoPago);
		if (peticion != null) {
			galeria.getAdminstrador().getOfertasARevisar().put(oferta.getIdOferta(), oferta);
		} else {
			galeria.getCajero().getOfertasAceptadas().add(oferta);
		}
	}
	
	public void hacerOfertaSubasta(int valorOferta, String metodoPago) {
		Pieza pieza = getPiezaSubastaEnCurso();
		String peticion = null;
		Oferta oferta = new Oferta(pieza, this, valorOferta, peticion, metodoPago);
		getSubastaEnCurso().addOferta(oferta);
		ofertasPendientes.add(oferta);
	}
	
}

