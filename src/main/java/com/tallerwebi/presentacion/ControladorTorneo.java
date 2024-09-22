package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorTorneo {
    @Autowired
    private ServicioTorneo servicioTorneo;

    @RequestMapping("/torneo")
    public String torneos(Model model){

        model.addAttribute("torneos",  this.servicioTorneo.consultasTorneos());

       return "torneo";
    }
}
