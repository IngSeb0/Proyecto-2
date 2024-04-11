package modelo.ventas;

import modelo.inventario.Pieza;
import modelo.perfiles.Administrador;
import modelo.perfiles.Comprador;

public class Venta {
	
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
	
	public Venta(Administrador administrador, Pieza pieza) {
		
	}

}
