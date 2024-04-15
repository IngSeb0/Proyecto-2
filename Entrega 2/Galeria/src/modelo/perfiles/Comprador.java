package modelo.perfiles;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.inventario.Pieza;
import modelo.subastas.Subasta;
public class Comprador extends Usuario {
    private ArrayList<Pieza> piezasActuales;
    private ArrayList<Pieza> piezasPasadas;
    private HashMap<String, String> facturas;
    private String metodoPago;
    private int valorMaximoCompras;
    private int valorTotalCompras;
    private Usuario usuario;
    private Subasta subasta;
    private int fondosDisponibles;

    // Constructor
    public Comprador( String login, String password) {
        super(login, password);
        this.piezasActuales = new ArrayList<>();
        this.piezasPasadas = new ArrayList<>();
        this.facturas = new HashMap<>();
        this.valorMaximoCompras = 0;
        this.valorTotalCompras = 0;
        this.fondosDisponibles = 0;
    }

    // Getters y setters
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

    public HashMap<String, String> getFacturas() {
        return facturas;
    }

    public void setFacturas(HashMap<String, String> facturas) {
        this.facturas = facturas;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getValorMaximoCompras() {
        return valorMaximoCompras;
    }

    public void setValorMaximoCompras(int valorMaximoCompras) {
        this.valorMaximoCompras = valorMaximoCompras;
    }

    public int getValorTotalCompras() {
        return valorTotalCompras;
    }

    public void setValorTotalCompras(int valorTotalCompras) {
        this.valorTotalCompras = valorTotalCompras;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public int getFondosDisponibles() {
        return fondosDisponibles;
    }

    public void setFondosDisponibles(int fondosDisponibles) {
        this.fondosDisponibles = fondosDisponibles;
    }
}