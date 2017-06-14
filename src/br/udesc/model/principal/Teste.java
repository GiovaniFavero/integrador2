package br.udesc.model.principal;

import br.udesc.controller.ControladorTelaInicio;
/*
    import br.udesc.controller.ControladorTelaRestricoesProfessor;
    import br.udesc.model.dao.CursoJpaController;
    import br.udesc.model.dao.DisciplinaJpaController;
    import br.udesc.model.dao.ProfessorJpaController;
    import br.udesc.model.entidade.Curso;
    import br.udesc.model.entidade.Disciplina;
    import br.udesc.model.entidade.Professor;
    import br.udesc.model.entidade.RestricaoDisciplina;
    import java.util.ArrayList;
    import java.util.List;
 */
import br.udesc.model.dao.ControladorGLPK;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.model.entidade.Sala;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {

        ControladorGLPK c = new ControladorGLPK();

        try {
            c.escreveProblema();
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DisciplinaJpaController djc = new DisciplinaJpaController();
        ProfessorJpaController pjc = new ProfessorJpaController();
        CursoJpaController cjc = new CursoJpaController();
        SalaJpaController sjc = new SalaJpaController();
        
        Professor p1 = new Professor("Joao", "1231213");
        pjc.create(p1);
        Professor p2 = new Professor("Amanda", "77878798");
        pjc.create(p2);
        Professor p3 = new Professor("Maria", "4546545");
        pjc.create(p3);
        Professor p4 = new Professor("Jose", "1474717414");
        pjc.create(p4);
        Professor p5 = new Professor("Tiago", "3696939");
        pjc.create(p5);
        Professor p6 = new Professor("Marcelo", "456456456");
        pjc.create(p6);
        
        Curso c1 = new Curso("Software", 5);
        cjc.create(c1);
        Curso c2 = new Curso("Contabeis", 5);
        cjc.create(c2);
        Curso c3 = new Curso("Sanitaria", 6);
        cjc.create(c3);
        
        Sala s1 = new Sala("10", 25, false);
        sjc.create(s1);
        Sala s2 = new Sala("11", 25, false);
        sjc.create(s2);
        Sala s3 = new Sala("9", 30, false);
        sjc.create(s3);
        Sala s4 = new Sala("2", 10, true);
        sjc.create(s4);
        Sala s5 = new Sala("3", 15, true);
        sjc.create(s5);
        Sala s6 = new Sala("4", 15, true);
        sjc.create(s6);
        
        Disciplina d1 = new Disciplina("Projeto integrador 2", 4, "5", 1, 10, "PINII", c1, p1);
        djc.create(d1);
        Disciplina d2 = new Disciplina("matematica idscreta", 4, "1", 0, 30, "MAT", c1, p2);
        djc.create(d2);
        Disciplina d3 = new Disciplina("prog 1", 6, "2", 1, 25, "PROI", c1, p3);
        djc.create(d3);
        Disciplina d4 = new Disciplina("prog 2", 6, "3", 1, 25, "PROII", c1, p4);
        djc.create(d4);
        Disciplina d5 = new Disciplina("Calculo 1", 6, "1", 1, 25, "CADI", c3, p5);
        djc.create(d5);
        Disciplina d6 = new Disciplina("Calculo", 6, "3", 1, 25, "CAD", c1, p6);
        djc.create(d6);
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");

        EntityManager em = emf.createEntityManager();

        //Acessa a primeira tela
        ControladorTelaInicio cti = new ControladorTelaInicio();
        cti.executar();
        //  ControladorTelaRestricoesProfessor cb = new ControladorTelaRestricoesProfessor();
        //  cb.executar();

    }
}
