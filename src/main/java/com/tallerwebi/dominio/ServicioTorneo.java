package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioTorneo {

    List<Torneo> consultasTorneos();
    List<Torneo> torneosDeOrganizador(Long id);
    void guardarTorneo(Torneo torneo);
    List<Torneo> buscarTorneo(String txt);


}
