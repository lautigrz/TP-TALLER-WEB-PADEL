package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioOrganizador;
import com.tallerwebi.dominio.ServicioUsuarioJugador;
import com.tallerwebi.dominio.UsuarioJugador;
import com.tallerwebi.excepciones.RegistroException;
import com.tallerwebi.excepciones.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class ControladorUsuarioJugador {

    private ServicioUsuarioJugador servicioUsuarioJugador;

    @Autowired
    public ControladorUsuarioJugador(ServicioUsuarioJugador servicioUsuarioJugador) {
        this.servicioUsuarioJugador = servicioUsuarioJugador;
    }

    @PostMapping("/registrar-usuario-jugador")
    public String registrarOrganizador(@ModelAttribute("usuarioJugador") UsuarioJugador usuarioJugador) {
        try {
            this.servicioUsuarioJugador.registrarUsuarioJugador(usuarioJugador);
            return "redirect:/login-usuario-jugador";
        } catch (RuntimeException e) {
            throw new RegistroException("Correo electronico ya registrado");
        }

    }

    @GetMapping("/formulario-usuario-jugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuarioJugador", new UsuarioJugador());
        return "registro-usuario-jugador";
    }

    @GetMapping("/login-usuario-jugador")
    public String mostrarFormularioInicio(Model model) {
        model.addAttribute("usuarioJugador", new UsuarioJugador());
        return "login-usuario-jugador";
    }

    @PostMapping("/iniciar-sesion-usuario-jugador")
    public String iniciarSessionUsuarioJugador(@ModelAttribute("usuarioJugador") UsuarioJugador usuarioJugador, HttpServletRequest httpServletRequest){

        UsuarioJugador usuarioJugadorExistente = this.servicioUsuarioJugador.iniciarSesionUsuarioJugador(usuarioJugador.getCorreoElectronico(), usuarioJugador.getPassword());

        if (usuarioJugadorExistente != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("usuarioJugadorLogueado", usuarioJugadorExistente);
            return "redirect:/torneo-usuario-jugador";
        }
        // Lanzar la excepción si el usuario no es válido
        throw new UsuarioException("Correo electronico o Contraseña invalida");

    }

}
