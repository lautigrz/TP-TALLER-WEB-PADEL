package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioTorneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;
import static org.mockito.Mockito.*;

public class ServicioTorneoTest {
    private ServicioTorneo servicioTorneo;
    private RepositorioTorneo repositorioTorneo;

    @BeforeEach
    public void init(){
        repositorioTorneo = mock(RepositorioTorneo.class);
        this.servicioTorneo = new ServicioTorneoIml(repositorioTorneo);
    }

    @Test
    public void queSePuedaGuardarUnTorneo(){
        Torneo torneo = new Torneo();
        torneo.setTitulo("Torneo Buenos Aires");

        this.servicioTorneo.guardarTorneo(torneo);

        verify(repositorioTorneo).guardar(torneo);
    }

    @Test
    public void siNoHayTorneosDebeDevolverUnaListaVacia(){
        when(repositorioTorneo.listaDeTorneos()).thenReturn(new ArrayList<Torneo>());
        List<Torneo> torneos = this.servicioTorneo.consultasTorneos();


        assertThat(torneos, is(empty()));
    }

    @Test
    public void siHayTorneosDebeDevolverLosTorneos(){
        Torneo torneo = new Torneo();
        Torneo torneo1 = new Torneo();

        List<Torneo> torneos = Arrays.asList(torneo,torneo1);

        when(repositorioTorneo.listaDeTorneos()).thenReturn(torneos);

        List<Torneo> resultado = this.servicioTorneo.consultasTorneos();

        assertThat(resultado.size(), equalTo(2));
        assertThat(resultado, contains(torneo, torneo1));

    }

    @Test
    public void dadoUnaListaDeTorneoBuscarTorneosQueContenganUniversitario(){
        Torneo torneo = new Torneo();
        torneo.setTitulo("Universitario");
        Torneo torneo1 = new Torneo();
        torneo1.setTitulo("Universitario");

        List<Torneo> torneos = Arrays.asList(torneo,torneo1);

        when(repositorioTorneo.buscarTorneos("Universitario")).thenReturn(torneos);

        List<Torneo> resultado = this.servicioTorneo.buscarTorneo("Universitario");

        assertThat(resultado.size(), is(2));
        assertThat(resultado, contains(torneo, torneo1));
    }

    @Test
    public void dadoQueUnOrganizadorTieneTorneoObtenerTorneosDeOrganizador(){
        Organizador organizador = new Organizador();
        organizador.setNombre("Lionel");

        Torneo torneo = new Torneo();
        torneo.setOrganizador(organizador);
        Torneo torneo1 = new Torneo();
        torneo1.setOrganizador(organizador);

        List<Torneo> torneos = Arrays.asList(torneo,torneo1);

       when(this.repositorioTorneo.torneosDeOrganizador(organizador.getId())).thenReturn(torneos);

        List<Torneo> resultado = this.servicioTorneo.torneosDeOrganizador(organizador.getId());

        assertThat(resultado.size(), is(2));
        assertThat(resultado.get(0).getOrganizador(), equalTo(organizador));
        assertThat(resultado.get(1).getOrganizador(), equalTo(organizador));
    }

    @Test
    public void dadoQueUnOrganizadorTieneTorneoObtenerTorneoPorId(){
        Organizador organizador = new Organizador();
        organizador.setNombre("Lionel");

        Torneo torneo = new Torneo();
        torneo.setOrganizador(organizador);
        Torneo torneo1 = new Torneo();
        torneo1.setOrganizador(organizador);

        List<Torneo> torneos = Arrays.asList(torneo,torneo1);

        when(this.repositorioTorneo.obtenerTorneo(torneo.getId())).thenReturn(torneo);

        Torneo resultado = this.servicioTorneo.obtenerTorneo(torneo.getId());

        assertThat(resultado.getOrganizador(), equalTo(organizador));
        assertThat(resultado, equalTo(torneo));
    }


}
