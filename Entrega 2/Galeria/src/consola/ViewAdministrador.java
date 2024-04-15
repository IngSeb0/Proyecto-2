package consola;

import java.util.ArrayList;

import modelo.Galeria;
import modelo.subastas.Subasta;
import modelo.usuarios.Administrador;
import modelo.usuarios.Cajero;
import modelo.usuarios.Empleado;

public class ViewAdministrador extends View {

	private Administrador administrador;
	
	private Galeria galeria;
	
	public ViewAdministrador(Galeria galeria, Administrador administrador) {
		this.administrador = administrador;
		this.galeria = galeria;
	}
	
	@Override
	public void mostrarMenu() {
		System.out.println("\n\n===========================================");
		System.out.println("Administrador");
        System.out.println("===========================================\n");
        
        //TODO organizar menú
        System.out.println("3. Configurar subasta");
        System.out.println("4. Registrar empleado");
        System.out.println("5. Registrar cajero");
      
        String opcion = getInput("\nSelecciona una opción: ");
        seleccionarOpcion(opcion);
	}
	
	public void seleccionarOpcion(String opcion) {
		
		switch(opcion) {
		case "3":
			crearSubasta();
			break;
		
		case "4":
			registrarEmpleado();
		break;
		}
		mostrarMenu();
	}
	
	private void registrarEmpleado() {
		ViewRegistro viewRegistro = new ViewRegistro(galeria);
		System.out.println("\n===========================================");
		System.out.println("Registrar empleado");
		System.out.println("===========================================");
		viewRegistro.registrarNuevoUsuario("Empleado");
	}

	public void crearSubasta() {
		System.out.println("\n--> Seleccionar fecha");
		String fecha = getInputFecha("Ingresa la fecha en la que se realizará la subasta (DD-MM-YYYY): ");
		
		System.out.println("\n--> Seleccionar operador");
		ArrayList<Empleado> empleados = galeria.getEmpleados();
		if (empleados.isEmpty()) {
			System.out.println("No hay ningún empleado registrado. Primero, registra un empleado.\n");
			mostrarMenu();
		} else {
			System.out.println("Empleados disponibles: \n");
			for (Empleado e : empleados) {
				if (!(e instanceof Cajero)) {
					System.out.println(e.getNombre() + " " + e.getApellido() + ", " + e.getCedula());
				}
		}
		System.out.println("\nPara asignar el operador de la subasta, ingresa el número de cédula del empleado.");
		Empleado operador = null;
		// Buscar empleado
		while (true) {
			String numeroCedula = getInput("\nNúmero de cédula: ");
	        try { 
	        	operador = galeria.getEmpleado(numeroCedula);
	        	if (operador != null) {
	        		break;
	        	} else {
	        		throw new IllegalArgumentException("No se encontró el empleado.");
	        	}
	        	
	        } catch (IllegalArgumentException e) {
	        	System.out.println(e.getMessage());	
	        }	
		}
		if (operador != null) {
		    Subasta subasta = galeria.crearSubasta(fecha, operador);
		    System.out.println("Se créo una subasta para " + subasta.getFecha() + ". Operador:" + subasta.getOperador().getNombre());
		} else {
		    System.out.println("Error: No se pudo asignar un operador para la subasta.");
		}
		}
	}




}