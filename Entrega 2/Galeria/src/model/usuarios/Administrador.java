package model.usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.Galeria;
import model.inventario.Artista;
import model.inventario.Escultura;
import model.inventario.Pieza;
import model.ventas.Consignacion;
import model.ventas.Oferta;
import view.ViewAdministrador;

public class Administrador extends Empleado implements Serializable {

	/*
	 * Atributos
	 */
	
	private HashMap<String, Oferta> ofertasARevisar = new HashMap<String, Oferta>();
	
	private ArrayList<Consignacion> consignacionesARevisar = new ArrayList<Consignacion>();
	
	/*
	 * Views
	 */
	
	private ViewAdministrador viewAdministrador;
	
	/*
	 * Constructor 
	 */

	public Administrador(String nombre, String apellido,  String cedula, String login, String password, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
	}

	/*
	 * Gettters
	 */
	

	public HashMap<String, Oferta> getOfertasARevisar() {
		return ofertasARevisar;
	}


	public void setOfertasARevisar(HashMap<String, Oferta> ofertasARevisar) {
		this.ofertasARevisar = ofertasARevisar;
	}


	public ArrayList<Consignacion> getConsignacionesARevisar() {
		return consignacionesARevisar;
	}


	public void setConsignacionesARevisar(ArrayList<Consignacion> consignacionesARevisar) {
		this.consignacionesARevisar = consignacionesARevisar;
	}


	public ViewAdministrador getViewAdministrador() {
		return viewAdministrador;
	}


	public void setViewAdministrador(ViewAdministrador viewAdministrador) {
		this.viewAdministrador = viewAdministrador;
	}
	
	/*
	 * Métodos
	 */
	
	public void registrarEmpleado() {
		galeria.getViewRegistro().mostrarMenuUsuario("Empleado");;
	}
	
	public void ingresarPieza(Pieza pieza) {
		String tipoPieza = pieza.getTipoPieza();
		String idPieza = pieza.getIdPieza();
		HashMap<String, Pieza> piezas = galeria.getPiezasInventario().get(tipoPieza);
		piezas.put(idPieza, pieza);
		galeria.getPiezasPasadas().add(pieza);
		if (pieza.getCostoFijo() > 0) {
			galeria.getPiezasDisponibles().add(pieza);
		}
		if(pieza.getUbicacion().equals("Bodega")) {
			galeria.getPiezasBodega().add(pieza);
		} else {
			galeria.getPiezasExhibidas().add(pieza);
		}
	}
	
	public void agregarPiezaAArtista(String idPieza, String tipoPieza, String nombreArtista, String nombreColectivo, boolean perteneceAColectivo) {
		Pieza pieza = galeria.getPiezaPorID(tipoPieza, idPieza);
		if (nombreArtista.equals(nombreColectivo)) {
			Artista colectivo = new Artista(nombreColectivo);
			colectivo.setColectivo(true);
			galeria.addArtista(colectivo);
			pieza.addArtista(colectivo);
			
		} else {
			Artista artista = new Artista(nombreArtista);
			galeria.addArtista(artista);
			pieza.addArtista(artista);
			if (perteneceAColectivo) {
				if(galeria.getArtistas().containsKey(nombreColectivo)) {
					Artista colectivo = galeria.getArtista(nombreArtista);
					colectivo.addArtista(artista);
					pieza.addArtista(colectivo);
				} else {
					Artista colectivo = new Artista(nombreColectivo);
					colectivo.addArtista(artista);
					galeria.addArtista(colectivo);
					pieza.addArtista(colectivo);
				}
			}
		}
		
	}

	public String ingresarEscultura(String ubicacion, String tituloPieza, String anioCreacion,String lugarCreacion, String nombreArtista, int costoFijo, String tipoPieza, String dimensiones, String peso, String materialesConstruccion, boolean requiereElectricidad) {
		String idPieza = String.valueOf(galeria.getPiezasPasadas().size() + 1);
		Escultura escultura = new Escultura(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, dimensiones, peso, materialesConstruccion, requiereElectricidad);
		ingresarPieza(escultura);
		return idPieza;
	}
}	
	


//	public void VerificarComprador(Subasta subasta, Comprador comprador, int valorMaximoCompras) {
//		comprador.setValorMaximoCompras(valorMaximoCompras);
//		subasta.agregarComprador(comprador);
//	}
//	
//	public void verificarOfertasSubasta(Subasta subasta, Oferta oferta) {
//		ArrayList<Oferta> ofertasSubasta = subasta.getOfertas();
//		for (Oferta o : ofertasSubasta) {
//			Pieza piezaOferta = o.getPieza();
//			Comprador compradorOferta = o.getComprador();
//			//if(o.getValorOferta() >= piezaOferta.getValorMinimo() && o.getValorOferta() <= compradorOferta.getSaldoDisponible()) {
//				o.aceptarOferta(true);
//		}
//	}
//}
//	

	
	
	
	
	
	

