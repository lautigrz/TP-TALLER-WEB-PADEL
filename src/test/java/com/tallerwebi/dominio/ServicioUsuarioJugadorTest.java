package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioOrganizador;
import com.tallerwebi.infraestructura.RepositorioUsuarioJugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServicioUsuarioJugadorTest {

    private ServicioUsuarioJugador servicioUsuarioJugador;
    private RepositorioUsuarioJugador repositorioUsuarioJugador;

    @BeforeEach
    public void init(){
        repositorioUsuarioJugador = mock(RepositorioUsuarioJugador.class);
        this.servicioUsuarioJugador = new ServicioUsuarioJugadorImpl(repositorioUsuarioJugador);
    }

    @Test
    public void registrarUsuarioJugadorDeberiaLlamarAlRepositorioUsuarioJugadorImpl(){

        //dado que tengo un usuario jugador

        UsuarioJugador usuarioJugador = new UsuarioJugador();
        usuarioJugador.setCorreoElectronico("usuariojugador1@gmail.com");
        usuarioJugador.setPassword("asd123!");


        servicioUsuarioJugador.registrarUsuarioJugador(usuarioJugador);


        verify(repositorioUsuarioJugador).registrarUsuarioJugador(usuarioJugador);

    }


}
