package consola;

import java.util.Scanner;

public abstract class View {

	protected Scanner scanner; 
	
	public View() {
		this.scanner = new Scanner(System.in);
	}
	
	public void mostrarMenu() {
		
	}
	
	public String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
//        if (input.equalsIgnoreCase("exit")) {
//            System.out.println("Cerrando Aplicación...");
//            System.out.println("Gracias por usar.");
//            close();
//            System.exit(0);
//        }
        return input;
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
