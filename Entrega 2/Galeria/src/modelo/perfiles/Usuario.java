package modelo.perfiles;

import java.util.ArrayList;

public abstract class Usuario {

	/*
	 * Atributos
	 */
	
	private static ArrayList<String> logins;

	protected String nombre;
	
	protected String apellido;
	
	protected String login;

	protected String password;

	/*
	 * Constructor
	 */

	public Usuario(String nombre, String apellido, String login, String password) {
		
		if (validarLogin(login)) {
            throw new IllegalArgumentException("El usuario " + login + "ya está registrado. Intenta con uno difente");
		}
		
		validarPassword(password);
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
		this.password = password;
		
		logins.add(login);
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
	
	public String getApellido() {
		return nombre;
	}
	
	/*
	 * Métodos
	 */

	public static boolean validarLogin(String login) {
		boolean present = false;
    	if (logins.contains(login)) {
    		present = true;
    	}
    	return present;
    }

	public static void validarPassword(String password) {

		String mayusculaRegex = ".*[A-Z].*";
        String simboloRegex = ".*[!@#$%^&*()].*";
        String numeroRegex = ".*\\d.*";

        if (!(password.matches(mayusculaRegex))) {
			throw new IllegalArgumentException("La contraseña debe contener al menos una mayúscula");
		} 
		else if (!(password.matches(simboloRegex))) {
			throw new IllegalArgumentException("La contraseña debe contener al menos un símbolo especial");
		}
		else if (!(password.matches(numeroRegex))) {
			throw new IllegalArgumentException("La contraseña debe contener al menos un número");		
		}	
	}	
	
	
	
}
