package modelo.usuarios;

import java.util.ArrayList;
import modelo.Galeria;
import modelo.ventas.Venta;
public class Cajero extends Empleado {
	private Galeria galeria;
	
	

	public Cajero(String nombre, String apellido, String login, String password, String cedula, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
		// TODO Auto-generated constructor stub
	}
	public void guardarVenta(String idVenta, Venta venta) {
		galeria.guardarVenta(idVenta,  venta);
	}
	
	
	
}
