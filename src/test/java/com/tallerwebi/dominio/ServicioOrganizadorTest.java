package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioOrganizador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ServicioOrganizadorTest {


    private ServicioOrganizador servicioOrganizador;
    private RepositorioOrganizador repositorioOrganizador;

    @BeforeEach
    public void init(){
        repositorioOrganizador = mock(RepositorioOrganizador.class);
        this.servicioOrganizador = new ServicioOrganizadorImpl(repositorioOrganizador);
    }

    @Test
    public void registrarOrganizador(){
        Organizador organizador = new Organizador();
        organizador.setNombre("Lionel");
        organizador.setApellido("Messi");
        organizador.setCorreoElectronico("messi@gmail.com");
        organizador.setPassword("qwe32");
        // Llamar al método que quieres probar
        this.servicioOrganizador.registrarOrganizador(organizador);

        // Verificar que el método guardarOrganizador fue llamado una vez con el organizador
        verify(repositorioOrganizador, times(1)).guardarOrganizador(organizador);
    }

    @Test
    public void iniciarSesionConOrganizador(){
        Organizador organizador = new Organizador();

        organizador.setNombre("Lionel");
        organizador.setApellido("Messi");
        organizador.setCorreoElectronico("messi@gmail.com");
        organizador.setPassword("qwe32");

        when(repositorioOrganizador.iniciar(organizador.getCorreoElectronico(), organizador.getPassword())).thenReturn(organizador);

        Organizador orga = this.servicioOrganizador.iniciarSesion(organizador.getCorreoElectronico(),organizador.getPassword());

        assertThat(orga, equalTo(organizador));
    }


}

