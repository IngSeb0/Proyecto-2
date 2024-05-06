package usuariosTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Galeria;
import model.inventario.Pintura;
import model.usuarios.Administrador;
import model.usuarios.Empleado;
import model.ventas.Oferta;
import model.ventas.Subasta;





public class EmpleadoTest {
	private Galeria galeria;

    private Empleado empleado;
    private Subasta subasta;
    private ArrayList<Oferta> ofertas;
    private Pintura pintura1;
    private Pintura pintura2;
    private Administrador admin;

    @BeforeEach
    public void setUp() {
        galeria = new Galeria(false);
        
        empleado = new Empleado("NombreEmpleado", "ApellidoEmpleado", "1234567890", "loginEmpleado", "passwordEmpleado", "TipoEmpleado");
        admin = new Administrador("NombreAdmin", "ApellidoAdmin", "1234567890", "loginAdmin", "cpasswordAdmin", "TipoAdmin");
        subasta = new Subasta("FechaSubasta", empleado, admin);
        
        ofertas = new ArrayList<>();
        pintura1 = new Pintura("ID1", "Ubicacion1", "Titulo1", "Anio1", "Lugar1", "Artista1", 100, "Tipo1", 50, 50, null);
        pintura2 = new Pintura("ID2", "Ubicacion2", "Titulo2", "Anio2", "Lugar2", "Artista2", 200, "Tipo2", 60, 60, null);
        Oferta oferta1 = new Oferta(pintura1, null, 50, "Peticion1", "MetodoPago1");
        Oferta oferta2 = new Oferta(pintura2, null, 150, "Peticion2", "MetodoPago2");
        ofertas.add(oferta1);
        ofertas.add(oferta2);
        
        for (Oferta oferta : ofertas) {
            subasta.addOferta(oferta);
        }
        
        empleado.setGaleria(galeria); 
        empleado.setSubastaEnCurso(subasta);
        empleado.setPiezaSubastaEnCurso(pintura1);
        galeria.addEmpleado(empleado);
        galeria.setAdministrador(admin);
        
        
       
    }



    @Test
    public void testRegistrarOfertasSubasta() {
    	
        
        empleado.registrarOfertasSubasta();
        
        
        
        ArrayList<Oferta> ofertasRegistradas = subasta.getOfertas();
        
        assertEquals(ofertas.size(), ofertasRegistradas.size(), "El número de ofertas registradas no coincide.");
        for (Oferta oferta : ofertas) {
            assertTrue(ofertasRegistradas.contains(oferta), "La oferta " + oferta.getIdOferta() + " no fue registrada correctamente.");
        }
    }


    
}
