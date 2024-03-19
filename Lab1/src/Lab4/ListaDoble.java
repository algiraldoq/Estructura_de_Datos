package Lab4;

public class ListaDoble {
	private NodoDoble head;
	private NodoDoble tail;
	private Integer size;

	public ListaDoble() {
		super();
		this.head = null;
	    this.tail = null;
	    this.size = 0; 
	}
	
	public Integer Size() {
		return size;
	}

	public Boolean isEmpty() {
		return size == 0;
	}

	public NodoDoble first() {
		return head;
	}

	public NodoDoble last() {
		return tail;
	}

	public void addFirst(Object e) {
		NodoDoble n = new NodoDoble(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head.setPrev(n);
			head = n;
		}
		size++;
	}

	public void addLast(Object e) {
		NodoDoble n = new NodoDoble(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
		}
		size++;
	}

	public Object removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			NodoDoble temp = head;
			head = temp.getNext();
			temp.setNext(null);
			temp.setPrev(null);
			size--;
			return temp.getData();
		}
	}

	public Object removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			NodoDoble temp = tail;
			tail = temp.getPrev();
			tail.setNext(null);
			temp.setPrev(null);
			size--;
			return temp.getData();
		}
	}

	public Object remove(NodoDoble n) {
		if (n == head) {
			return removeFirst();
		} else if (n == tail) {
			return removeLast();
		} else {
			Object e = n.getData();
			NodoDoble p = n.getPrev();
			NodoDoble nx = n.getNext();
			p.setNext(nx);
			nx.setPrev(p);
			n.setNext(null);
			n.setPrev(null);
			size--;
			return e;
		}
	}

	public void addBefore(NodoDoble n, Object e) {
		if (n == head) {
			addFirst(e);
		} else {
			NodoDoble m = new NodoDoble(e);
			NodoDoble p = n.getPrev();
			p.setNext(m);
			m.setPrev(p);
			m.setNext(n);
			n.setPrev(m);
			size++;
		}
	}

	public void addAfter(NodoDoble n, Object e) {
		if (n == tail) {
			addLast(e);
		} else {
			NodoDoble m = new NodoDoble(e);
			NodoDoble nx = n.getNext();
			n.setNext(m);
			m.setPrev(n);
			m.setNext(nx);
			nx.setPrev(m);
			size++;
		}
	}
}
