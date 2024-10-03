package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioOrganizador;
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

public class ControladorOrganizador {

    private ServicioOrganizador servicioOrganizador;
    @Autowired
    public ControladorOrganizador(ServicioOrganizador servicioOrganizador) {
        this.servicioOrganizador = servicioOrganizador;
    }

    @GetMapping("/formulario-organizador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("organizador", new Organizador());
        return "registro";
    }

    @GetMapping("/login")
    public String mostrarFormularioInicio(Model model) {
        model.addAttribute("organizador", new Organizador());
        return "login";
    }

    @PostMapping("/registrar-organizador")
    public String registrarOrganizador(@ModelAttribute("organizador") Organizador organizador) {
        try {
            this.servicioOrganizador.registrarOrganizador(organizador);
            return "redirect:/login";
        } catch (RuntimeException e) {
            throw new RegistroException("Correo electronico ya registrado");
        }

    }
    @PostMapping("/iniciar-session")
    public String iniciarSession(@ModelAttribute("organizador") Organizador organizador, HttpServletRequest httpServletRequest){

        Organizador organizadorExistente = this.servicioOrganizador.iniciarSesion(organizador.getCorreoElectronico(), organizador.getPassword());

        if (organizadorExistente != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("organizadorLogueado", organizadorExistente);
            return "redirect:/torneo";
        }
            // Lanzar la excepción si el usuario no es válido
            throw new UsuarioException("Correo electronico o Contraseña invalida");

    }
}
