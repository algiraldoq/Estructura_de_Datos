package Lab8;

public class QueueListaNodo {
	private ListaNodo list;

	// Constructor vacío
	public QueueListaNodo() {
		this.list = new ListaNodo();
	}

	// Retorna el tamaño de la cola
	public int size() {
		return list.size();
	}

	// Verifica si la cola está vacía
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Agrega un elemento al final de la cola
	public void enqueue(Object item) {
		list.addLast(item);
	}

	// Remueve y retorna el elemento del frente de la cola
	public Object dequeue() {
		return list.removeFirst();
	}

	// Retorna el elemento en el frente de la cola sin removerlo
	public Nodo first() {
		return list.first();
	}
}
