package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
