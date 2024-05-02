package view;

import model.usuarios.Cajero;
import model.ventas.Oferta;

public class ViewCajero extends View {
	
	private Cajero cajero;

	public ViewCajero(Cajero cajero) {
		cajero.setViewCajero(this);
		this.cajero = cajero;
	}
	
	@Override
	public void mostrarMenu() {
		System.out.println("\n===========================================");
		System.out.println("Bienvenido, Cajero!");
        System.out.println("===========================================\n");
        System.out.println("1. Ver ofertas aceptadas \n");
        System.out.println("0. Cerrar sesión \n");
        
        
        String opcion = getInput("\nSelecciona una opción: ").trim();
        seleccionarOpcion(opcion);
	}
	
	
	public void seleccionarOpcion(String opcion) {
		if (!(opcion.equals("0"))) {
			switch(opcion) {
				case "1":
				verOfertasAceptadas();
			 	break;
			} 
		} else {
			cajero.getGaleria().getViewLogin().mostrarMenu();
		}
	}
	
	public void  verOfertasAceptadas() {
		 System.out.println("Ofertas Aceptadas:");
		 for (Oferta oferta : cajero.getOfertasAceptadas()) {
		      System.out.println("ID: " + oferta.getIdOferta() + ". Monto: " + oferta.getValorOferta() + ". Fecha: " + oferta.getFecha());
		  }
		  registrarVentas();
		    
		}
	
	public void registrarVentas() {
		boolean registrar = getInputY_N("\n¿Deseas registrar todas las ventas?");
		if (registrar) {
			cajero.registrarVentas();
			System.out.println("Registradas con éxito");
		} else {
			System.out.println("Hmmm... ¿Qué más piensas hacer?");
			mostrarMenu();
		}
		
	}
		
		
}