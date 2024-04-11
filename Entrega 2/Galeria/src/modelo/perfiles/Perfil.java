//package modelo.perfiles;
//
//import java.util.HashMap;
//
//public abstract class Perfil {
//
//	/*
//	 * Atributos
//	 */
//
//	private static HashMap<String, Perfil> perfiles = new HashMap<>();
//
//	protected String nombre;
//
//	protected String apellido;
//
//	protected Usuario usuario;
//
//
//	/*
//	 * Constructor
//	 */
//
//	public Perfil(String nombre, String apellido, String login, String password) {
//		try {
//            Usuario usuario = new Usuario(this, login, password);
//            this.nombre = nombre;
//            this.apellido = apellido;
//            this.usuario = usuario;
//            perfiles.put(login, this);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//	}
//
//	/*
//	 * Getters
//	 */
//
//	public String getNombre() {
//        return nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    /*
//     * Métodos
//     */
//
//
//    public static Perfil getPerfil(String login) {
//        return perfiles.get(login); 
//    }
//}
//
