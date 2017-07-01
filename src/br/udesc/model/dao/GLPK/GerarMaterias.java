package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Sala;

/**
 * Classe responsável por geração de matérias.
 * @author Favero
 */
public class GerarMaterias {

    private Curso curso = new Curso();
    private CursoJpaController cjc = new CursoJpaController();

    private Disciplina disciplina = new Disciplina();
    private DisciplinaJpaController djc = new DisciplinaJpaController();

    private Sala sala = new Sala();
    private SalaJpaController sjc = new SalaJpaController();

    /**
     * Gerar curso.
     */
    public void gerarCurso() {
        curso.setDuracao(8);
        curso.setNome("ESO");
        cjc.create(curso);
    }

    /**
     * Gerar primeira fase.
     */
    public void gerarPrimeiraFase() {
        Disciplina arq = new Disciplina("Arquitetura de Computadores", "15arc", 4, "1", 40, curso, null, null);
        djc.create(arq);
        curso.addListaDisciplina(arq);

        Disciplina cex = new Disciplina("Comunicação e Expressão", "15cex", 2, "1", 40, curso, null, null);
        djc.create(cex);
        curso.addListaDisciplina(cex);

        Disciplina fad = new Disciplina("Fundamentos de Administração", "15fad", 2, "1", 40, curso, null, null);
        djc.create(fad);
        curso.addListaDisciplina(fad);

        Disciplina fes = new Disciplina("Fundamentos de Engenharia de Software", "15fes", 2, "1", 40, curso, null, null);
        djc.create(fes);
        curso.addListaDisciplina(fes);

        Disciplina inp = new Disciplina("Introdução à Programação", "15inp", 6, "1", 40, curso, null, null);
        djc.create(inp);
        curso.addListaDisciplina(inp);

        Disciplina mad = new Disciplina("Matemática Discreta", "15mad", 4, "1", 40, curso, null, null);
        djc.create(mad);
        curso.addListaDisciplina(mad);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gerar segunda fase.
     */
    public void gerarSegundaFase() {
        Disciplina alg = new Disciplina("Álgebra Linear", "25alg", 4, "2", 40, curso, null, null);
        djc.create(alg);
        curso.addListaDisciplina(alg);

        Disciplina grh = new Disciplina("Gestão de Recursos Humanos", "25grh", 2, "2", 40, curso, null, null);
        djc.create(grh);
        curso.addListaDisciplina(grh);

        Disciplina pre = new Disciplina("Probabilidade e Estatística", "25pre", 4, "2", 40, curso, null, null);
        djc.create(pre);
        curso.addListaDisciplina(pre);

        Disciplina prs = new Disciplina("Processo de Software", "25prs", 2, "2", 40, curso, null, null);
        djc.create(prs);
        curso.addListaDisciplina(prs);

        Disciplina pro = new Disciplina("Programação I", "25proI", 4, "2", 40, curso, null, null);
        djc.create(pro);
        curso.addListaDisciplina(pro);

        Disciplina pri = new Disciplina("Projeto de Interface", "25pri", 2, "2", 40, curso, null, null);
        djc.create(pri);
        curso.addListaDisciplina(pri);

        Disciplina sis = new Disciplina("Sistemas Operacionais", "25sis", 2, "2", 40, curso, null, null);
        djc.create(sis);
        curso.addListaDisciplina(sis);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gerar terceira fase.
     */
    public void gerarTerceiraFase() {
        Disciplina cdi = new Disciplina("Cálculo Diferencial e Integral", "35cdi", 6, "3", 40, curso, null, null);
        djc.create(cdi);
        curso.addListaDisciplina(cdi);

        Disciplina req = new Disciplina("Engenharia de Requisitos", "35req", 2, "3", 40, curso, null, null);
        djc.create(req);
        curso.addListaDisciplina(req);

        Disciplina fco = new Disciplina("Fundamentos de Contabilidade", "35fco", 2, "3", 40, curso, null, null);
        djc.create(fco);
        curso.addListaDisciplina(fco);

        Disciplina mpc = new Disciplina("Metodologia de Pequisa Científica", "35mpc", 2, "3", 40, curso, null, null);
        djc.create(mpc);
        curso.addListaDisciplina(mpc);

        Disciplina bad = new Disciplina("Modelagemd e Banco de Dados", "35bad", 4, "3", 40, curso, null, null);
        djc.create(bad);
        curso.addListaDisciplina(bad);

        Disciplina pro = new Disciplina("Programação II", "35proII", 4, "3", 40, curso, null, null);
        djc.create(pro);
        curso.addListaDisciplina(pro);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gerar quarta fase.
     */
    public void gerarQuartaFase() {
        Disciplina prj = new Disciplina("Desenho e Projeto de Software", "45prj", 4, "4", 40, curso, null, null);
        djc.create(prj);
        curso.addListaDisciplina(prj);

        Disciplina emp = new Disciplina("Empreendedorismo", "45emp", 4, "4", 40, curso, null, null);
        djc.create(emp);
        curso.addListaDisciplina(emp);

        Disciplina est = new Disciplina("Algoritmos e Estrutura de Dados", "45est", 4, "4", 40, curso, null, null);
        djc.create(est);
        curso.addListaDisciplina(est);

        Disciplina log = new Disciplina("Lógica Matemática", "45log", 2, "4", 40, curso, null, null);
        djc.create(log);
        curso.addListaDisciplina(log);

        Disciplina pbd = new Disciplina("Persistência de Dados", "45pbd", 4, "4", 40, curso, null, null);
        djc.create(pbd);
        curso.addListaDisciplina(pbd);

        Disciplina pin = new Disciplina("Projeto Integrador I", "45pinI", 4, "4", 40, curso, null, null);
        djc.create(pin);
        curso.addListaDisciplina(pin);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gerar quinta fase.
     */
    public void gerarQuintaFase() {
        Disciplina dsw = new Disciplina("Desenvolvimento de Sistemas para Web", "55dsw", 6, "5", 40, curso, null, null);
        djc.create(dsw);
        curso.addListaDisciplina(dsw);

        Disciplina equ = new Disciplina("Engenharia da Qualidade", "55equ", 2, "5", 40, curso, null, null);
        djc.create(equ);
        curso.addListaDisciplina(equ);

        Disciplina ppr = new Disciplina("Padrões de Projeto", "55ppr", 4, "5", 40, curso, null, null);
        djc.create(ppr);
        curso.addListaDisciplina(ppr);

        Disciplina mqu = new Disciplina("Métodos Quantitativos", "55mqu", 4, "5", 40, curso, null, null);
        djc.create(mqu);
        curso.addListaDisciplina(mqu);

        Disciplina red = new Disciplina("Redes de Computares", "55red", 2, "5", 40, curso, null, null);
        djc.create(red);
        curso.addListaDisciplina(red);

        Disciplina pin2 = new Disciplina("Projeto Integrador II", "55pinII", 4, "5", 40, curso, null, null);
        djc.create(pin2);
        curso.addListaDisciplina(pin2);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Gerar sexta fase.
     */
    public void gerarSextaFase() {
        Disciplina dsd = new Disciplina("Desinvolvimento de Sistemas para Web", "65dsd", 6, "6", 40, curso, null, null);
        djc.create(dsd);
        curso.addListaDisciplina(dsd);

        Disciplina optI = new Disciplina("Disciplina Optativa I", "65optI", 4, "6", 40, curso, null, null);
        djc.create(optI);
        curso.addListaDisciplina(optI);

        Disciplina eeo = new Disciplina("Estrategias de Experimentação e Observação", "65eeo", 2, "6", 40, curso, null, null);
        djc.create(eeo);
        curso.addListaDisciplina(eeo);

        Disciplina grpI = new Disciplina("Gerenciamento de Projetos I", "65grpI", 2, "6", 40, curso, null, null);
        djc.create(grpI);
        curso.addListaDisciplina(grpI);

        Disciplina tes = new Disciplina("Testes de Software", "65tes", 4, "6", 40, curso, null, null);
        djc.create(tes);
        curso.addListaDisciplina(tes);

        Disciplina pin3 = new Disciplina("Projeto Integrador III", "65pinIII", 4, "6", 40, curso, null, null);
        djc.create(pin3);
        curso.addListaDisciplina(pin3);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Gerar sétima fase.
     */
    public void gerarSetimaFase() {
        Disciplina ars = new Disciplina("Arquitetura de Software", "75ars", 2, "7", 40, curso, null, null);
        djc.create(ars);
        curso.addListaDisciplina(ars);

        Disciplina optII = new Disciplina("Disciplina Opitativa II", "75optII", 4, "7", 40, curso, null, null);
        djc.create(optII);
        curso.addListaDisciplina(optII);

        Disciplina gcf = new Disciplina("Gerência de Configuração", "75gcf", 2, "7", 40, curso, null, null);
        djc.create(gcf);
        curso.addListaDisciplina(gcf);

        Disciplina grpII = new Disciplina("Gerencia de Projeto II", "75grpII", 4, "7", 40, curso, null, null);
        djc.create(grpII);
        curso.addListaDisciplina(grpII);

        Disciplina inc = new Disciplina("Inteligencia Computação", "75inc", 4, "7", 40, curso, null, null);
        djc.create(inc);
        curso.addListaDisciplina(inc);

        Disciplina qua = new Disciplina("Qualidade de Software", "75qua", 2, "7", 40, curso, null, null);
        djc.create(qua);
        curso.addListaDisciplina(qua);

        Disciplina tccI = new Disciplina("Orientação para Trabalho de Conclusão de Curso", "75tccI", 2, "7", 40, curso, null, null);
        djc.create(tccI);
        curso.addListaDisciplina(tccI);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Gerar oitava fase.
     */
    public void gerarOitavaFase() {
        Disciplina optIII = new Disciplina("Disciplina optativa III", "85optIII", 4, "8", 40, curso, null, null);
        djc.create(optIII);
        curso.addListaDisciplina(optIII);

        Disciplina eec = new Disciplina("Engenharia Economica", "85eec", 4, "8", 40, curso, null, null);
        djc.create(eec);
        curso.addListaDisciplina(eec);

        Disciplina ecs = new Disciplina("Etica Computador e Sociedade", "85ecs", 2, "8", 40, curso, null, null);
        djc.create(ecs);
        curso.addListaDisciplina(ecs);

        Disciplina man = new Disciplina("Manuntenção de Software", "85man", 2, "8", 40, curso, null, null);
        djc.create(man);
        curso.addListaDisciplina(man);

        Disciplina mps = new Disciplina("Melhoria e Processo de Software", "85mps", 2, "8", 40, curso, null, null);
        djc.create(mps);
        curso.addListaDisciplina(mps);

        Disciplina mef = new Disciplina("Métodos Formais", "85mef", 4, "8", 40, curso, null, null);
        djc.create(mef);
        curso.addListaDisciplina(mef);

        Disciplina mkt = new Disciplina("Marketing", "85mkt", 2, "8", 40, curso, null, null);
        djc.create(mkt);
        curso.addListaDisciplina(mkt);

        Disciplina tccII = new Disciplina("Trabalho de Conclusão de Curso", "85tccII", 5, "8", 40, curso, null, null);
        djc.create(tccII);
        curso.addListaDisciplina(tccII);

        try {
            cjc.edit(curso);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
