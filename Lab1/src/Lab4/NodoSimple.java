package Lab4;

public class NodoSimple {
	private Object data;
	private NodoSimple next;

	public NodoSimple() {
		super();
		this.data = null;
		this.next = null;
	}

	public NodoSimple(Object data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public NodoSimple getNext() {
		return next;
	}

	public void setNext(NodoSimple next) {
		this.next = next;
	}

}
