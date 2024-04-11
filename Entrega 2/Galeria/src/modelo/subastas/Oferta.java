package modelo.subastas;

import modelo.inventario.Pieza;
import modelo.perfiles.Comprador;

public class Oferta {

	/*
	 * Atributos
	 */
	
	private String fecha;
	
	private Pieza pieza;

	private int bid;
	
	private Comprador bidder;
	
	/*
	 * Constructor
	 */
	
	public Oferta(String fecha, Pieza pieza, Comprador comprador, int bid) {
		
	}

	/*
	 * Getters + Setters
	 */
	
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Pieza getPieza() {
		return pieza;
	}


	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public Comprador getBidder() {
		return bidder;
	}


	public void setBidder(Comprador bidder) {
		this.bidder = bidder;
	}
	
	
	
	
}
