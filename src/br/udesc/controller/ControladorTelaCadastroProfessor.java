package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorTelaCadastroProfessor {

    private TelaCadastroProfessor tcp;

    public ControladorTelaCadastroProfessor() {
        tcp = new TelaCadastroProfessor();
        iniciar();
    }

    public boolean validarCampos() {
        if (tcp.fieldNome.getText().isEmpty()) {
            tcp.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor informar o nome do professor", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (tcp.fieldCpf.getText().isEmpty()) {
            tcp.fieldCpf.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor informar o cpf do professor", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public void iniciar() {

        //Botões salvar e limpar
        tcp.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcp.fieldNome.setText("");
                tcp.fieldCpf.setText("");
            }
        });

        tcp.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (validarCampos() == true) {
                    ProfessorJpaController pjc = new ProfessorJpaController();
                    if (pjc.validaProfessor(tcp.fieldNome.getText()) == null) {
                        Professor professor = new Professor(tcp.fieldNome.getText(), tcp.fieldCpf.getText());
                        pjc.create(professor);
                        tcp.fieldNome.setText("");
                        tcp.fieldCpf.setText("");
                        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Professor já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });

        tcp.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                    ctcd.executar();
                    tcp.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tcp.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcp.setVisible(false);
            }
        });

        tcp.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala ctcs = new ControladorTelaCadastroSala();
                ctcs.executar();
                tcp.setVisible(false);
            }
        });
        
        tcp.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tcp.setVisible(false);
            }
        });

    }

    public void executar() {
        tcp.setVisible(true);
    }

}
