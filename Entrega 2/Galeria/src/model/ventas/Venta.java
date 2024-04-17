package model.ventas;
import model.inventario.Pieza;
import java.util.Date; 
import model.usuarios.Comprador;
import model.Galeria;
import model.usuarios.Administrador;




public class Venta {
    
    private static int contadorVentas = 0;
    private String idVenta;
    private Pieza pieza;
    private Comprador comprador;
    private String fecha;

    
    public Venta(Pieza pieza, Comprador comprador, String fecha, String idVenta) {
    	
     
        this.idVenta = idVenta;
        this.pieza = pieza;
        this.comprador = comprador;
        this.fecha = fecha;
    }
    
    public String getIdVenta() {
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

	public static int getContadorVentas() {
		return contadorVentas;
	}

	public static void setContadorVentas(int contadorVentas) {
		Venta.contadorVentas += 1;
	}



	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
    
}
    
   
    