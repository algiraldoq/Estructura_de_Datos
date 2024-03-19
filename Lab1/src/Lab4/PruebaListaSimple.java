// PruebaListaSimple.java
package Lab4;

public class PruebaListaSimple {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Crear una colección donde cada nodo almacena los números pares del 1 al 20
        for (int i = 2; i <= 20; i += 2) {
            lista.addLast(i);
        }

        System.out.println("Datos en la lista simple:");
        NodoSimple current = lista.first();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();

        // Eliminar los números 2, 20 y 10
        lista.removeFirst(); // Elimina 2 (primer nodo)
        lista.removeLast(); // Elimina 20 (último nodo)

        // Eliminar el número 10 (quinto nodo)
        current = lista.first();
        for (int i = 0; i < 3; i++) {
            current = current.getNext();
        }
        NodoSimple temp = current.getNext();
        current.setNext(temp.getNext());
        temp.setNext(null);
        lista.size(lista.size() - 1);

        System.out.println("\nDatos en la lista simple resultante:");
        current = lista.first();
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }
}