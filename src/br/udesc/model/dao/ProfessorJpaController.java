package br.udesc.model.dao;

import br.udesc.model.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.udesc.model.entidade.Disciplina;
import java.util.ArrayList;
import java.util.List;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe resposável pelas operações de persistencia do objeto Professor.
 * @author PIN2
 */
public class ProfessorJpaController implements Serializable {

    /**
     * Construtor guardando a unidade de persistência em uma variável local.
     */
    public ProfessorJpaController() {
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
     * Método responsável por salvar Professor no banco de dados.
     * @param professor Professor a ser salva no banco de dados.
     */
    public void create(Professor professor) {
        if (professor.getListaDisciplinaProfessor() == null) {
            professor.setListaDisciplinaProfessor(new ArrayList<Disciplina>());
        }
        if (professor.getListaHorario() == null) {
            professor.setListaHorario(new ArrayList<PessoaHorarioPreferencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Disciplina> attachedListaDisciplinaProfessor = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaProfessorDisciplinaToAttach : professor.getListaDisciplinaProfessor()) {
                listaDisciplinaProfessorDisciplinaToAttach = em.getReference(listaDisciplinaProfessorDisciplinaToAttach.getClass(), listaDisciplinaProfessorDisciplinaToAttach.getId());
                attachedListaDisciplinaProfessor.add(listaDisciplinaProfessorDisciplinaToAttach);
            }
            professor.setListaDisciplinaProfessor(attachedListaDisciplinaProfessor);
            List<PessoaHorarioPreferencia> attachedListaHorario = new ArrayList<PessoaHorarioPreferencia>();
            for (PessoaHorarioPreferencia listaHorarioPessoaHorarioPreferenciaToAttach : professor.getListaHorario()) {
                listaHorarioPessoaHorarioPreferenciaToAttach = em.getReference(listaHorarioPessoaHorarioPreferenciaToAttach.getClass(), listaHorarioPessoaHorarioPreferenciaToAttach.getId());
                attachedListaHorario.add(listaHorarioPessoaHorarioPreferenciaToAttach);
            }
            professor.setListaHorario(attachedListaHorario);
            em.persist(professor);
            for (Disciplina listaDisciplinaProfessorDisciplina : professor.getListaDisciplinaProfessor()) {
                Professor oldProfessorOfListaDisciplinaProfessorDisciplina = listaDisciplinaProfessorDisciplina.getProfessor();
                listaDisciplinaProfessorDisciplina.setProfessor(professor);
                listaDisciplinaProfessorDisciplina = em.merge(listaDisciplinaProfessorDisciplina);
                if (oldProfessorOfListaDisciplinaProfessorDisciplina != null) {
                    oldProfessorOfListaDisciplinaProfessorDisciplina.getListaDisciplinaProfessor().remove(listaDisciplinaProfessorDisciplina);
                    oldProfessorOfListaDisciplinaProfessorDisciplina = em.merge(oldProfessorOfListaDisciplinaProfessorDisciplina);
                }
            }
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

    /**
     * Método responsável por alterar Professor no banco de dados.
     * @param professor Professor a ser editado.
     * @throws NonexistentEntityException Não encontrado(a).
     */
    public void edit(Professor professor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor persistentProfessor = em.find(Professor.class, professor.getId());
            List<Disciplina> listaDisciplinaProfessorOld = persistentProfessor.getListaDisciplinaProfessor();
            List<Disciplina> listaDisciplinaProfessorNew = professor.getListaDisciplinaProfessor();
            List<PessoaHorarioPreferencia> listaHorarioOld = persistentProfessor.getListaHorario();
            List<PessoaHorarioPreferencia> listaHorarioNew = professor.getListaHorario();
            List<Disciplina> attachedListaDisciplinaProfessorNew = new ArrayList<Disciplina>();
            for (Disciplina listaDisciplinaProfessorNewDisciplinaToAttach : listaDisciplinaProfessorNew) {
                listaDisciplinaProfessorNewDisciplinaToAttach = em.getReference(listaDisciplinaProfessorNewDisciplinaToAttach.getClass(), listaDisciplinaProfessorNewDisciplinaToAttach.getId());
                attachedListaDisciplinaProfessorNew.add(listaDisciplinaProfessorNewDisciplinaToAttach);
            }
            listaDisciplinaProfessorNew = attachedListaDisciplinaProfessorNew;
            professor.setListaDisciplinaProfessor(listaDisciplinaProfessorNew);
            List<PessoaHorarioPreferencia> attachedListaHorarioNew = new ArrayList<PessoaHorarioPreferencia>();
            for (PessoaHorarioPreferencia listaHorarioNewPessoaHorarioPreferenciaToAttach : listaHorarioNew) {
                listaHorarioNewPessoaHorarioPreferenciaToAttach = em.getReference(listaHorarioNewPessoaHorarioPreferenciaToAttach.getClass(), listaHorarioNewPessoaHorarioPreferenciaToAttach.getId());
                attachedListaHorarioNew.add(listaHorarioNewPessoaHorarioPreferenciaToAttach);
            }
            listaHorarioNew = attachedListaHorarioNew;
            professor.setListaHorario(listaHorarioNew);
            professor = em.merge(professor);
            for (Disciplina listaDisciplinaProfessorOldDisciplina : listaDisciplinaProfessorOld) {
                if (!listaDisciplinaProfessorNew.contains(listaDisciplinaProfessorOldDisciplina)) {
                    listaDisciplinaProfessorOldDisciplina.setProfessor(null);
                    listaDisciplinaProfessorOldDisciplina = em.merge(listaDisciplinaProfessorOldDisciplina);
                }
            }
            for (Disciplina listaDisciplinaProfessorNewDisciplina : listaDisciplinaProfessorNew) {
                if (!listaDisciplinaProfessorOld.contains(listaDisciplinaProfessorNewDisciplina)) {
                    Professor oldProfessorOfListaDisciplinaProfessorNewDisciplina = listaDisciplinaProfessorNewDisciplina.getProfessor();
                    listaDisciplinaProfessorNewDisciplina.setProfessor(professor);
                    listaDisciplinaProfessorNewDisciplina = em.merge(listaDisciplinaProfessorNewDisciplina);
                    if (oldProfessorOfListaDisciplinaProfessorNewDisciplina != null && !oldProfessorOfListaDisciplinaProfessorNewDisciplina.equals(professor)) {
                        oldProfessorOfListaDisciplinaProfessorNewDisciplina.getListaDisciplinaProfessor().remove(listaDisciplinaProfessorNewDisciplina);
                        oldProfessorOfListaDisciplinaProfessorNewDisciplina = em.merge(oldProfessorOfListaDisciplinaProfessorNewDisciplina);
                    }
                }
            }
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

    /**
     * Método responsável por excluir Professor no banco de dados.
     * @param id Id do Professor a ser excluído. 
     * @throws NonexistentEntityException Não encontrado(a).
     */
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
            List<Disciplina> listaDisciplinaProfessor = professor.getListaDisciplinaProfessor();
            for (Disciplina listaDisciplinaProfessorDisciplina : listaDisciplinaProfessor) {
                listaDisciplinaProfessorDisciplina.setProfessor(null);
                listaDisciplinaProfessorDisciplina = em.merge(listaDisciplinaProfessorDisciplina);
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

    /**
     * Método responsável por retornar professor solicitada através da Id.
     * @param id Id do professor solicitado.
     * @return Professor
     */
    public Professor findProfessor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Professor.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Método que retorna quantidade de professores no banco de dados.
     * @return quantidadeDeProfessores
     */
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

    /**
     * Método responsável por buscar todos os professores no banco de dados.
     * @return Lista de Professor
     */
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

    /**
     * Método responsável por buscar Professor por nome no banco de dados.
     * @param professor Nome do professor
     * @return Lista de Professor
     */
    public List<Professor> validaProfessor(String professor) {
        String jpql = "select u from Professor u where u.nome =:nome_professor";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();
        List<Professor> prof = em.createQuery(jpql, Professor.class).setParameter("nome_professor", professor).getResultList();
        if (prof == null || prof.isEmpty()) {
            return null;
        }
        return prof;
    }

}
