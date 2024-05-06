package model.inventario;
import java.util.ArrayList;
import java.util.HashMap;
public class Video extends Pieza {
	private int duracion;
	private boolean ParaMayoresDe18;
	private String resolucion;
	private int EspacioEnMemoria;

	public Video(String idPieza, String ubicacion, String tituloPieza, String anioCreacion, String lugarCreacion,
			String nombreArtista, int costoFijo, String tipoPieza, int duracion, boolean paraMayoresDe18,
			String resolucion, int espacioEnMemoria, ArrayList<HashMap<String, Object>>historia) {
		super(idPieza, ubicacion, tituloPieza, anioCreacion, lugarCreacion, nombreArtista, costoFijo, tipoPieza, historia);
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