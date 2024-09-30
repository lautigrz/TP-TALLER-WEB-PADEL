package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTorneoTest {

    private ControladorTorneo controladorTorneo;
    private ServicioTorneo servicioTorneoMock;

    @BeforeEach
    public void init(){
       servicioTorneoMock = mock(ServicioTorneo.class);
       controladorTorneo = new ControladorTorneo(servicioTorneoMock);
    }

   /* @Test
    public void debeRetornarLaVistaTorneoConLaListaDeTorneosVacia() {

        when(this.servicioTorneoMock.consultasTorneos()).thenReturn(new ArrayList<>());
        ModelAndView model = this.controladorTorneo.torneos();

        List<Torneo> torneos = new ArrayList<>();

        assertThat(model.getViewName(), equalToIgnoringCase("torneo"));
        assertThat(model.getModel().get("torneos"), equalTo(torneos));
    }

    */
}
