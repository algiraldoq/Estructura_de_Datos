package Lab4;

public class NodoDoble {
	private Object data;
	private NodoDoble next;
	private NodoDoble prev;

	public NodoDoble() {
		super();
		this.data = null;
		this.next = null;
		this.prev = null;
	}

	public NodoDoble(Object data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public NodoDoble getNext() {
		return next;
	}

	public void setNext(NodoDoble next) {
		this.next = next;
	}

	public NodoDoble getPrev() {
		return prev;
	}

	public void setPrev(NodoDoble prev) {
		this.prev = prev;
	}
}
