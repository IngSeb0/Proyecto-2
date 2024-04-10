package modelo.perfiles;

public class Comprador extends Perfil {

	/*
	 * Atributos
	 */
	
	private MetodoPago metodoPago;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password) {
		super(nombre, apellido, login, password);
		
	}
}

