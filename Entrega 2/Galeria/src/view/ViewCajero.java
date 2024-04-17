package view;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import model.Galeria;
import model.ventas.Subasta;
import model.ventas.Venta;
import model.usuarios.Administrador;
import model.usuarios.Cajero;
import model.usuarios.Empleado;

public class ViewCajero extends View {
	
	private Cajero cajero;
	private Galeria galeria;

	
	public ViewCajero(Cajero cajero) {
		cajero.setViewCajero(this);
		this.cajero = cajero;
	}
	
	@Override
	public void mostrarMenu() {
		System.out.println("\n===========================================");
		System.out.println("Bienvenido, Cajero!");
        System.out.println("===========================================\n");
        System.out.println("1. Ver oferta aceptadas \n");
        String opcion = getInput("\nSelecciona una opción: ");
        
        
        seleccionarOpcion(opcion);
	}
public void seleccionarOpcion(String opcion) {
		
		switch(opcion) {
		case "1":
			 verOfertasAceptadas();}
		
		
	}
		public void  verOfertasAceptadas() {
			cajero.verOfertasAceptadas();
		}
		public void registrarVenta(String idVenta, Venta venta) {
			cajero.registrarVenta(idVenta,  venta);
		}
		
		public void metodoCarlos() {
			// Hola
		}
		}