package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.CursoJpaController;
import javax.swing.JOptionPane;

public class PreencherTudo {

    private GerarLaboratorios gl = new GerarLaboratorios();
  
    private GerarMaterias gm = new GerarMaterias();
    private GerarProfessor gp = new GerarProfessor();
    private GerarRestricaoDisciplina gd = new GerarRestricaoDisciplina();
    private CursoJpaController cjc = new CursoJpaController();

    public void gerarTudo() {
        if (cjc.getCursoCount() == 0) {
            gm.gerarCurso();
            gm.gerarPrimeiraFase();
            gm.gerarSegundaFase();
            gp.gerarProfessorPrimeiraSegundaFase();
            gd.criaRestricao();
            JOptionPane.showMessageDialog(null, "Banco Gerado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Banco Já Criado Previamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
