package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class ServicioTorneoIml implements ServicioTorneo{

    private RepositorioTorneo repositorioTorneo;

    @Autowired
    public ServicioTorneoIml(RepositorioTorneo repositorioTorneo) {
        this.repositorioTorneo = repositorioTorneo;
    }

    @Override
    public List<Torneo> consultasTorneos() {

        return this.repositorioTorneo.listaDeTorneos();
    }

    @Override
    public List<Torneo> torneosDeOrganizador(Long id) {
        return this.repositorioTorneo.torneosDeOrganizador(id);
    }

    @Override
    public void guardarTorneo(Torneo torneo) {
        validarFechaDeTorneo(torneo);
        this.repositorioTorneo.guardar(torneo);

    }

    @Override
    public List<Torneo> buscarTorneo(String txt) {
        return this.repositorioTorneo.buscarTorneos(txt);
    }

    @Override
    public Torneo obtenerTorneo(Long id) {
        return this.repositorioTorneo.obtenerTorneo(id);
    }

    private void validarFechaDeTorneo(Torneo torneo){

        LocalDate fechaInicio = LocalDate.parse(torneo.getFechaInicio());
        LocalDate fechaFin = LocalDate.parse(torneo.getFechaFin());
        LocalDate inscripcionInicia = LocalDate.parse(torneo.getInscripcionInicia());
        LocalDate inscripcionFin = LocalDate.parse(torneo.getInscripcionFin());

        if(fechaInicio.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la fecha actual.");
        }
        if(fechaInicio.isAfter(fechaFin)){
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin.");
        }

        if(inscripcionInicia.isAfter(fechaInicio)){
            throw new IllegalArgumentException("La fecha de inscripcion no puede ser posterior a la fecha inicial.");
        }

        if(inscripcionInicia.isAfter(inscripcionFin)){
            throw new IllegalArgumentException("La fecha de inscripcion no puede ser posterior a la fecha fin de inscripcion.");
        }
        if(inscripcionFin.isBefore(inscripcionInicia)) {
            throw new IllegalArgumentException("La fecha fin de inscripcion no puede ser anterior a la fecha inicial de inscripcion.");
        }
        if(inscripcionFin.isAfter(fechaInicio)){
            throw new IllegalArgumentException("La fecha fin de inscripcion no puede ser despues de la fecha inicial.");
        }

    }
}
