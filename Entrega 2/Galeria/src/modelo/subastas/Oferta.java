package modelo.subastas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	public Oferta(Subasta subasta, Pieza pieza, Comprador comprador, int bid) {
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = now.format(formatter);
        
        this.fecha = fecha;
        this.pieza = pieza;
        this.bid = bid;
        this.bidder = comprador;
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

	public int getBid() {
		return bid;
	}

	public Comprador getBidder() {
		return bidder;
	}

}
