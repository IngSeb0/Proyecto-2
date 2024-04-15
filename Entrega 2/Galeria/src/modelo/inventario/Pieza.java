package modelo.inventario;

import java.util.ArrayList;

import modelo.perfiles.Propietario;
import modelo.inventario.ColectivoArtistas;
import modelo.inventario.Consignacion;

public abstract class Pieza {

	protected int idPieza;

	protected String titulo;

	protected String anioCreacion;

	protected String lugarCreacion;

	protected boolean disponibilidad;

	protected int costofijo;

	protected ArrayList<Artista> artista;

	protected Propietario propietario;
	
	protected Consignacion consignacion;
	
	protected int valorinicial;
	
	protected int valorMinimo;


	/*
	 * Constructor 
	 */

	public Pieza(String titulo, String anioCreacion, String lugarCreacion,
			Artista artista, Propietario propietario, Consignacion consignacion) {
		this.titulo = titulo;
		this.anioCreacion = anioCreacion;
		this.lugarCreacion = lugarCreacion;
		this.artista.add(artista);
		if (artista instanceof ColectivoArtistas) {
			ArrayList<Artista> artistasColectivo = artista.getColectivo().getArtistas();
			for (Artista a : artistasColectivo) {
				this.artista.add(a);
			}
		}
		this.propietario = propietario;
		this.consignacion = consignacion;
	}


	public int getIdPieza() {
		return idPieza;
	}

	public String getTitulo() {
		return titulo;
	}


	public String getAnioCreacion() {
		return anioCreacion;
	}


	public String getLugarCreacion() {
		return lugarCreacion;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public int getCostofijo() {
		return costofijo;
	}


	public ArrayList<Artista> getArtista() {
		return artista;
	}

	
	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public Consignacion getConsignacion() {
		return consignacion;
	}


	public int getValorinicial() {
		return valorinicial;
	}

	public int getValorMinimo() {
		return valorMinimo;
	}



}