package com.tallerwebi.dominio;


import com.tallerwebi.infraestructura.RepositorioOrganizador;
import com.tallerwebi.infraestructura.RepositorioUsuarioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServicioUsuarioJugadorImpl implements ServicioUsuarioJugador{

    private RepositorioUsuarioJugador repositorioUsuarioJugador;

    @Autowired
    public ServicioUsuarioJugadorImpl(RepositorioUsuarioJugador repositorioUsuarioJugador) {
        this.repositorioUsuarioJugador = repositorioUsuarioJugador;
    }

    @Override
    public UsuarioJugador iniciarSesionUsuarioJugador(String email, String password) {
        return repositorioUsuarioJugador.iniciarSesionUsuarioJugador(email,password);
    }

    @Override
    public void registrarUsuarioJugador(UsuarioJugador usuarioJugador) {
        this.repositorioUsuarioJugador.registrarUsuarioJugador(usuarioJugador);
    }

}
