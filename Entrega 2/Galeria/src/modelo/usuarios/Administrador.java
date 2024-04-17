package modelo.usuarios;
import view.ViewRegistro;
import modelo.Galeria;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.subastas.Oferta;
import modelo.ventas.Consignación;

public class Administrador extends Usuario {
    private Galeria galeria;
    private ViewRegistro viewRegistro;
    private HashMap<String, Oferta> ofertasPendientes;
    private ArrayList<Consignación> consignacionesPendientes;

   

    public Administrador(String nombre, String apellido, String cedula, String login, String password,
			String tipoUsuario, Galeria galeria, ViewRegistro viewRegistro, HashMap<String, Oferta> ofertasPendientes,
			ArrayList<Consignación> consignacionesPendientes) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
		this.galeria = galeria;
		this.viewRegistro = viewRegistro;
		this.ofertasPendientes = ofertasPendientes;
		this.consignacionesPendientes = consignacionesPendientes;
	}

	// Getters y Setters
    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public ViewRegistro getViewRegistro() {
        return viewRegistro;
    }

    public void setViewRegistro(ViewRegistro viewRegistro) {
        this.viewRegistro = viewRegistro;
    }

    public HashMap<String, Oferta> getOfertasPendientes() {
        return ofertasPendientes;
    }

    public void setOfertasPendientes(HashMap<String, Oferta> ofertasPendientes) {
        this.ofertasPendientes = ofertasPendientes;
    }

    public ArrayList<Consignación> getConsignacionesPendientes() {
        return consignacionesPendientes;
    }

    public void setConsignacionesPendientes(ArrayList<Consignación> consignacionesPendientes) {
        this.consignacionesPendientes = consignacionesPendientes;
    }
}

	
	// Resto de actividades del Administrador
	
	
	

