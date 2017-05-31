package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.view.TelaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorTelaInicio {

    private TelaInicio ti;

    public ControladorTelaInicio() {
        ti = new TelaInicio();
        iniciar();
    }

    public void iniciar() {

        //Para acessar a tela de cadastro de Curso
        ti.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
            }
        });

        //Para acessar a tela de cadastro de disciplina
        ti.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                    ctcd.executar();
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        //Para acessar a tela de cadastro de professores
        ti.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
            }
        });

        //Para acessar a tela de cadastro de professores
        ti.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaEditar cte = new ControladorTelaEditar();
                cte.executar();
            }
        });

        //Para acessar a tela de cadastro de Sala
        ti.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
            }
        });
        
        ti.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
            }
        });
    }

    public void executar() {
        ti.setVisible(true);
    }

}
