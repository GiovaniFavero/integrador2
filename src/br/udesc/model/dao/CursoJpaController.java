package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Curso;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.udesc.model.entidade.Disciplina;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável pelas operações de persistencia do objeto Curso.
 * @author PIN2
 */
public class CursoJpaController implements Serializable {

    /**
     * Construtor guardando a unidade de persistência em uma variável local.
     */
    public CursoJpaController() {
        emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
    }
    private EntityManagerFactory emf;

    /**
     * Método para adquirir uma EntityManager;
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Método responsável por inserir Curso no banco de dados.
     * @param curso Curso a ser criado.
     */
    public void create(Curso curso) {
        if (curso.getListaDisciplina() == null) {
            curso.setListaDisciplina(new ArrayList<Disciplina>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Disciplina> attachedListaDisciplina = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaDisciplinaToAttach : curso.getListaDisciplina()) {
                listaDisciplinaDisciplinaToAttach = em.getReference(listaDisciplinaDisciplinaToAttach.getClass(), listaDisciplinaDisciplinaToAttach.getId());
                attachedListaDisciplina.add(listaDisciplinaDisciplinaToAttach);
            }
            curso.setListaDisciplina(attachedListaDisciplina);
            em.persist(curso);
            for (Disciplina listaDisciplinaDisciplina : curso.getListaDisciplina()) {
                Curso oldCursoOfListaDisciplinaDisciplina = listaDisciplinaDisciplina.getCurso();
                listaDisciplinaDisciplina.setCurso(curso);
                listaDisciplinaDisciplina = em.merge(listaDisciplinaDisciplina);
                if (oldCursoOfListaDisciplinaDisciplina != null) {
                    oldCursoOfListaDisciplinaDisciplina.getListaDisciplina().remove(listaDisciplinaDisciplina);
                    oldCursoOfListaDisciplinaDisciplina = em.merge(oldCursoOfListaDisciplinaDisciplina);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método responsável por alterar Curso no banco de dados.
     * @param curso Curso a ser editado.
     * @throws NonexistentEntityException Não encontrado(a).
     */
    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getId());
            List<Disciplina> listaDisciplinaOld = persistentCurso.getListaDisciplina();
            List<Disciplina> listaDisciplinaNew = curso.getListaDisciplina();
            List<Disciplina> attachedListaDisciplinaNew = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaNewDisciplinaToAttach : listaDisciplinaNew) {
                listaDisciplinaNewDisciplinaToAttach = em.getReference(listaDisciplinaNewDisciplinaToAttach.getClass(), listaDisciplinaNewDisciplinaToAttach.getId());
                attachedListaDisciplinaNew.add(listaDisciplinaNewDisciplinaToAttach);
            }
            listaDisciplinaNew = attachedListaDisciplinaNew;
            curso.setListaDisciplina(listaDisciplinaNew);
            curso = em.merge(curso);
            for (Disciplina listaDisciplinaOldDisciplina : listaDisciplinaOld) {
                if (!listaDisciplinaNew.contains(listaDisciplinaOldDisciplina)) {
                    listaDisciplinaOldDisciplina.setCurso(null);
                    listaDisciplinaOldDisciplina = em.merge(listaDisciplinaOldDisciplina);
                }
            }
            for (Disciplina listaDisciplinaNewDisciplina : listaDisciplinaNew) {
                if (!listaDisciplinaOld.contains(listaDisciplinaNewDisciplina)) {
                    Curso oldCursoOfListaDisciplinaNewDisciplina = listaDisciplinaNewDisciplina.getCurso();
                    listaDisciplinaNewDisciplina.setCurso(curso);
                    listaDisciplinaNewDisciplina = em.merge(listaDisciplinaNewDisciplina);
                    if (oldCursoOfListaDisciplinaNewDisciplina != null && !oldCursoOfListaDisciplinaNewDisciplina.equals(curso)) {
                        oldCursoOfListaDisciplinaNewDisciplina.getListaDisciplina().remove(listaDisciplinaNewDisciplina);
                        oldCursoOfListaDisciplinaNewDisciplina = em.merge(oldCursoOfListaDisciplinaNewDisciplina);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = curso.getId();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método responsável por excluir Curso no banco de dados.
     * @param id Id do curso a ser excluído. 
     * @throws NonexistentEntityException Não encontrado(a).
     */
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<Disciplina> listaDisciplina = curso.getListaDisciplina();
            for (Disciplina listaDisciplinaDisciplina : listaDisciplina) {
                listaDisciplinaDisciplina.setCurso(null);
                listaDisciplinaDisciplina = em.merge(listaDisciplinaDisciplina);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    /**
     * Método responsável por retornar curso solicitado através da Id.
     * @param id Id do curso solicitado.
     * @return Curso
     */
    public Curso findCurso(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Método que retorna quantidade de cursos no banco de dados.
     * @return quantidadeCursos
     */
    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Método para buscar todos os cursos no banco de dados.
     * @return Cursos. Lista de cursos disponíveis.
     */
    public static List<Curso> listarCurso() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT e FROM Curso e");
            List<Curso> curso = query.getResultList();
            return curso;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Método responsável por retornar cursos com o nome definido no parâmetro. 
     * @param curso Curso na qual é solicitado por nome.
     * @return Cursos Lista de cursos
     */
    public List<Curso> validaCurso(String curso) {
        String jpql = "select u from Curso u where u.nome =:nome_curso";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Curso> curs = em.createQuery(jpql, Curso.class).setParameter("nome_curso", curso).getResultList();
        if (curs == null || curs.isEmpty()) {
            return null;
        }
        return curs;
    }
}
