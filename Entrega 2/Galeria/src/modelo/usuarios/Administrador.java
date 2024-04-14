package modelo.usuarios;

import java.util.ArrayList;

import modelo.Galeria;
import modelo.inventario.Pieza;
import modelo.subastas.Oferta;
import modelo.subastas.Subasta;

public class Administrador extends Empleado {

	/*
	 * Atributos
	 */
	
	private Galeria galeria;
	
	/*
	 * Constructor 
	 */

	public Administrador(String nombre, String apellido,  String cedula, String login, String password) {
		super(nombre, apellido, cedula, login, password);
	}


	/*
	 * Gettters
	 */
	
	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}
	

	/*
	 * Métodos
	 */
	
	public void ingresarPieza(Pieza pieza) {
		galeria.getPiezas().add(pieza);
	}
	
	public void VerificarComprador(Subasta subasta, Comprador comprador, int valorMaximoCompras) {
		
		comprador.setValorMaximoCompras(valorMaximoCompras);
		subasta.agregarComprador(comprador);
		
	}
	
	public void verificarOfertasSubasta(Subasta subasta, Oferta oferta) {
		ArrayList<Oferta> ofertasSubasta = subasta.getOfertas();
		for (Oferta o : ofertasSubasta) {
			Pieza piezaOferta = o.getPieza();
			Comprador compradorOferta = o.getComprador();
			if(o.getValorOferta() >= piezaOferta.getValorMinimo() && o.getValorOferta() <= compradorOferta.getSaldoDisponible()) {
				o.aceptarOferta(true);
			}
		}
	}
	

	
	
	
	
	
	
}
