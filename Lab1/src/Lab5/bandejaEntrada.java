package Lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Lab2.Fecha;
import Lab2.Usuario;
import Lab4.ListaDoble;
import Lab4.NodoDoble;

public class bandejaEntrada {
	public static ListaDoble bandejaEntrada = new ListaDoble();

	public static void ImportMensajes() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/BandejaEntrada.txt";
			File file = new File(ruta);
			FileReader fr = new FileReader(file);
			BufferedReader entrada = new BufferedReader(fr);
			String s;
			while ((s = entrada.readLine()) != null) {
				String mensajeArchivo[] = s.split(",");
				String fecha[] = mensajeArchivo[4].split("/");
				Fecha fechaMensaje = new Fecha(Short.valueOf(fecha[0]), Short.valueOf(fecha[1]),
						Short.valueOf(fecha[2]));
				Mensaje mensajes = new Mensaje(Long.valueOf(mensajeArchivo[0]), mensajeArchivo[1], mensajeArchivo[2],
						mensajeArchivo[3], fechaMensaje, mensajeArchivo[5]);
				if (bandejaEntrada.isEmpty()) {
					bandejaEntrada.addFirst(mensajes);
				} else {
					bandejaEntrada.addLast(mensajes);

				}
			}
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void agregarMensaje(Object mensaje) {
		bandejaEntrada.addLast(mensaje);
	}

	public static void mostrarBandejaEntrada(Usuario empleado) {
		NodoDoble mensaje = bandejaEntrada.first();
		while (mensaje != null) {
			Mensaje mensajeSelect = (Mensaje) mensaje.getData();
			if (empleado.getId().equals(mensajeSelect.getIdDestinatario())) {
				System.out.println(mensajeSelect.toString());
			}
			mensaje = mensaje.getNext();
		}
	}

	public static void mensajeVer(String tituloMensaje) {
		NodoDoble current = bandejaEntrada.first();
		while (current != null) {
			Mensaje mensajes = (Mensaje) current.getData();
			if (tituloMensaje.equalsIgnoreCase(mensajes.getTituloMensaje())) {
				System.out.println(mensajes.mostrarMensaje(mensajes));
				return;
			}
			current = current.getNext();
		}
	}

	public static void toFile() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/BandejaEntrada.txt";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				bw.write("");
			} catch (IOException e) {
				System.out.println("Error al eliminar contenido del archivo: " + e.getMessage());
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				NodoDoble actual = bandejaEntrada.first();
				while (actual != null) {
					Mensaje mensajeSelect = (Mensaje) actual.getData();
					bw.write(mensajeSelect.guardar());
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
}
