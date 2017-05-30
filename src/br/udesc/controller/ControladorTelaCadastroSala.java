package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaCadastroSala;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorTelaCadastroSala {

    private TelaCadastroSala tcs;

    public ControladorTelaCadastroSala() {
        tcs = new TelaCadastroSala();
        iniciar();
    }

    public boolean validarCampos() {

        if (tcs.fieldNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o numero da sala", "Erro", JOptionPane.WARNING_MESSAGE);
            tcs.fieldNumero.requestFocus();
            return false;
        }
        if (tcs.fieldLimite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o limite de vagas na sala", "Erro", JOptionPane.WARNING_MESSAGE);
            tcs.fieldLimite.requestFocus();
            return false;
        }

        if ((!(tcs.radioLaboratorio.isSelected())) && (!(tcs.radioSala.isSelected()))) {
            JOptionPane.showMessageDialog(null, "Favor escolha entre Lab ou Sala", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public void iniciar() {

        tcs.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcs.setVisible(false);
            }
        });

        tcs.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                    ctcd.executar();
                    tcs.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tcs.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroProfessor ctcp = new ControladorTelaCadastroProfessor();
                ctcp.executar();
                tcs.setVisible(false);
            }
        });

        tcs.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcs.fieldLimite.setText("");

            }
        });

        tcs.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (validarCampos() == true) {
                    SalaJpaController sjc = new SalaJpaController();
                    if (sjc.validaSala(tcs.fieldNumero.getText()) == null) {
                        boolean verdade = true;
                        if (tcs.radioSala.isSelected()) {
                            verdade = false;
                        }

                        int a = Integer.parseInt(tcs.fieldLimite.getText());
                        Sala sala = new Sala(tcs.fieldNumero.getText(), a, verdade);

                        List<Sala> listaSala = sjc.listarSala();
                        
                        
                        sjc.create(sala);

                        JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        tcs.fieldLimite.setText("");
                        tcs.fieldNumero.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "Sala já cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

    }

    public void editar(Sala s) {
        tcs.fieldNumero.setText(s.getNumero());
        tcs.fieldLimite.setText(String.valueOf(s.getLimite()));
    }

    public void executar() {
        tcs.setVisible(true);
    }

}
