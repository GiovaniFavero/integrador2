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
import br.udesc.model.entidade.Sala;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.SalaHorario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 5105011505
 */
public class SalaHorarioJpaController implements Serializable {

    public SalaHorarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SalaHorario salaHorario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala sala = salaHorario.getSala();
            if (sala != null) {
                sala = em.getReference(sala.getClass(), sala.getId());
                salaHorario.setSala(sala);
            }
            Disciplina disciplina = salaHorario.getDisciplina();
            if (disciplina != null) {
                disciplina = em.getReference(disciplina.getClass(), disciplina.getId());
                salaHorario.setDisciplina(disciplina);
            }
            em.persist(salaHorario);
            if (sala != null) {
                sala.getListSalaHorario().add(salaHorario);
                sala = em.merge(sala);
            }
            if (disciplina != null) {
                disciplina.getListaSalaHorario().add(salaHorario);
                disciplina = em.merge(disciplina);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SalaHorario salaHorario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SalaHorario persistentSalaHorario = em.find(SalaHorario.class, salaHorario.getId());
            Sala salaOld = persistentSalaHorario.getSala();
            Sala salaNew = salaHorario.getSala();
            Disciplina disciplinaOld = persistentSalaHorario.getDisciplina();
            Disciplina disciplinaNew = salaHorario.getDisciplina();
            if (salaNew != null) {
                salaNew = em.getReference(salaNew.getClass(), salaNew.getId());
                salaHorario.setSala(salaNew);
            }
            if (disciplinaNew != null) {
                disciplinaNew = em.getReference(disciplinaNew.getClass(), disciplinaNew.getId());
                salaHorario.setDisciplina(disciplinaNew);
            }
            salaHorario = em.merge(salaHorario);
            if (salaOld != null && !salaOld.equals(salaNew)) {
                salaOld.getListSalaHorario().remove(salaHorario);
                salaOld = em.merge(salaOld);
            }
            if (salaNew != null && !salaNew.equals(salaOld)) {
                salaNew.getListSalaHorario().add(salaHorario);
                salaNew = em.merge(salaNew);
            }
            if (disciplinaOld != null && !disciplinaOld.equals(disciplinaNew)) {
                disciplinaOld.getListaSalaHorario().remove(salaHorario);
                disciplinaOld = em.merge(disciplinaOld);
            }
            if (disciplinaNew != null && !disciplinaNew.equals(disciplinaOld)) {
                disciplinaNew.getListaSalaHorario().add(salaHorario);
                disciplinaNew = em.merge(disciplinaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = salaHorario.getId();
                if (findSalaHorario(id) == null) {
                    throw new NonexistentEntityException("The salaHorario with id " + id + " no longer exists.");
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
            SalaHorario salaHorario;
            try {
                salaHorario = em.getReference(SalaHorario.class, id);
                salaHorario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salaHorario with id " + id + " no longer exists.", enfe);
            }
            Sala sala = salaHorario.getSala();
            if (sala != null) {
                sala.getListSalaHorario().remove(salaHorario);
                sala = em.merge(sala);
            }
            Disciplina disciplina = salaHorario.getDisciplina();
            if (disciplina != null) {
                disciplina.getListaSalaHorario().remove(salaHorario);
                disciplina = em.merge(disciplina);
            }
            em.remove(salaHorario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SalaHorario> findSalaHorarioEntities() {
        return findSalaHorarioEntities(true, -1, -1);
    }

    public List<SalaHorario> findSalaHorarioEntities(int maxResults, int firstResult) {
        return findSalaHorarioEntities(false, maxResults, firstResult);
    }

    private List<SalaHorario> findSalaHorarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SalaHorario.class));
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

    public SalaHorario findSalaHorario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SalaHorario.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalaHorarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SalaHorario> rt = cq.from(SalaHorario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void limparTabela() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("Delete FROM SalaHorario");
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
