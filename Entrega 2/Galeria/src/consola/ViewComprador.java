package consola;
import modelo.usuarios.Comprador; 
import modelo.Galeria;
import modelo.usuarios.Cajero;
import modelo.inventario.Pieza;
import modelo.ventas.Consignación; 
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewComprador extends View {
    private Comprador comprador;
    private Cajero cajero;
    private int TotalComprasRealizadas;
    private int SaldoDisponible;
    private Scanner scanner;
    private Galeria galeria;

    public ViewComprador(Comprador comprador,Galeria galeria, Scanner scanner) {
        this.comprador = comprador;
        this.galeria = galeria;
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

    public void comprarPieza(String tipoPieza, String nombrePieza) {
        // Aquí deberías implementar la lógica para comprar una pieza
        // Por ejemplo:
        Pieza pieza = galeria.buscarPiezaPorId(tipoPieza, nombrePieza); // Obtener la pieza por su nombre
        
        if (pieza != null && SaldoDisponible >= pieza.getCosto()&& pieza.getCosto()>= 0) {
            if (TotalComprasRealizadas >= comprador.getValorMaximoCompras()) {
                System.out.println("¿Puede pagar la pieza con recursos adicionales? (S/N)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Indique cuál es la forma de pago adicional:");
                    String formaPagoAdicional = scanner.nextLine();
                    System.out.println("Indique cuál es la fecha de compra:(dd/mm/YYYY)");
                    String fecha = scanner.nextLine();
                    comprador.comprarPieza(galeria, tipoPieza, comprador, fecha, tipoPieza, cajero);
                    comprador.agregarPiezaActual(pieza);
                    comprador.agregarPiezaPasada(pieza);
                    // Aquí podrías hacer algo con la forma de pago adicional, como registrarla o procesarla
                    System.out.println("Compra realizada con recursos adicionales.");
                    System.out.println("Has comprado la pieza: " + nombrePieza);
                    System.out.println("Saldo restante: " + SaldoDisponible);
                    SaldoDisponible -= pieza.getCosto(); // Restar el costo de la pieza al saldo disponible
                    TotalComprasRealizadas += pieza.getCosto();
                } else {
                    System.out.println("No se pudo realizar la compra de la pieza.");
                }
            } else {
            	
                
                System.out.println("Indique cuál es la fecha de compra:(dd/mm/YYYY)");
                String fecha = scanner.nextLine();
                comprador.comprarPieza(galeria, tipoPieza, comprador, fecha, tipoPieza, cajero);
                comprador.agregarPiezaActual(pieza);
                comprador.agregarPiezaPasada(pieza);
                SaldoDisponible -= pieza.getCosto(); // Restar el costo de la pieza al saldo disponible
                TotalComprasRealizadas += pieza.getCosto();
                System.out.println("Has comprado la pieza: " + nombrePieza);
                System.out.println("Saldo restante: " + SaldoDisponible);
            }
        } else {
            System.out.println("No se pudo realizar la compra de la pieza.");
            // Proceso para realizar oferta 
        }
    }


    public void verPiezasDisponibles() {
        System.out.println("Piezas disponibles para compra:");
        
        for (HashMap<String, Pieza> piezasPorTipo : galeria.getPiezasInventario().values()) {
            for (Pieza pieza : piezasPorTipo.values()) {
                if (!galeria.getPiezasPasadas().contains(pieza) &&
                    !galeria.getPiezasBodega().contains(pieza) &&
                    !galeria.getPiezasExhibidas().contains(pieza)) {
                    System.out.println(pieza.getTitulo() + " - Precio: " + pieza.getCosto());
                }
            }
        }
    }

    public void verConsignaciones() {
        System.out.println("Consignaciones del comprador:");
        // Aquí deberías implementar la lógica para mostrar las consignaciones del comprador
        ArrayList<Consignación> consignaciones = comprador.getConsignaciones();
        for (Consignación consignacion : consignaciones) {
            System.out.println("Pieza: " + consignacion.getPieza().getTitulo()  + ", Costo: " + consignacion.getPieza().getCosto());
        }
    }

    
    //public void consignarPieza(String idPieza, String modalidadConsignacion, int costoFijo) {
        // Aquí deberías implementar la lógica para que el comprador consigne una pieza
        // Por ejemplo:
    // Pieza pieza = comprador.getPieza(idPieza);
    //   if (pieza != null) {
    //    Consignación consignacion = new Consignación(pieza, modalidadConsignacion, costoFijo);
    //    comprador.addConsignacion(consignacion);
    //     System.out.println("Se ha registrado la consignación de la pieza.");
    // } else {
    //       System.out.println("La pieza con ID " + idPieza + " no se encontró.");
    // }
    // }

    // public void getPiezaSubastaEnCurso() {
        // Aquí deberías implementar la lógica para obtener la pieza en subasta en curso
        // Por ejemplo:
    //  Subasta subasta = comprador.getGaleria().getSubastaEnCurso();
    //   if (subasta != null) {
    //     Pieza piezaSubasta = subasta.getPieza();
    //    System.out.println("Pieza en subasta en curso: " + piezaSubasta.getNombre());
            //    //  } else {
    //   System.out.println("No hay ninguna subasta en curso.");
    //   }
    //  }
//
    // Otros métodos si es necesario
}
