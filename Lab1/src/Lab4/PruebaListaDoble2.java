package Lab4;

import java.util.Scanner;
import Lab2.Direccion;
import Lab2.Fecha;
import Lab2.Usuario;

public class PruebaListaDoble2 {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        Scanner scanner = new Scanner(System.in);

        // Crear una colección con al menos 5 usuarios
        Fecha fechaNacimiento1 = new Fecha(Short.valueOf("02"), Short.valueOf("01"), Short.valueOf("2002"));
        Direccion direccion1 = new Direccion("calle66", "66-66", "VillaHermosa", "Medellín", null, null);
        Usuario usuario1 = new Usuario("Alejandro Giraldo Quiceno", 1000753146L, fechaNacimiento1, "Medellin", 3053080620L, "algiraldoq@unal.edu.co", direccion1);
        lista.addLast(usuario1);

        Fecha fechaNacimiento2 = new Fecha(Short.valueOf("12"), Short.valueOf("04"), Short.valueOf("2002"));
        Direccion direccion2 = new Direccion("calle13", "40-23", "Boston", "Medellín", null, null);
        Usuario usuario2 = new Usuario("Omar Garcia", 82364592236L, fechaNacimiento2, "Medellin", 3214574323L, "ogarcia@unal.edu.co", direccion2);
        lista.addLast(usuario2);

        Fecha fechaNacimiento3 = new Fecha(Short.valueOf("03"), Short.valueOf("07"), Short.valueOf("2001"));
        Direccion direccion3 = new Direccion("calle23", "74-12", "CampoValdez", "Medellín", null, null);
        Usuario usuario3 = new Usuario("Oscar Espinoza", 7936538921L, fechaNacimiento3, "Medellin", 3014538957L, "oespinoza@unal.edu.co", direccion3);
        lista.addLast(usuario3);
        
        Fecha fechanacimiento4 = new Fecha(Short.valueOf("14"), Short.valueOf("8"), Short.valueOf("2000"));
        Direccion direccion4 = new Direccion("calle40", "43-65", "VillaHermosa", "Medellín", null, null);
        Usuario usuario4 = new Usuario("Isabella Vanegas", 3969823375L, fechanacimiento4, "Medellin",
                3116453279L, "ivanegas@unal.edu.co", direccion4);
        lista.addLast(usuario4);
        
        Fecha fechanacimiento5 = new Fecha(Short.valueOf("30"), Short.valueOf("11"), Short.valueOf("1999"));
        Direccion direccion5 = new Direccion("calle3", "56-33", "guayabal", "Medellín", null, null);
        Usuario usuario5 = new Usuario ("Sofia Morales", 2384657289L, fechanacimiento5, "Medellin",
                3204658239L, "smorales@unal.edu.co", direccion5);
        lista.addLast(usuario5);

        System.out.println("Usuarios en la lista doble:");
        NodoDoble current = lista.first();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

        // Pedir por consola un nuevo usuario para ser insertado al principio
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del nuevo usuario: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el ID
        System.out.print("Ingrese la fecha de nacimiento (día mes año): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la fecha
        System.out.print("Ingrese la ciudad de nacimiento: ");
        String ciudadNacimiento = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        Long tel = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el teléfono
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese la dirección: (ejemplo: calle23 74-12 CampoValdez Medellín)");
        String direccionInput = scanner.nextLine();
        String direccion[] = direccionInput.split(" ");
		Direccion dir;
		if (direccion.length == 4) {
			dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], null, null);
		} else {
			dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], direccion[4],
					direccion[5]);
		}

        Fecha fechaNacimiento = new Fecha(Short.valueOf(String.valueOf(dia)), Short.valueOf(String.valueOf(mes)), Short.valueOf(String.valueOf(anio)));
        
        Usuario nuevoUsuario1 = new Usuario(nombre, id, fechaNacimiento, ciudadNacimiento, tel, email, dir);
        lista.addFirst(nuevoUsuario1);

        // Pedir por consola un nuevo usuario para ser insertado al final
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del nuevo usuario: ");
        id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el ID
        System.out.print("Ingrese la fecha de nacimiento (día mes año): ");
        dia = scanner.nextInt();
        mes = scanner.nextInt();
        anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la fecha
        System.out.print("Ingrese la ciudad de nacimiento: ");
        ciudadNacimiento = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        tel = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el teléfono
        System.out.print("Ingrese el email: ");
        email = scanner.nextLine();
        System.out.print("Ingrese la dirección: (ejemplo: calle23 74-12 CampoValdez Medellín)");
        direccionInput = scanner.nextLine();
        String dir2[] = direccionInput.split(" ");
		
		if (dir2.length == 4) {
			dir = new Direccion(dir2[0], dir2[1], dir2[2], dir2[3], null, null);
		} else {
			dir = new Direccion(dir2[0], dir2[1], dir2[2], dir2[3], dir2[4],
					dir2[5]);
		}

        fechaNacimiento = new Fecha(Short.valueOf(String.valueOf(dia)), Short.valueOf(String.valueOf(mes)), Short.valueOf(String.valueOf(anio)));
        Usuario nuevoUsuario2 = new Usuario(nombre, id, fechaNacimiento, ciudadNacimiento, tel, email, dir);
        lista.addLast(nuevoUsuario2);

        // Repite el mismo proceso que para el usuario insertado al principio

        System.out.println("\nUsuarios en la lista doble después de las inserciones:");
        current = lista.first();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

        // Pedir un usuario e insertarlo después del tercer nodo
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del nuevo usuario: ");
        id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el ID
        System.out.print("Ingrese la fecha de nacimiento (día mes año): ");
        dia = scanner.nextInt();
        mes = scanner.nextInt();
        anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la fecha
        System.out.print("Ingrese la ciudad de nacimiento: ");
        ciudadNacimiento = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        tel = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea después de leer el teléfono
        System.out.print("Ingrese el email: ");
        email = scanner.nextLine();
        
        System.out.print("Ingrese la dirección: (ejemplo: calle23 74-12 CampoValdez Medellín)");
        direccionInput = scanner.nextLine();
        String dir3[] = direccionInput.split(" ");
		
		if (dir3.length == 4) {
			dir = new Direccion(dir3[0], dir3[1], dir3[2], dir3[3], null, null);
		} else {
			dir = new Direccion(dir3[0], dir3[1], dir3[2], dir3[3], dir3[4],
					dir3[5]);
		}

        fechaNacimiento = new Fecha(Short.valueOf(String.valueOf(dia)), Short.valueOf(String.valueOf(mes)), Short.valueOf(String.valueOf(anio)));
        
        Usuario nuevoUsuario3 = new Usuario(nombre, id, fechaNacimiento, ciudadNacimiento, tel, email, dir);

        current = lista.first();
        for (int i = 0; i < 2; i++) {
            current = current.getNext();
        }
        lista.addAfter(current, nuevoUsuario3);

        System.out.println("\nUsuarios en la lista doble después de insertar después del tercer nodo:");
        current = lista.first();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

        scanner.close();
    }
}
