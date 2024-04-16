package modelo.ventas;
import modelo.inventario.Pieza;
import java.util.Date; 
import modelo.usuarios.Comprador;
import modelo.usuarios.Administrador;




public class Venta {
    
    private static int contadorVentas = 0;
    private int idVenta;
    private Pieza pieza;
    private Comprador comprador;
    private String fecha;
    private MetodoPago metodoPago;
    
    public Venta(Pieza pieza, Comprador comprador, String fecha) {
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
    
    public String getFecha() {
        return fecha;
    }
    
    public static void realizarVenta( Pieza pieza, Comprador comprador, String fecha, int precio) {
        
    	if (compradorSerio(comprador, precio)) {
            Venta venta = new Venta(pieza, comprador, fecha);
            venta.guardarVenta();
            System.out.println("Venta realizada con éxito. ID de venta: " + venta.getIdVenta());
            }}
    
        

    private static boolean compradorSerio(Comprador comprador, int Costopieza) {
    	
            return comprador.getSaldoDisponible() >= Costopieza;
        }
        

    public void guardarVenta() {
        BaseDeDatosVenta.guardarVenta(this);
    }
}