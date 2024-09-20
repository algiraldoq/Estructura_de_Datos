package Lab2;

public class Usuario {
	private String nombre;
	private Long id;
	private Fecha fecha_nacimiento;
	private String ciudad_nacimiento;
	private Long tel;
	private String email;
	private Direccion dir;

	public Usuario() {
		super();
	}

	public Usuario(String nombre, Long id, Fecha fecha_nacimiento, String ciudad_nacimiento, Long tel, String email,
			Direccion dir) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad_nacimiento = ciudad_nacimiento;
		this.tel = tel;
		this.email = email;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return nombre + ", " + id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fecha getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Fecha fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCiudad_nacimiento() {
		return ciudad_nacimiento;
	}

	public void setCiudad_nacimiento(String ciudad_nacimiento) {
		this.ciudad_nacimiento = ciudad_nacimiento;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

}
