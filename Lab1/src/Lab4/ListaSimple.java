package Lab4;

public class ListaSimple {
	private NodoSimple head;
	private NodoSimple tail;
	private Integer size;

	public ListaSimple() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Integer size() {
		return size;
	}

	public void size(Integer s) {
		size = s;
	}

	public Boolean isEmpty() {
		return size == 0;
	}

	public NodoSimple first() {
		return head;
	}

	public NodoSimple last() {
		return tail;
	}

	public void addFirst(Object first) {
		NodoSimple n = new NodoSimple(first);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}
		size++;
	}

	public void addLast(Object first) {
		NodoSimple n = new NodoSimple(first);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
		size++;
	}

	public Object removeFirst() {
		if (!isEmpty()) {
			NodoSimple temp = head;
			head = temp.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
		} else {
			return null;
		}
	}

	public Object removeLast() {
		if (size == 1) {
			return removeFirst();
		} else {
			NodoSimple temp = tail;
			NodoSimple anterior = head;
			while (anterior.getNext() != tail) {
				anterior = anterior.getNext();
			}
			anterior.setNext(null);
			tail = anterior;
			size--;
			return temp.getData();
		}
	}

}