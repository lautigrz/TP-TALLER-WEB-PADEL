package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioTorneo {

    List<Torneo> consultasTorneos();
    void guardarTorneo(Torneo torneo);
    List<Torneo> buscarTorneo(String txt);
}
