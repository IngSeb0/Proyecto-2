package modelo.inventario;
import java.util.ArrayList;
import java.util.Date;

import modelo.usuarios.Comprador;
import modelo.usuarios.Administrador;
import modelo.ventas.Venta;

public abstract class Pieza {

    protected String idPieza;
    protected String titulo;
    protected String fechaCreacion;
    protected String lugarCreacion;
    protected boolean disponibilidad;
    protected int costo;
    protected ArrayList<Artista> artistas;
    protected Comprador propietario;

    public Pieza(String idPieza, String titulo, String fechaCreacion, String lugarCreacion, Artista artista, int costo, Comprador propietario) {
        this.idPieza = idPieza;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.lugarCreacion = lugarCreacion;
        this.propietario = propietario;
        this.artistas = new ArrayList<>();
        this.costo = costo;
        this.artistas.add(artista);
        
        if (artista instanceof ColectivoArtistas) {
            ArrayList<Artista> artistasColectivo = artista.getColectivo().getArtistas();
            for (Artista a : artistasColectivo) {
                this.artistas.add(a);
            }
        } 
        this.disponibilidad = true; // Por defecto, la pieza está disponible para la venta
    }

    public String getIdPieza() {
		return idPieza;
	}

	public void setIdPieza(String idPieza) {
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

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(ArrayList<Artista> artistas) {
		this.artistas = artistas;
	}

	public Comprador getPropietario() {
		return propietario;
	}

	public void setPropietario(Comprador propietario) {
		this.propietario = propietario;
	}

}
