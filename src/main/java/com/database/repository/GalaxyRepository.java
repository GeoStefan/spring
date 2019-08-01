package com.database.repository;

import com.database.exception.DatabaseException;
import com.database.model.Galaxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class GalaxyRepository implements Repository<Long, Galaxy> {
    private EntityManager em;

    public GalaxyRepository(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Galaxy add(Galaxy object) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(object);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            throw new DatabaseException(e.getMessage());
        }
        return object;
    }

    @Override
    public Optional<Galaxy> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Galaxy update(Galaxy object) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Galaxy> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Galaxy> cq = cb.createQuery(Galaxy.class);
        Root<Galaxy> rootEntry = cq.from(Galaxy.class);
        CriteriaQuery<Galaxy> all = cq.select(rootEntry);
        TypedQuery<Galaxy> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
