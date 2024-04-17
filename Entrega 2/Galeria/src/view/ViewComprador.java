package view;

import java.util.ArrayList;
import java.util.HashMap;

import model.inventario.Pieza;
import model.usuarios.Comprador; 

public class ViewComprador extends View {
   
	private Comprador comprador;
	
    public ViewComprador(Comprador comprador) {
		this.comprador = comprador;
	}

    public void mostrarMenu() {
    	System.out.println("\n===========================================");
		System.out.println("Bienvenido, " + comprador.getNombre()+ "!");
        System.out.println("===========================================\n");
        
        // En caso de subasta
        if (comprador.getSubastaEnCurso() != null) {
        	System.out.println("\n----------------------------------------");
        	System.out.println("Subasta en curso\n");
        	System.out.println("Pieza actual: " + comprador.getPiezaSubastaEnCurso().getTituloPieza()+ "de" + comprador.getPiezaSubastaEnCurso().getArtistas().get(0));
        	System.out.println("[" + comprador.getPiezaSubastaEnCurso().getTipoPieza() + "]");
        	System.out.println("\nOferta actual: $" + String.valueOf(comprador.getPiezaSubastaEnCurso().getValorInicial()));
        	System.out.println("----------------------------------------\n");
        	
        }
        
        // Info
        System.out.println("Valor máximo de compras: $" + String.valueOf(comprador.getValorMaximoCompras()));
        System.out.println("Total de compras realizadas: $" + String.valueOf(comprador.getTotalComprasRealizadas()));
        System.out.println("Saldo disponible: $" + String.valueOf(comprador.getSaldoDisponible()));
        
        //Menú
        System.out.println("1. Comprar pieza");
        System.out.println("2. Consignar pieza");
        System.out.println("3. Ofertar por la pieza actual de la subasta");
        System.out.println("4. Ver mis consignaciones actuales");
        System.out.println("5. Revisar mis consignaciones pendientes");
        System.out.println("6. Revisar mis ofertas pendientes");
        System.out.println("0. Salir");
    }
    
    public void seleccionarOpcion(String opcion) {
		switch(opcion) {
		case "1":
			comprarPieza();
			break;
		case "2":
//			consignarPieza();
			break;
		case "3":
//			hacerOfertaSubasta();
			break;
		case "4":
//			verConsignacionesComprador();
			break;
		case "5":
//			verConsignacionesPendientesComprador();
			break;
		case "6":
//			verOfertasPendientesComprador();
			break;
		}
		mostrarMenu();
	}
    

    public void comprarPieza() {
    	verPiezasDisponibles();
    	System.out.println("Para comprar una pieza debes conocer su tipo y el id de la pieza en la galería.");
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
        String idPieza = String.valueOf(getInputInt("\nID de la pieza: "));
        Pieza pieza = comprador.getGaleria().getPiezaPorID(tipoPieza, idPieza);
        try {
        	if (pieza != null) {
        		String peticion = null;
        		if (pieza.getCostoFijo() <= comprador.getSaldoDisponible()) {
        			comprador.comprarPieza(tipoPieza, idPieza, pieza.getCostoFijo(), peticion);
        		} else {
        			System.out.println("No tienes más saldo para comprar en la galería.");
        			boolean hacerPeticion = getInputY_N("¿Quieres solicitar un cupo mayor de compra?");
        			if (hacerPeticion) {
        				peticion = getInput("Petición: ");
        				
        				comprador.comprarPieza(tipoPieza, idPieza, pieza.getCostoFijo(), peticion);
        			} else {
        				mostrarMenu();
        			}
        		}
        	}
        	else {
        		throw new IllegalArgumentException("No se encontró una pieza para el ID: " + idPieza);
        	}
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    System.out.println("Pieza comprada con éxito: " + mostrarPieza(pieza));
       
    }
        
    public void verPiezasDisponibles() {
        System.out.println("Piezas disponibles para compra: ");
        ArrayList<Pieza> piezasDisponibles = comprador.getGaleria().getPiezasDisponibles();
        for (Pieza p : piezasDisponibles) {
        	System.out.println(mostrarPieza(p));
        }
    }

    
}
////
////    public void verConsignaciones() {
////        System.out.println("Consignaciones del comprador:");
////        // Aquí deberías implementar la lógica para mostrar las consignaciones del comprador
////        ArrayList<Consignación> consignaciones = comprador.getConsignaciones();
////        for (Consignación consignacion : consignaciones) {
////            System.out.println("Pieza: " + consignacion.getPieza().getTitulo()  + ", Costo: " + consignacion.getPieza().getCosto());
////        }
////    }
////}
