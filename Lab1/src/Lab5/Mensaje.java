package Lab5;

import Lab2.Fecha;

public class Mensaje {
	private Long idDestinatario;
	private String nomRedactor;
	private String tituloMensaje;
	private String mensaje;
	private Fecha fecha;
	private String hora;

	public Mensaje(Long idDestinatario, String nomRedactor, String tituloMensaje, String mensaje, Fecha fecha,
			String hora) {
		super();
		this.idDestinatario = idDestinatario;
		this.nomRedactor = nomRedactor;
		this.tituloMensaje = tituloMensaje;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String toString() {
		return "fecha=" + fecha + hora + "|" + tituloMensaje + "|envia:" + nomRedactor;
	}

	public Long getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getTituloMensaje() {
		return tituloMensaje;
	}

	public void setTituloMensaje(String tituloMensaje) {
		this.tituloMensaje = tituloMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNomRedactor() {
		return nomRedactor;
	}

	public void setNomRedactor(String nomRedactor) {
		this.nomRedactor = nomRedactor;
	}

	public String mostrarMensaje(Mensaje mensaje) {
		return "Titulo:" + mensaje.getTituloMensaje() + "\nMensaje:" + mensaje.getMensaje();
	}

	public String guardar() {
		return idDestinatario.toString() + "," + nomRedactor + "," + tituloMensaje + "," + mensaje + "," + fecha + ","
				+ hora;
	}
}
