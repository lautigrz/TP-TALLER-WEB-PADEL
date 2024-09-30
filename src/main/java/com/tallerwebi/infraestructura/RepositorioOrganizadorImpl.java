package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Organizador;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrganizadorImpl implements RepositorioOrganizador{


    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioOrganizadorImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarOrganizador(Organizador organizador) {
        this.sessionFactory.getCurrentSession().save(organizador);
    }

    @Override
    public Organizador iniciar(String email, String password) {
        String hql = "FROM Organizador WHERE correoElectronico = :email AND password = :password";
        return (Organizador) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
    }
}
