package modelo.subastas;

import java.util.ArrayList;

import modelo.inventario.Pieza;
import modelo.usuarios.Administrador;
import modelo.usuarios.Comprador;
import modelo.usuarios.Empleado;

public class Subasta {

	/*
	 * Atributos
	 */
	
	private String fecha;
	
	private ArrayList<Comprador> compradoresVerificados;
	
	private ArrayList<Oferta> ofertas;
	
	private Empleado operador;
	
	private Administrador administrador;
	
	private ArrayList<Pieza> piezasSubasta;
	
	/*
	 * Constructor
	 */
	
	public Subasta(String fecha, Empleado operador) {
		this.fecha = fecha;
		this.operador = operador;
		operador.setSubasta(this);
	}
	
	/*
	 * Getters + Setters
	 */
	
	public String getFecha() {
		return fecha;
	}

	public ArrayList<Comprador> getCompradoresVerificados() {
		return compradoresVerificados;
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public Empleado getOperador() {
		return operador;
	}


	public ArrayList<Pieza> getPiezasSubasta() {
		return piezasSubasta;
	}
	
	
	/*
	 * Métodos
	 */
	
	public void finalizarSubasta() {

	}
		
	public void agregarComprador(Comprador comprador) {
		this.compradoresVerificados.add(comprador);
	}
	
	public void mostrarPieza(Pieza pieza) {
		for (Comprador c : compradoresVerificados) {
			c.verPieza(pieza);
		}
	
	}
}