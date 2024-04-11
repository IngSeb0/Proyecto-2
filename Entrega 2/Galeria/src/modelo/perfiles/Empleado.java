package modelo.perfiles;

import modelo.inventario.Pieza;
import modelo.subastas.Oferta;
import modelo.subastas.Subasta;

public class Empleado extends Usuario {

	
	/*
	 * Atributos
	 */
	
	protected Subasta subasta;
	
	

	/*
	 * Constructor
	 */
	
	public Empleado(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
	}
	
	/*
	 * Getters
	 */
	
	public void setSubasta(Subasta subasta) {
		
	}
	

	/*
	 * Métodos
	 */
	
	public void agregarPiezaASubasta(Subasta subasta, Pieza pieza, int valorInicial, int valorMinimo) {
		
		pieza.setValorInicial(valorInicial);
		pieza.setValorMinimo(valorMinimo);
		subasta.getPiezasSubasta().add(pieza);
	}

	public void aceptarOfertaSubasta(Subasta subasta, Oferta oferta, boolean vendida) {
		if (vendida) {
		subasta.getOfertas().add(oferta);
		oferta.getPieza().venderPieza();
		} else {
			subasta.getOfertas().add(oferta);
		}
	}

}
