package com.blue.apartamentos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "propiedad_imagenes")
public class PropiedadImagenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propiedad", nullable = false)
    private PropiedadesModel propiedad;

    @Column(name = "url_imagen", length = 500)
    private String urlImagen;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "es_principal")
    private Boolean esPrincipal = Boolean.FALSE;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;

    public PropiedadImagenModel() {
    }

    public PropiedadImagenModel(Long id, Long idPropiedad, String urlImagen, Integer orden, Boolean esPrincipal,
            LocalDateTime fechaSubida) {
        this.id = id;
        if (idPropiedad != null) {
            PropiedadesModel p = new PropiedadesModel();
            p.setId(idPropiedad);
            this.propiedad = p;
        }
        this.urlImagen = urlImagen;
        this.orden = orden;
        this.esPrincipal = esPrincipal;
        this.fechaSubida = fechaSubida;
    }

    public PropiedadImagenModel(Long idPropiedad, String urlImagen, Integer orden, Boolean esPrincipal,
            LocalDateTime fechaSubida) {
        if (idPropiedad != null) {
            PropiedadesModel p = new PropiedadesModel();
            p.setId(idPropiedad);
            this.propiedad = p;
        }
        this.urlImagen = urlImagen;
        this.orden = orden;
        this.esPrincipal = esPrincipal;
        this.fechaSubida = fechaSubida;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDateTime fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

}
