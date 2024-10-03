package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Organizador;
import com.tallerwebi.dominio.UsuarioJugador;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuarioJugador")
public class RepositorioUsuarioJugadorImpl implements RepositorioUsuarioJugador{

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioUsuarioJugadorImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public UsuarioJugador iniciarSesionUsuarioJugador(String email, String password) {
        String hql = "FROM UsuarioJugador WHERE correoElectronico = :email AND password = :password";
        return (UsuarioJugador) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
    }

    @Override
    public void registrarUsuarioJugador(UsuarioJugador usuarioJugador) {
        this.sessionFactory.getCurrentSession().save(usuarioJugador);
    }
}
