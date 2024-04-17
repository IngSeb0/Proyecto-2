package view;

import model.Galeria;
import modelo.usuarios.Administrador;
import modelo.usuarios.Usuario;

public class ViewLogin extends View {

	private Galeria galeria;
	
	public ViewLogin(Galeria galeria) {
		this.galeria = galeria;

	}
}
	
	
//	@Override
//	public void mostrarMenu() {
//		 System.out.println("\n\n===========================================");
//		 System.out.println("Bienvenido al sistema de la Galería");
//		 System.out.println("===========================================");
//		if (galeria != null) {
//			String login = getInput("\nIngresa tu usuario: ");
//			if (galeria.getUsuarios().containsKey(login)) {
//				validarPassword(login);
//				Usuario usuario = galeria.getUsuarios().get(login);
//				System.out.println("\nInicio de sesión exitoso.");
//				iniciarSesion(usuario);
//				
//			} else {
//				usuarioNoRegistrado();
//			}
//			
//		}
//	}
//	
//	private void validarPassword(String login) {
//		while (true) {
//			String password = getInput("\nIngresa tu constraseña: ").trim();
//			Usuario usuario = galeria.getUsuarios().get(login);
//			try {
//				if (password.equals(usuario.getPassword())) {
//					break;
//				} else {
//					throw new IllegalArgumentException("La contraseña no es correcta");
//				}
//			} catch (IllegalArgumentException e ) {
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//
//	public String validarLogin() {
//		while (true) {
//			String login = getInput("\nNombre de usuario: ");
//			
//	        try {
//	        	if (login.equals("")) {
//					throw new IllegalArgumentException("No has ingresado información.\n");
//	        	}
//	        	return login;
//	        } catch (IllegalArgumentException e) {
//	        	System.out.println(e.getMessage());	
//	        }	
//		}
//	}
//		
//	public void iniciarSesion(Usuario usuario) {
//		String tipoUsuario = usuario.getTipoUsuario();
//		switch(tipoUsuario) {
//		case "Administrador":
//			Administrador administrador = (Administrador) usuario;
//			ViewAdministrador viewAdmin = new ViewAdministrador(galeria, administrador);
//			viewAdmin.mostrarMenu();
//			break;
//		case "Empleado":
//			//viewEmpleado
//			break;
//		case "Cajero":
//			break;
//			//viewCajero
//		case "Comprador":
//			break;
//			//viewComprador
//			
//		}
//		
//	}
//	
//	public void usuarioNoRegistrado() {
//		System.out.println("\nEl usuario no se encuentra registrado. ¿Deseas registrarte? [Y/N]");
//		String action = getInput("Ingresa una opción:");
//		if(action.equalsIgnoreCase("Y")) {				
//			ViewRegistro viewRegistro = new ViewRegistro(galeria);
//			viewRegistro.mostrarMenu();
//			
//		} else {
//			mostrarMenu();
//		}
//	}
//	
//	
//}
//		
//		
//		
//
//
//
//	
