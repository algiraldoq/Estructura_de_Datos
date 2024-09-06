package Lab8;

public class Nodo {
	private Object data;
	private Nodo left;
	private Nodo right;

	public Nodo() {
		super();
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public Nodo(Object data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Nodo getLeft() {
		return left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}
}
