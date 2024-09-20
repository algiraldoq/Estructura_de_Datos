package Lab8;

public class ListaNodo {
	private Nodo head;
	private Nodo tail;
	private Integer size;

	public ListaNodo() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Integer size() {
		return size;
	}

	public Boolean isEmpty() {
		return size == 0;
	}

	public Nodo first() {
		return head;
	}

	public Nodo last() {
		return tail;
	}

	public void addFirst(Object e) {
		Nodo n = new Nodo(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			n.setLeft(head);
			head.setRight(n);
			head = n;
		}
		size++;
	}

	public void addLast(Object e) {
		Nodo n = new Nodo(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			tail.setLeft(n);
			n.setRight(tail);
			tail = n;
		}
		size++;
	}

	public Object removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			Nodo temp = head;
			head = temp.getLeft();
			temp.setLeft(null);
			temp.setRight(null);
			size--;
			return temp.getData();
		}
	}

	public Object removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			Nodo temp = tail;
			tail = temp.getRight();
			tail.setLeft(null);
			temp.setRight(null);
			size--;
			return temp.getData();
		}
	}

	public Object remove(Nodo n) {
		if (n == head) {
			return removeFirst();
		} else if (n == tail) {
			return removeLast();
		} else {
			Object e = n.getData();
			Nodo p = n.getRight();
			Nodo nx = n.getLeft();
			p.setLeft(nx);
			nx.setRight(p);
			n.setLeft(null);
			n.setRight(null);
			size--;
			return e;
		}
	}

	public void addBefore(Nodo n, Object e) {
		if (n == head) {
			addFirst(e);
		} else {
			Nodo m = new Nodo(e);
			Nodo p = n.getRight();
			p.setLeft(m);
			m.setRight(p);
			m.setLeft(n);
			n.setRight(m);
			size++;
		}
	}

	public void addAfter(Nodo n, Object e) {
		if (n == tail) {
			addLast(e);
		} else {
			Nodo m = new Nodo(e);
			Nodo nx = n.getLeft();
			n.setLeft(m);
			m.setRight(n);
			m.setLeft(nx);
			nx.setRight(m);
			size++;
		}
	}
}
