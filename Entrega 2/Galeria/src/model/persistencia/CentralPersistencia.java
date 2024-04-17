package model.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.View;

import model.Galeria;
import model.inventario.Artista;
import model.inventario.Escultura;
import model.inventario.Pieza;
import model.usuarios.Cajero;
import model.usuarios.Usuario;
import model.ventas.Consignacion;
import model.ventas.Oferta;
import model.ventas.Subasta;
import model.ventas.Venta;
import view.ViewAdministrador;
import view.ViewCajero;
import view.ViewComprador;
import view.ViewEmpleado;
import view.ViewLogin;
import view.ViewRegistro;

import java.io.*;

public class CentralPersistencia {
	
	public Galeria galeria;
	public Usuario usuarios;
	public Cajero cajero;
	public Pieza pieza;
	public Escultura escultura;
	public Artista artista;
	public Consignacion consignacion;
	public Oferta ofertas;
	public Subasta subastas;
	public Venta ventas;
	public View view;
	public ViewAdministrador adminView;
	public ViewCajero cajeroView;
	public ViewComprador compradorView;
	public ViewEmpleado viewEmpleado;
	public ViewLogin viewLogin;
	public ViewRegistro viewRegistro;
	
	
    public static void guardarGaleria(Galeria galeria, String nombreArchivo) {
        try {
            FileOutputStream archivoSalida = new FileOutputStream("fichero.txt");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(galeria);
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("Galería guardada correctamente.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Galeria cargarGaleria(String nombreArchivo) {
        Galeria galeria = null;
        try {
            FileInputStream archivoEntrada = new FileInputStream("fichero.txt");
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            galeria = (Galeria) objetoEntrada.readObject();
            objetoEntrada.close();
            archivoEntrada.close();
            System.out.println("Se ha guardado la galeria correctamente");
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return galeria;
    }

	public Galeria getGaleria() {
		return galeria;
	}

	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public Escultura getEscultura() {
		return escultura;
	}

	public void setEscultura(Escultura escultura) {
		this.escultura = escultura;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Consignacion getConsignacion() {
		return consignacion;
	}

	public void setConsignacion(Consignacion consignacion) {
		this.consignacion = consignacion;
	}

	public Oferta getOfertas() {
		return ofertas;
	}

	public void setOfertas(Oferta ofertas) {
		this.ofertas = ofertas;
	}

	public Subasta getSubastas() {
		return subastas;
	}

	public void setSubastas(Subasta subastas) {
		this.subastas = subastas;
	}

	public Venta getVentas() {
		return ventas;
	}

	public void setVentas(Venta ventas) {
		this.ventas = ventas;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public ViewAdministrador getAdminView() {
		return adminView;
	}

	public void setAdminView(ViewAdministrador adminView) {
		this.adminView = adminView;
	}

	public ViewCajero getCajeroView() {
		return cajeroView;
	}

	public void setCajeroView(ViewCajero cajeroView) {
		this.cajeroView = cajeroView;
	}

	public ViewComprador getCompradorView() {
		return compradorView;
	}

	public void setCompradorView(ViewComprador compradorView) {
		this.compradorView = compradorView;
	}

	public ViewEmpleado getViewEmpleado() {
		return viewEmpleado;
	}

	public void setViewEmpleado(ViewEmpleado viewEmpleado) {
		this.viewEmpleado = viewEmpleado;
	}

	public ViewLogin getViewLogin() {
		return viewLogin;
	}

	public void setViewLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;
	}

	public ViewRegistro getViewRegistro() {
		return viewRegistro;
	}

	public void setViewRegistro(ViewRegistro viewRegistro) {
		this.viewRegistro = viewRegistro;
	}
    
    
    
}