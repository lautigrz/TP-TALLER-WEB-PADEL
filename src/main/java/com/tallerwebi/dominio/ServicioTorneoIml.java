package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public void guardarTorneo(Torneo torneo) {
        this.repositorioTorneo.guardar(torneo);
    }

    @Override
    public List<Torneo> buscarTorneo(String txt) {
        return this.repositorioTorneo.buscarTorneos(txt);
    }
}
