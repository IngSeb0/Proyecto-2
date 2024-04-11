package modelo.inventario;

import java.util.ArrayList;

import modelo.perfiles.Propietario;
import modelo.perfiles.Comprador;
import modelo.perfiles.Administrador;
import modelo.ventas.Venta;


public abstract class Pieza {

	protected int idPieza;

	protected String titulo;

	protected String fechaCreacion;

	protected String lugarCreacion;

	protected boolean disponibilidad;

	protected int costo;

	protected ArrayList<Artista> artista;

	protected Propietario propietario;
	


	/*
	 * Constructor 
	 */

	public Pieza(int idPieza, String titulo, String fechaCreacion, String lugarCreacion, Artista artista, Propietario propietario) {
		this.idPieza = idPieza;
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
	public void vender(Administrador administrador, Comprador comprador, String fecha) {
        if (disponibilidad)  and (Comprador in ){
            Venta.realizarVenta(administrador,this, comprador, fecha);
            disponibilidad= false;
        } else {
            System.out.println("La pieza ya no está disponible para la venta.");
        }
    }
}



