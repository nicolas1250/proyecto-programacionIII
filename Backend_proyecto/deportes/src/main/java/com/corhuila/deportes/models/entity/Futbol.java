package com.corhuila.deportes.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="futbol")
public class Futbol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)

    private String nombre;

    private Long jugadoresPorEquipos;

    private Long duracion;
    @Column(length = (100))
    private String popularidadGlobal;
    @Column(length = (100))
    private String origen;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getJugadoresPorEquipos() {
        return jugadoresPorEquipos;
    }

    public void setJugadoresPorEquipos(Long jugadoresPorEquipos) {
        this.jugadoresPorEquipos = jugadoresPorEquipos;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public String getPopularidadGlobal() {
        return popularidadGlobal;
    }

    public void setPopularidadGlobal(String popularidadGlobal) {
        this.popularidadGlobal = popularidadGlobal;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    private static final long serialVersionUID = 1L;



    }
