package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 1000)
    private String descripcion;
    private String deporte;
    private String fechaInicio;
    private String fechaFin;
    private String inscripcionInicia;
    private String inscripcionFin;
    private String horarioDesde;
    private String horarioHasta;
    private String ubicacion;
    @ManyToOne
    private Organizador organizador;

    public String getInscripcionInicia() {
        return inscripcionInicia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
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
        this.inscripcionInicia = inscripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaInicio(String fecha) {
        this.fechaInicio = fecha;
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

    public String getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(String horarioTorneo) {
        this.horarioDesde = horarioTorneo;
    }

    public String getInscripcionFin() {
        return inscripcionFin;
    }

    public void setInscripcionFin(String inscripcionFin) {
        this.inscripcionFin = inscripcionFin;
    }

    public void setInscripcionInicia(String inscripcionInicia) {
        this.inscripcionInicia = inscripcionInicia;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public String getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(String horarioHasta) {
        this.horarioHasta = horarioHasta;
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
