package Lab6;

import Lab4.ListaSimple;
import Lab4.NodoSimple;

public class stack {
	private ListaSimple list;

	// Constructor vacío
	public stack() {
		this.list = new ListaSimple();
	}

	// Retorna el tamaño de la pila
	public int size() {
		return list.size();
	}

	// Verifica si la pila está vacía
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Agrega un elemento al tope de la pila
	public void push(Object item) {
		list.addFirst(item);
	}

	// Remueve y retorna el elemento del tope de la pila
	public Object pop() {
		return list.removeFirst();
	}

	// Retorna el elemento en el tope de la pila sin removerlo
	public NodoSimple top() {
		return list.first();
	}
}
