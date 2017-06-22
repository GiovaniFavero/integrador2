package br.udesc.model.principal;

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

//        EntityManager em = emf.createEntityManager();
//        GerarMaterias gm = new GerarMaterias();
//        gm.gerarCurso();
//        gm.gerarPrimeiraFase();
//        gm.gerarSegundaFase();
//        gm.gerarTerceiraFase();
//        gm.gerarQuartaFase();
//        gm.gerarQuintaFase();
//        gm.gerarSextaFase();
//        gm.gerarSetimaFase();
//        gm.gerarOitavaFase();
        GerarGLPK gg = new GerarGLPK();
        gg.salvar();
        gg.salvarComLab();
        gg.funcaoMax();
        gg.funcaoMaxSala();

//        DisciplinaJpaController djc = new DisciplinaJpaController();
//        CursoJpaController cjc = new CursoJpaController();
//        System.out.println(cjc.listarCurso().get(0).getListaDisciplina().size());
//        for (int i = 0; i < cjc.listarCurso().get(0).getListaDisciplina().size(); i++) {
//            System.out.println(cjc.listarCurso().get(0).getListaDisciplina().get(i).getNome());
//        }
        //Acessa a primeira tela
        ControladorTelaInicio cti = new ControladorTelaInicio();
        cti.executar();
    }
}
