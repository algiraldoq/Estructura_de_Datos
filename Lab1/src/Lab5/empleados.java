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
			entrada = new BufferedReader(fr);
			while ((s = entrada.readLine()) != null) {
				String claves[] = s.split(",");
				if (claves[0].equalsIgnoreCase(id.toString()) && claves[1] == password) {
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
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				bw.write("");
			} catch (IOException e) {
				System.out.println("Error al eliminar contenido del archivo: " + e.getMessage());
			}
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
		Usuario u = buscarEmpleado(id);
		if (u != null) {
			System.out.println("¿Cual es la nueva clave?");
			String contraseña = scanner.nextLine();
			NodoDoble currentPassword = lstPasswords.first();
			while (currentPassword != null) {
				String[] clave = (String[]) currentPassword.getData();
				if (clave[0].equalsIgnoreCase(String.valueOf(id))) {
					clave[1] = contraseña;
					currentPassword.setData(clave);
					break;
				}
				currentPassword = currentPassword.getNext();
			}
		} else {
			System.out.println("Usuario no Existe");
		}
	}

	public static void main(String[] args) {
		Import();
		bandejaEntrada.ImportMensajes();
		Usuario usuario = null;
		while (usuario == null) {
			System.out.print("Digite su numero de identificación: ");
			long id = scanner.nextLong();
			usuario = buscarEmpleado(id);
			if (usuario == null) {
				System.out.println("Usuario no existe");
			} else {
				break;
			}
		}
		String[] EmpleadoVerificado = new String[3];
		while (EmpleadoVerificado[0] == null) {
			System.out.print("Digite su contraseña: ");
			String contraseña = scanner.nextLine();
			EmpleadoVerificado = autenticarEmpleado(usuario.getId(), contraseña);
		}
		Boolean HacerAlgoMas = Boolean.TRUE;
		while (HacerAlgoMas) {
			if (EmpleadoVerificado[2].equalsIgnoreCase("empleado")) {
				System.out.println("1.ver bandeja de Mensajes \n2.enviarMensaje");
				int desicion = scanner.nextInt();
				if (desicion == 1) {
					bandejaEntrada.mostrarBandejaEntrada(usuario);
				} else if (desicion == 2) {
					enviarMensaje();
				}
			} else if (EmpleadoVerificado[2].equalsIgnoreCase("Administrador")) {
				System.out.println(
						"1.ver bandeja de Mensajes \n2.enviarMensaje\\n3.Cambiar contraseñas\\n4.eliminar usuarios");
				int desicion = scanner.nextInt();
				if (desicion == 1) {
					bandejaEntrada.mostrarBandejaEntrada(usuario);
				} else if (desicion == 2) {
					enviarMensaje();
				} else if (desicion == 3) {
					cambiarContraseñas();
				} else if (desicion == 4) {
					eliminarUsuarios();
				}
			}
			System.out.println("Desea Hacer algo mas? 1. Si 2. No");
			int desicion = scanner.nextInt();
			if (desicion == 1) {
				HacerAlgoMas = Boolean.TRUE;
			} else {
				HacerAlgoMas = Boolean.FALSE;
			}
		}

		bandejaEntrada.toFile();
		toFileEmpleados();
		toFilePassWords();
	}
}
