package modelo.subastas;

import java.util.ArrayList;

import modelo.inventario.Pieza;
import modelo.perfiles.Comprador;
import modelo.perfiles.Empleado;

public class Subasta {

	/*
	 * Atributos
	 */
	
	private String fecha;
	
	private ArrayList<Comprador> compradoreVerificados;
	
	private Empleado operador;
	
	private  ArrayList<Pieza> piezasSubasta;
	
	/*
	 * Constructor
	 */
	
	public Subasta(String fecha, Empleado operador) {
		
		this.fecha = fecha;
		this.operador = operador;
	}
	

	
}
