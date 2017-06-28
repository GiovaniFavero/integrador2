package br.udesc.model.dao.GLPK;

import br.udesc.controller.ControladorTelaInicio;
import br.udesc.model.dao.ControladorGLPK;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.GerarGLPK;
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

        GerarMaterias gm = new GerarMaterias();
        GerarLaboratorios gl = new GerarLaboratorios();
        GerarProfessor gp = new GerarProfessor();

        SalaJpaController sjc = new SalaJpaController();
        DisciplinaJpaController djc = new DisciplinaJpaController();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        EntityManager em = emf.createEntityManager();

//        gm.gerarCurso();
//        gm.gerarPrimeiraFase();
//        gm.gerarSegundaFase();
//        gp.gerarProfessorPrimeiraSegundaFase();
//        gm.gerarTerceiraFase();
//        gm.gerarQuartaFase();
//        gm.gerarQuintaFase();
//        gm.gerarSextaFase();
//        gm.gerarSetimaFase();
//        gm.gerarOitavaFase();
//        gl.gerarLabs();
//        gp.gerarProfessor();
//        gp.gerarRestricaoProfessor();
//         gl.vincularLabs();

//            GerarGLPK gg = new GerarGLPK();
////
//            gg.geraTudo();



        ControladorTelaInicio cti = new ControladorTelaInicio();
        cti.executar();
    }
}
