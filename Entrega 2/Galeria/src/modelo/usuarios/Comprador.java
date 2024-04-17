package modelo.usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import modelo.inventario.Pieza;
import modelo.subastas.Oferta;
import modelo.subastas.Subasta;
import modelo.ventas.MetodoPago;
import modelo.ventas.Venta;
import modelo.Galeria;
import java.util.Date;
import consola.ViewRegistro;
import consola.ViewComprador;
import modelo.ventas.Consignación;
public class Comprador extends Usuario {

	/*
	 * Atributos
	 */

	    private ViewRegistro viewRegistro;
	    private ViewComprador viewComprador;
	    private ArrayList<Pieza> piezasActuales;
	    private ArrayList<Pieza> piezasPasadas;
	    private int totalComprasRealizadas;
	    private int saldoDisponible;
	    private int valorMaximoCompras;
	    private ArrayList<Oferta> ofertas;
	    private Subasta subastaEnCurso;
	    private ArrayList<Consignación> consignaciones;
	    private Pieza piezaSubastaEnCurso;
	
	/*
	 * Constructor
	 */
	
	public Comprador(String nombre, String apellido, String login, String password, String cedula, String tipoUsuario) {
		super(nombre, apellido, cedula, login, password, tipoUsuario);
	}

	/*
	 * Getters
	 */

	public ViewRegistro getViewRegistro() {
		return viewRegistro;
	}

	public void setViewRegistro(ViewRegistro viewRegistro) {
		this.viewRegistro = viewRegistro;
	}

	public ViewComprador getViewComprador() {
		return viewComprador;
	}

	public void setViewComprador(ViewComprador viewComprador) {
		this.viewComprador = viewComprador;
	}

	public ArrayList<Pieza> getPiezasActuales() {
		return piezasActuales;
	}

	public void setPiezasActuales(ArrayList<Pieza> piezasActuales) {
		this.piezasActuales = piezasActuales;
	}

	public ArrayList<Pieza> getPiezasPasadas() {
		return piezasPasadas;
	}

	public void setPiezasPasadas(ArrayList<Pieza> piezasPasadas) {
		this.piezasPasadas = piezasPasadas;
	}

	public int getTotalComprasRealizadas() {
		return totalComprasRealizadas;
	}

	public void setTotalComprasRealizadas(int totalComprasRealizadas) {
		this.totalComprasRealizadas = totalComprasRealizadas;
	}

	public int getSaldoDisponible() {
		return saldoDisponible;
	}

	

	public void setSaldoDisponible(int saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public int getValorMaximoCompras() {
		return valorMaximoCompras;
	}

	public void setValorMaximoCompras(int valorMaximoCompras) {
		this.valorMaximoCompras = valorMaximoCompras;
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public Subasta getSubastaEnCurso() {
		return subastaEnCurso;
	}

	public void setSubastaEnCurso(Subasta subastaEnCurso) {
		this.subastaEnCurso = subastaEnCurso;
	}

	public ArrayList<Consignación> getConsignaciones() {
		return consignaciones;
	}

	public void setConsignaciones(ArrayList<Consignación> consignaciones) {
		this.consignaciones = consignaciones;
	}

	
	public Pieza getPiezaSubastaEnCurso() {
		return piezaSubastaEnCurso;
	}

	public void setPiezaSubastaEnCurso(Pieza piezaSubastaEnCurso) {
		this.piezaSubastaEnCurso = piezaSubastaEnCurso;
	}
	
	public void setSaldoDisponible() {
		int valorMaximoCompras = getValorMaximoCompras();
		int valorTotalCompras = getTotalComprasRealizadas();
		this.saldoDisponible = valorMaximoCompras - valorTotalCompras;
	}
	/*
	 * Métodos
	 */

	

	public Oferta hacerOferta(Galeria galeria,Comprador comprador,  String idPieza, int valorOferta, Subasta subasta, String tipoPieza) {
	    Pieza pieza = galeria.buscarPiezaPorId(tipoPieza, idPieza);

	    if (pieza != null && pieza.isDisponibilidad()) {
	        Oferta oferta = new Oferta(subasta, pieza,comprador, valorOferta);
	        pieza.setDisponibilidad(false);
	        return oferta;
	    } else {
	        throw new IllegalStateException("Error: La pieza no está disponible para hacer ofertas.");
	    }
	}
	        // Comprar una pieza

public void comprarPieza(Galeria galeria, String idPieza, Comprador comprador, String fecha, String tipoPieza) {
    Pieza pieza = galeria.buscarPiezaPorId(tipoPieza, idPieza);
    if (pieza != null && pieza.isDisponibilidad()) {
        // Generar un ID único para la venta
        String idVenta = UUID.randomUUID().toString();
        
        // Crear la venta con el ID generado
        Venta venta = new Venta(pieza, comprador, fecha, idVenta);
        
        // Guardar la venta en la galería
        galeria.guardarVenta(idVenta, venta);
        
        System.out.println("Venta realizada con éxito. ID de venta: " + venta.getIdVenta());
    } else {
        System.out.println("Error: La pieza no está disponible para la venta.");
    }
}
}
