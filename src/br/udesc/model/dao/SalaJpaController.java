/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Sala;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.udesc.model.entidade.SalaHorario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 5105011505
 */
public class SalaJpaController implements Serializable {

    public SalaJpaController() {
       emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sala sala) {
        if (sala.getListSalaHorario() == null) {
            sala.setListSalaHorario(new ArrayList<SalaHorario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SalaHorario> attachedListSalaHorario = new ArrayList<SalaHorario>();
            for (SalaHorario listSalaHorarioSalaHorarioToAttach : sala.getListSalaHorario()) {
                listSalaHorarioSalaHorarioToAttach = em.getReference(listSalaHorarioSalaHorarioToAttach.getClass(), listSalaHorarioSalaHorarioToAttach.getId());
                attachedListSalaHorario.add(listSalaHorarioSalaHorarioToAttach);
            }
            sala.setListSalaHorario(attachedListSalaHorario);
            em.persist(sala);
            for (SalaHorario listSalaHorarioSalaHorario : sala.getListSalaHorario()) {
                Sala oldSalaOfListSalaHorarioSalaHorario = listSalaHorarioSalaHorario.getSala();
                listSalaHorarioSalaHorario.setSala(sala);
                listSalaHorarioSalaHorario = em.merge(listSalaHorarioSalaHorario);
                if (oldSalaOfListSalaHorarioSalaHorario != null) {
                    oldSalaOfListSalaHorarioSalaHorario.getListSalaHorario().remove(listSalaHorarioSalaHorario);
                    oldSalaOfListSalaHorarioSalaHorario = em.merge(oldSalaOfListSalaHorarioSalaHorario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sala sala) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala persistentSala = em.find(Sala.class, sala.getId());
            List<SalaHorario> listSalaHorarioOld = persistentSala.getListSalaHorario();
            List<SalaHorario> listSalaHorarioNew = sala.getListSalaHorario();
            List<SalaHorario> attachedListSalaHorarioNew = new ArrayList<SalaHorario>();
            for (SalaHorario listSalaHorarioNewSalaHorarioToAttach : listSalaHorarioNew) {
                listSalaHorarioNewSalaHorarioToAttach = em.getReference(listSalaHorarioNewSalaHorarioToAttach.getClass(), listSalaHorarioNewSalaHorarioToAttach.getId());
                attachedListSalaHorarioNew.add(listSalaHorarioNewSalaHorarioToAttach);
            }
            listSalaHorarioNew = attachedListSalaHorarioNew;
            sala.setListSalaHorario(listSalaHorarioNew);
            sala = em.merge(sala);
            for (SalaHorario listSalaHorarioOldSalaHorario : listSalaHorarioOld) {
                if (!listSalaHorarioNew.contains(listSalaHorarioOldSalaHorario)) {
                    listSalaHorarioOldSalaHorario.setSala(null);
                    listSalaHorarioOldSalaHorario = em.merge(listSalaHorarioOldSalaHorario);
                }
            }
            for (SalaHorario listSalaHorarioNewSalaHorario : listSalaHorarioNew) {
                if (!listSalaHorarioOld.contains(listSalaHorarioNewSalaHorario)) {
                    Sala oldSalaOfListSalaHorarioNewSalaHorario = listSalaHorarioNewSalaHorario.getSala();
                    listSalaHorarioNewSalaHorario.setSala(sala);
                    listSalaHorarioNewSalaHorario = em.merge(listSalaHorarioNewSalaHorario);
                    if (oldSalaOfListSalaHorarioNewSalaHorario != null && !oldSalaOfListSalaHorarioNewSalaHorario.equals(sala)) {
                        oldSalaOfListSalaHorarioNewSalaHorario.getListSalaHorario().remove(listSalaHorarioNewSalaHorario);
                        oldSalaOfListSalaHorarioNewSalaHorario = em.merge(oldSalaOfListSalaHorarioNewSalaHorario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = sala.getId();
                if (findSala(id) == null) {
                    throw new NonexistentEntityException("The sala with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala sala;
            try {
                sala = em.getReference(Sala.class, id);
                sala.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sala with id " + id + " no longer exists.", enfe);
            }
            List<SalaHorario> listSalaHorario = sala.getListSalaHorario();
            for (SalaHorario listSalaHorarioSalaHorario : listSalaHorario) {
                listSalaHorarioSalaHorario.setSala(null);
                listSalaHorarioSalaHorario = em.merge(listSalaHorarioSalaHorario);
            }
            em.remove(sala);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sala> findSalaEntities() {
        return findSalaEntities(true, -1, -1);
    }

    public List<Sala> findSalaEntities(int maxResults, int firstResult) {
        return findSalaEntities(false, maxResults, firstResult);
    }

    private List<Sala> findSalaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sala.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sala findSala(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sala.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sala> rt = cq.from(Sala.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
