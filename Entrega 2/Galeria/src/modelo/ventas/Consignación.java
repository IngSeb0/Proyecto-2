package modelo.ventas;

import java.time.LocalDate;
import java.util.List;
import modelo.inventario.Pieza;
import modelo.usuarios.Administrador;
import modelo.usuarios.Comprador;

public class Consignación {
    private Pieza pieza;
    private String modoConsignacion;
    private LocalDate fecha;
    private Administrador administrador;
    private Comprador propietario;

    public Consignación(Pieza pieza, String modoConsignacion, Administrador administrador, Comprador propietario) {
        this.pieza = pieza;
        this.modoConsignacion = modoConsignacion;
        this.administrador = administrador;
        this.propietario = propietario;
        this.fecha = LocalDate.now().plusMonths(1);
        agregarConsignacionPendiente();
    }

    private void agregarConsignacionPendiente() {
        List<Consignación> consignacionesPendientes = administrador.getConsignacionesPendientes();
        consignacionesPendientes.add(this);
    }

    // Getters y Setters
    // ...
}

