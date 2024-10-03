package com.tallerwebi.dominio;


import org.springframework.stereotype.Service;

@Service("servicioUsuarioJugador")
public interface ServicioUsuarioJugador {

    public UsuarioJugador iniciarSesionUsuarioJugador(String email, String password);

    void registrarUsuarioJugador(UsuarioJugador usuarioJugador);
}
