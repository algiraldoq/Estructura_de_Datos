package Lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Lab2.Usuario;
import Lab4.NodoSimple;

public class turnoUsuario {
	private queue registro;
	private stack usuarioAtendidos;

	public turnoUsuario() {
		this.registro = new queue();
		this.usuarioAtendidos = new stack();
	}

	public void registrar(Usuario u) {
		registro.enqueue(u);
	}

	// TODO: retorna Usuario
	public void atenderSiguiente() {
		Usuario usuario = (Usuario) registro.dequeue();
		if (usuario != null) {
			usuarioAtendidos.push(usuario);
		}
	}

	public void toFile() {
		try (PrintWriter pendientes = new PrintWriter(new FileWriter(
				"/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/usuariospendientes.txt"));
				PrintWriter atendidos = new PrintWriter(new FileWriter(
						"/home/artifex/Documents/Universidad/Estructura_de_Datos/Lab1/src/Archivos/usuariosatendidos.txt"))) {

			// Guardar usuarios pendientes
			NodoSimple current = registro.first(); // Obtén el primer nodo de la cola
			while (current != null) {
				Usuario u = (Usuario) current.getData();
				pendientes.println(u.getId() + "," + u.getNombre());
				current = current.getNext(); // Avanza al siguiente nodo
			}

			NodoSimple current2 = usuarioAtendidos.top();
			while (current2 != null) {
				Usuario u = (Usuario) current2.getData();
				atendidos.println(u.getId() + "," + u.getNombre());
				current2 = current2.getNext(); // Avanza al siguiente nodo
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
