package model.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import model.Galeria;
import model.inventario.Pieza;

public class CentralPersistencia {
	
	private Galeria galeria;
	private BufferedReader buffEntrada;
	private FileReader archivoLeer;
	private FileWriter entradaEscritura;
	private PrintWriter buffSalida;
	
	
	public Galeria getGaleria() {
		return galeria;
	}

	
	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}
	
	
	public BufferedReader getBuffEntrada() {
		return buffEntrada;
	}

	public void setBuffEntrada(BufferedReader buffEntrada) {
		this.buffEntrada = buffEntrada;
	}

	public FileWriter getEntradaEscritura() {
		return entradaEscritura;
	}

	public void setEntradaEscritura(FileWriter entradaEscritura) {
		this.entradaEscritura = entradaEscritura;
	}

	public PrintWriter getBuffSalida() {
		return buffSalida;
	}

	public void setBuffSalida(PrintWriter buffSalida) {
		this.buffSalida = buffSalida;
	}

	public FileReader getArchivoLeer() {
		return archivoLeer;
	}

	public void setArchivoLeer(FileReader archivoLeer) {
		this.archivoLeer = archivoLeer;
	}

	public static void cargarObjetos(){
		File usuarioTXT = new File("usuario.txt");
		File piezasTXT = new File ("piezas.txt");
		File ventasTXT = new File ("ventas.txt");
		File empleadoTXT = new File ("empleados.txt");
	}
	public String leerObjetosUsuarios() throws IOException{
		this.archivoLeer = new FileReader ("usuario.txt");
		buffEntrada = new BufferedReader (archivoLeer);
		String datos = "";
		String linea = this.buffEntrada.readLine();
		while (linea != null) {
			datos += linea+"\n";
			linea = this.buffEntrada.readLine();
		}
		buffEntrada.close();
		return datos;
		}
	
	public void escribirDatosUsuarios(String datos) throws IOException {
		entradaEscritura = new FileWriter("usuario.txt", true);
		buffSalida = new PrintWriter(entradaEscritura);
		buffSalida.println(datos);
		buffSalida.close();
	}
	public String leerObjetosPieza() throws IOException{
		this.archivoLeer = new FileReader ("piezas.txt");
		buffEntrada = new BufferedReader (archivoLeer);
		String datos = "";
		String linea = this.buffEntrada.readLine();
		while (linea != null) {
			datos += linea+"\n";
			linea = this.buffEntrada.readLine();
		}
		buffEntrada.close();
		return datos;
		}
	
	public void escribirDatosPieza(String datos) throws IOException {
		entradaEscritura = new FileWriter("piezas.txt", true);
		buffSalida = new PrintWriter(entradaEscritura);
		buffSalida.println(datos);
		buffSalida.close();
	}
	public String leerObjetosVentas() throws IOException{
		this.archivoLeer = new FileReader ("ventas.txt");
		buffEntrada = new BufferedReader (archivoLeer);
		String datos = "";
		String linea = this.buffEntrada.readLine();
		while (linea != null) {
			datos += linea+"\n";
			linea = this.buffEntrada.readLine();
		}
		buffEntrada.close();
		return datos;
		}
	
	public void escribirDatosVentas(String datos) throws IOException {
		entradaEscritura = new FileWriter("ventas.txt", true);
		buffSalida = new PrintWriter(entradaEscritura);
		buffSalida.println(datos);
		buffSalida.close();
	}
	public String leerObjetosFotografia() throws IOException{
		
		this.archivoLeer = new FileReader ("piezas.txt");
		buffEntrada = new BufferedReader (archivoLeer);
		String datos = "";
		String linea = this.buffEntrada.readLine();
		while (linea != null) {
			datos += linea+"\n";
			linea = this.buffEntrada.readLine();
		}
		buffEntrada.close();
		return datos;
		}

	public void escribirDatosFotografia(HashMap<String, HashMap<String, Pieza>> datos) throws IOException {
		entradaEscritura = new FileWriter("piezas.txt", true);
		buffSalida = new PrintWriter(entradaEscritura);
		buffSalida.println(datos);
		for (String Fotografía : datos.keySet()) {
            System.out.println("Clave externa: " + Fotografía);
            HashMap<String, Pieza> mapaInterno = datos.get(Fotografía);
            for (Map.Entry<String, Pieza> entradaInterna : mapaInterno.entrySet()) {
                String claveInterna = entradaInterna.getKey();
                Pieza pieza = entradaInterna.getValue();
                pieza.getFormato();
                System.out.println(claveInterna);}}
		buffSalida.close();
			
		}
	}
