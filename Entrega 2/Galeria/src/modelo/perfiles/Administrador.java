package modelo.perfiles;

import modelo.Galeria;
import modelo.inventario.Pieza;
import modelo.subastas.Subasta;

public class Administrador extends Empleado {

	/*
	 * Atributos
	 */
	
	private Galeria galeria;
	
	
	
	/*
	 * Constructor 
	 */

	public Administrador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		// TODO Auto-generated constructor stub
	}


	/*
	 * Gettters
	 */
	

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
	

	
	
	
	
	
	
}
