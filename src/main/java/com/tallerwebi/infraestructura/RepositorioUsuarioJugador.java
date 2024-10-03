package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.UsuarioJugador;

public interface RepositorioUsuarioJugador {

    UsuarioJugador iniciarSesionUsuarioJugador(String email, String password);

    void registrarUsuarioJugador(UsuarioJugador usuarioJugador);
}
