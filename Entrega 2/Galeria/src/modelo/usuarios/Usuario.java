package modelo.usuarios;

public abstract class Usuario {

	/*
	 * Atributos
	 */

	protected String nombre;
	
	protected String apellido;
	
	protected String cedula;
	
	protected String login;

	protected String password;

	/*
	 * Constructor
	 */

	public Usuario(String nombre, String apellido, String cedula, String login, String password) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.login = login;
		this.password = password;
	}

	/*
	 * Getters
	 */

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getApellido() {
		return apellido;
	}
}
