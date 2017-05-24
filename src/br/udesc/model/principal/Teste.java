package br.udesc.model.principal;

import br.udesc.controller.ControladorTelaInicio;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
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

        //Singleton para criar o curso
//        CriarCurso cc = CriarCurso.getInstance();

//        CursoJpaController cjc = new CursoJpaController();
//        DisciplinaJpaController djc = new DisciplinaJpaController();

//            List<Curso> curso = cjc.listarCurso();
//            List<Disciplina> disciplina = djc.listarDisciplinaPorFase("1");
//            System.out.println(disciplina.size());
        //Para Criação de Disciplinas (0 = Obrigatóriamente em Sala, 1 = Obrigatóriamente em Lab, 2 = Misto, 3 = Tanto Faz)
//            Disciplina primeiraFaseArquiteura = new Disciplina("Arquitetura de Computadores", 4, "1", 3, 40, eso);
//            djc.create(primeiraFaseArquiteura);
//            eso.addListaDisciplina(primeiraFaseArquiteura);
//            
//            Disciplina primeiraFaseComunicacao = new Disciplina ("Comunicação e Expressão", 2, "1", 0, 40, eso);
//            djc.create(primeiraFaseComunicacao);
//            eso.addListaDisciplina(primeiraFaseComunicacao);
//            
//            Disciplina primeiraFaseFundamentos = new Disciplina ("Fundamentos da Engenharia de Software", 2, "1", 3, 40, eso); 
//            djc.create(primeiraFaseFundamentos);
//            eso.addListaDisciplina(primeiraFaseFundamentos);
//            
//            Disciplina primeiraFaseAdm = new Disciplina ("Fundamentos de Administração", 2, "1", 0, 40, eso); 
//            djc.create(primeiraFaseAdm);
//            eso.addListaDisciplina(primeiraFaseAdm);
//            
//            Disciplina primeiraFaseIntro = new Disciplina ("Introdução à Programação", 6, "1", 2, 40, eso); 
//            djc.create(primeiraFaseIntro);
//            eso.addListaDisciplina(primeiraFaseIntro);
//            
//            Disciplina primeiraFaseMat = new Disciplina ("Matemática Discreta", 4, "2", 0, 40, eso);
//            djc.create(primeiraFaseMat);
//            eso.addListaDisciplina(primeiraFaseMat);
//            
//            cjc.edit(eso);
//                    
        em.close();
        emf.close();

    }
}
