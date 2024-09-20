package Lab9;

import Lab2.Usuario;
import Lab4.ListaDoble;
import Lab4.NodoDoble;

public class Chained_Hash<T> {
	private ListaDoble[] table;
	private int m;
	private String hashMethod;
	private static final double A = (Math.sqrt(5) - 1) / 2; // Constante para el método de la multiplicación

	// Constructor
	public Chained_Hash(int size, String hashMethod) {
		this.m = size;
		this.hashMethod = hashMethod;
		table = new ListaDoble[m];
		for (int i = 0; i < m; i++) {
			table[i] = new ListaDoble();
		}
	}

	// Función hash usando el método de la división
	private int hashDivision(int key) {
		return key % m;
	}

	// Función hash usando el método de la multiplicación
	private int hashMultiplication(int key) {
		double frac = key * A % 1;
		return (int) Math.floor(m * frac);
	}

	// Insertar un dato en la tabla hash
	public void insert(int key, T data) {
		int index = hashMethod.equals("division") ? hashDivision(key) : hashMultiplication(key);
		table[index].addLast(data); // Usando la clase ListaDoble
	}

	// Buscar un dato en la tabla hash
	@SuppressWarnings("unchecked")
	public T search(int key, T data) {
		int index = hashMethod.equals("division") ? hashDivision(key) : hashMultiplication(key);
		NodoDoble current = table[index].first(); // Primer nodo de la lista en esa posición
		while (current != null) {
			if (current.getData().equals(data)) {
				return (T) current.getData(); // Retorna el dato si lo encuentra
			}
			current = current.getNext();
		}
		return null; // No encontrado
	}

	// Eliminar un dato en la tabla hash
	public boolean remove(int key, T data) {
		int index = hashMethod.equals("division") ? hashDivision(key) : hashMultiplication(key);
		NodoDoble current = table[index].first(); // Primer nodo de la lista en esa posición
		while (current != null) {
			if (current.getData().equals(data)) {
				table[index].remove(current); // Elimina el nodo
				return true; // Eliminado
			}
			current = current.getNext();
		}
		return false; // No encontrado
	}

	// Método para imprimir el estado de la tabla (opcional)
	public void printTable() {
		for (int i = 0; i < m; i++) {
			System.out.print("Posición " + i + ": ");
			NodoDoble current = table[i].first();
			while (current != null) {
				System.out.print(current.getData() + " -> ");
				current = current.getNext();
			}
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		// Problema 1: Implementar operaciones con el método de la división
		System.out.println("==== Problema 1 - Método de la división ====");
		Chained_Hash<Integer> hashTableDiv = new Chained_Hash<>(10, "division");

		// a. Insertar 20 números aleatorios en la tabla Hash usando el método de la
		// división
		for (int i = 0; i < 20; i++) {
			int randomNum = (int) (Math.random() * 100);
			System.out.println("Insertando: " + randomNum);
			hashTableDiv.insert(randomNum, randomNum);
		}

		// Imprimir la tabla
		hashTableDiv.printTable();

		// b. Buscar uno de los números generados
		int searchKey = 42; // Ejemplo de búsqueda (puedes cambiar este número por uno que hayas generado)
		Integer foundDiv = hashTableDiv.search(searchKey, searchKey);
		if (foundDiv != null) {
			System.out.println("Encontrado en tabla (división): " + foundDiv);
		} else {
			System.out.println("No encontrado en tabla (división)");
		}

		// c. Eliminar uno de los números generados
		if (hashTableDiv.remove(searchKey, searchKey)) {
			System.out.println("Eliminado de la tabla (división): " + searchKey);
		} else {
			System.out.println("No se pudo eliminar de la tabla (división): " + searchKey);
		}

		// Imprimir la tabla después de eliminar
		hashTableDiv.printTable();

		// Problema 2, d: Repetir pasos a-c con el método de la multiplicación
		System.out.println("==== Problema 2, d - Método de la multiplicación ====");
		Chained_Hash<Integer> hashTableMul = new Chained_Hash<>(10, "multiplication");

		// a. Insertar 20 números aleatorios en la tabla Hash usando el método de la
		// multiplicación
		for (int i = 0; i < 20; i++) {
			int randomNum = (int) (Math.random() * 100);
			System.out.println("Insertando: " + randomNum);
			hashTableMul.insert(randomNum, randomNum);
		}

		// Imprimir la tabla
		hashTableMul.printTable();

		// b. Buscar uno de los números generados
		Integer foundMul = hashTableMul.search(searchKey, searchKey);
		if (foundMul != null) {
			System.out.println("Encontrado en tabla (multiplicación): " + foundMul);
		} else {
			System.out.println("No encontrado en tabla (multiplicación)");
		}

		// c. Eliminar uno de los números generados
		if (hashTableMul.remove(searchKey, searchKey)) {
			System.out.println("Eliminado de la tabla (multiplicación): " + searchKey);
		} else {
			System.out.println("No se pudo eliminar de la tabla (multiplicación): " + searchKey);
		}

		// Imprimir la tabla después de eliminar
		hashTableMul.printTable();

		System.out.println("==== Problema 3 - Tabla Hash con Usuarios ====");

		// Crear 6 usuarios con id y nombre
		Usuario[] usuarios = new Usuario[6];
		usuarios[0] = new Usuario("Ana", 123L, null, null, null, null, null);
		usuarios[1] = new Usuario("Carlos", 456L, null, null, null, null, null);
		usuarios[2] = new Usuario("Maria", 789L, null, null, null, null, null);
		usuarios[3] = new Usuario("Luis", 234L, null, null, null, null, null);
		usuarios[4] = new Usuario("Jose", 567L, null, null, null, null, null);
		usuarios[5] = new Usuario("Sofia", 890L, null, null, null, null, null);

		// Crear la tabla hash con 5 posiciones
		Chained_Hash<Usuario> hashTable = new Chained_Hash<>(5, "division");

		// a. Insertar los usuarios usando el método de la división
		System.out.println("Insertando usuarios con el método de la división:");
		for (Usuario usuario : usuarios) {
			hashTable.insert(usuario.getId().intValue(), usuario);
		}

		// Imprimir cuántos usuarios fueron almacenados en cada posición del arreglo
		hashTable.printTable();

		// b. Repetir usando el método de la multiplicación
		System.out.println("==== Usando el método de la multiplicación ====");
		Chained_Hash<Usuario> hashTableMul2 = new Chained_Hash<>(5, "multiplication");

		// Insertar los usuarios usando el método de la multiplicación
		System.out.println("Insertando usuarios con el método de la multiplicación:");
		for (Usuario usuario : usuarios) {
			hashTableMul2.insert(usuario.getId().intValue(), usuario);
		}

		// Imprimir cuántos usuarios fueron almacenados en cada posición del arreglo
		hashTableMul2.printTable();
	}

}
