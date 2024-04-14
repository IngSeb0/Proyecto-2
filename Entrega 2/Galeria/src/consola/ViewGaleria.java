package consola;

import java.util.Scanner;

import modelo.Galeria;

public class ViewGaleria extends View {

	  public static void main(String[] args) {
		  
		  Galeria galeria = new Galeria();
		  
		  if (galeria.getUsuarios().isEmpty()) {
			  ViewRegistro viewRegistro = new ViewRegistro(galeria);
			  viewRegistro.mostrarMenu();
		  }
		  
		  ViewLogin viewLogin = new ViewLogin(galeria);
		  viewLogin.mostrarMenu();
		  
		  Scanner scanner = new Scanner(System.in);
		  boolean running = true;
		  while (running && scanner.hasNextLine()) {
			  String input = scanner.nextLine();
			  if(input.equalsIgnoreCase("exit")) {
				  //PERSISTIR TOOODOOO PRIMERO
				  running = false;
			  }
		  }
		  scanner.close();
	  }
	  
}
