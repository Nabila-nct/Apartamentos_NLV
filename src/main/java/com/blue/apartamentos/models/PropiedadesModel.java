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
@Table(name = "propiedades")
public class PropiedadesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_propiedad")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_propietario", nullable = false)
	private ClienteModel propietario;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 50)
	private Tipo tipo = Tipo.APARTAMENTO;

	@Column(name = "titulo", length = 255)
	private String titulo;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@Lob
	@Column(name = "direccion")
	private String direccion;

	@Column(name = "ciudad", length = 100)
	private String ciudad;

	@Column(name = "codigo_postal", length = 50)
	private String codigoPostal;

	@Column(name = "pais", length = 100)
	private String pais;

	@Column(name = "latitud", precision = 10, scale = 7)
	private BigDecimal latitud;

	@Column(name = "longitud", precision = 10, scale = 7)
	private BigDecimal longitud;

	@Column(name = "precio_noche", precision = 12, scale = 2)
	private BigDecimal precioNoche;

	@Column(name = "capacidad_personas")
	private Integer capacidadPersonas;

	@Column(name = "numero_habitaciones")
	private Integer numeroHabitaciones;

	@Column(name = "numero_banos")
	private Integer numeroBanos;

	@Column(name = "metros_cuadrados")
	private Integer metrosCuadrados;

	@Lob
	@Column(name = "comodidades")
	private String comodidades;

	@Lob
	@Column(name = "normas_casa")
	private String normasCasa;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 50)
	private Estado estado = Estado.DISPONIBLE;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public enum EstadoPropiedad {
    DISPONIBLE,
    NO_DISPONIBLE,
    EN_MANTENIMIENTO,
    RESERVADO
}

public enum TipoPropiedad {
    APARTAMENTO,
    CASA,
    ESTUDIO,
    VILLA,
    BUNGALOW,
    OTRO
}


	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteModel getPropietario() {
		return propietario;
	}

	public void setPropietario(ClienteModel propietario) {
		this.propietario = propietario;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public BigDecimal getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(BigDecimal precioNoche) {
		this.precioNoche = precioNoche;
	}

	public Integer getCapacidadPersonas() {
		return capacidadPersonas;
	}

	public void setCapacidadPersonas(Integer capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Integer getNumeroBanos() {
		return numeroBanos;
	}

	public void setNumeroBanos(Integer numeroBanos) {
		this.numeroBanos = numeroBanos;
	}

	public Integer getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Integer metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getComodidades() {
		return comodidades;
	}

	public void setComodidades(String comodidades) {
		this.comodidades = comodidades;
	}

	public String getNormasCasa() {
		return normasCasa;
	}

	public void setNormasCasa(String normasCasa) {
		this.normasCasa = normasCasa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public PropiedadesModel() {
	}

	public PropiedadesModel(Long id, Long idPropietario, Tipo tipo, String titulo, String descripcion,
			String direccion, String ciudad, String codigoPostal, String pais, BigDecimal latitud,
			BigDecimal longitud, BigDecimal precioNoche, Integer capacidadPersonas, Integer numeroHabitaciones,
			Integer numeroBanos, Integer metrosCuadrados, String comodidades, String normasCasa, Estado estado,
			LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
		this.id = id;
		if (idPropietario != null) {
			ClienteModel c = new ClienteModel();
			c.setId(idPropietario);
			this.propietario = c;
		}
		this.tipo = tipo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precioNoche = precioNoche;
		this.capacidadPersonas = capacidadPersonas;
		this.numeroHabitaciones = numeroHabitaciones;
		this.numeroBanos = numeroBanos;
		this.metrosCuadrados = metrosCuadrados;
		this.comodidades = comodidades;
		this.normasCasa = normasCasa;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion != null ? fechaCreacion : LocalDateTime.now();
		this.fechaActualizacion = fechaActualizacion != null ? fechaActualizacion : this.fechaCreacion;
	}

	public PropiedadesModel(Long idPropietario, Tipo tipo, String titulo, String descripcion, String direccion,
			String ciudad, String codigoPostal, String pais, BigDecimal latitud, BigDecimal longitud,
			BigDecimal precioNoche, Integer capacidadPersonas, Integer numeroHabitaciones, Integer numeroBanos,
			Integer metrosCuadrados, String comodidades, String normasCasa, Estado estado) {
		if (idPropietario != null) {
			ClienteModel c = new ClienteModel();
			c.setId(idPropietario);
			this.propietario = c;
		}
		this.tipo = tipo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precioNoche = precioNoche;
		this.capacidadPersonas = capacidadPersonas;
		this.numeroHabitaciones = numeroHabitaciones;
		this.numeroBanos = numeroBanos;
		this.metrosCuadrados = metrosCuadrados;
		this.comodidades = comodidades;
		this.normasCasa = normasCasa;
		this.estado = estado;
		this.fechaCreacion = LocalDateTime.now();
		this.fechaActualizacion = this.fechaCreacion;
	}

	// Enums internos (mismo estilo que ClienteModel)
	public enum Tipo {
		APARTAMENTO,
		CASA,
		ESTUDIO,
		VILLA,
		BUNGALOW,
		OTRO
	}

	public enum Estado {
		DISPONIBLE,
		NO_DISPONIBLE,
		EN_MANTENIMIENTO,
		RESERVADO
	}

}
