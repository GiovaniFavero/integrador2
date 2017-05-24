/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.udesc.model.entidade.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 5105011505
 */
public class PessoaHorarioPreferenciaJpaController implements Serializable {

    public PessoaHorarioPreferenciaJpaController() {
        emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaHorarioPreferencia pessoaHorarioPreferencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor professor = pessoaHorarioPreferencia.getProfessor();
            if (professor != null) {
                professor = em.getReference(professor.getClass(), professor.getId());
                pessoaHorarioPreferencia.setProfessor(professor);
            }
            em.persist(pessoaHorarioPreferencia);
            if (professor != null) {
                professor.getListaHorario().add(pessoaHorarioPreferencia);
                professor = em.merge(professor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaHorarioPreferencia pessoaHorarioPreferencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PessoaHorarioPreferencia persistentPessoaHorarioPreferencia = em.find(PessoaHorarioPreferencia.class, pessoaHorarioPreferencia.getId());
            Professor professorOld = persistentPessoaHorarioPreferencia.getProfessor();
            Professor professorNew = pessoaHorarioPreferencia.getProfessor();
            if (professorNew != null) {
                professorNew = em.getReference(professorNew.getClass(), professorNew.getId());
                pessoaHorarioPreferencia.setProfessor(professorNew);
            }
            pessoaHorarioPreferencia = em.merge(pessoaHorarioPreferencia);
            if (professorOld != null && !professorOld.equals(professorNew)) {
                professorOld.getListaHorario().remove(pessoaHorarioPreferencia);
                professorOld = em.merge(professorOld);
            }
            if (professorNew != null && !professorNew.equals(professorOld)) {
                professorNew.getListaHorario().add(pessoaHorarioPreferencia);
                professorNew = em.merge(professorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pessoaHorarioPreferencia.getId();
                if (findPessoaHorarioPreferencia(id) == null) {
                    throw new NonexistentEntityException("The pessoaHorarioPreferencia with id " + id + " no longer exists.");
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
            PessoaHorarioPreferencia pessoaHorarioPreferencia;
            try {
                pessoaHorarioPreferencia = em.getReference(PessoaHorarioPreferencia.class, id);
                pessoaHorarioPreferencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaHorarioPreferencia with id " + id + " no longer exists.", enfe);
            }
            Professor professor = pessoaHorarioPreferencia.getProfessor();
            if (professor != null) {
                professor.getListaHorario().remove(pessoaHorarioPreferencia);
                professor = em.merge(professor);
            }
            em.remove(pessoaHorarioPreferencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaHorarioPreferencia> findPessoaHorarioPreferenciaEntities() {
        return findPessoaHorarioPreferenciaEntities(true, -1, -1);
    }

    public List<PessoaHorarioPreferencia> findPessoaHorarioPreferenciaEntities(int maxResults, int firstResult) {
        return findPessoaHorarioPreferenciaEntities(false, maxResults, firstResult);
    }

    private List<PessoaHorarioPreferencia> findPessoaHorarioPreferenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaHorarioPreferencia.class));
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

    public PessoaHorarioPreferencia findPessoaHorarioPreferencia(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaHorarioPreferencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaHorarioPreferenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaHorarioPreferencia> rt = cq.from(PessoaHorarioPreferencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
