package com.blue.apartamentos.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;;

@Entity
@Table(name = "clientes")
public class ClienteModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoCliente tipo = TipoCliente.INDIVIDUAL;

    @Column(name = "nombre", nullable = false, length = 35)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 35)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false, length = 10)
    private Date fechaNacimiento;
    
    @Column(name = "numero_ine", unique = true, length = 20)
    private String ine;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", nullable = false)
    private Status estatus;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    public enum Status {
        ACTIVO,
        INACTIVO,
        SUSPENDIDO
    }

    public enum TipoCliente {
        REGULAR,
        PREMIUM,
        VIP,
        INDIVIDUAL,
        EMPRESA,
        AGENCIA
    }

    // Getters and Setters
    // Falta la generación de los metodos getters y setters de acada atributo de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Status getEstatus() {
        return estatus;
    }

    public void setEstatus(Status estatus) {
        this.estatus = estatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClienteModel() {
    }

    public ClienteModel(Long id, TipoCliente tipo, String nombres, String apellidos, String email,
            String telefono, Date fechaNacimiento, String ine, String direccion, LocalDateTime fechaRegistro,
            Status estatus, String password) {
        this.id = id;
        this.tipo = tipo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.ine = ine;
        this.direccion = direccion;
        this.fechaRegistro = LocalDateTime.now();
        this.estatus = estatus;
        this.password = password;
    }

    // Crea otro constructor con los atributos necesarios para registrar un cliente
    public ClienteModel(TipoCliente tipo, String nombres, String apellidos, String email,
            String telefono, Date fechaNacimiento, String ine, String direccion, Status estatus, String password) {
        this.tipo = tipo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.ine = ine;
        this.direccion = direccion;
        this.fechaRegistro = LocalDateTime.now();
        this.estatus = estatus;
        this.password = password;
    }
}
