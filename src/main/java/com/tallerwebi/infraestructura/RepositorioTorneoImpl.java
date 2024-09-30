package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Torneo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class RepositorioTorneoImpl implements RepositorioTorneo {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTorneoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Torneo> torneosDeOrganizador(Long id) {
        String hql = "FROM Torneo t WHERE t.organizador.id = :id ";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Torneo> listaDeTorneos() {
        String hql = "FROM Torneo";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.getResultList();
    }

    @Override
    public List<Torneo> buscarTorneos(String txt) {
        String hql = "FROM Torneo WHERE titulo LIKE :titulo";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("titulo", "%" + txt + "%");
        return query.getResultList();
    }

    @Override
    public void guardar(Torneo torneo) throws Exception {
        this.sessionFactory.getCurrentSession().save(torneo);
    }
}
