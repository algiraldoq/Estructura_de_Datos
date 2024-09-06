package Lab6;

import Lab4.ListaSimple;
import Lab4.NodoSimple;

public class queue {
	  private ListaSimple list;

	    // Constructor vacío
	    public queue() {
	        this.list = new ListaSimple();
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
	    public NodoSimple first() {
	        return list.first();
	    }
}
