package com.blue.apartamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "reservaciones")
public class ReservacionesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservacion")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_propiedad", nullable = false)
	private PropiedadesModel propiedad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	private ClienteModel cliente;

	@Column(name = "fecha_entrada")
	private LocalDate fechaEntrada;

	@Column(name = "fecha_salida")
	private LocalDate fechaSalida;

	@Column(name = "numero_huespedes")
	private Integer numeroHuespedes;

	@Column(name = "precio_total", precision = 12, scale = 2)
	private BigDecimal precioTotal;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 50)
	private EstadoReservacion estado = EstadoReservacion.PENDIENTE;

	@Column(name = "fecha_reservacion")
	private LocalDateTime fechaReservacion;

	@Lob
	@Column(name = "notas")
	private String notas;

	@Column(name = "codigo_reserva", length = 100)
	private String codigoReserva;

	@Column(name = "fecha_checkin")
	private LocalDateTime fechaCheckin;

	@Column(name = "fecha_checkout")
	private LocalDateTime fechaCheckout;

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PropiedadesModel getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(PropiedadesModel propiedad) {
		this.propiedad = propiedad;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getNumeroHuespedes() {
		return numeroHuespedes;
	}

	public void setNumeroHuespedes(Integer numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public EstadoReservacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoReservacion estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaReservacion() {
		return fechaReservacion;
	}

	public void setFechaReservacion(LocalDateTime fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public LocalDateTime getFechaCheckin() {
		return fechaCheckin;
	}

	public void setFechaCheckin(LocalDateTime fechaCheckin) {
		this.fechaCheckin = fechaCheckin;
	}

	public LocalDateTime getFechaCheckout() {
		return fechaCheckout;
	}

	public void setFechaCheckout(LocalDateTime fechaCheckout) {
		this.fechaCheckout = fechaCheckout;
	}

	public ReservacionesModel() {
	}

	public ReservacionesModel(Long id, Long idPropiedad, Long idCliente, LocalDate fechaEntrada,
			LocalDate fechaSalida, Integer numeroHuespedes, BigDecimal precioTotal, EstadoReservacion estado,
			LocalDateTime fechaReservacion, String notas, String codigoReserva, LocalDateTime fechaCheckin,
			LocalDateTime fechaCheckout) {
		this.id = id;
		if (idPropiedad != null) {
			PropiedadesModel p = new PropiedadesModel();
			// solo referencia por id
			try { p.getClass(); } catch (Exception ignored) {}
			p.setId(idPropiedad);
			this.propiedad = p;
		}
		if (idCliente != null) {
			ClienteModel c = new ClienteModel();
			c.setId(idCliente);
			this.cliente = c;
		}
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroHuespedes = numeroHuespedes;
		this.precioTotal = precioTotal;
		this.estado = estado;
		this.fechaReservacion = fechaReservacion;
		this.notas = notas;
		this.codigoReserva = codigoReserva;
		this.fechaCheckin = fechaCheckin;
		this.fechaCheckout = fechaCheckout;
	}

	public ReservacionesModel(Long idPropiedad, Long idCliente, LocalDate fechaEntrada,
			LocalDate fechaSalida, Integer numeroHuespedes, BigDecimal precioTotal, EstadoReservacion estado,
			String notas, String codigoReserva) {
		if (idPropiedad != null) {
			PropiedadesModel p = new PropiedadesModel();
			p.setId(idPropiedad);
			this.propiedad = p;
		}
		if (idCliente != null) {
			ClienteModel c = new ClienteModel();
			c.setId(idCliente);
			this.cliente = c;
		}
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroHuespedes = numeroHuespedes;
		this.precioTotal = precioTotal;
		this.estado = estado;
		this.fechaReservacion = LocalDateTime.now();
		this.notas = notas;
		this.codigoReserva = codigoReserva;
	}

	public enum EstadoReservacion {
		PENDIENTE,
		CONFIRMADA,
		CANCELADA,
		FINALIZADA
	}

}
