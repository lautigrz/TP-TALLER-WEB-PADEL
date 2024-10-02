package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.*;

public class ControladorTorneoTest {

    private ControladorTorneo controladorTorneo;
    private ServicioTorneo servicioTorneoMock;
    private HttpSession sessionMock;

    @BeforeEach
    public void init(){
       servicioTorneoMock = mock(ServicioTorneo.class);
       sessionMock = mock(HttpSession.class);
       controladorTorneo = new ControladorTorneo(servicioTorneoMock);
    }

    @Test
    public void queUnOrganizadorRegistreUnTorneoLoRedireccioneAlaVistaDeLosTorneos(){
        Organizador organizadorLogueado = new Organizador();
        organizadorLogueado.setId(1L);
        Torneo torneo = new Torneo();
        torneo.setTitulo("Torneo Buenos Aires");
        torneo.setDescripcion("---------");
        torneo.setDeporte("Padel");
        torneo.setFechaInicio("24/05/2024");
        torneo.setInscripcionInicia("10/4/2024");
        torneo.setUbicacion("Buenos Aires, Moron");

        when(sessionMock.getAttribute("organizadorLogueado")).thenReturn(organizadorLogueado);
       this.servicioTorneoMock.guardarTorneo(torneo);

       verify(servicioTorneoMock).guardarTorneo(torneo);

    }

  @Test
    public void debeRetornarLaVistaConLosTorneosDelOrganizador() {
      Organizador organizadorLogueado = new Organizador();
      organizadorLogueado.setId(1L);
      Torneo torneo = new Torneo();
      torneo.setTitulo("Torneo Buenos Aires");
      torneo.setDescripcion("---------");
      torneo.setDeporte("Padel");
      torneo.setFechaInicio("24/05/2024");
      torneo.setInscripcionInicia("10/4/2024");
      torneo.setUbicacion("Buenos Aires, Moron");
      torneo.setOrganizador(organizadorLogueado);

      Torneo torneo1 = new Torneo();
      torneo1.setTitulo("Torneo Santa Fe");
      torneo1.setDescripcion("---------");
      torneo1.setDeporte("Padel");
      torneo1.setFechaInicio("24/05/2024");
      torneo1.setInscripcion("10/4/2024");
      torneo1.setUbicacion("Buenos Aires, Moron");
      torneo1.setOrganizador(organizadorLogueado);

      List<Torneo> torneosMock = Arrays.asList(torneo,torneo1);

      when(sessionMock.getAttribute("organizadorLogueado")).thenReturn(organizadorLogueado);
      when(servicioTorneoMock.torneosDeOrganizador(organizadorLogueado.getId())).thenReturn(torneosMock);

      ModelAndView model= this.controladorTorneo.torneos(sessionMock);

        assertThat(model.getViewName(), equalToIgnoringCase("torneo"));
        assertThat(model.getModel().get("torneos"), equalTo(torneosMock));
    }

}
