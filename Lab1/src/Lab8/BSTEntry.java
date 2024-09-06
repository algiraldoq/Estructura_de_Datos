package Lab8;

public class BSTEntry {
	private Object data;
	private int key;

	public BSTEntry(Object e, int k) {
		this.data = e;
		this.key = k;
	}

	public Object getData() {
		return data;
	}

	public int getKey() {
		return key;
	}

	public void setData(Object d) {
		this.data = d;
	}

	public void setKey(int k) {
		this.key = k;
	}

}
