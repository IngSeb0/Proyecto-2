package model.usuarios;

import java.io.Serializable;
import java.util.HashMap;

import model.Galeria;
import model.inventario.Pieza;
import view.ViewLogin;


public abstract class Usuario implements Serializable {

	/*
	 * Atributos
	 */
	
	protected Galeria galeria;
	
	protected String nombre;
	
	protected String apellido;
	
	protected String cedula;
	
	protected String login;

	protected String password;

	protected String tipoUsuario;
	
	/*
	 * Views
	 */
	
	protected ViewLogin viewLogin;

	/*
	 * Constructor
	 */

	public Usuario(String nombre, String apellido, String cedula, String login, String password, String tipoUsuario) {
		
		setNombre(nombre);
		setApellido(apellido);
		setCedula(cedula);
		setLogin(login);
		setPassword(password);
		setTipoUsuario(tipoUsuario);
	}
	
	/*
	 * Getters + Setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public ViewLogin getViewLogin() {
		return viewLogin;
	}

	public void setViewLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;
	}

	public Galeria getGaleria() {
		return galeria;
	}

	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}	
	
	/*
	 * Métodos
	 */
	

}
