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
        	System.out.println("\n----------------------------------------");
        	System.out.println("Subasta en curso\n");
        	System.out.println("Pieza actual: " + empleado.getPiezaSubastaEnCurso().getTituloPieza()+ "de" + empleado.getPiezaSubastaEnCurso().getArtistas().get(0));
        	System.out.println("[" + empleado.getPiezaSubastaEnCurso().getTipoPieza() + "]");
        	System.out.println("\nOferta actual: $" + String.valueOf(empleado.getPiezaSubastaEnCurso().getValorInicial()));
        	System.out.println("----------------------------------------\n");
        	
        }
        System.out.println("Disfruta tu tiempo libre. Por ahora no hay mucho que hacer...\n");
        System.out.println("1. Iniciar subasta");
        System.out.println("0. Cerrar sesión");
    }
    
    public void seleccionarOpcion(String opcion) {
    	if (!opcion.equals("0")) {
    		switch(opcion) {
			case "1":
			//iniciarsubasta
			break;
			}
    		mostrarMenu();
    	} else {
    		empleado.getGaleria().getViewLogin().mostrarMenu();
    	}
	}
    
}

