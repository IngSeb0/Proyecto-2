package modelo.ventas;

import modelo.inventario.Pieza;
import modelo.perfiles.Administrador;
import modelo.perfiles.Comprador;

public class Venta implements Factura {
	
	/*
	 * Atributos
	 */
	
	private int idFactura;

	private Pieza pieza;
	
	private Comprador comprador;
	
	private String fecha;
	
	/*
	 * Constructor
	 */
	
	public Venta(Pieza pieza, Comprador comprador, String fecha) {
		
		this.pieza = pieza;
		this.comprador = comprador;
		this.fecha = fecha;
	}
	
	
	
	

}
