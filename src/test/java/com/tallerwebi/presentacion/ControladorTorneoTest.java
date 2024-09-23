package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.mock;

public class ControladorTorneoTest {

    private ControladorTorneo controladorTorneo;
    private ServicioTorneo servicioTorneoMock;

    @BeforeEach
    public void init(){
       servicioTorneoMock = mock(ServicioTorneo.class);
    }



}
