package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioOrganizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServicioOrganizadorImpl implements ServicioOrganizador{

    private RepositorioOrganizador repositorioOrganizador;

    @Autowired
    public ServicioOrganizadorImpl(RepositorioOrganizador repositorioOrganizador) {
        this.repositorioOrganizador = repositorioOrganizador;
    }

    @Override
    public void registrarOrganizador(Organizador organizador) {
        this.repositorioOrganizador.guardarOrganizador(organizador);
    }

    @Override
    public Organizador iniciarSesion(String email,String password) {
        return repositorioOrganizador.iniciar(email,password);
    }
}
