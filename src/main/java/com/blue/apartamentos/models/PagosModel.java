package com.blue.apartamentos.models;

import java.math.BigDecimal;
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
@Table(name = "pagos")
public class PagosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_reservacion", nullable = false)
	private ReservacionesModel reservacion;

	@Column(name = "monto", precision = 12, scale = 2)
	private BigDecimal monto;

	@Enumerated(EnumType.STRING)
	@Column(name = "metodo_pago", length = 50)
	private MetodoPago metodoPago = MetodoPago.TARJETA;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 50)
	private EstadoPago estado = EstadoPago.PENDIENTE;

	@Column(name = "fecha_pago")
	private LocalDateTime fechaPago;

	@Column(name = "referencia_pago", length = 200)
	private String referenciaPago;

	@Lob
	@Column(name = "datos_pago")
	private String datosPago;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	public PagosModel() {
	}

	public PagosModel(Long id, Long idReservacion, BigDecimal monto, MetodoPago metodoPago, EstadoPago estado,
			LocalDateTime fechaPago, String referenciaPago, String datosPago, LocalDateTime fechaCreacion) {
		this.id = id;
		if (idReservacion != null) {
			ReservacionesModel r = new ReservacionesModel();
			r.setId(idReservacion);
			this.reservacion = r;
		}
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.referenciaPago = referenciaPago;
		this.datosPago = datosPago;
		this.fechaCreacion = fechaCreacion;
	}

	public PagosModel(Long idReservacion, BigDecimal monto, MetodoPago metodoPago, EstadoPago estado,
			LocalDateTime fechaPago, String referenciaPago, String datosPago) {
		if (idReservacion != null) {
			ReservacionesModel r = new ReservacionesModel();
			r.setId(idReservacion);
			this.reservacion = r;
		}
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.fechaPago = fechaPago;
		this.referenciaPago = referenciaPago;
		this.datosPago = datosPago;
		this.fechaCreacion = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservacionesModel getReservacion() {
		return reservacion;
	}

	public void setReservacion(ReservacionesModel reservacion) {
		this.reservacion = reservacion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public EstadoPago getEstado() {
		return estado;
	}

	public void setEstado(EstadoPago estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	public String getDatosPago() {
		return datosPago;
	}

	public void setDatosPago(String datosPago) {
		this.datosPago = datosPago;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public enum MetodoPago {
		TARJETA,
		TRANSFERENCIA,
		PAYPAL,
		EFECTIVO,
		OTRO
	}

	public enum EstadoPago {
		PENDIENTE,
		COMPLETADO,
		FALLIDO,
		REEMBOLSADO
	}

}
