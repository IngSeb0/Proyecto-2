package modelo.perfiles;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Usuario {

	/*
	 * Atributos
	 */

	private static HashMap<String, Usuario> usuarios = new HashMap<>();

	protected String nombre;
	
	protected String apellido;
	
	protected String login;

	protected String password;

	/*
	 * Constructor
	 */

	public Usuario(String nombre, String apellido, String login, String password) {

//		if (validarLogin(login)) {
//            throw new IllegalArgumentException("El usuario '" + login + "' ya está registrado. Intenta con uno diferente.");
//        }
//		 validarPassword(password);
//		 this.login = login;
//		 this.password = password;
//		 logins.add(login);
//		
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

	/*
	 * Métodos
	 */

	
}
