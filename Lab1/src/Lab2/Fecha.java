package Lab2;

public class Fecha {
	private Short dd;
	private Short mm;
	private Short aa;

	public Fecha() {
		super();
	}

	@Override
	public String toString() {
		return dd.toString() + "/" + mm.toString() + "/" + aa.toString();
	}

	public Fecha(Short dd, Short mm, Short aa) {
		this.dd = dd;
		this.mm = mm;
		this.aa = aa;
	}

	public Short getDia() {
		return dd;
	}

	public void setDia(Short dd) {
		this.dd = dd;
	}

	public Short getMes() {
		return mm;
	}

	public void setMes(Short mm) {
		this.mm = mm;
	}

	public Short getA() {
		return aa;
	}

	public void setA(Short aa) {
		this.aa = aa;
	}
}
