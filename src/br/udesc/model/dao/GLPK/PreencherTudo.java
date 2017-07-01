package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.CursoJpaController;
import javax.swing.JOptionPane;

/**
 * Classe reponsável pelo preenchimento.
 * @author PIN2
 */
public class PreencherTudo {

    private GerarLaboratorios gl = new GerarLaboratorios();

    private GerarMaterias gm = new GerarMaterias();
    private GerarProfessor gp = new GerarProfessor();
    private GerarRestricaoDisciplina gd = new GerarRestricaoDisciplina();
    private CursoJpaController cjc = new CursoJpaController();

    /**
     * Classe gerarTudo.
     */
    public void gerarTudo() {
        if (cjc.getCursoCount() == 0) {
            gm.gerarCurso();
            gm.gerarPrimeiraFase();
            gm.gerarSegundaFase();
            gm.gerarTerceiraFase();
            gm.gerarQuartaFase();
            gm.gerarQuintaFase();
            gm.gerarSextaFase();
            gm.gerarSetimaFase();
            gm.gerarOitavaFase();
            gp.gerarProfessor();
            gd.criarRestricaoGeral();
            JOptionPane.showMessageDialog(null, "Banco Gerado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Banco Já Criado Previamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void gerarTeste() {
        if (cjc.getCursoCount() == 0) {
            gm.gerarCurso();
            gm.gerarPrimeiraFase();
            gm.gerarSegundaFase();
            gp.gerarProfessorPrimeiraSegundaFase();
            JOptionPane.showMessageDialog(null, "Banco Gerado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Banco Já Criado Previamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
