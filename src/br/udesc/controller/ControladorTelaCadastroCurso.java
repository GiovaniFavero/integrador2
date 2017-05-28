package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.view.TelaCadastroCurso;
import br.udesc.view.TelaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorTelaCadastroCurso {

    private TelaCadastroCurso tcc;

    public ControladorTelaCadastroCurso() {
        tcc = new TelaCadastroCurso();
        iniciar();
    }

    public boolean validarCampos() {
        if (tcc.fieldNome.getText().isEmpty()) {
            tcc.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor preencher o Nome do curso", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (tcc.fieldDuracao.getText().isEmpty()) {
            tcc.fieldDuracao.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor preencher a duração do curso", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public void iniciar() {

        tcc.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcc.setVisible(false);
            }
        });

        tcc.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroProfessor ctcp = new ControladorTelaCadastroProfessor();
                tcc.setVisible(false);
                ctcp.executar();
            }
        });

        tcc.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala ctcs = new ControladorTelaCadastroSala();
                tcc.setVisible(false);
                ctcs.executar();
            }
        });

        tcc.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                    tcc.setVisible(false);
                    ctcd.executar();
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        tcc.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcc.fieldNome.setText("");
                tcc.fieldDuracao.setText("");
            }
        });

        tcc.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();

                if (validarCampos() == true) {
                    if (cjc.validaCurso(tcc.fieldNome.getText()) == null) {

                        int a = Integer.parseInt(tcc.fieldDuracao.getText());
                        Curso curso = new Curso(tcc.fieldNome.getText(), a);
                        cjc.create(curso);
                        JOptionPane.showMessageDialog(null, "Curso criado com sucesso");
                        tcc.fieldNome.setText("");
                        tcc.fieldDuracao.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Esse curso já está cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }

    public void executar() {
        tcc.setVisible(true);
    }

}
