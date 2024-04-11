package modelo.perfiles;
import modelo.inventario.Pieza;

public class Comprador extends Perfil {

	/*
	 * Atributos
	 */
	
	private String metodoPago;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		
	}
	 public void comprar(Administrador administrador, Pieza pieza, String fecha) {
	        pieza.vender(administrador, this, fecha);
	    }
}

