//package modelo.perfiles;
//
//public class GeneradorUsuario {
//	
//	
//	private 
//	
//	/*
//	 * Métodos
//	 */
//	
//	public static boolean validarLogin(String login)
//    {
//    	boolean present = false;
//    	if (logins.contains(login)) {
//    		present = true;
//    	}
//    	return present;
//    }
//
//	public static void validarPassword(String password) {
//
//		String mayusculaRegex = ".*[A-Z].*";
//        String simboloRegex = ".*[!@#$%^&*()].*";
//        String numeroRegex = ".*\\d.*";
//
//        if (!(password.matches(mayusculaRegex))) {
//			throw new IllegalArgumentException("La contraseña debe contener al menos una mayúscula");
//		} 
//		else if (!(password.matches(simboloRegex))) {
//			throw new IllegalArgumentException("La contraseña debe contener al menos un símbolo especial");
//		}
//		else if (!(password.matches(numeroRegex))) {
//			throw new IllegalArgumentException("La contraseña debe contener al menos un número");		
//		}	
//	}	
//
//}
