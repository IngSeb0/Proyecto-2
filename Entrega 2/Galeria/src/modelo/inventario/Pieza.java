package modelo.inventario;

import java.util.ArrayList;

import modelo.perfiles.Comprador;
import modelo.subastas.Subasta;

public abstract class Pieza {
	
	/*
	 * Atirbutos
	 */

	protected int idPieza;

	protected String titulo;

	protected String fechaCreacion;

	protected String lugarCreacion;

	protected boolean disponibilidad;

	protected int costoFijo;

	protected ArrayList<Artista> artista;

	protected Comprador propietario;
	
	protected int valorMinimo;
	
	protected int valorInicial;
	
	protected Subasta subasta;


	/*
	 * Constructor 
	 */

	public Pieza(String titulo, String fechaCreacion, String lugarCreacion, Artista artista, Propietario propietario) {

		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.lugarCreacion = lugarCreacion;
		this.propietario = propietario;
		this.artista.add(artista);
		if (artista instanceof ColectivoArtistas) {
			ArrayList<Artista> artistasColectivo = artista.getColectivo().getArtistas();
			for (Artista a : artistasColectivo) {
				this.artista.add(a);
			}
		} 

	}


	/*
	 * Getters + Setters
	 */
	
	public int getIdPieza() {
		return idPieza;
	}


	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getLugarCreacion() {
		return lugarCreacion;
	}


	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public int getCostoFijo() {
		return costoFijo;
	}


	public void setCostoFijo(int costoFijo) {
		this.costoFijo = costoFijo;
	}


	public ArrayList<Artista> getArtista() {
		return artista;
	}


	public void setArtista(ArrayList<Artista> artista) {
		this.artista = artista;
	}


	public Comprador getPropietario() {
		return propietario;
	}


	public void setPropietario(Comprador propietario) {
		this.propietario = propietario;
	}


	public int getValorMinimo() {
		return valorMinimo;
	}


	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}


	public int getValorInicial() {
		return valorInicial;
	}


	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}


	



}