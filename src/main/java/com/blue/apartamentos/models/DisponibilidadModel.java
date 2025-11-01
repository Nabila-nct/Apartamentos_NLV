package com.blue.apartamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "disponibilidad")
public class DisponibilidadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disponibilidad")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_propiedad", nullable = false)
	private PropiedadesModel propiedad;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "disponible")
	private Boolean disponible = Boolean.TRUE;

	@Column(name = "precio_especial", precision = 12, scale = 2)
	private BigDecimal precioEspecial;

	public DisponibilidadModel() {
	}

	public DisponibilidadModel(Long id, Long idPropiedad, LocalDate fecha, Boolean disponible, BigDecimal precioEspecial) {
		this.id = id;
		if (idPropiedad != null) {
			PropiedadesModel p = new PropiedadesModel();
			p.setId(idPropiedad);
			this.propiedad = p;
		}
		this.fecha = fecha;
		this.disponible = disponible;
		this.precioEspecial = precioEspecial;
	}

	public DisponibilidadModel(Long idPropiedad, LocalDate fecha, Boolean disponible, BigDecimal precioEspecial) {
		if (idPropiedad != null) {
			PropiedadesModel p = new PropiedadesModel();
			p.setId(idPropiedad);
			this.propiedad = p;
		}
		this.fecha = fecha;
		this.disponible = disponible;
		this.precioEspecial = precioEspecial;
	}

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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public BigDecimal getPrecioEspecial() {
		return precioEspecial;
	}

	public void setPrecioEspecial(BigDecimal precioEspecial) {
		this.precioEspecial = precioEspecial;
	}

}
