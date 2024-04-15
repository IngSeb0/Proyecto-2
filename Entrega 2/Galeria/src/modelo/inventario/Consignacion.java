package modelo.inventario;
import modelo.inventario.Pieza;
import modelo.perfiles.Administrador;
import modelo.perfiles.Propietario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


public class Consignacion{
	private Pieza pieza;
	private Administrador administrador;
	private Propietario propietario;
	private String fechaVencimiento;
	private String modoConsignacion;
	
	
	public Consignacion(Pieza pieza, String fechaVencimiento, String modoConsignacion) {
		this.pieza = pieza;
		this.fechaVencimiento = fechaVencimiento;
		this.modoConsignacion = modoConsignacion;
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
		

	public Pieza getPieza() {
		return pieza;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public boolean verificarVencimiento(String fechaActual) {
		boolean resultado;
		String [] fechaA=fechaActual.split("/");
		String [] fechaV=this.getFechaVencimiento().split("/");
		int AnioA=Integer.parseInt(fechaA[2]);
		int AnioV=Integer.parseInt(fechaV[2]);
		int MesA=Integer.parseInt(fechaA[1]);
		int MesV=Integer.parseInt(fechaV[1]);
		int DiaA=Integer.parseInt(fechaA[0]);
		int DiaV=Integer.parseInt(fechaV[0]);
		
		LocalDate VENCIMIENTO=LocalDate.of(AnioV, MesV, DiaV);
		LocalDate ACTUAL=LocalDate.of(AnioA, MesA, DiaA);
		if (VENCIMIENTO.isEqual(ACTUAL)) {
		    resultado=false;
		} else if (VENCIMIENTO.isBefore(ACTUAL)) {
			Administrador Admin=this.getAdministrador();
			Pieza pieza=this.getPieza();
			this.finalizarConsignacion(pieza, Admin);
		    resultado=true;
		    
		} else {
		    resultado=false;
		}
		return resultado;
	}

	public void finalizarConsignacion(Pieza pieza, Administrador administrador) {
		//El admin elimina la pieza de la galeria administrador.devolucionPieza(Pieza pieza)
	}
	
}