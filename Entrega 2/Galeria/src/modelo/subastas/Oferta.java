package modelo.subastas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import modelo.inventario.Pieza;
import modelo.usuarios.Comprador;

public class Oferta {

	/*
	 * Atributos
	 */
	
	private String fecha;
	
	private Pieza pieza;

	private int valorOferta;
	
	private Comprador comprador;
	
	private boolean aceptada;
	
	/*
	 * Constructor
	 */
	
	public Oferta(Subasta subasta, Pieza pieza, Comprador comprador, int valorOferta) {
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = now.format(formatter);
        
        this.fecha = fecha;
        this.pieza = pieza;
        this.valorOferta = valorOferta;
        this.comprador = comprador;
        subasta.getOfertas().add(this);
	}

	/*
	 * Getters + Setters
	 */
	
	public String getFecha() {
		return fecha;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public int getValorOferta() {
		return valorOferta;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public boolean esAceptada() {
		return aceptada;
	}
	
	public void aceptarOferta(boolean aceptada) {
		this.aceptada = aceptada;
	}
	
}
