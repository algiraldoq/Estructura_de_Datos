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

	public Nodo predecesor(Nodo v) {
		Nodo temp = v.getLeft();
		return maxNode(temp);
	}

	public BSTEntry remove(int k) {
		Nodo v = find(k);
		BSTEntry temp = (BSTEntry) v.getData();
		if (hasLeft(v) && hasRight(v)) {
			Nodo w = predecesor(v);
			v.setData(w.getData());
			super.remove(w);
		} else {
			super.remove(v);
		}
		return temp;
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
