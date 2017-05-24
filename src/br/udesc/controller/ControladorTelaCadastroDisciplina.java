package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroDisciplina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorTelaCadastroDisciplina {

    private TelaCadastroDisciplina tcd;

    public ControladorTelaCadastroDisciplina() {
        tcd = new TelaCadastroDisciplina();
        iniciar();
    }

    public boolean validarCampos() {
        CursoJpaController cjc = new CursoJpaController();
        int a = cjc.getCursoCount();

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Favor cadastrar um curso", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        if (tcd.fieldNome.getText().isEmpty()) {
            tcd.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor preencher o nome da disciplina", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tcd.fieldFase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher a fase da disciplina", "Erro", JOptionPane.ERROR_MESSAGE);
            tcd.fieldFase.requestFocus();
            return false;
        }
        if (tcd.fieldCreditos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher os créditos da dsiciplina", "Erro", JOptionPane.ERROR_MESSAGE);
            tcd.fieldCreditos.requestFocus();
            return false;
        }
        if (tcd.fieldTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher o tipo da disciplina", "Erro", JOptionPane.ERROR_MESSAGE);
            tcd.fieldTipo.requestFocus();
            return false;
        }
        if (tcd.fieldQuantidadeAlunos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher a quantidade de alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            tcd.fieldQuantidadeAlunos.requestFocus();
            return false;
        }

        return true;
    }

    public void carregarCursos() {
        CursoJpaController cjc = new CursoJpaController();
        tcd.comboBoxCurso.removeAllItems();
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso : listaCurso) {
            tcd.comboBoxCurso.addItem(curso.getNome());
        }

    }

    public void carregarProfessores() {
        ProfessorJpaController pjc = new ProfessorJpaController();
        tcd.comboBoxProfessor.removeAllItems();
        List<Professor> listaProfessor = pjc.listarProfessor();
        for (Professor professor : listaProfessor) {
            tcd.comboBoxCurso.addItem(professor.getNome());
        }

    }

    public void iniciar() {
        carregarCursos();
        carregarProfessores();

        tcd.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DisciplinaJpaController djc = new DisciplinaJpaController();
           
                if (validarCampos() == true) {
                    if(djc.validaDisciplina(tcd.fieldNome.getText()) == null){
                        System.out.println("olá");
                    } else{
                        JOptionPane.showMessageDialog(null, "Disciplina já cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

    }

    public void executar() {
        tcd.setVisible(true);
    }

}
