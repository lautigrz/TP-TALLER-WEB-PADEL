package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Torneo;
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

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateInfraestructuraTestConfig.class})
public class RepositorioTorneoImplTest {
    @Autowired
    private SessionFactory sessionFactory;
    private RepositorioTorneo repositorioTorneo;

    @BeforeEach
    public void init() {
        this.repositorioTorneo = new RepositorioTorneoImpl(this.sessionFactory);
    }

    @Test
    @Transactional
    public void dadoQueExisteUnTorneoEnLaBaseDeDatosCuandoLoGuardoLoEncuentroEnLaBaseDeDatos() {

        Torneo torneo = new Torneo();
        torneo.setTitulo("Torneo Buenos Aires");
        torneo.setDescripcion("---------");
        torneo.setDeporte("Padel");
        torneo.setFecha("24/05/2024");
        torneo.setInscripcion("10/4/2024");
        torneo.setUbicacion("Buenos Aires, Moron");

        try {
            this.repositorioTorneo.guardar(torneo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Torneo torneo1 = new Torneo();
        torneo1.setTitulo("Torneo Santa Fe");
        torneo1.setDescripcion("---------");
        torneo1.setDeporte("Padel");
        torneo1.setFecha("24/05/2024");
        torneo1.setInscripcion("10/4/2024");
        torneo1.setUbicacion("Buenos Aires, Moron");

        try {
            this.repositorioTorneo.guardar(torneo1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String hql = "FROM Torneo WHERE titulo = :titulo";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("titulo", "Torneo Santa Fe");

        Torneo obtenido = (Torneo) query.getSingleResult();

        assertThat(obtenido, equalTo(torneo1));
    }

    @Test
    @Transactional
    public void dadoQueExisteTorneosEnLaBaseDeDatosObtenerTodosLosTorneos() {

        Torneo torneo = new Torneo();
        torneo.setTitulo("Torneo Buenos Aires");
        torneo.setDescripcion("---------");
        torneo.setDeporte("Padel");
        torneo.setFecha("24/05/2024");
        torneo.setInscripcion("10/4/2024");
        torneo.setUbicacion("Buenos Aires, Moron");

        try {
            this.repositorioTorneo.guardar(torneo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Torneo torneo1 = new Torneo();
        torneo1.setTitulo("Torneo Santa Fe");
        torneo1.setDescripcion("---------");
        torneo1.setDeporte("Padel");
        torneo1.setFecha("24/05/2024");
        torneo1.setInscripcion("10/4/2024");
        torneo1.setUbicacion("Buenos Aires, Moron");

        try {
            this.repositorioTorneo.guardar(torneo1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Torneo> esperado = Arrays.asList(torneo, torneo1);
        List<Torneo> obtenido = this.repositorioTorneo.listaDeTorneos();
        assertThat(obtenido, equalTo(esperado));
    }


}
