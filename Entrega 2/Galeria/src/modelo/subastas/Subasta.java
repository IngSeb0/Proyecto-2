package modelo.subastas;

import java.util.ArrayList;

import modelo.inventario.Pieza;
import modelo.perfiles.Administrador;
import modelo.perfiles.Comprador;
import modelo.perfiles.Empleado;

public class Subasta {

	/*
	 * Atributos
	 */
	
	private String fecha;
	
	private ArrayList<Comprador> compradoresVerificados;
	
	private ArrayList<Oferta> ofertas;
	
	private Empleado operador;
	
	private Administrador Administrador;
	
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
		
		for (Pieza p : piezasSubasta) {
			p.setValorMinimo(0);
			p.setValorInicial(0);
		}
		this.operador.setSubasta(null);
	}
		
	public void agregarComprador(Subasta subasta, Comprador comprador) {
		this.compradoresVerificados.add(comprador);
	}

	
}