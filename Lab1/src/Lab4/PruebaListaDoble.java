// PruebaListaDoble.java
package Lab4;

public class PruebaListaDoble {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        // Crear una colección donde cada nodo almacena los números pares del 1 al 20
        for (int i = 2; i <= 20; i += 2) {
            lista.addLast(i);
        }

        System.out.println("Datos en la lista doble:");
        NodoDoble current = lista.first();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();

        // Eliminar los números 1, 10 y 20
        lista.removeFirst(); // Elimina 2 (primer nodo)
        lista.removeLast(); // Elimina 20 (último nodo)
        NodoDoble temp = lista.first();
        for (int i = 0; i < 3; i++) {
            temp = temp.getNext();
        }
        lista.remove(temp); // Elimina 10 (quinto nodo)

        System.out.println("\nDatos en la lista doble resultante:");
        current = lista.first();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}