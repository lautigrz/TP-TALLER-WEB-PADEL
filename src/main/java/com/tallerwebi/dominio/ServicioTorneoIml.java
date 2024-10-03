package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        try {
            this.repositorioTorneo.guardar(torneo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Torneo> buscarTorneo(String txt) {
        return this.repositorioTorneo.buscarTorneos(txt);
    }

    @Override
    public Torneo obtenerTorneo(Long id) {
        return this.repositorioTorneo.obtenerTorneo(id);
    }

    @Override
    public List<Torneo> verTorneosDisponibles() {
        return this.repositorioTorneo.verTorneosDisponibles();
    }


}
