package model
.usuarios;

import java.util.ArrayList;

import model.Galeria;
import model.ventas.Oferta;
import model.ventas.Venta;
import view.ViewCajero;


public class Cajero extends Empleado {
	
	private ArrayList<Oferta> ofertasAceptadas;
	
	private ViewCajero viewCajero;
	private Galeria galeria;
	
	/*
	 * Constructor
	 */

	public Cajero(String nombre, String apellido, String login, String password, String cedula, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Getters + Setters
	 */
	
	public Galeria getGaleria() {
		return galeria;
	}


	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}


	public ArrayList<Oferta> getOfertasAceptadas() {
		return ofertasAceptadas;
	}


	public void setVentas(ArrayList<Oferta> ventas) {
		this.ofertasAceptadas= ventas;
	}


	public ViewCajero getViewCajero() {
		return viewCajero;
	}


	public void setViewCajero(ViewCajero viewCajero) {
		this.viewCajero = viewCajero;
	}

	/*
	 * Métodos
	 */
	
	public void registrarVentas() {
		for (Oferta o : ofertasAceptadas) {
			Venta venta = new Venta(o);
			galeria.guardarVenta(venta.getIdVenta(), venta);
		}
	}
	

	
	
	
}