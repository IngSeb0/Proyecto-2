package model.ventas;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.inventario.Pieza;
import model.usuarios.Administrador;
import model.usuarios.Comprador;
import model.usuarios.Empleado;

public class Subasta {
	
	private String fecha;
	
	private Administrador administrador;
	
	private Empleado operador;
	
	private ArrayList<Comprador> compradoresVerificados = new ArrayList<Comprador>();
	
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	private ArrayList<Pieza> piezasSubasta = new ArrayList<Pieza>();
	
	/*
	 * Constructor
	 */
	
	public Subasta(String fecha, Empleado operador, Administrador administrador) {
		
		this.fecha = fecha;
		this.operador = operador;
		this.administrador = administrador;
	}

	/*
	 * Getters + Setters
	 */
	
	
	public String getFecha() {
		return fecha;
	}

	public Empleado getOperador() {
		return operador;
	}

	public ArrayList<Comprador> getCompradoresVerificados() {
		return compradoresVerificados;
	}

	public void addCompradorVerificado(Comprador comprador) {
		this.compradoresVerificados.add(comprador);
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void addOferta(Oferta oferta) {
		this.ofertas.add(oferta);
		mostrarPieza(oferta.getPieza(), oferta.getValorOferta());
	}

	public ArrayList<Pieza> getPiezasSubasta() {
		return piezasSubasta;
	}

	public void addPiezasSubasta(Pieza pieza) {
		this.piezasSubasta.add(pieza);
	}
	
	/*
	 * Métodos
	 */

	public void iniciarSubasta() {
	    operador.setSubastaEnCurso(this);
	    for (Comprador c : compradoresVerificados) {
	        c.setSubastaEnCurso(this);
	    }
	    long delay = 5;
	        for (Pieza p : piezasSubasta) {
	        	mostrarPieza(p, p.getValorMinimo());
	            try {
	                TimeUnit.MINUTES.sleep(delay);
	            } catch (InterruptedException e) {
	            	return;
	            }
	        }
	}
	
	
	public void mostrarPieza(Pieza pieza, int valorOfertaActual) {
	    pieza.setValorActualSubasta(valorOfertaActual);
		for (Comprador c : compradoresVerificados) {
	    	c.setPiezaSubastaEnCurso(pieza);
	    }
	}
	
	
	public void finalizarSubasta() {
		operador.registrarOfertasSubasta();
        operador.setSubastaEnCurso(null);
        for (Comprador c : compradoresVerificados) {
            c.setSubastaEnCurso(null);
        }
//    administrador.getGaleria().guardarSubasta();
    }
	
	
	
	
	
}
	
	
	

