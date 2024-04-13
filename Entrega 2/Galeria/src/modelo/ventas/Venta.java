package modelo.ventas;
import modelo.inventario.Pieza;
import java.util.Date; 
import modelo.perfiles.Comprador;
import modelo.perfiles.Administrador;

import modelo.perfiles.Usuario;

public class Venta {
    
    private static int contadorVentas = 0;
    private int idVenta;
    private Pieza pieza;
    private Comprador comprador;
    private Date fecha;
    
    public Venta(Pieza pieza, Comprador comprador, Date fecha) {
        this.idVenta = ++contadorVentas;
        this.pieza = pieza;
        this.comprador = comprador;
        this.fecha = fecha;
    }
    
    public int getIdVenta() {
        return idVenta;
    }
    
    public Pieza getPieza() {
        return pieza;
    }
    
    public Comprador getComprador() {
        return comprador;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public static void realizarVenta(Administrador administrador, Pieza pieza, Comprador comprador, Date fecha, int precio) {
        if (Comprador.getUsuario);
    	if (compradorSerio(comprador, precio)) {
            Venta venta = new Venta(pieza, comprador, fecha);
            venta.guardarVenta();
            System.out.println("Venta realizada con éxito. ID de venta: " + venta.getIdVenta());
        } else {
            System.out.println("La oferta del comprador no es seria. La venta no se puede realizar.");
        }
    }

    private static boolean compradorSerio(Comprador comprador, int Costopieza) {
    	
            return comprador.getFondosDisponibles() >= Costopieza;
        }
        

    public void guardarVenta() {
        BaseDeDatosVenta.guardarVenta(this);
    }
}