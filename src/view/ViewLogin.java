package view;

import model.Galeria;
import model.usuarios.Administrador;
import model.usuarios.Comprador;
import model.usuarios.Usuario;

public class ViewLogin extends View {

	private Galeria galeria;
	
	public ViewLogin(Galeria galeria) {
		this.galeria = galeria;

	}
	
	@Override
	public void mostrarMenu() {
		 System.out.println("\n===========================================");
		 System.out.println("Bienvenido al sistema de la Galería");
		 System.out.println("===========================================\n");
		if (galeria != null) {
			
			System.out.println("Iniciar sesión ");
			String login = getInput("\nUsuario: ");
			if (galeria.getUsuarios().containsKey(login)) {
				validarPassword(login);
				Usuario usuario = galeria.getUsuarios().get(login);
				System.out.println("\nInicio de sesión exitoso.");
				iniciarSesion(usuario);
			} else {
				usuarioNoRegistrado();
			}
		}
	}
	
	
	public void usuarioNoRegistrado() {
		boolean opcion = getInputY_N("El usuario no se encuentra registrado. ¿Deseas registrarte?");
		if(opcion) {				
			ViewRegistro viewRegistro = new ViewRegistro(galeria);
			viewRegistro.mostrarMenu();
		} else {
			mostrarMenu();
		}
	}
	
	private void validarPassword(String login) {
		while (true) {
			String password = getInput("\nContraseña: ").trim();
			Usuario usuario = galeria.getUsuarios().get(login);
			try {
				if (password.equals(usuario.getPassword())) {
					break;
				} else {
					throw new IllegalArgumentException("La contraseña no es correcta");
				}
			} catch (IllegalArgumentException e ) {
				System.out.println(e.getMessage());
			}
		}
	}

	
	public String validarLogin() {
		while (true) {
			String login = getInput("\nNombre de usuario: ");
	        try {
	        	if (login.equals("")) {
					throw new IllegalArgumentException("No has ingresado información.\n");
	        	}
	        	return login;
	        } catch (IllegalArgumentException e) {
	        	System.out.println(e.getMessage());	
	        }	
		}
	}

	
	public void iniciarSesion(Usuario usuario) {
		String tipoUsuario = usuario.getTipoUsuario();
		switch(tipoUsuario) {
		case "Administrador":
			Administrador administrador = (Administrador) usuario;
			ViewAdministrador viewAdministrador = administrador.getViewAdministrador();
			viewAdministrador.mostrarMenu();
			break;
		case "Empleado":
//			Empleado empleado = (Empleado) usuario;
//			ViewEmpleado viewEmpleado = empleado.getViewEmpleado();
//			viewEmpleado.mostrarMenu();
			break;
		case "Cajero":
			break;
			//viewCajero
		case "Comprador":
			Comprador comprador = (Comprador) usuario;
			ViewComprador viewComprador = comprador.getViewComprador();
			viewComprador.mostrarMenu();
			break;
		}
		
	}
	
}
