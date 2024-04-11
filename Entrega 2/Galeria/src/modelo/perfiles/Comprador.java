package modelo.perfiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.inventario.Pieza;
import modelo.subastas.Oferta;
import modelo.subastas.Subasta;
import modelo.ventas.MetodoPago;

public class Comprador extends Usuario {

	/*
	 * Atributos
	 */
	
	private ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	
	private MetodoPago metodoPago;
	
	private int valorMaximoCompras;
	
	private int saldoCompras;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		
	}

	/*
	 * Getters
	 */

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public int getValorMaximoCompras() {
		return valorMaximoCompras;
	}

	public void setValorMaximoCompras(int valorMaximoCompras) {
		this.valorMaximoCompras = valorMaximoCompras;
	}
	
	/*
	 * Métodos
	 */
	
	public Oferta hacerOfectar(Subasta subasta, Pieza pieza, int bid) {
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = now.format(formatter);
		
		Oferta oferta = new Oferta(fecha, pieza, this, bid);
		subasta.getOfertas().add(oferta);
		
		return oferta;
	}
	
}

