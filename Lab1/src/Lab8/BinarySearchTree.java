package Lab8;

import Lab2.Usuario;

public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree() {
		super();
	}

	private Nodo searchTree(int k, Nodo v) {
		BSTEntry u = (BSTEntry) v.getData();
		if (k == u.getKey()) {
			return v;
		} else if (k < u.getKey()) {
			return searchTree(k, v.getLeft());
		} else {
			return searchTree(k, v.getRight());
		}
	}

	public Nodo find(int k) {
		return searchTree(k, root());
	}

	private void addEntry(Nodo v, BSTEntry o) {
		BSTEntry temp = (BSTEntry) v.getData();
		Nodo nd = new Nodo(o);
		if (o.getKey() < temp.getKey()) {
			if (hasLeft(v)) {
				addEntry(left(v), o);
			} else {
				v.setLeft(nd);
			}
		} else {
			if (hasRight(v)) {
				addEntry(right(v), o);
			} else {
				v.setRight(nd);
			}
		}
	}

	public void insert(Object e, int k) {
		BSTEntry o = new BSTEntry(e, k);
		if (isEmpty()) {
			super.addRoot(o);
		} else {
			addEntry(root(), o);
		}
	}

	public Nodo maxNode(Nodo temp) {
		if (hasRight(temp)) {
			return maxNode(right(temp));
		} else {
			return temp;
		}
	}

	private Nodo minNode(Nodo v) {
		while (hasLeft(v)) {
			v = left(v);
		}
		return v;
	}

	public BSTEntry remove(int k) {
		Nodo v = find(k); // Buscar el nodo a eliminar
		if (v == null) {
			return null; // Si el nodo no existe, retorna null
		}

		BSTEntry temp = (BSTEntry) v.getData(); // Obtener los datos del nodo

		// Caso 1: v es una hoja (sin hijos)
		if (!hasLeft(v) && !hasRight(v)) {
			Nodo p = parent(v);
			if (p == null) {
				// v es la raíz
				super.addRoot(null); // Modificar la raíz
			} else if (left(p) == v) {
				p.setLeft(null);
			} else {
				p.setRight(null);
			}
		}
		// Caso 2: v tiene solo hijo izquierdo
		else if (!hasRight(v)) {
			Nodo child = left(v);
			Nodo p = parent(v);
			if (p == null) {
				// v es la raíz
				super.addRoot(child.getData());
			} else if (left(p) == v) {
				p.setLeft(child);
			} else {
				p.setRight(child);
			}
		}
		// Caso 3: v tiene solo hijo derecho
		else if (!hasLeft(v)) {
			Nodo child = right(v);
			Nodo p = parent(v);
			if (p == null) {
				// v es la raíz
				super.addRoot(child.getData());
			} else if (left(p) == v) {
				p.setLeft(child);
			} else {
				p.setRight(child);
			}
		}
		// Caso 4: v tiene dos hijos
		else {
			// Encontrar el sucesor (el nodo más pequeño del subárbol derecho)
			Nodo successor = minNode(right(v));
			BSTEntry successorEntry = (BSTEntry) successor.getData();

			// Copiar los datos del sucesor en el nodo actual
			v.setData(successorEntry);

			// Eliminar el sucesor manualmente
			Nodo successorParent = parent(successor);
			if (left(successorParent) == successor) {
				successorParent.setLeft(successor.getRight()); // Sucesor está a la izquierda del padre
			} else {
				successorParent.setRight(successor.getRight()); // Sucesor está a la derecha del padre
			}
		}

		return temp; // Retorna el nodo eliminado
	}// s

	public Nodo predecesor(Nodo v) {
		Nodo temp = v.getLeft();
		return maxNode(temp);
	}

	public void inOrder(BinaryTree t, Nodo v) {
		if (t.hasLeft(v)) {
			inOrder(t, t.left(v));
		}
		BSTEntry temp = (BSTEntry) v.getData();
		System.out.print(temp.getKey() + "-");
		if (t.hasRight(v)) {
			inOrder(t, t.right(v));
		}
	}

	public BSTEntry min(BinaryTree t, Nodo v) {
		if (t.hasLeft(v)) {
			return min(t, t.left(v));
		} else {
			return (BSTEntry) v.getData();
		}
	}

	public BSTEntry max(BinaryTree t, Nodo v) {
		if (t.hasRight(v)) {
			return max(t, t.right(v));
		} else {
			return (BSTEntry) v.getData();
		}
	}

	public void imprimirArbol(Nodo v, String indent, boolean esUltimo) {
		if (v != null) {
			System.out.print(indent);
			if (esUltimo) {
				System.out.print("Right----");
				indent += "     	";
			} else {
				System.out.print("Left----");
				indent += "|    	";
			}

			BSTEntry temp = (BSTEntry) v.getData();
			Usuario usu = (Usuario) temp.getData();
			System.out.println(temp.getKey() + ", " + usu.getNombre() + ", " + usu.getId());
			imprimirArbol(v.getLeft(), indent, false);
			imprimirArbol(v.getRight(), indent, true);
		}
	}

	public void imprimirArbol() {
		imprimirArbol(root(), "", true);
	}
}
