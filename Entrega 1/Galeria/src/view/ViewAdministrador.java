package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import model.usuarios.Administrador;
import model.usuarios.Cajero;
import model.usuarios.Comprador;
import model.usuarios.Empleado;
import model.usuarios.Usuario;
import model.ventas.Oferta;
import model.ventas.Subasta;

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
        
        //menú
        System.out.println("1. Ingresar pieza a inventario"); //DONE
        System.out.println("2. Configurar subasta"); //DONE
        System.out.println("3. Iniciar subasta"); //DONE
        System.out.println("4. Verificar comprador"); //DONE
        System.out.println("5. Revisar ofertas pendientes"); // DONE
        System.out.println("6. Revisar consignaciones pendientes");
        System.out.println("7. Registrar empleado"); //DONE
        System.out.println("8. Configurar cajero"); //DONE
        System.out.println("\n0. Cerrar sesión");
      
        String opcion = getInput("\nSelecciona una opción: ").trim();
        seleccionarOpcion(opcion);
	}
	
	public void seleccionarOpcion(String opcion) {
		if (!(opcion.equals("0"))) {
			switch(opcion) {
			case "1":
				ingresarPiezaAInventario();
				break;
			case "2":
				crearSubasta();
			case "3":
				iniciarSubasta();
				break;
			case "4":
				verificarComprador();
			case "5":
				revisarOfertasPendientes();
				break;
			case "7":
				registrarEmpleado();
				break;
			case "8":
				configurarCajero();
				break;
			}
			mostrarMenu();
		} else {
			administrador.getGaleria().getViewLogin().mostrarMenu();	
		}
	}
		
	
	
	/*
	 * Métodos
	 */
	
	public void ingresarPiezaAInventario() {
		System.out.println("--> 1. Ingresar pieza a inventario");
		String salir = getInput("Ingresa cualquier tecla para continuar ó [0] para regresar:").trim();
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
	        	}
	        	else if (ubicacion.equals("2")) {
	        		ubicacion = "Bodega";
	        	} else {
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println("Pieza a " + ubicacion);
			System.out.println("\nInformación del autor.");
			System.out.println("\n¿Es un artista individual o un colectivo de artistas?");
	        System.out.println("1. Artista individual");
	        System.out.println("2. Colectivo de artistas");
	        System.out.println("0. Artista anónimo");
	        String nombreArtista = getInput("\nEscoge una opción:").trim();
	        String nombreColectivo = null;
	        boolean perteneceAColectivo = false;
			try {
	        	if (nombreArtista.equals("1")) {
	        		nombreArtista = getInput("\nNombre del artista:").trim();
	        		boolean c = getInputY_N("\n¿El artista pertenece a algún colectivo de artista?");
	        		if (c) {
	        			nombreColectivo = getInput("\nNombre del colectivo:").trim();
	        			perteneceAColectivo = true;
	        		}
	        	}
	        	else if (nombreArtista.equals("2")) {
	        		nombreArtista = getInput("\nNombre del colectivo:").trim();
	        		nombreColectivo = nombreArtista;
	        		perteneceAColectivo = true;
	        	} else if (nombreArtista.equals("0")) {
					nombreArtista = "Anónimo";
					nombreColectivo = null;
			        perteneceAColectivo = false;
				}
	        	else {
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
			System.out.println("\nInformación de la pieza.");
			String tituloPieza = getInput("\nTítulo de la pieza: ").trim();
			String anioCreacion = getInputFecha("\nAño de creación: ").trim();
			String lugarCreacion = capitalize(getInput("\nLugar de creación: ")).trim();
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
	        	}
	        	else if (tipoPieza.equals("2")) {
	        		tipoPieza = "Pintura";
	        	}
	        	else if (tipoPieza.equals("3")) {
	        		tipoPieza = "Impresión";
	        	}
	        	else if (tipoPieza.equals("4")) {
	        		tipoPieza = "Fotografía";
	        	}
	        	else if (tipoPieza.equals("5")) {
	        		tipoPieza = "Vídeos";
	        	} else {
	        		throw new IllegalArgumentException("Opción inválida.");
	        	}
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println("¿La pieza tiene precio de venta? Ingresa [0] si no.");
	        int costoFijo = getInputInt("Precio de venta: ");
            ingresarTipoPieza(tituloPieza, ubicacion, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, nombreColectivo, perteneceAColectivo);
	    } 
	}
	
	public void ingresarTipoPieza(String tituloPieza, String ubicacion, String anioCreacion, String lugarCreacion, String nombreArtista, int costoFijo, String tipoPieza, String nombreColectivo, boolean perteneceAColectivo) {
		switch(tipoPieza) {
		case "Escultura":
			System.out.println("\nDimensiones (Centímetros):");
			int alto = getInputInt("Alto: ");
			int largo = getInputInt("Largo: ");
			int ancho = getInputInt("Ancho: ");
			String dimensiones = ( String.valueOf(alto) + "-" + String.valueOf(largo) + "-" + String.valueOf(ancho));
			String peso = String.valueOf(getInputInt("\nPeso (Kilogramos): "));
			String materialesConstruccion = String.valueOf(getInput("\nMateriales de construcción:  "));
			boolean requiereElectricidad = getInputY_N("\n¿La escultura requiere electricidad?");
			String idPieza = administrador.ingresarEscultura(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, dimensiones, peso, materialesConstruccion, requiereElectricidad);
			administrador.agregarPiezaAArtista(idPieza, tipoPieza, nombreArtista, nombreColectivo, perteneceAColectivo);
		case "Pintura":
			int largoP = getInputInt("\nLargo(centimetros): ");
			int anchoP = getInputInt("\nAncho(centimetros): ");
			String idPintura= administrador.ingresarPintura(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, largoP, anchoP);
			administrador.agregarPiezaAArtista(idPintura, tipoPieza, nombreArtista, nombreColectivo, perteneceAColectivo);
			break;

		case "Impresión":
			String tipohoja= String.valueOf(getInput("\nTipo de hoja"));
			int largoI = getInputInt("\nLargo: ");
			int anchoI = getInputInt("\nAncho: ");
			String idImpresion=administrador.ingresarImpresion(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, tipohoja, largoI, anchoI);
			administrador.agregarPiezaAArtista(idImpresion, tipoPieza, nombreArtista, nombreColectivo, perteneceAColectivo);
			break;

		case "Fotografía":
			String tipoFotografia= String.valueOf(getInput("\nTipo de fotografia"));
			int altoF = getInputInt("\nLargo: ");
			int anchoF = getInputInt("\nAncho: ");
			String resolucionImagen=String.valueOf(getInput("\nResolucion imagen(Píxeles por pulgada)"));
			String idFotografía= administrador.ingresarFotografia(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, altoF, anchoF, tipoFotografia, resolucionImagen);
			administrador.agregarPiezaAArtista(idFotografía, tipoPieza, nombreArtista, nombreColectivo, perteneceAColectivo);
			break;
			
		case "Vídeos":
			int duracion =getInputInt("\nDuración(minutos): ");
			int pesoV =getInputInt("\nCuanto pesa el video(MB): ");
			boolean mayoresDeEdad = getInputY_N("\n¿El video es para mayores de 18?");
			String resolucionVideo=String.valueOf(getInput("\nResolucion imagen(Píxeles por pulgada)"));
			String idVideo= administrador.ingresarVideo(ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, duracion, mayoresDeEdad, resolucionVideo, pesoV);
			administrador.agregarPiezaAArtista(idVideo, tipoPieza, nombreArtista, nombreColectivo, perteneceAColectivo);
			break;
		}
		System.out.println("\nPieza ingresada con éxito:" + nombreArtista + ". (" + anioCreacion + "). " + tituloPieza + " [" + tipoPieza + "] .");
		mostrarMenu();
	}
	
	public void registrarEmpleado() {
		administrador.registrarEmpleado();
	}
	 
	public void revisarOfertasPendientes() {
	        HashMap<String, Oferta> ofertas = administrador.getOfertasARevisar();
	        System.out.println("\nOfertas Pendientes:");
	        for (Oferta oferta : ofertas.values()) {
	            System.out.println("ID: " + oferta.getIdOferta() + ". Monto: " + oferta.getValorOferta() + ". Fecha: " + oferta.getFecha());
	            // Imprimir otras propiedades de la oferta según sea necesario
	            boolean aceptar = getInputY_N("¿Desea aceptar esta oferta?");
	            if (aceptar) {
	            	administrador.aceptarOferta(oferta);
	                System.out.println("Oferta aceptada correctamente.");
	            } else {
	                System.out.println("Oferta rechazada.");
	            }
	        }
	    }

	public void iniciarSubasta() {
		HashMap<String, Subasta> subastas = administrador.getGaleria().getSubastas();
		String fecha = getInputFecha("Ingresa la fecha de la subasta a inciar (DD-MM-YYYY): ");
		if (subastas.containsKey(fecha)) {
			Subasta subasta = subastas.get(fecha);
			subasta.iniciarSubasta();
			System.out.println("Se ha iniciado la subasta :)");
		} else {
			System.out.println("No se encontró una subasta para la fecha.");
			mostrarMenu();
		}
	}
	
	public void crearSubasta() {
		System.out.println("\n--> Seleccionar fecha");
		String fecha = getInputFecha("Ingresa la fecha en la que se realizará la subasta (DD-MM-YYYY): ");
		System.out.println("\n--> Seleccionar operador");
		Empleado empleado = seleccionarEmpleado();
		if (empleado != null) {
		    administrador.getGaleria().crearSubasta(fecha, empleado);
		    System.out.println("Se créo una subasta para " + fecha + ". Operador:" + empleado.getNombre() + " " + empleado.getApellido());
		} else {
		    System.out.println("Error: No se pudo asignar un operador para la subasta.");
			mostrarMenu();
		}
	}
	
	public Empleado seleccionarEmpleado() {
        ArrayList<Empleado> empleados = administrador.getGaleria().getEmpleadosDisponibles();
        if (empleados.isEmpty()) {
            System.out.println("No hay ningún empleado registrado. Primero, registra un empleado.\n");
            return null;
        } else {
            System.out.println("Empleados disponibles: \n");
            for (Empleado e : empleados) {
                System.out.println(e.getNombre() + " " + e.getApellido() + ", CC: " + e.getCedula());
            }
        }
        System.out.println("\nPara asignar el empleado, ingresa su número de cédula.");
        while (true) {
        	String numeroCedula = getInput("\nNúmero de cédula: ");
            try {
                Empleado empleado = administrador.getGaleria().getEmpleado(numeroCedula);
                if (empleado != null) {
                    return empleado;
                } else {
                    System.out.println("No se encontró el empleado con la cédula proporcionada. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
	
	public void verificarComprador() {
		HashMap<String, Subasta> subastas = administrador.getGaleria().getSubastas();
		String fecha = getInputFecha("Ingresa la fecha de la subasta a inciar (DD-MM-YYYY): ");
		if (subastas.containsKey(fecha)) {
			Subasta subasta = subastas.get(fecha);
			Comprador comprador = (Comprador) seleccionarComprador(); 
			if (comprador != null){
				administrador.VerificarComprador(subasta, comprador);
			} else {
				System.out.println("Todavía no hay compradores registrados.");
				mostrarMenu();
			}
		} else {
			System.out.println("No se encontró una subasta para la fecha.");
			mostrarMenu();
	}
		
	}
	
	public Usuario seleccionarComprador() {
        Collection<Usuario> usuarios = administrador.getGaleria().getUsuarios().values();
        if (usuarios.isEmpty()) {
            System.out.println("No hay compradores. Espera a que se registren.\n");
            return null;
        } else {
            System.out.println("Compradores disponibles: \n");
            for (Usuario u : usuarios) {
            	if (u instanceof Comprador) {
                System.out.println(u.getNombre() + " " + u.getApellido() + ", CC: " + u.getCedula());
            	}
            }
        }
        System.out.println("\nPara escoger el comprador, ingresa su número de cédula.");
        while (true) {
        	String numeroCedula = getInput("\nNúmero de cédula: ").trim();
            Usuario usuario = null;
        	try {
                for (Usuario u : usuarios) {
                	if (u.getCedula().equals(numeroCedula)) {
                	usuario = u;
                	return usuario;
                	} else {
                		throw new IllegalArgumentException("\"No se encontró un comprador con la cédula proporcionada. Intente nuevamente.");
                	}
                }
            } catch (Exception e) { 
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
	
	public void configurarCajero() {
		System.out.println("\nSelecciona un empleado para que sea el cajero");
		Empleado empleado = seleccionarEmpleado();
		administrador.getGaleria().setCajero((Cajero) empleado);
	}

}
	





