package view;

import model.usuarios.Empleado; 

public class ViewEmpleado extends View {
   
	private Empleado empleado;
	
    public ViewEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

    public void mostrarMenu() {
    	System.out.println("\n===========================================");
		System.out.println("Bienvenido, " + empleado.getNombre()+ "!");
        System.out.println("===========================================\n");
        
        if (empleado.getSubastaEnCurso() != null) {
//        	System.out.println("\n----------------------------------------");
//        	System.out.println("Subasta en curso\n");
//        	System.out.println("Pieza actual: " + comprador.getPiezaSubastaEnCurso().getTituloPieza()+ "de" + comprador.getPiezaSubastaEnCurso().getArtistas().get(0));
//        	System.out.println("[" + comprador.getPiezaSubastaEnCurso().getTipoPieza() + "]");
//        	System.out.println("\nOferta actual: $" + String.valueOf(comprador.getPiezaSubastaEnCurso().getValorInicial()));
//        	System.out.println("----------------------------------------\n");
        	
        }
//        //En caso de subasta
//        System.out.println("Valor máximo de compras: $" + String.valueOf(comprador.getValorMaximoCompras()));
//        System.out.println("Total de compras realizadas: $" + String.valueOf(comprador.getTotalComprasRealizadas()));
//        System.out.println("Saldo disponible: $" + String.valueOf(comprador.getSaldoDisponible()));
        
        //Menú
        System.out.println("1. Comprar pieza");
        System.out.println("0. Salir");
    }
    
    public void seleccionarOpcion(String opcion) {
		switch(opcion) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
		}
		mostrarMenu();
	}
    
    
    
    
}

