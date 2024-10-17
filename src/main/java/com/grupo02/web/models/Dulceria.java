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
@Table(name = "dulceria")
public class Dulceria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDuleria")
    private Long id;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idCine", referencedColumnName = "idCine")
    @JsonIgnore
    private Cine cine;

    public Dulceria() {
        id = null;
        direccion = null;
        cine = null;
    }

    public Dulceria(Long id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public Cine getCine() {
        return cine;
    }

    public String getDireccion() {
        return direccion;
    }

    public Long getId() {
        return id;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
