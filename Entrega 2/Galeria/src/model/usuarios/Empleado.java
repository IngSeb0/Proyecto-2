package model.usuarios;

import model.inventario.Pieza;
import model.ventas.Subasta;
import view.ViewEmpleado;

public class Empleado extends Usuario {

	
	/*
	 * Atributos
	 */
	
	private Subasta subastaEnCurso;
	
	private Pieza piezaSubastaEnCurso;
	
	/*
	 * Views
	 */
	
	private ViewEmpleado viewEmpleado;
	
	/*
	 * Constructor
	 */
	
	public Empleado(String nombre, String apellido,  String cedula, String login, String password, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
	}
	
	/*
	 * Getters + Setters
	 */

	public Subasta getSubastaEnCurso() {
		return subastaEnCurso;
	}

	public void setSubastaEnCurso(Subasta subastaEnCurso) {
		this.subastaEnCurso = subastaEnCurso;
	}

	public Pieza getPiezaSubastaEnCurso() {
		return piezaSubastaEnCurso;
	}

	public void setPiezaSubastaEnCurso(Pieza piezaSubastaEnCurso) {
		this.piezaSubastaEnCurso = piezaSubastaEnCurso;
	}	
	
	/*
	 * Métodos
	 */
	
	
	

}
