package modelo.ventas;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosVenta {
    private static List<Venta> ventas = new ArrayList<>();

    public static void guardarVenta(Venta venta) {
        ventas.add(venta);
        System.out.println("Venta registrada en la base de datos.");
    }
    private BaseDeDatosVenta() {
        
    }
    public static List<Venta> obtenerVentas() {
        return ventas;
    }

	public static List<Venta> getVentas() {
		return ventas;
	}

	public static void setVentas(List<Venta> ventas) {
		BaseDeDatosVenta.ventas = ventas;
	}
	
}
