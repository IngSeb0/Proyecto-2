package model
.usuarios;

import java.util.ArrayList;

import model.Galeria;
import model.ventas.Oferta;
import model.ventas.Venta;
import view.ViewCajero;


public class Cajero extends Empleado {
	
	private Galeria galeria;
	
	private ArrayList<Oferta> OfertasAceptadas;
	
	private ViewCajero viewCajero;
	
	

	public Cajero(String nombre, String apellido, String login, String password, String cedula, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
		// TODO Auto-generated constructor stub
	}

	
	public Galeria getGaleria() {
		return galeria;
	}


	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}


	public ArrayList<Oferta> getOfertasAceptadas() {
		return OfertasAceptadas;
	}


	public void setVentas(ArrayList<Oferta> ventas) {
		this.OfertasAceptadas= ventas;
	}


	public ViewCajero getViewCajero() {
		return viewCajero;
	}


	public void setViewCajero(ViewCajero viewCajero) {
		this.viewCajero = viewCajero;
	}

	public void verOfertasAceptadas() {
	    
	    System.out.println("Ofertas Aceptadas:");
	    for (Oferta oferta : OfertasAceptadas) {
	        System.out.println("ID: " + oferta.getIdOferta() + ", Monto: " + oferta.getValorOferta() + ", Fecha: " + oferta.getFecha());
	        // Ajusta las propiedades de la oferta según corresponda
	    }
	    
	}
	public void registrarVenta(String idVenta, Venta venta) {
		galeria.guardarVenta(idVenta,  venta);
	}
	
	
	
}