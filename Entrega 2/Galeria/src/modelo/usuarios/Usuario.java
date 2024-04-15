package modelo.usuarios;

public class Usuario {

	/*
	 * Atributos
	 */

	protected String nombre;
	
	protected String apellido;
	
	protected String cedula;
	
	protected String login;

	protected String password;

	protected String tipoUsuario;

	/*
	 * Constructor
	 */

	public Usuario(String nombre, String apellido, String cedula, String login, String password, String tipoUsuario) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.login = login;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
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
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
}
