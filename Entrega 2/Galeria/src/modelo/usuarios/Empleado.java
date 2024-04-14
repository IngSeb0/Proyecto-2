package modelo.usuarios;

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
	
	public Empleado(String nombre, String apellido,  String cedula, String login, String password) {
		super(nombre, apellido, cedula, login, password);
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

	public void registrarOfertaSubasta(Subasta subasta, Oferta oferta) {
		subasta.getOfertas().add(oferta);
	}

}
