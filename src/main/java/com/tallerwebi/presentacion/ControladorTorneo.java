package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.ServicioTorneo;
import com.tallerwebi.dominio.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ControladorTorneo {

    private ServicioTorneo servicioTorneo;
    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo) {
        this.servicioTorneo = servicioTorneo;
    }

    @RequestMapping("/torneo")
    public ModelAndView torneos(HttpSession session) {
        ModelMap modelo = new ModelMap();

        Organizador organizadorLogueado = (Organizador) session.getAttribute("organizadorLogueado");
        modelo.put("torneos", this.servicioTorneo.torneosDeOrganizador(organizadorLogueado.getId()));
        if (organizadorLogueado != null) {
            modelo.put("organizador", organizadorLogueado);
        }


        return new ModelAndView("torneo", modelo);
    }
    @GetMapping("/crear-torneo")
    public String mostrarFormularioRegistroTorneo(Model model, HttpSession session) {
            Torneo torneo = new Torneo();
            model.addAttribute("torneo", torneo);

            return "nuevo-torneo";

    }


    @PostMapping("/registrar-torneo")
    public String registrarTorneo(@ModelAttribute("torneo") Torneo torneo, HttpSession session) {
        Organizador organizador = (Organizador) session.getAttribute("organizadorLogueado");
        torneo.setOrganizador(organizador);
        servicioTorneo.guardarTorneo(torneo);
            return "redirect:/torneo";

    }

}

