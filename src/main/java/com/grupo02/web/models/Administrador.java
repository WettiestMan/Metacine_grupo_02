package com.grupo02.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdmin")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @OneToOne(mappedBy = "administrador")
    private Cine cine;

    public Administrador() {
        id = null;
        nombre = null;
        correo = null;
        cine = null;
    }

    public Administrador(Long id, String nombre, String correo, Cine cine) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cine = cine;
    }

    public Long getId() {
        return id;
    }

    public Cine getCine() {
        return cine;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
