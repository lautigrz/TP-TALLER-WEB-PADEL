package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Torneo;

import java.util.List;

public interface RepositorioTorneo {

    List<Torneo> listaDeTorneos();
    List<Torneo> buscarTorneos(String txt);
    void guardar(Torneo torneo);
}
