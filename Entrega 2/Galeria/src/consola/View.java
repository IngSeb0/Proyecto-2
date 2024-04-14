package consola;

import java.util.Scanner;

public abstract class View {

	protected Scanner scanner; 
	
	public View() {
		this.scanner = new Scanner(System.in);
	}
	
	public void mostrarMenu() {
		
	}
	
    public String getInput(String input) {
        System.out.println(input);
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Cerrando Aplicación...");
            System.exit(0);
        }
        return scanner.nextLine();
        
    }
    
    public String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    

    public void close() {
        scanner.close();
    }
}
