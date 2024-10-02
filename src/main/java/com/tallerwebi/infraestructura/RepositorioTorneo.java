package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Torneo;

import java.util.List;

public interface RepositorioTorneo {
    List<Torneo> torneosDeOrganizador(Long id);
    List<Torneo> listaDeTorneos();
    List<Torneo> buscarTorneos(String txt);
    Torneo obtenerTorneo(Long id);
    void guardar(Torneo torneo);
}
