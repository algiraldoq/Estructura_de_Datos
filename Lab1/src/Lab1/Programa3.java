package Lab1;

import java.util.HashMap;
import java.util.Scanner;

public class Programa3 {
	public static void maAin(String[] args) {
		HashMap<String, String> usuariosContrasenas = new HashMap<>();
		usuariosContrasenas.put("Juan1223", "J12an*.");
		usuariosContrasenas.put("Maria2345", "M23a*.");
		usuariosContrasenas.put("Pablo1459", "P14o*.");
		usuariosContrasenas.put("Ana3456", "A34a*.");
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i <= 3; i++) {
			if(i==3) {
				System.out.println("Lo siento, su acceso no es permitido.");
				break;
			}
			System.out.println("Ingrese su nombre de usuario:");
			String nombreUsuario = scanner.nextLine();
			System.out.println("Ingrese su contraseña:");
			String contrasena = scanner.nextLine();

			if (usuariosContrasenas.containsKey(nombreUsuario)) {
				String contrasenaGuardada = usuariosContrasenas.get(nombreUsuario);
				if (contrasenaGuardada.equals(contrasena)) {
					System.out.println("Acceso Permitido");
					break;
				} else {
					System.out.println("Datos Incorrectos");
				}
			} else {
				System.out.println("Datos Incorrectos");
			}
		}
		scanner.close();
	}
}
