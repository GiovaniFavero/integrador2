package br.udesc.model.principal;

import br.udesc.controller.ControladorTelaInicio;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();

        //Acessa a primeira tela
        ControladorTelaInicio cti = new ControladorTelaInicio();
        cti.executar();

        ProfessorJpaController pjc = new ProfessorJpaController();
        List<Professor> listaProfessor = pjc.validaProfessor("Pedro");
//        System.out.println(listaProfessor.get(0).getListaDisciplinaProfessor().size() + " Tamanho do array do prof");
//
//        DisciplinaJpaController djc = new DisciplinaJpaController();
//        List<Disciplina> listaDisciplina = djc.validaDisciplinaNome("Discreta");
//        System.out.println(listaDisciplina.get(0).getProfessor() + " Professor dessa");
//
//        CursoJpaController cjc = new CursoJpaController();
//        List<Curso> listaCurso = cjc.validaCurso("Software");
//        System.out.println(listaCurso.get(0).getListaDisciplina().get(0).toString() + " toString da disciplina dentro do Array de curso");

    }
}
