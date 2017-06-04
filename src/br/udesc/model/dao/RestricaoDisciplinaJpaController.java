/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.RestricaoDisciplina;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author phzpe
 */
public class RestricaoDisciplinaJpaController implements Serializable {

    public RestricaoDisciplinaJpaController() {
        emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RestricaoDisciplina restricaoDisciplina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(restricaoDisciplina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RestricaoDisciplina restricaoDisciplina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            restricaoDisciplina = em.merge(restricaoDisciplina);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = restricaoDisciplina.getId();
                if (findRestricaoDisciplina(id) == null) {
                    throw new NonexistentEntityException("The restricaoDisciplina with id " + id + " no longer exists.");
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
            RestricaoDisciplina restricaoDisciplina;
            try {
                restricaoDisciplina = em.getReference(RestricaoDisciplina.class, id);
                restricaoDisciplina.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The restricaoDisciplina with id " + id + " no longer exists.", enfe);
            }
            em.remove(restricaoDisciplina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RestricaoDisciplina> findRestricaoDisciplinaEntities() {
        return findRestricaoDisciplinaEntities(true, -1, -1);
    }

    public List<RestricaoDisciplina> findRestricaoDisciplinaEntities(int maxResults, int firstResult) {
        return findRestricaoDisciplinaEntities(false, maxResults, firstResult);
    }

    private List<RestricaoDisciplina> findRestricaoDisciplinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RestricaoDisciplina.class));
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

    public RestricaoDisciplina findRestricaoDisciplina(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RestricaoDisciplina.class, id);
        } finally {
            em.close();
        }
    }

    public int getRestricaoDisciplinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RestricaoDisciplina> rt = cq.from(RestricaoDisciplina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
      public List<RestricaoDisciplina> buscarRestricoes(long id){
        EntityManager em = getEntityManager();
        try{
            Disciplina d = em.find(Disciplina.class, id);
            Query q = em.createQuery("select a from RestricaoDisciplina a where a.disciplina = :d");
            q.setParameter("d", d);
            return (List<RestricaoDisciplina>) q.getResultList();
        }catch(Exception e){
            return null;
        }
        
    }
    
}
