package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class View {

	protected Scanner scanner; 
	
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
                if (date.getYear() > 2024) {
                    throw new IllegalArgumentException("El año no puede ser mayor a 2024.");
                }
                return mensaje;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en formato DD-MM-YYYY.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
	
	// Validad input de tipo entero
	public int getInputInt(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero; // Return the successfully parsed integer
            } catch (Exception e) {
                scanner.nextLine();
            }
        }
    }
	
	// Manejar de sí o no.
	public boolean getInputY_N(String mensaje) {
        System.out.println(mensaje + " [Y/N]");
        while (true) {
            String action = getInput("Ingresa una opción:");
            if (action.equalsIgnoreCase("Y")) {
                return true;
            } else if (action.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Opción inválida. Ingresa 'Y' para sí o 'N' para no.");
            }
        }
    }
    

	// Cerrar Scanner
	public void close() {
        scanner.close();
    }

	
}
