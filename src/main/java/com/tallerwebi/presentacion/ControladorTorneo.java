package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTorneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTorneo {

    private ServicioTorneo servicioTorneo;
    @Autowired
    public ControladorTorneo(ServicioTorneo servicioTorneo) {
        this.servicioTorneo = servicioTorneo;
    }

    @RequestMapping("/torneo")
    public ModelAndView torneos(){
        ModelMap modelo = new ModelMap();
        modelo.put("torneos", this.servicioTorneo.consultasTorneos());
       return new ModelAndView("torneo", modelo);
    }
}
