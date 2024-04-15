package consola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class View {

	/*
	 * Atributos
	 */
	
	protected Scanner scanner; 

	
	/*
	 * Constructor
	 */
	
	public View() {
		this.scanner = new Scanner(System.in);
	}
	
	
	/*
	 * Métodos
	 */
	
	
	// Muestra el menú propio del view
	
	public void mostrarMenu() {
	}
	
	
	// Recibir input desde la consola
	
	public String getInput(String prompt) {
        
		System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
    
	
	// Convertir la primera letra de cualquier input en mayúscula

	public String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    
	// Validar input de tipo fecha

	public String getInputFecha(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String input = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if (date.isBefore(LocalDate.now())) {
                    throw new IllegalArgumentException("La fecha no puede ser anterior a la fecha actual.");
                }
                return mensaje;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en formato DD-MM-YYYY.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    

	// Cerrar Scanner

	public void close() {
        scanner.close();
    }

	
}
