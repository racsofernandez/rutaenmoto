package es.meco.rutaenmoto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.meco.rutaenmoto.entidades.RutaDTO;

public class RutaDao {
	
	private static final String PERSISTENCE_UNIT_NAME = "RutaEnMotoPU";	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();
	private static EntityTransaction to = em.getTransaction();
	
    // Stores a new ruta:
    public void persist(RutaDTO ruta) {
    	if(!to.isActive()) {
			to.begin();
		}
        em.persist(ruta);
        to.commit();
    }

    // Retrieves all the guests:
    public List<RutaDTO> getAllRutas() {
        TypedQuery<RutaDTO> query = em.createQuery(
            "SELECT r FROM ruta r ORDER BY r.id", RutaDTO.class);
        return query.getResultList();
    }
}
