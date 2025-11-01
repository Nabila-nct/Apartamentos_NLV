package com.blue.apartamentos.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resenas")
public class ResenasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_reservacion", nullable = false)
    private ReservacionesModel reservacion;

    @Column(name = "calificacion_limpieza")
    private Integer calificacionLimpieza;

    @Column(name = "calificacion_ubicacion")
    private Integer calificacionUbicacion;

    @Column(name = "calificacion_comunicacion")
    private Integer calificacionComunicacion;

    @Column(name = "calificacion_general")
    private Integer calificacionGeneral;

    @Lob
    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_resena")
    private LocalDateTime fechaResena;

    @Lob
    @Column(name = "respuesta_propietario")
    private String respuestaPropietario;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    public ResenasModel() {
    }

    public ResenasModel(Long id, Long idReservacion, Integer calificacionLimpieza, Integer calificacionUbicacion,
            Integer calificacionComunicacion, Integer calificacionGeneral, String comentario,
            LocalDateTime fechaResena, String respuestaPropietario, LocalDateTime fechaRespuesta) {
        this.id = id;
        if (idReservacion != null) {
            ReservacionesModel r = new ReservacionesModel();
            r.setId(idReservacion);
            this.reservacion = r;
        }
        this.calificacionLimpieza = calificacionLimpieza;
        this.calificacionUbicacion = calificacionUbicacion;
        this.calificacionComunicacion = calificacionComunicacion;
        this.calificacionGeneral = calificacionGeneral;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
        this.respuestaPropietario = respuestaPropietario;
        this.fechaRespuesta = fechaRespuesta;
    }

    public ResenasModel(Long idReservacion, Integer calificacionLimpieza, Integer calificacionUbicacion,
            Integer calificacionComunicacion, Integer calificacionGeneral, String comentario) {
        if (idReservacion != null) {
            ReservacionesModel r = new ReservacionesModel();
            r.setId(idReservacion);
            this.reservacion = r;
        }
        this.calificacionLimpieza = calificacionLimpieza;
        this.calificacionUbicacion = calificacionUbicacion;
        this.calificacionComunicacion = calificacionComunicacion;
        this.calificacionGeneral = calificacionGeneral;
        this.comentario = comentario;
        this.fechaResena = LocalDateTime.now();
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

    public Integer getCalificacionLimpieza() {
        return calificacionLimpieza;
    }

    public void setCalificacionLimpieza(Integer calificacionLimpieza) {
        this.calificacionLimpieza = calificacionLimpieza;
    }

    public Integer getCalificacionUbicacion() {
        return calificacionUbicacion;
    }

    public void setCalificacionUbicacion(Integer calificacionUbicacion) {
        this.calificacionUbicacion = calificacionUbicacion;
    }

    public Integer getCalificacionComunicacion() {
        return calificacionComunicacion;
    }

    public void setCalificacionComunicacion(Integer calificacionComunicacion) {
        this.calificacionComunicacion = calificacionComunicacion;
    }

    public Integer getCalificacionGeneral() {
        return calificacionGeneral;
    }

    public void setCalificacionGeneral(Integer calificacionGeneral) {
        this.calificacionGeneral = calificacionGeneral;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }

    public String getRespuestaPropietario() {
        return respuestaPropietario;
    }

    public void setRespuestaPropietario(String respuestaPropietario) {
        this.respuestaPropietario = respuestaPropietario;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

}
