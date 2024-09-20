package Lab8;

import Lab2.Usuario;

public class PruebaLab8 {

	public static void main(String[] args) {
		Usuario usu1 = new Usuario();
		usu1.setNombre("Juan");
		usu1.setId(10101013L);

		Usuario usu2 = new Usuario();
		usu2.setNombre("Pablo");
		usu2.setId(10001011L);

		Usuario usu3 = new Usuario();
		usu3.setNombre("Maria");
		usu3.setId(10101015L);

		Usuario usu4 = new Usuario();
		usu4.setNombre("Ana");
		usu4.setId(1010000L);

		Usuario usu5 = new Usuario();
		usu5.setNombre("Diana");
		usu5.setId(10111105L);

		Usuario usu6 = new Usuario();
		usu6.setNombre("Mateo");
		usu6.setId(10110005L);

		BinarySearchTree arbol = new BinarySearchTree();
		arbol.insert(usu1, 7);
		arbol.insert(usu2, 4);
		arbol.insert(usu3, 9);
		arbol.insert(usu4, 2);
		arbol.insert(usu5, 10);
		arbol.insert(usu6, 8);

		arbol.imprimirArbol();

		System.out.println("");
		System.out.println("");

		BSTEntry maximo = arbol.max(arbol, arbol.root());
		Usuario usu = (Usuario) maximo.getData();
		System.out.println("llave mayor:" + maximo.getKey() + ", " + usu.getNombre() + ", " + usu.getId());

		BSTEntry minimo = arbol.min(arbol, arbol.root());
		usu = (Usuario) minimo.getData();
		System.out.println("Llave menor:" + minimo.getKey() + ", " + usu.getNombre() + ", " + usu.getId());

		BSTEntry buscar = (BSTEntry) arbol.find(4).getData();
		usu = (Usuario) buscar.getData();
		System.out.println("Persona buscada:" + buscar.getKey() + ", " + usu.getNombre() + ", " + usu.getId());

		System.out.println("Metodo InOrder:");
		arbol.inOrder(arbol, arbol.root());

		System.out.println("");
		System.out.println("");
		System.out.println("");
		arbol.remove(10);
		arbol.imprimirArbol();
	}

}
