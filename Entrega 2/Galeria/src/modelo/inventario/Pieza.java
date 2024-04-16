package modelo.inventario;
import java.util.ArrayList;
import java.util.Date;

import modelo.usuarios.Comprador;
import modelo.usuarios.Administrador;
import modelo.ventas.Venta;

public abstract class Pieza {

    protected int idPieza;
    protected String titulo;
    protected String fechaCreacion;
    protected String lugarCreacion;
    protected boolean disponibilidad;
    protected int costo;
    protected ArrayList<Artista> artistas;
    protected Comprador propietario;

    public Pieza(int idPieza, String titulo, String fechaCreacion, String lugarCreacion, Artista artista, int costo, Comprador propietario) {
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

    public void vender( Comprador comprador, Date fecha) {
        if (disponibilidad)  {
            Venta.realizarVenta( this, comprador, fecha, this.costo);
            disponibilidad= false;
        } else {
            System.out.println("La pieza ya no está disponible para la venta.");
        }
    }
}
