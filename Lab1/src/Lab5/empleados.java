package Lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Lab2.Direccion;
import Lab2.Fecha;
import Lab2.Usuario;
import Lab4.ListaDoble;
import Lab4.NodoDoble;

public class empleados {

	public static ListaDoble lstEmpleados = new ListaDoble();
	public static ListaDoble lstPasswords = new ListaDoble();
	public static Scanner scanner = new Scanner(System.in);

	public static void Import() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/Empleados.txt";
			File file = new File(ruta);
			FileReader fr = new FileReader(file);
			BufferedReader entrada = new BufferedReader(fr);
			String s;
			while ((s = entrada.readLine()) != null) {
				String usuario[] = s.split(", ");
				String fecha[] = usuario[2].split("/");
				Fecha fecha_nacimiento = new Fecha(Short.valueOf(fecha[0]), Short.valueOf(fecha[1]),
						Short.valueOf(fecha[2]));
				String direccion[] = usuario[6].split(" ");
				Direccion dir;
				if (direccion.length == 4) {
					dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], null, null);
				} else {
					dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], direccion[4],
							direccion[5]);
				}
				Usuario u = new Usuario(usuario[0], Long.valueOf(usuario[1]), fecha_nacimiento, usuario[3],
						Long.valueOf(usuario[4]), usuario[5], dir);

				NodoDoble current = lstEmpleados.first();
				while (current != null && ((Usuario) current.getData()).getId() < u.getId()) {
					current = current.getNext();
				}
				if (current == null) {
					lstEmpleados.addLast(u);
				} else {
					lstEmpleados.addBefore(current, u);
				}
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("Error llenando Empleados");
			e.printStackTrace();
		}
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/Password.txt";
			File file = new File(ruta);
			FileReader fr;
			fr = new FileReader(file);
			BufferedReader entrada = new BufferedReader(fr);
			String s;
			while ((s = entrada.readLine()) != null) {
				String claves[] = s.split(",");
				NodoDoble current = lstPasswords.first();
				if (current == null) {
					lstPasswords.addLast(claves);
				} else {
					lstPasswords.addBefore(current, claves);
				}
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("Error llenando Passwords");
			e.printStackTrace();
		}
	}

	public static Usuario buscarEmpleado(Long id) {
		NodoDoble current = lstEmpleados.first();
		while (current != null) {
			Usuario u = (Usuario) current.getData();
			if (u.getId().equals(id)) {
				return u;
			}
			current = current.getNext();
		}
		return null; // No se encontró el empleado con ese ID
	}

	public static String[] autenticarEmpleado(Long id, String password) {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/Password.txt";
			File file = new File(ruta);
			FileReader fr = new FileReader(file);
			BufferedReader entrada = new BufferedReader(fr);
			String s;

			while ((s = entrada.readLine()) != null) {
				String[] claves = s.split(",");
				if (claves.length > 1 && claves[0].equals(id.toString()) && claves[1].trim().equals(password.trim())) {
					entrada.close();
					return claves;
				}
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void imprimirList() {
		NodoDoble current = lstEmpleados.first();
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

	public static void toFileEmpleados() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/Empleados.txt";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				bw.write("");
			} catch (IOException e) {
				System.out.println("Error al eliminar contenido del archivo: " + e.getMessage());
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				NodoDoble actual = lstEmpleados.first();
				while (actual != null) {
					Usuario u = (Usuario) actual.getData();
					bw.write(u.toString());
					bw.newLine();
					actual = actual.getNext();
				}
			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo: " + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void toFilePassWords() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/Password.txt";
			// Primero, elimina el contenido del archivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				bw.write("");
			} catch (IOException e) {
				System.out.println("Error al eliminar contenido del archivo: " + e.getMessage());
			}
			// Luego, escribe las contraseñas actuales en el archivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				NodoDoble actual = lstPasswords.first();
				while (actual != null) {
					String[] claves = (String[]) actual.getData();
					bw.write(claves[0] + "," + claves[1] + "," + claves[2]);
					bw.newLine();
					actual = actual.getNext();
				}
			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo: " + e.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enviarMensaje() {
		System.out.print("Digite el ID del destinatario: ");
		Long idDestinatario = scanner.nextLong();
		scanner.nextLine(); // Consume la nueva línea

		System.out.print("Digite su nombre: ");
		String nomRedactor = scanner.nextLine();

		System.out.print("Digite el título del mensaje: ");
		String tituloMensaje = scanner.nextLine();

		System.out.print("Digite el mensaje: ");
		String mensaje = scanner.nextLine();

		Fecha fechaActual = new Fecha((short) 18, (short) 8, (short) 2024); // Fecha actual como ejemplo

		System.out.print("Digite la hora (HH:MM): ");
		String hora = scanner.nextLine();

		Mensaje nuevoMensaje = new Mensaje(idDestinatario, nomRedactor, tituloMensaje, mensaje, fechaActual, hora);
		bandejaEntrada.agregarMensaje(nuevoMensaje);

		System.out.println("Mensaje enviado exitosamente.");
	}

	public static void eliminarUsuarios() {
		System.out.println("¿Cual es el id del usuario que desea Eliminar?");
		long id = scanner.nextLong();
		NodoDoble current = lstEmpleados.first();
		NodoDoble currentPassword = lstPasswords.first();
		while (current != null) {
			Usuario u = (Usuario) current.getData();
			if (u.getId().equals(id)) {
				lstEmpleados.remove(current);
				break;
			}
			current = current.getNext();
		}
		while (currentPassword != null) {
			String[] clave = (String[]) currentPassword.getData();
			if (clave[0].equalsIgnoreCase(String.valueOf(id))) {
				lstPasswords.remove(currentPassword);
				System.out.println("Usuario Eliminado" + id);
				break;
			}
			currentPassword = currentPassword.getNext();
		}

	}

	public static void cambiarContraseñas() {
		System.out.println("¿Cual es el id del usuario que desea Cambiar Contraseña?");
		long id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("¿Cual es la nueva clave?");
		String nuevaContraseña = scanner.nextLine();
		Usuario u = buscarEmpleado(id);
		if (u != null) {
			NodoDoble currentPassword = lstPasswords.first();
			while (currentPassword != null) {
				String[] clave = (String[]) currentPassword.getData();
				if (clave[0].equalsIgnoreCase(String.valueOf(id))) {
					clave[1] = nuevaContraseña;
					currentPassword.setData(clave);
					break;
				}
				currentPassword = currentPassword.getNext();
			}
		} else {
			System.out.println("Usuario no Existe");
		}
	}

	private static void crearUsuarios() {
		System.out.println("Ingrese El dia de nacimiento en numero:");
		String dianacimiento = scanner.nextLine();
		System.out.println("Ingrese El mes de nacimiento en numero:");
		String mesnacimiento = scanner.nextLine();
		System.out.println("Ingrese El año de nacimiento en numero:");
		String añonacimiento = scanner.nextLine();
		Fecha fecha_nacimiento = new Fecha();
		fecha_nacimiento.setDia(Short.valueOf(dianacimiento));
		fecha_nacimiento.setMes(Short.valueOf(mesnacimiento));
		fecha_nacimiento.setA(Short.valueOf(añonacimiento));

		Direccion direccion_residencia = new Direccion();

		System.out.println("Ingrese Su calle: (Ejemplo calle 54)");
		String calle = scanner.nextLine();
		System.out.println("Ingrese la nomenclatura de su direccion (Ejmplo 64-34)");
		String nomenclatura = scanner.nextLine();
		System.out.println("Ingrese Su barrio:");
		String barrio = scanner.nextLine();
		System.out.println("Ingrese Su Ciudad:");
		String ciudad = scanner.nextLine();
		System.out.println("¿Vive en edificio? responda 'Si' o 'NO'");
		String pregunta = scanner.nextLine();
		if (pregunta.equalsIgnoreCase("Si")) {
			System.out.println("Nombre edificio:");
			String edificio = scanner.nextLine();
			direccion_residencia.setEdificio(edificio);
			System.out.println("# de Apartamento:");
			String apt = scanner.nextLine();
			direccion_residencia.setApto(apt);
		} else {
			direccion_residencia.setEdificio(null);
			direccion_residencia.setApto(null);
		}

		direccion_residencia.setCalle(calle);
		direccion_residencia.setNomenclatura(nomenclatura);
		direccion_residencia.setBarrio(barrio);
		direccion_residencia.setCiudad(ciudad);

		Usuario usuario = new Usuario();
		System.out.println("Digite su nombre:");
		String nombre = scanner.nextLine();
		usuario.setNombre(nombre);
		System.out.println("Digite su #identificacion:");
		String id = scanner.nextLine();
		usuario.setId(Long.valueOf(id));
		System.out.println("Digite su ciudad de nacimiento:");
		String ciudad_nacimiento = scanner.nextLine();
		usuario.setCiudad_nacimiento(ciudad_nacimiento);
		System.out.println("Digite su telefono:");
		String telefono = scanner.nextLine();
		usuario.setTel(Long.valueOf(telefono));
		System.out.println("Digite su email:");
		String email = scanner.nextLine();
		usuario.setEmail(email);
		usuario.setFecha_nacimiento(fecha_nacimiento);
		usuario.setDir(direccion_residencia);

		lstEmpleados.addLast(usuario);

		System.out.println("Digite la Contraseña:");
		String contraseña = scanner.nextLine();
		System.out.println("que tipo de empleado es: (empleado o administrador)");
		String tipoEmpleado = scanner.nextLine();
		String[] passwordCreacionUsuario = new String[3];
		passwordCreacionUsuario[0] = usuario.getId().toString();
		passwordCreacionUsuario[1] = contraseña;
		passwordCreacionUsuario[2] = tipoEmpleado;
		lstPasswords.addLast(passwordCreacionUsuario);
		System.out.println("Creacion Exitosa");
	}

	public static void main(String[] args) {
		Import();
		bandejaEntrada.ImportMensajes();
		Usuario usuario = null;

		while (usuario == null) {
			System.out.print("Digite su número de identificación: ");
			long id = scanner.nextLong();
			scanner.nextLine(); // Consume el salto de línea
			usuario = buscarEmpleado(id);
			if (usuario == null) {
				System.out.println("Usuario no existe");
			}
		}

		String[] EmpleadoVerificado = null;

		while (EmpleadoVerificado == null) {
			System.out.print("Digite su contraseña: ");
			String contraseña = scanner.nextLine();
			EmpleadoVerificado = autenticarEmpleado(usuario.getId(), contraseña);

			if (EmpleadoVerificado == null) {
				System.out.println("Contraseña incorrecta. Inténtelo de nuevo.");
			}
		}

		if (EmpleadoVerificado.length > 2) {
			Boolean HacerAlgoMas = Boolean.TRUE;
			while (HacerAlgoMas) {
				if (EmpleadoVerificado[2].equalsIgnoreCase("empleado")) {
					System.out.println("1. Ver bandeja de Mensajes \n2. Enviar Mensaje \n3. Ver Mensaje");
					int decision = scanner.nextInt();
					scanner.nextLine();
					if (decision == 1) {
						bandejaEntrada.mostrarBandejaEntrada(usuario);
					} else if (decision == 2) {
						enviarMensaje();
					} else if (decision == 3) {
						System.out.println("Escriba el titulo del mensaje que desea ver");
						String titulo = scanner.nextLine();
						bandejaEntrada.mensajeVer(titulo);
					}
				} else if (EmpleadoVerificado[2].equalsIgnoreCase("administrador")) {
					System.out.println(
							"1. Ver bandeja de Mensajes \n2. Enviar Mensaje\n3. Cambiar contraseñas\n4. Eliminar usuarios\n5. Crear usuarios");
					int decision = scanner.nextInt();
					scanner.nextLine();
					if (decision == 1) {
						bandejaEntrada.mostrarBandejaEntrada(usuario);
					} else if (decision == 2) {
						enviarMensaje();
					} else if (decision == 3) {
						cambiarContraseñas();
					} else if (decision == 4) {
						eliminarUsuarios();
					} else if (decision == 5) {
						crearUsuarios();
					}
				}
				System.out.println("desea Hacer algo mas? \n1. Si \n2.No");
				int decision = scanner.nextInt();
				if (decision == 1) {
					HacerAlgoMas = Boolean.TRUE;
				} else {
					HacerAlgoMas = Boolean.FALSE;
				}
			}
		} else {
			System.out.println("Error de autenticación.");
		}
		bandejaEntrada.toFile();
		toFileEmpleados();
		toFilePassWords();
	}
}
