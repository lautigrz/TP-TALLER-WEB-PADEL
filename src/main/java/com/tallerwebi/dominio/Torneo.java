package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String deporte;
    private String fecha;
    private String inscripcion;
    private String ubicacion;
    @ManyToOne
    private Organizador organizador;

    public String getInscripcion() {
        return inscripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return Objects.equals(id, torneo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
