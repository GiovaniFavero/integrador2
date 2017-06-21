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
import br.udesc.model.entidade.Professor;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.RestricaoDisciplina;
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
public class DisciplinaJpaController implements Serializable {

    public DisciplinaJpaController() {
        emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Disciplina disciplina) {
        if (disciplina.getListaRestricaoDisciplina() == null) {
            disciplina.setListaRestricaoDisciplina(new ArrayList<RestricaoDisciplina>());
        }
        if (disciplina.getListaSalaHorario() == null) {
            disciplina.setListaSalaHorario(new ArrayList<SalaHorario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala sala = disciplina.getSala();
            if (sala != null) {
                sala = em.getReference(sala.getClass(), sala.getId());
                disciplina.setSala(sala);
            }
            Professor professor = disciplina.getProfessor();
            if (professor != null) {
                professor = em.getReference(professor.getClass(), professor.getId());
                disciplina.setProfessor(professor);
            }
            Curso curso = disciplina.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                disciplina.setCurso(curso);
            }
            List<RestricaoDisciplina> attachedListaRestricaoDisciplina = new ArrayList<RestricaoDisciplina>();
            for (RestricaoDisciplina listaRestricaoDisciplinaRestricaoDisciplinaToAttach : disciplina.getListaRestricaoDisciplina()) {
                listaRestricaoDisciplinaRestricaoDisciplinaToAttach = em.getReference(listaRestricaoDisciplinaRestricaoDisciplinaToAttach.getClass(), listaRestricaoDisciplinaRestricaoDisciplinaToAttach.getId());
                attachedListaRestricaoDisciplina.add(listaRestricaoDisciplinaRestricaoDisciplinaToAttach);
            }
            disciplina.setListaRestricaoDisciplina(attachedListaRestricaoDisciplina);
            List<SalaHorario> attachedListaSalaHorario = new ArrayList<SalaHorario>();
            for (SalaHorario listaSalaHorarioSalaHorarioToAttach : disciplina.getListaSalaHorario()) {
                listaSalaHorarioSalaHorarioToAttach = em.getReference(listaSalaHorarioSalaHorarioToAttach.getClass(), listaSalaHorarioSalaHorarioToAttach.getId());
                attachedListaSalaHorario.add(listaSalaHorarioSalaHorarioToAttach);
            }
            disciplina.setListaSalaHorario(attachedListaSalaHorario);
            em.persist(disciplina);
            if (sala != null) {
                sala.getListaDisciplina().add(disciplina);
                sala = em.merge(sala);
            }
            if (professor != null) {
                professor.getListaDisciplinaProfessor().add(disciplina);
                professor = em.merge(professor);
            }
            if (curso != null) {
                curso.getListaDisciplina().add(disciplina);
                curso = em.merge(curso);
            }
            for (RestricaoDisciplina listaRestricaoDisciplinaRestricaoDisciplina : disciplina.getListaRestricaoDisciplina()) {
                Disciplina oldDisciplinaOfListaRestricaoDisciplinaRestricaoDisciplina = listaRestricaoDisciplinaRestricaoDisciplina.getDisciplina();
                listaRestricaoDisciplinaRestricaoDisciplina.setDisciplina(disciplina);
                listaRestricaoDisciplinaRestricaoDisciplina = em.merge(listaRestricaoDisciplinaRestricaoDisciplina);
                if (oldDisciplinaOfListaRestricaoDisciplinaRestricaoDisciplina != null) {
                    oldDisciplinaOfListaRestricaoDisciplinaRestricaoDisciplina.getListaRestricaoDisciplina().remove(listaRestricaoDisciplinaRestricaoDisciplina);
                    oldDisciplinaOfListaRestricaoDisciplinaRestricaoDisciplina = em.merge(oldDisciplinaOfListaRestricaoDisciplinaRestricaoDisciplina);
                }
            }
            for (SalaHorario listaSalaHorarioSalaHorario : disciplina.getListaSalaHorario()) {
                Disciplina oldDisciplinaOfListaSalaHorarioSalaHorario = listaSalaHorarioSalaHorario.getDisciplina();
                listaSalaHorarioSalaHorario.setDisciplina(disciplina);
                listaSalaHorarioSalaHorario = em.merge(listaSalaHorarioSalaHorario);
                if (oldDisciplinaOfListaSalaHorarioSalaHorario != null) {
                    oldDisciplinaOfListaSalaHorarioSalaHorario.getListaSalaHorario().remove(listaSalaHorarioSalaHorario);
                    oldDisciplinaOfListaSalaHorarioSalaHorario = em.merge(oldDisciplinaOfListaSalaHorarioSalaHorario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Disciplina disciplina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Disciplina persistentDisciplina = em.find(Disciplina.class, disciplina.getId());
            Sala salaOld = persistentDisciplina.getSala();
            Sala salaNew = disciplina.getSala();
            Professor professorOld = persistentDisciplina.getProfessor();
            Professor professorNew = disciplina.getProfessor();
            Curso cursoOld = persistentDisciplina.getCurso();
            Curso cursoNew = disciplina.getCurso();
            List<RestricaoDisciplina> listaRestricaoDisciplinaOld = persistentDisciplina.getListaRestricaoDisciplina();
            List<RestricaoDisciplina> listaRestricaoDisciplinaNew = disciplina.getListaRestricaoDisciplina();
            List<SalaHorario> listaSalaHorarioOld = persistentDisciplina.getListaSalaHorario();
            List<SalaHorario> listaSalaHorarioNew = disciplina.getListaSalaHorario();
            if (salaNew != null) {
                salaNew = em.getReference(salaNew.getClass(), salaNew.getId());
                disciplina.setSala(salaNew);
            }
            if (professorNew != null) {
                professorNew = em.getReference(professorNew.getClass(), professorNew.getId());
                disciplina.setProfessor(professorNew);
            }
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                disciplina.setCurso(cursoNew);
            }
            List<RestricaoDisciplina> attachedListaRestricaoDisciplinaNew = new ArrayList<RestricaoDisciplina>();
            for (RestricaoDisciplina listaRestricaoDisciplinaNewRestricaoDisciplinaToAttach : listaRestricaoDisciplinaNew) {
                listaRestricaoDisciplinaNewRestricaoDisciplinaToAttach = em.getReference(listaRestricaoDisciplinaNewRestricaoDisciplinaToAttach.getClass(), listaRestricaoDisciplinaNewRestricaoDisciplinaToAttach.getId());
                attachedListaRestricaoDisciplinaNew.add(listaRestricaoDisciplinaNewRestricaoDisciplinaToAttach);
            }
            listaRestricaoDisciplinaNew = attachedListaRestricaoDisciplinaNew;
            disciplina.setListaRestricaoDisciplina(listaRestricaoDisciplinaNew);
            List<SalaHorario> attachedListaSalaHorarioNew = new ArrayList<SalaHorario>();
            for (SalaHorario listaSalaHorarioNewSalaHorarioToAttach : listaSalaHorarioNew) {
                listaSalaHorarioNewSalaHorarioToAttach = em.getReference(listaSalaHorarioNewSalaHorarioToAttach.getClass(), listaSalaHorarioNewSalaHorarioToAttach.getId());
                attachedListaSalaHorarioNew.add(listaSalaHorarioNewSalaHorarioToAttach);
            }
            listaSalaHorarioNew = attachedListaSalaHorarioNew;
            disciplina.setListaSalaHorario(listaSalaHorarioNew);
            disciplina = em.merge(disciplina);
            if (salaOld != null && !salaOld.equals(salaNew)) {
                salaOld.getListaDisciplina().remove(disciplina);
                salaOld = em.merge(salaOld);
            }
            if (salaNew != null && !salaNew.equals(salaOld)) {
                salaNew.getListaDisciplina().add(disciplina);
                salaNew = em.merge(salaNew);
            }
            if (professorOld != null && !professorOld.equals(professorNew)) {
                professorOld.getListaDisciplinaProfessor().remove(disciplina);
                professorOld = em.merge(professorOld);
            }
            if (professorNew != null && !professorNew.equals(professorOld)) {
                professorNew.getListaDisciplinaProfessor().add(disciplina);
                professorNew = em.merge(professorNew);
            }
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getListaDisciplina().remove(disciplina);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getListaDisciplina().add(disciplina);
                cursoNew = em.merge(cursoNew);
            }
            for (RestricaoDisciplina listaRestricaoDisciplinaOldRestricaoDisciplina : listaRestricaoDisciplinaOld) {
                if (!listaRestricaoDisciplinaNew.contains(listaRestricaoDisciplinaOldRestricaoDisciplina)) {
                    listaRestricaoDisciplinaOldRestricaoDisciplina.setDisciplina(null);
                    listaRestricaoDisciplinaOldRestricaoDisciplina = em.merge(listaRestricaoDisciplinaOldRestricaoDisciplina);
                }
            }
            for (RestricaoDisciplina listaRestricaoDisciplinaNewRestricaoDisciplina : listaRestricaoDisciplinaNew) {
                if (!listaRestricaoDisciplinaOld.contains(listaRestricaoDisciplinaNewRestricaoDisciplina)) {
                    Disciplina oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina = listaRestricaoDisciplinaNewRestricaoDisciplina.getDisciplina();
                    listaRestricaoDisciplinaNewRestricaoDisciplina.setDisciplina(disciplina);
                    listaRestricaoDisciplinaNewRestricaoDisciplina = em.merge(listaRestricaoDisciplinaNewRestricaoDisciplina);
                    if (oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina != null && !oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina.equals(disciplina)) {
                        oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina.getListaRestricaoDisciplina().remove(listaRestricaoDisciplinaNewRestricaoDisciplina);
                        oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina = em.merge(oldDisciplinaOfListaRestricaoDisciplinaNewRestricaoDisciplina);
                    }
                }
            }
            for (SalaHorario listaSalaHorarioOldSalaHorario : listaSalaHorarioOld) {
                if (!listaSalaHorarioNew.contains(listaSalaHorarioOldSalaHorario)) {
                    listaSalaHorarioOldSalaHorario.setDisciplina(null);
                    listaSalaHorarioOldSalaHorario = em.merge(listaSalaHorarioOldSalaHorario);
                }
            }
            for (SalaHorario listaSalaHorarioNewSalaHorario : listaSalaHorarioNew) {
                if (!listaSalaHorarioOld.contains(listaSalaHorarioNewSalaHorario)) {
                    Disciplina oldDisciplinaOfListaSalaHorarioNewSalaHorario = listaSalaHorarioNewSalaHorario.getDisciplina();
                    listaSalaHorarioNewSalaHorario.setDisciplina(disciplina);
                    listaSalaHorarioNewSalaHorario = em.merge(listaSalaHorarioNewSalaHorario);
                    if (oldDisciplinaOfListaSalaHorarioNewSalaHorario != null && !oldDisciplinaOfListaSalaHorarioNewSalaHorario.equals(disciplina)) {
                        oldDisciplinaOfListaSalaHorarioNewSalaHorario.getListaSalaHorario().remove(listaSalaHorarioNewSalaHorario);
                        oldDisciplinaOfListaSalaHorarioNewSalaHorario = em.merge(oldDisciplinaOfListaSalaHorarioNewSalaHorario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = disciplina.getId();
                if (findDisciplina(id) == null) {
                    throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.");
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
            Disciplina disciplina;
            try {
                disciplina = em.getReference(Disciplina.class, id);
                disciplina.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.", enfe);
            }
            Sala sala = disciplina.getSala();
            if (sala != null) {
                sala.getListaDisciplina().remove(disciplina);
                sala = em.merge(sala);
            }
            Professor professor = disciplina.getProfessor();
            if (professor != null) {
                professor.getListaDisciplinaProfessor().remove(disciplina);
                professor = em.merge(professor);
            }
            Curso curso = disciplina.getCurso();
            if (curso != null) {
                curso.getListaDisciplina().remove(disciplina);
                curso = em.merge(curso);
            }
            List<RestricaoDisciplina> listaRestricaoDisciplina = disciplina.getListaRestricaoDisciplina();
            for (RestricaoDisciplina listaRestricaoDisciplinaRestricaoDisciplina : listaRestricaoDisciplina) {
                listaRestricaoDisciplinaRestricaoDisciplina.setDisciplina(null);
                listaRestricaoDisciplinaRestricaoDisciplina = em.merge(listaRestricaoDisciplinaRestricaoDisciplina);
            }
            List<SalaHorario> listaSalaHorario = disciplina.getListaSalaHorario();
            for (SalaHorario listaSalaHorarioSalaHorario : listaSalaHorario) {
                listaSalaHorarioSalaHorario.setDisciplina(null);
                listaSalaHorarioSalaHorario = em.merge(listaSalaHorarioSalaHorario);
            }
            em.remove(disciplina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Disciplina> findDisciplinaEntities() {
        return findDisciplinaEntities(true, -1, -1);
    }

    public List<Disciplina> findDisciplinaEntities(int maxResults, int firstResult) {
        return findDisciplinaEntities(false, maxResults, firstResult);
    }

    private List<Disciplina> findDisciplinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Disciplina.class));
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

    public Disciplina findDisciplina(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Disciplina.class, id);
        } finally {
            em.close();
        }
    }

    public int getDisciplinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Disciplina> rt = cq.from(Disciplina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Disciplina> listarDisciplinaPorFase(String fase) {
        String jpql = "select u from Disciplina u where u.fase =:fase_disciplina";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Disciplina> resultado = em.createQuery(jpql, Disciplina.class).setParameter("fase_disciplina", fase).getResultList();
        if (resultado == null || resultado.isEmpty()) {
            return null;
        }
        return resultado;
    }

    public List<Disciplina> listarDisciplinaPorCurso(Long curso) {
        String jpql = "select u from Disciplina u where u.curso =:id_curso";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Disciplina> resultado = em.createQuery(jpql, Disciplina.class).setParameter("id_curso", curso).getResultList();
        if (resultado == null || resultado.isEmpty()) {
            return null;
        }
        return resultado;
    }

    public List<Disciplina> listarDisciplina() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Disciplina e");
            List<Disciplina> disciplina = query.getResultList();
            return disciplina;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public List<Disciplina> validaDisciplina(String disciplina) {
        String jpql = "select u from Disciplina u where u.codigo =:codigo_disciplina";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Disciplina> disc = em.createQuery(jpql, Disciplina.class).setParameter("codigo_disciplina", disciplina).getResultList();
        if (disc == null || disc.isEmpty()) {
            return null;
        }
        return disc;
    }

    public List<Disciplina> validaDisciplinaNome(String nome) {
        String jpql = "select u from Disciplina u where u.nome =:nome_disciplina";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Disciplina> disc = em.createQuery(jpql, Disciplina.class).setParameter("nome_disciplina", nome).getResultList();
        if (disc == null || disc.isEmpty()) {
            return null;
        }
        return disc;
    }

}
