package consola;
import modelo.usuarios.Comprador; 
import modelo.Galeria;
import modelo.inventario.Pieza;
import java.util.Scanner;

public class viewComprador {
    private Comprador comprador;
    private int TotalComprasRealizadas;
    private int SaldoDisponible;
    private Scanner scanner;

    public viewComprador(Comprador comprador, Scanner scanner) {
        this.comprador = comprador;
        this.scanner = scanner;
        TotalComprasRealizadas = 0;
        SaldoDisponible = comprador.getSaldoDisponible(); // Obtener el saldo disponible del comprador
    }

    public void mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("1. Comprar pieza");
        System.out.println("2. Ver piezas disponibles");
        System.out.println("3. Ver consignaciones");
        System.out.println("4. Consignar pieza");
        System.out.println("5. Ver pieza en subasta en curso");
        System.out.println("6. Total de compras realizadas: " + TotalComprasRealizadas);
        System.out.println("7. Saldo disponible: " + SaldoDisponible);
        System.out.println("8. Salir");
        System.out.println("--------------");
    }

    public void comprarPieza(String nombrePieza) {
        // Aquí deberías implementar la lógica para comprar una pieza
        // Por ejemplo:
        Pieza pieza = comprador.getPieza(nombrePieza); // Obtener la pieza por su nombre
        if (pieza != null && pieza.isDisponible() && SaldoDisponible >= pieza.getCostoFijo()) {
            SaldoDisponible -= pieza.getCostoFijo(); // Restar el costo de la pieza al saldo disponible
            TotalComprasRealizadas++;
            System.out.println("Has comprado la pieza: " + nombrePieza);
            System.out.println("Saldo restante: " + SaldoDisponible);
        } else {
            System.out.println("No se pudo realizar la compra de la pieza.");
        }
    }

    public void verPiezasDisponibles() {
        System.out.println("Piezas disponibles para compra:");
        // Aquí deberías implementar la lógica para mostrar las piezas disponibles para compra
        ArrayList<Pieza> piezasDisponibles = comprador.getPiezasDisponibles();
        for (Pieza pieza : piezasDisponibles) {
            System.out.println(pieza.getNombre() + " - Precio: " + pieza.getCostoFijo());
        }
    }

    public void verConsignaciones() {
        System.out.println("Consignaciones del comprador:");
        // Aquí deberías implementar la lógica para mostrar las consignaciones del comprador
        ArrayList<Consignacion> consignaciones = comprador.getConsignaciones();
        for (Consignacion consignacion : consignaciones) {
            System.out.println("Pieza: " + consignacion.getPieza().getNombre() + ", Modalidad: " + consignacion.getModalidad() + ", Costo: " + consignacion.getCostoFijo());
        }
    }

    public void consignarPieza(String idPieza, String modalidadConsignacion, int costoFijo) {
        // Aquí deberías implementar la lógica para que el comprador consigne una pieza
        // Por ejemplo:
        Pieza pieza = comprador.getPieza(idPieza);
        if (pieza != null) {
            Consignacion consignacion = new Consignacion(pieza, modalidadConsignacion, costoFijo);
            comprador.addConsignacion(consignacion);
            System.out.println("Se ha registrado la consignación de la pieza.");
        } else {
            System.out.println("La pieza con ID " + idPieza + " no se encontró.");
        }
    }

    public void getPiezaSubastaEnCurso() {
        // Aquí deberías implementar la lógica para obtener la pieza en subasta en curso
        // Por ejemplo:
        Subasta subasta = comprador.getGaleria().getSubastaEnCurso();
        if (subasta != null) {
            Pieza piezaSubasta = subasta.getPieza();
            System.out.println("Pieza en subasta en curso: " + piezaSubasta.getNombre());
        } else {
            System.out.println("No hay ninguna subasta en curso.");
        }
    }

    // Otros métodos si es necesario
}
