package com.tallerwebi.presentacion;
import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioOrganizador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ControladorOrganizadorTest {

    private ServicioOrganizador servicioOrganizador;
    private HttpServletRequest request;
    private HttpSession session;
    private ControladorOrganizador controladorOrganizador;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        session= mock(HttpSession.class);
        servicioOrganizador = mock(ServicioOrganizador.class);
        this.controladorOrganizador = new ControladorOrganizador(servicioOrganizador);
    }

    @Test
    public void testIniciarSessionConOrganizadorValido() throws Exception {

        Organizador organizadorExistente = new Organizador();
        organizadorExistente.setCorreoElectronico("messi@gmail.com");
        organizadorExistente.setPassword("qwe32");

        when(request.getSession()).thenReturn(session);
        when(servicioOrganizador.iniciarSesion("messi@gmail.com", "qwe32")).thenReturn(organizadorExistente);
        String esperado = this.controladorOrganizador.iniciarSession(organizadorExistente, request);

        assertThat(esperado, equalTo( "redirect:/torneo"));

    }
}
