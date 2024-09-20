package Lab8;

public class BinaryTree {
	private Nodo root;
	private int size;

	public BinaryTree() {
		root = new Nodo();
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isRoot(Nodo v) {
		return v.equals(root);
	}

	public boolean isInternal(Nodo v) {
		return hasLeft(v) || hasRight(v);
	}

	public boolean hasLeft(Nodo v) {
		return v.getLeft() != null;
	}

	public boolean hasRight(Nodo v) {
		return v.getRight() != null;
	}

	public int depth(Nodo v) {
		if (isRoot(v)) {
			return 0;
		} else {
			return 1 + depth(parent(v));
		}
	}

	public int height(Nodo v) {
		if (!isInternal(v)) {
			return 0;
		} else {
			int h = 0;
			h = Math.max(height(left(v)), height(right(v)));
			return 1 + h;
		}
	}

	public Nodo root() {
		return root;
	}

	public Nodo left(Nodo v) {
		return v.getLeft();
	}

	public Nodo right(Nodo v) {
		return v.getRight();
	}

	public Nodo parent(Nodo v) {
		if (isRoot(v)) {
			return null;
		} else {
			QueueListaNodo Q = new QueueListaNodo();
			Q.enqueue(root);
			Nodo temp = null;

			while (!Q.isEmpty()) {
				temp = (Nodo) Q.dequeue();
				if (hasLeft(temp) && left(temp) == v) {
					return temp; // El padre está a la izquierda
				}
				if (hasRight(temp) && right(temp) == v) {
					return temp; // El padre está a la derecha
				}
				if (hasLeft(temp)) {
					Q.enqueue(left(temp)); // Explorar el subárbol izquierdo
				}
				if (hasRight(temp)) {
					Q.enqueue(right(temp)); // Explorar el subárbol derecho
				}
			}
		}
		return null; // Retorna null si no se encuentra el padre
	}

	public void addRoot(Object e) {
		root = new Nodo(e);
		size = 1;
	}

	public void insertLeft(Nodo v, Object e) {
		Nodo left = new Nodo(e);
		v.setLeft(left);
		size++;
	}

	public void insertRight(Nodo v, Object e) {
		Nodo right = new Nodo(e);
		v.setRight(right);
		size++;
	}

	public void remove(Nodo v) {
		Nodo p = parent(v);
		Nodo Child;
		if (hasLeft(v) || hasRight(v)) {
			if (hasLeft(v)) {
				Child = left(v);
			} else {
				Child = right(v);
			}
			if (left(p) == v) {
				p.setLeft(Child);
			} else {
				p.setRight(Child);
			}
			v.setLeft(null);
			v.setRight(null);
		} else {
			if (left(p) == v) {
				p.setLeft(null);
			} else {
				p.setRight(null);
			}
		}
		size--;
	}
}
