package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioTorneo {

    List<Torneo> listaDeTorneos();
    void guardar(Torneo torneo);
}
