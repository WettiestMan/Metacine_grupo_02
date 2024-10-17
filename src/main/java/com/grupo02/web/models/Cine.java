package com.grupo02.web.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "cine")
public class Cine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCine")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin")
    @JsonIgnore
    private Administrador admin;

    @OneToOne(mappedBy = "cine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDuleria", referencedColumnName = "idDuleria")
    @JsonIgnore
    private Dulceria dulceria;

    public Cine() {
        id = null;
        nombre = null;
        direccion = null;
        telefono = null;
        admin = null;
        dulceria = null;
    }

    public Cine(Long id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Dulceria getDulceria() {
        return dulceria;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDulceria(Dulceria dulceria) {
        this.dulceria = dulceria;
    }
}
