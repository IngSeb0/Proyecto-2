package modelo.perfiles;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.inventario.Pieza;
import modelo.subastas.Oferta;
import modelo.subastas.Subasta;
import modelo.ventas.MetodoPago;

public class Comprador extends Usuario {

	/*
	 * Atributos
	 */
	
	private ArrayList<Pieza> piezasActuales = new ArrayList<Pieza>();
	
	private ArrayList<Pieza> piezasPasadas = new ArrayList<Pieza>();
	
	private HashMap<String, String> facturas = new HashMap<String, String>();
	
	private MetodoPago metodoPagoActual;
	
	private ArrayList<MetodoPago> metodosPago;
	
	private int valorMaximoCompras;
	
	private int valorTotalCompras;
	
	private Subasta subasta;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		
	}

	/*
	 * Getters
	 */

	public ArrayList<Pieza> getPiezasActuales() {
		return piezasActuales;
	}
	
	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}
	
	public HashMap<String, String> getFacturas() {
		return facturas;
	}

	public MetodoPago getMetodoPagoActual() {
		return metodoPagoActual;
	}

	public void setMetodoPagoActual(MetodoPago metodoPago) {
		this.metodoPagoActual = metodoPago;
	}
	
	public ArrayList<MetodoPago> getMetodosPago() {
		return metodosPago;
	}

	public int getValorMaximoCompras() {
		return valorMaximoCompras;
	}

	public void setValorMaximoCompras(int valorMaximoCompras) {
		this.valorMaximoCompras = valorMaximoCompras;
	}
	
	public int getValorTotalCompras() {
		return valorTotalCompras;
	}
	
	public void setValorTotalCompras(int valorCompra) {
		this.valorTotalCompras += valorCompra;
	}
	
	/*
	 * Métodos
	 */
	
	public void hacerOfectar(Pieza pieza, int bid) {
		
		if (this.subasta != null) {
			new Oferta(subasta, pieza, this, bid);
		}
	}
	
	public void comprarPieza(Pieza pieza) {
		//TODO
	}
	
}

