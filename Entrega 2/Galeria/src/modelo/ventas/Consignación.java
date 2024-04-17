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

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public String getModoConsignacion() {
		return modoConsignacion;
	}

	public void setModoConsignacion(String modoConsignacion) {
		this.modoConsignacion = modoConsignacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Comprador getPropietario() {
		return propietario;
	}

	public void setPropietario(Comprador propietario) {
		this.propietario = propietario;
	}

    // Getters y Setters
    // ...
    
}

