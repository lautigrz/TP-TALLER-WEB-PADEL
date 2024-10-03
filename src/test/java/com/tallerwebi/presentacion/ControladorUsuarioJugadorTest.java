package com.tallerwebi.presentacion;
import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioOrganizador;
import com.tallerwebi.dominio.ServicioUsuarioJugador;
import com.tallerwebi.dominio.UsuarioJugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ControladorUsuarioJugadorTest {

    private ServicioUsuarioJugador servicioUsuarioJugador;
    private HttpServletRequest request;
    private HttpSession session;
    private ControladorUsuarioJugador controladorUsuarioJugador;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        session= mock(HttpSession.class);
        servicioUsuarioJugador = mock(ServicioUsuarioJugador.class);
        this.controladorUsuarioJugador = new ControladorUsuarioJugador(servicioUsuarioJugador);
    }

    @Test
    public void testIniciarSesionConUsuarioJugadorValido() throws Exception {

        UsuarioJugador usuarioJugadorExistente = new UsuarioJugador();
        usuarioJugadorExistente.setCorreoElectronico("usuario@gmail.com");
        usuarioJugadorExistente.setPassword("asd123");

        when(request.getSession()).thenReturn(session);
        when(servicioUsuarioJugador.iniciarSesionUsuarioJugador("usuario@gmail.com", "asd123")).thenReturn(usuarioJugadorExistente);
        String usuarioJugadorEsperado = this.controladorUsuarioJugador.iniciarSessionUsuarioJugador(usuarioJugadorExistente, request);

        assertThat(usuarioJugadorEsperado, equalTo( "redirect:/torneo"));

    }


    @Test
    public void testMostrarFormularioInicioDeUsuarioJugador(){

        //dado que tengo un modelo
        Model model = mock(Model.class);

        //cuando llamo a la vista del controlador

        String vistaEsperada = controladorUsuarioJugador.mostrarFormularioInicio(model);

        verify(model).addAttribute(eq("usuarioJugador"), any(UsuarioJugador.class));

        assertEquals("login-usuario-jugador", vistaEsperada);

    }
}
