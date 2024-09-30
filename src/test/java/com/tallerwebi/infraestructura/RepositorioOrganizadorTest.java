package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.infraestructura.config.HibernateInfraestructuraTestConfig;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Query;
import javax.transaction.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateInfraestructuraTestConfig.class})
public class RepositorioOrganizadorTest {
    @Autowired
    private SessionFactory sessionFactory;

    private RepositorioOrganizador repositorioOrganizador;

    @BeforeEach
    public void init(){
        this.repositorioOrganizador = new RepositorioOrganizadorImpl(sessionFactory);
    }

    @Test
    @Transactional
    public void registrarOrganizadorYBuscarloEnLaBD(){

        Organizador organizador = new Organizador();

        organizador.setNombre("Lionel");
        organizador.setApellido("Messi");
        organizador.setCorreoElectronico("messi@gmail.com");
        organizador.setPassword("qwe32");

        this.repositorioOrganizador.guardarOrganizador(organizador);

        String hql = "FROM Organizador WHERE id = :id";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id",organizador.getId());


        Organizador orga = (Organizador) query.getResultList().get(0);

        assertThat(orga, equalTo(organizador));
    }

    @Test
    @Transactional
    public void iniciarSessionConCorreoYContrasenia(){

        Organizador organizador = new Organizador();

        organizador.setNombre("Lionel");
        organizador.setApellido("Messi");
        organizador.setCorreoElectronico("messi@gmail.com");
        organizador.setPassword("qwe32");

        this.repositorioOrganizador.guardarOrganizador(organizador);

        String hql = "FROM Organizador WHERE correoElectronico = :correo AND password = :pass";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("correo",organizador.getCorreoElectronico());
        query.setParameter("pass", organizador.getPassword());


        Organizador orga = (Organizador) query.getResultList().get(0);

        assertThat(orga, equalTo(organizador));
    }



}
