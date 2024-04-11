package modelo.ventas;

import modelo.inventario.Pieza;
import modelo.perfiles.Comprador;
import modelo.perfiles.Administrador;

import modelo.perfiles.Usuario;
public class Venta {
    
    /*
     * Atributos
     */
    
    private static int contadorVentas = 0;
    private int idVenta;
    private Pieza pieza;
    private Comprador comprador;
    private String fecha;
    
    /*
     * Constructor
     */
    
    public Venta(Pieza pieza, Comprador comprador, String fecha) {
        this.idVenta = ++contadorVentas;
        this.pieza = pieza;
        this.comprador = comprador;
        this.fecha = fecha;
    }
    
    /*
     * Getters
     */
    
    public int getIdVenta() {
        return idVenta;
    }
    
    public Pieza getPieza() {
        return pieza;
    }
    
    public Comprador getComprador() {
        return comprador;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    /*
     * Métodos
     */
    
    // Método para realizar la venta
    public static void realizarVenta(Administrador administrador, Pieza pieza, Comprador comprador, String fecha) {
    	String loginComprador = comprador.getUsuario().getLogin();
    	if (Usuario.validarLogin(loginComprador)) {
        Venta venta = new Venta(pieza, comprador, fecha);
        venta.guardarVenta();
        System.out.println("Venta realizada con éxito. ID de venta: " + venta.getIdVenta());
    	}
    }
    public void guardarVenta() {
    	BaseDeDatosVenta.guardarVenta(this);
    }
}