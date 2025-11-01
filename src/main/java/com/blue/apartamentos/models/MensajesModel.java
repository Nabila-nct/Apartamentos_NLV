package com.blue.apartamentos.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class MensajesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mensaje")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_remitente", nullable = false)
	private ClienteModel remitente;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_destinatario", nullable = false)
	private ClienteModel destinatario;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_reservacion")
	private ReservacionesModel reservacion;

	@Column(name = "asunto", length = 200)
	private String asunto;

	@Lob
	@Column(name = "contenido")
	private String contenido;

	@Column(name = "leido")
	private Boolean leido = Boolean.FALSE;

	@Column(name = "fecha_envio")
	private LocalDateTime fechaEnvio;

	public MensajesModel() {
	}

	public MensajesModel(Long id, Long idRemitente, Long idDestinatario, Long idReservacion, String asunto,
			String contenido, Boolean leido, LocalDateTime fechaEnvio) {
		this.id = id;
		if (idRemitente != null) { ClienteModel c = new ClienteModel(); c.setId(idRemitente); this.remitente = c; }
		if (idDestinatario != null) { ClienteModel c2 = new ClienteModel(); c2.setId(idDestinatario); this.destinatario = c2; }
		if (idReservacion != null) { ReservacionesModel r = new ReservacionesModel(); r.setId(idReservacion); this.reservacion = r; }
		this.asunto = asunto;
		this.contenido = contenido;
		this.leido = leido;
		this.fechaEnvio = fechaEnvio;
	}

	public MensajesModel(Long idRemitente, Long idDestinatario, Long idReservacion, String asunto, String contenido) {
		if (idRemitente != null) { ClienteModel c = new ClienteModel(); c.setId(idRemitente); this.remitente = c; }
		if (idDestinatario != null) { ClienteModel c2 = new ClienteModel(); c2.setId(idDestinatario); this.destinatario = c2; }
		if (idReservacion != null) { ReservacionesModel r = new ReservacionesModel(); r.setId(idReservacion); this.reservacion = r; }
		this.asunto = asunto;
		this.contenido = contenido;
		this.leido = Boolean.FALSE;
		this.fechaEnvio = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteModel getRemitente() { return remitente; }
	public void setRemitente(ClienteModel remitente) { this.remitente = remitente; }
	public ClienteModel getDestinatario() { return destinatario; }
	public void setDestinatario(ClienteModel destinatario) { this.destinatario = destinatario; }
	public ReservacionesModel getReservacion() { return reservacion; }
	public void setReservacion(ReservacionesModel reservacion) { this.reservacion = reservacion; }

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

}
