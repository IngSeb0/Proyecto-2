package modelo.perfiles;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

	/*
	 * Atributos
	 */

	private static Set<String> logins = new HashSet<String>(); 

	private String login;

	private String password;
	/*
	 * Constructor
	 */

	public Usuario( String login, String password) {

		if (validarLogin(login)) {
            throw new IllegalArgumentException("El usuario '" + login + "' ya está registrado. Intenta con uno diferente.");
        }
		 validarPassword(password);
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


	/*
	 * Métodos
	 */

	public static boolean validarLogin(String login)
    {
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
