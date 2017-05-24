/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 5105011505
 */
public class ProfessorJpaController implements Serializable {

    public ProfessorJpaController() {
       emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Professor professor) {
        if (professor.getListaHorario() == null) {
            professor.setListaHorario(new ArrayList<PessoaHorarioPreferencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PessoaHorarioPreferencia> attachedListaHorario = new ArrayList<PessoaHorarioPreferencia>();
            for (PessoaHorarioPreferencia listaHorarioPessoaHorarioPreferenciaToAttach : professor.getListaHorario()) {
                listaHorarioPessoaHorarioPreferenciaToAttach = em.getReference(listaHorarioPessoaHorarioPreferenciaToAttach.getClass(), listaHorarioPessoaHorarioPreferenciaToAttach.getId());
                attachedListaHorario.add(listaHorarioPessoaHorarioPreferenciaToAttach);
            }
            professor.setListaHorario(attachedListaHorario);
            em.persist(professor);
            for (PessoaHorarioPreferencia listaHorarioPessoaHorarioPreferencia : professor.getListaHorario()) {
                Professor oldProfessorOfListaHorarioPessoaHorarioPreferencia = listaHorarioPessoaHorarioPreferencia.getProfessor();
                listaHorarioPessoaHorarioPreferencia.setProfessor(professor);
                listaHorarioPessoaHorarioPreferencia = em.merge(listaHorarioPessoaHorarioPreferencia);
                if (oldProfessorOfListaHorarioPessoaHorarioPreferencia != null) {
                    oldProfessorOfListaHorarioPessoaHorarioPreferencia.getListaHorario().remove(listaHorarioPessoaHorarioPreferencia);
                    oldProfessorOfListaHorarioPessoaHorarioPreferencia = em.merge(oldProfessorOfListaHorarioPessoaHorarioPreferencia);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Professor professor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor persistentProfessor = em.find(Professor.class, professor.getId());
            List<PessoaHorarioPreferencia> listaHorarioOld = persistentProfessor.getListaHorario();
            List<PessoaHorarioPreferencia> listaHorarioNew = professor.getListaHorario();
            List<PessoaHorarioPreferencia> attachedListaHorarioNew = new ArrayList<PessoaHorarioPreferencia>();
            for (PessoaHorarioPreferencia listaHorarioNewPessoaHorarioPreferenciaToAttach : listaHorarioNew) {
                listaHorarioNewPessoaHorarioPreferenciaToAttach = em.getReference(listaHorarioNewPessoaHorarioPreferenciaToAttach.getClass(), listaHorarioNewPessoaHorarioPreferenciaToAttach.getId());
                attachedListaHorarioNew.add(listaHorarioNewPessoaHorarioPreferenciaToAttach);
            }
            listaHorarioNew = attachedListaHorarioNew;
            professor.setListaHorario(listaHorarioNew);
            professor = em.merge(professor);
            for (PessoaHorarioPreferencia listaHorarioOldPessoaHorarioPreferencia : listaHorarioOld) {
                if (!listaHorarioNew.contains(listaHorarioOldPessoaHorarioPreferencia)) {
                    listaHorarioOldPessoaHorarioPreferencia.setProfessor(null);
                    listaHorarioOldPessoaHorarioPreferencia = em.merge(listaHorarioOldPessoaHorarioPreferencia);
                }
            }
            for (PessoaHorarioPreferencia listaHorarioNewPessoaHorarioPreferencia : listaHorarioNew) {
                if (!listaHorarioOld.contains(listaHorarioNewPessoaHorarioPreferencia)) {
                    Professor oldProfessorOfListaHorarioNewPessoaHorarioPreferencia = listaHorarioNewPessoaHorarioPreferencia.getProfessor();
                    listaHorarioNewPessoaHorarioPreferencia.setProfessor(professor);
                    listaHorarioNewPessoaHorarioPreferencia = em.merge(listaHorarioNewPessoaHorarioPreferencia);
                    if (oldProfessorOfListaHorarioNewPessoaHorarioPreferencia != null && !oldProfessorOfListaHorarioNewPessoaHorarioPreferencia.equals(professor)) {
                        oldProfessorOfListaHorarioNewPessoaHorarioPreferencia.getListaHorario().remove(listaHorarioNewPessoaHorarioPreferencia);
                        oldProfessorOfListaHorarioNewPessoaHorarioPreferencia = em.merge(oldProfessorOfListaHorarioNewPessoaHorarioPreferencia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = professor.getId();
                if (findProfessor(id) == null) {
                    throw new NonexistentEntityException("The professor with id " + id + " no longer exists.");
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
            Professor professor;
            try {
                professor = em.getReference(Professor.class, id);
                professor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The professor with id " + id + " no longer exists.", enfe);
            }
            List<PessoaHorarioPreferencia> listaHorario = professor.getListaHorario();
            for (PessoaHorarioPreferencia listaHorarioPessoaHorarioPreferencia : listaHorario) {
                listaHorarioPessoaHorarioPreferencia.setProfessor(null);
                listaHorarioPessoaHorarioPreferencia = em.merge(listaHorarioPessoaHorarioPreferencia);
            }
            em.remove(professor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Professor> findProfessorEntities() {
        return findProfessorEntities(true, -1, -1);
    }

    public List<Professor> findProfessorEntities(int maxResults, int firstResult) {
        return findProfessorEntities(false, maxResults, firstResult);
    }

    private List<Professor> findProfessorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Professor.class));
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

    public Professor findProfessor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Professor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfessorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Professor> rt = cq.from(Professor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Professor> listarProfessor() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Professor e");
            List<Professor> professor = query.getResultList();
            return professor;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }
    
    public List<Professor> validaProfessor(String professor) {
        String jpql = "select u from Professor u where u.nomeProfessor =:nomeprofessor";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Professor> prof = em.createQuery(jpql, Professor.class).setParameter("nomeprofessor", professor).getResultList();
        if (prof == null || prof.isEmpty()) {
            return null;
        }
        return prof;
    }
    
}
