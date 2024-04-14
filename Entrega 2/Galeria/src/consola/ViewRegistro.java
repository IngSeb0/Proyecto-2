package consola;

import modelo.Galeria;
import modelo.usuarios.Administrador;

public class ViewRegistro extends View {
	
private Galeria galeria;
	
	public ViewRegistro(Galeria galeria) {
		this.galeria = galeria;
	}
	
	@Override
	public void mostrarMenu() {
		
		
		if (galeria.getAdministrador() == null) {
			 System.out.println("===========================================");
			 System.out.println("Configuración Inicial de la Galería");
	         System.out.println("===========================================\n");
	         System.out.println("No hay ningún administrador configurado en el sistema.\n");
	         System.out.println("Como primer paso, debes crear una cuenta de administrador.");
	         System.out.println("Esta cuenta tendrá acceso completo al sistema para gestionar \nusuarios, inventario y subastas.\n");
	         registrarNuevoUsuario("Administrador");
		} else {
			System.out.println("\n\n===========================================");
			 System.out.println("Registrarse");
	         System.out.println("===========================================");
	         registrarNuevoUsuario("Comprador");
		}
			
	}
	

	public void registrarNuevoUsuario(String tipoUsuario) {
		
		String login = validarLogin();
		String password = validarPassword();
		String nombre = capitalize(getInput("\nNombre: "));
		String apellido = capitalize(getInput("\nApellido: "));
		String cedula = capitalize(getInput("\nCédula: "));
		
		switch(tipoUsuario) {
		
		case "Administrador":
			Administrador administrador = new Administrador(nombre, apellido, cedula, login, password);
			galeria.agregarUsuario(login, administrador);
			administrador.setGaleria(galeria);
			System.out.println("\nUsuario creado con éxito");
			break;
			
		case "Empleado":
			//viewEmpleado
			break;
		case "Cajero":
			break;
			//viewCajero
		case "Comprador":
			break;
			//viewComprador
			
		}
	}
	
	public String validarLogin() {
		while (true) {
			String login = getInput("\nNombre de usuario: ");
			
	        try {
	        	if (login.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	if (galeria.getUsuarios().containsKey(login)) {
					throw new IllegalArgumentException("El usuario " + login + "ya se encuentra registrado. Intenta con uno diferente.\n");
	        	}
	        	return login;
	        } catch (IllegalArgumentException e) {
	        	System.out.println(e.getMessage());	
	        }	
		}
	}
	
	
	public String validarPassword() {

		while (true) {
			
			String password = getInput("\nContraseña: \nDebe tener al menos una mayúscula, un número y un símbolo especial [!@#$%^&()*]").trim();
			
	        try {
	        	String mayusculaRegex = ".*[A-Z].*";
	            String simboloRegex = ".*[!@#$%^&*()].*";
	            String numeroRegex = ".*\\d.*";
	            
	            if (password.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	if (!(password.matches(mayusculaRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos una mayúscula.\n");
				} 
				if (!(password.matches(simboloRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos un símbolo especial.\n");
				}
				if (!(password.matches(numeroRegex))) {
					throw new IllegalArgumentException("La contraseña debe contener al menos un número.\n");		
				}
				return password;
	        } catch (IllegalArgumentException e) {
	        	System.out.println("Contraseña inválida: " + e.getMessage() + "\nIntenta de nuevo");	
	        }
		}
	}
	
	
}
