package view;

import model.Galeria;
import model.usuarios.Administrador;
import model.usuarios.Comprador;
import model.usuarios.Empleado;

	public class ViewRegistro extends View {
	
	private Galeria galeria;
	
	/*
	 * Constructor
	 */
	
	public ViewRegistro(Galeria galeria) {

		this.galeria = galeria;
	}
	
	/*
	 * Menús
	 */
	
	public void mostrarMenuUsuario(String tipoUsuario) {
		if (tipoUsuario.equals("Administrador")) {
			mostrarMenuAdministrador();
		} else if (tipoUsuario.equals("Empleado")) {
			mostrarMenuEmpleado();
		}
	}
	

	public void mostrarMenuAdministrador() {
		 System.out.println("\n===========================================");
		 System.out.println("Configuración inicial de la Galería");
         System.out.println("===========================================\n");
         System.out.println("No hay ningún administrador configurado en el sistema.\n");
         System.out.println("Como primer paso, debes crear una cuenta de administrador.");
         System.out.println("Esta cuenta tendrá acceso completo al sistema para gestionar \nusuarios, inventario y subastas.\n");
         registrarNuevoUsuario("Administrador");
	}
	
	public void mostrarMenuEmpleado() {
		 System.out.println("\n===========================================");
		 System.out.println("Registrar empleado");
         System.out.println("===========================================\n");
         System.out.println("Por favor, ingresa los datos del empleado.");
         registrarNuevoUsuario("Empleado");
         registrarNuevoUsuario("Administrador");
	}


	/*
	 * Registrar un usuario
	 * 
	 */
	
	public void registrarNuevoUsuario(String tipoUsuario) {
		
		String nombre = capitalize(getInput("\nNombre: ").trim());
		String apellido = capitalize(getInput("\nApellido: ").trim());
		String cedula = String.valueOf(getInputInt("\nCédula: "));
		
		switch(tipoUsuario) {
		
		case "Administrador":
			String login = validarLogin();
			String password = validarPassword();
			Administrador administrador = new Administrador(nombre, apellido, cedula, login, password, tipoUsuario);
			galeria.setAdministrador(administrador);
			System.out.println("\nUsuario creado con éxito.");
			ViewAdministrador viewAdministrador = new ViewAdministrador(administrador);
			administrador.setViewAdministrador(viewAdministrador);
			viewAdministrador.mostrarMenu();
			break;
			
		case "Empleado":
			login = galeria.generarLogin(nombre, apellido);
			password = galeria.generarPassword();
			Empleado empleado = new Empleado(nombre, apellido, cedula, login, password, tipoUsuario);
			galeria.addEmpleado(empleado);
			System.out.println("\nCredenciales del empleado; ");
			System.out.println("\nlogin: " + login);
			System.out.println("password: " + password);
			System.out.println("\nEmpleado registrado con éxito.");
			galeria.getAdminstrador().getViewAdministrador().mostrarMenu();
			break;
	
		case "Comprador":
			login = validarLogin();
			password = validarPassword();
			Comprador comprador = new Comprador(nombre, apellido, cedula, login, password, tipoUsuario);
			ViewComprador viewComprador = new ViewComprador(comprador);
			comprador.setViewComprador(viewComprador);
			comprador.setGaleria(galeria);
			galeria.addUsuario(comprador);
			comprador.getViewComprador().mostrarMenu();
			break;
		}
		
		;
	}
	
		
	public String validarLogin() {
		while (true) {
			String login = getInput("\nNombre de usuario: ").trim();
			
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
