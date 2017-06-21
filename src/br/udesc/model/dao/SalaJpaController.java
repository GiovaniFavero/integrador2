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
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Sala;
import java.util.ArrayList;
import java.util.List;
import br.udesc.model.entidade.SalaHorario;
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
        if (sala.getListaDisciplina() == null) {
            sala.setListaDisciplina(new ArrayList<Disciplina>());
        }
        if (sala.getListSalaHorario() == null) {
            sala.setListSalaHorario(new ArrayList<SalaHorario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Disciplina> attachedListaDisciplina = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaDisciplinaToAttach : sala.getListaDisciplina()) {
                listaDisciplinaDisciplinaToAttach = em.getReference(listaDisciplinaDisciplinaToAttach.getClass(), listaDisciplinaDisciplinaToAttach.getId());
                attachedListaDisciplina.add(listaDisciplinaDisciplinaToAttach);
            }
            sala.setListaDisciplina(attachedListaDisciplina);
            List<SalaHorario> attachedListSalaHorario = new ArrayList<SalaHorario>();
            for (SalaHorario listSalaHorarioSalaHorarioToAttach : sala.getListSalaHorario()) {
                listSalaHorarioSalaHorarioToAttach = em.getReference(listSalaHorarioSalaHorarioToAttach.getClass(), listSalaHorarioSalaHorarioToAttach.getId());
                attachedListSalaHorario.add(listSalaHorarioSalaHorarioToAttach);
            }
            sala.setListSalaHorario(attachedListSalaHorario);
            em.persist(sala);
            for (Disciplina listaDisciplinaDisciplina : sala.getListaDisciplina()) {
                Sala oldSalaOfListaDisciplinaDisciplina = listaDisciplinaDisciplina.getSala();
                listaDisciplinaDisciplina.setSala(sala);
                listaDisciplinaDisciplina = em.merge(listaDisciplinaDisciplina);
                if (oldSalaOfListaDisciplinaDisciplina != null) {
                    oldSalaOfListaDisciplinaDisciplina.getListaDisciplina().remove(listaDisciplinaDisciplina);
                    oldSalaOfListaDisciplinaDisciplina = em.merge(oldSalaOfListaDisciplinaDisciplina);
                }
            }
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
            List<Disciplina> listaDisciplinaOld = persistentSala.getListaDisciplina();
            List<Disciplina> listaDisciplinaNew = sala.getListaDisciplina();
            List<SalaHorario> listSalaHorarioOld = persistentSala.getListSalaHorario();
            List<SalaHorario> listSalaHorarioNew = sala.getListSalaHorario();
            List<Disciplina> attachedListaDisciplinaNew = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaNewDisciplinaToAttach : listaDisciplinaNew) {
                listaDisciplinaNewDisciplinaToAttach = em.getReference(listaDisciplinaNewDisciplinaToAttach.getClass(), listaDisciplinaNewDisciplinaToAttach.getId());
                attachedListaDisciplinaNew.add(listaDisciplinaNewDisciplinaToAttach);
            }
            listaDisciplinaNew = attachedListaDisciplinaNew;
            sala.setListaDisciplina(listaDisciplinaNew);
            List<SalaHorario> attachedListSalaHorarioNew = new ArrayList<SalaHorario>();
            for (SalaHorario listSalaHorarioNewSalaHorarioToAttach : listSalaHorarioNew) {
                listSalaHorarioNewSalaHorarioToAttach = em.getReference(listSalaHorarioNewSalaHorarioToAttach.getClass(), listSalaHorarioNewSalaHorarioToAttach.getId());
                attachedListSalaHorarioNew.add(listSalaHorarioNewSalaHorarioToAttach);
            }
            listSalaHorarioNew = attachedListSalaHorarioNew;
            sala.setListSalaHorario(listSalaHorarioNew);
            sala = em.merge(sala);
            for (Disciplina listaDisciplinaOldDisciplina : listaDisciplinaOld) {
                if (!listaDisciplinaNew.contains(listaDisciplinaOldDisciplina)) {
                    listaDisciplinaOldDisciplina.setSala(null);
                    listaDisciplinaOldDisciplina = em.merge(listaDisciplinaOldDisciplina);
                }
            }
            for (Disciplina listaDisciplinaNewDisciplina : listaDisciplinaNew) {
                if (!listaDisciplinaOld.contains(listaDisciplinaNewDisciplina)) {
                    Sala oldSalaOfListaDisciplinaNewDisciplina = listaDisciplinaNewDisciplina.getSala();
                    listaDisciplinaNewDisciplina.setSala(sala);
                    listaDisciplinaNewDisciplina = em.merge(listaDisciplinaNewDisciplina);
                    if (oldSalaOfListaDisciplinaNewDisciplina != null && !oldSalaOfListaDisciplinaNewDisciplina.equals(sala)) {
                        oldSalaOfListaDisciplinaNewDisciplina.getListaDisciplina().remove(listaDisciplinaNewDisciplina);
                        oldSalaOfListaDisciplinaNewDisciplina = em.merge(oldSalaOfListaDisciplinaNewDisciplina);
                    }
                }
            }
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
            List<Disciplina> listaDisciplina = sala.getListaDisciplina();
            for (Disciplina listaDisciplinaDisciplina : listaDisciplina) {
                listaDisciplinaDisciplina.setSala(null);
                listaDisciplinaDisciplina = em.merge(listaDisciplinaDisciplina);
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

    public List<Sala> validaSala(String sala) {
        String jpql = "select u from Sala u where u.numero =:numero_sala";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Sala> curs = em.createQuery(jpql, Sala.class).setParameter("numero_sala", sala).getResultList();
        if (curs == null || curs.isEmpty()) {
            return null;
        }
        return curs;
    }

    public List<Sala> listarSala() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Sala e");
            List<Sala> sala = query.getResultList();
            return sala;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }
}
