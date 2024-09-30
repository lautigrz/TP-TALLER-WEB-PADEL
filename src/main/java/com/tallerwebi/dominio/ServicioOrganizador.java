package com.tallerwebi.dominio;

public interface ServicioOrganizador {

    void registrarOrganizador(Organizador organizador);
    Organizador iniciarSesion(String email, String password);
}
