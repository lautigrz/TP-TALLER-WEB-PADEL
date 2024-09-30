package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Organizador;

public interface RepositorioOrganizador {
    void guardarOrganizador(Organizador organizador);
    Organizador iniciar(String email, String password);
}
