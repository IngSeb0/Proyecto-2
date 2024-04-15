package modelo.inventario;

import modelo.perfiles.Propietario;

public class Video extends Pieza {
	private int duracion;
	private boolean ParaMayoresDe18;
	private String resolucion;
	private int EspacioEnMemoria;
	
	public Video(String titulo, String anioCreacion, String lugarCreacion, Artista artista, Propietario propietario,
			Consignacion consignacion, int duracion, boolean paraMayoresDe18, String resolucion, int espacioEnMemoria) {
		super(titulo, anioCreacion, lugarCreacion, artista, propietario, consignacion);
		this.duracion = duracion;
		ParaMayoresDe18 = paraMayoresDe18;
		this.resolucion = resolucion;
		EspacioEnMemoria = espacioEnMemoria;
	}

	public int getDuracion() {
		return duracion;
	}

	public boolean isParaMayoresDe18() {
		return ParaMayoresDe18;
	}

	public String getResolucion() {
		return resolucion;
	}

	public int getEspacioEnMemoria() {
		return EspacioEnMemoria;
	}
	
}
	