package view;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import model.Galeria;
import model.ventas.Subasta;
import model.usuarios.Administrador;
import model.usuarios.Cajero;
import model.usuarios.Empleado;

public class ViewAdministrador extends View {
	
	private Administrador administrador;
	
	public ViewAdministrador(Administrador administrador) {
		administrador.setViewAdministrador(this);
		this.administrador = administrador;
	}
	
	@Override
	public void mostrarMenu() {
		System.out.println("\n===========================================");
		System.out.println("Bienvenido, administrador!");
        System.out.println("===========================================\n");
        
        //TODO organizar menú
        System.out.println("1. Ingresar pieza a inventario");
        System.out.println("3. Configurar subasta");
        System.out.println("4. Registrar empleado");
        System.out.println("5. Registrar cajero");
      
        String opcion = getInput("\nSelecciona una opción: ");
        seleccionarOpcion(opcion);
	}
	
	public void seleccionarOpcion(String opcion) {
		
		switch(opcion) {
		case "1":
			ingresarPiezaAInventario();
		case "3":
//			crearSubasta();
			break;
		
		case "4":
//			registrarEmpleado();
		break;
		}
		mostrarMenu();
	}
	
	/*
	 * Métodos
	 */
	
	public void ingresarPiezaAInventario() {
		System.out.println("--> 1. Ingresar pieza a inventario");
		String salir = getInput("Ingresa: [0]").trim();
		if (salir.equals("0")) {
			mostrarMenu();
		} else {
			
			System.out.println("\n¿Adónde ingresa la pieza?");
			System.out.println("1. Exhibición");
	        System.out.println("2. Bodega");
	        String ubicacion = getInput("\nEscoge una opción:").trim();
	        try {
	        	if (ubicacion.equals("1")) {
	        		ubicacion = "Exhibición";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        	if (ubicacion.equals("2")) {
	        		ubicacion = "Bodega";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	        
			System.out.println("Ingresa la información de la pieza.");
			
			String tituloPieza = getInput("\nTítulo de la pieza: ").trim();
			String nombreArtista = getInput("\nNombre del autor: \n(Si es anónimo ingresa [0]").trim();
			if (nombreArtista.equals("0")) {
				nombreArtista = "Anónimo";
			}
			String anioCreacion = getInputFecha("\nAño de creación: ").trim();
			String lugarCreacion = getInput("\nLugar de creación: ").trim();
			
			System.out.println("\nTipo de la pieza:");
			System.out.println("1. Escultura");
	        System.out.println("2. Pintura");
	        System.out.println("3. Impresión");
	        System.out.println("4. Fotografía");
	        System.out.println("5. Vídeos");
	        
	        String tipoPieza = getInput("\nEscoge una opción:").trim();
	        try {
	        	if (tipoPieza.equals("1")) {
	        		tipoPieza = "Escultura";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        	if (tipoPieza.equals("2")) {
	        		tipoPieza = "Pintura";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        	if (tipoPieza.equals("3")) {
	        		tipoPieza = "Impresión";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        	if (tipoPieza.equals("4")) {
	        		tipoPieza = "Fotografía";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        	if (tipoPieza.equals("5")) {
	        		tipoPieza = "Vídeos";
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println("¿La pieza tiene precio de venta? Ingresa [0] si no.");
	        int costoFijo = getInputInt("Precio de venta: ");
            ingresarTipoPieza(tituloPieza, ubicacion, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza);
	    } 
	}
	
	public void ingresarTipoPieza(String tituloPieza, String ubicacion, String anioCreacion, String lugarCreacion, String nombreArtista, int costoFijo, String tipoPieza) {
		switch(tipoPieza) {
		case "Escultura":
			System.out.println("\nDimensiones:");
			int alto = getInputInt("Alto: ");
			int largo = getInputInt("Largo: ");
			int ancho = getInputInt("Ancho: ");
			String dimensiones = ( String.valueOf(alto) + "-" + String.valueOf(largo) + "-" + String.valueOf(ancho));
			String peso = String.valueOf(getInputInt("\nPeso: "));
			String materialesConstruccion = String.valueOf(getInputInt("\nMateriales de construncción: "));
			boolean requiereElectricidad = getInputY_N("¿La escultura requiere electricidad?");
			administrador.ingresarEscultura(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, dimensiones, peso, materialesConstruccion, requiereElectricidad);
		
			
		case "3":
//			crearSubasta();
			break;
		
		case "4":
//			registrarEmpleado();
		break;
		}
        
	}
	
}

//	public void crearSubasta() {
//		System.out.println("\n--> Seleccionar fecha");
//		String fecha = getInputFecha("Ingresa la fecha en la que se realizará la subasta (DD-MM-YYYY): ");
//		
//		System.out.println("\n--> Seleccionar operador");
//		ArrayList<Empleado> empleados = galeria.getEmpleados();
//		if (empleados.isEmpty()) {
//			System.out.println("No hay ningún empleado registrado. Primero, registra un empleado.\n");
//			mostrarMenu();
//		} else {
//			System.out.println("Empleados disponibles: \n");
//			for (Empleado e : empleados) {
//				if (!(e instanceof Cajero)) {
//					System.out.println(e.getNombre() + " " + e.getApellido() + ", " + e.getCedula());
//				}
//		}
//		System.out.println("\nPara asignar el operador de la subasta, ingresa el número de cédula del empleado.");
//		Empleado operador = null;
//		// Buscar empleado
//		while (true) {
//			String numeroCedula = getInput("\nNúmero de cédula: ");
//	        try { 
//	        	operador = galeria.getEmpleado(numeroCedula);
//	        	if (operador != null) {
//	        		break;
//	        	} else {
//	        		throw new IllegalArgumentException("No se encontró el empleado.");
//	        	}
//	        	
//	        } catch (IllegalArgumentException e) {
//	        	System.out.println(e.getMessage());	
//	        }	
//		}
//		if (operador != null) {
//		    Subasta subasta = galeria.crearSubasta(fecha, operador);
//		    System.out.println("Se créo una subasta para " + subasta.getFecha() + ". Operador:" + subasta.getOperador().getNombre());
//		} else {
//		    System.out.println("Error: No se pudo asignar un operador para la subasta.");
//		}
//		}
//	}




