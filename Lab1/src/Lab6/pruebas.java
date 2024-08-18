package Lab6;

import Lab2.Usuario;

public class pruebas {
	public static void main(String[] args) {
		// Prueba Stack
		stack stack = new stack();
		stack.push(2);
		stack.push(4);
		stack.push(6);
		stack.push(8);
		stack.push(10);

		System.out.println("Pila:");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		// Prueba Queue
		queue queue = new queue();
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(8);
		queue.enqueue(10);

		System.out.println("\nCola:");
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}

		// TODO: prueba 3
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		Usuario usuario4 = new Usuario();
		Usuario usuario5 = new Usuario();

		usuario1.setNombre("Alejandro");
		usuario1.setId(1000753146L);

		usuario2.setNombre("Juan");
		usuario2.setId(2364384783L);

		usuario3.setNombre("Felipe");
		usuario3.setId(8974629831L);

		usuario4.setNombre("Laura");
		usuario4.setId(3894563346L);

		usuario5.setNombre("Anderson");
		usuario5.setId(5646326297L);

		turnoUsuario turnos = new turnoUsuario();
		turnos.registrar(usuario1);
		turnos.registrar(usuario2);
		turnos.registrar(usuario3);
		turnos.registrar(usuario4);
		turnos.registrar(usuario5);
		turnos.toFile();
		turnos.atenderSiguiente();
		turnos.atenderSiguiente();
		turnos.toFile();
	}
}
