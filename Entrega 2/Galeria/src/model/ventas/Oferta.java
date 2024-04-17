package model.ventas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import model.inventario.Pieza;
import model.usuarios.Comprador;

public class Oferta {

	/*
	 * Atributos
	 */
	
	private String idOferta;
	
	private String fecha;
	
	private Pieza pieza;

	private int valorOferta;
	
	private Comprador comprador;
	
	private String peticion;

	private Subasta subasta;
	
	/*
	 * Constructor
	 */

	public Oferta(Pieza pieza, Comprador comprador, int valorOferta, String peticion) {
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = now.format(formatter);
		
        this.idOferta = UUID.randomUUID().toString();
        this.fecha = fecha;
		this.pieza = pieza;
		this.valorOferta = valorOferta;
		this.comprador = comprador;
		this.peticion = peticion;
	}


	/*
	 * Getters + Setters
	 */
	
	public String getFecha() {
		return fecha;
	}


	public Subasta getSubasta() {
		return subasta;
	}


	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}


	public String getPeticion() {
		return peticion;
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


	public String getIdOferta() {
		return idOferta;
	}
	
	
}