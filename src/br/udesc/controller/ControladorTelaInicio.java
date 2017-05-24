package br.udesc.controller;

import br.udesc.view.TelaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTelaInicio {

    private TelaInicio ti;

    public ControladorTelaInicio() {
        ti = new TelaInicio();
        iniciar();
    }

    public void iniciar() {

        //Para acessar a tela de cadastro de disciplina
        ti.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                ctcd.executar();
            }
        });

        //Para acessar a tela de cadastro de professores
        ti.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroProfessor ctcp = new ControladorTelaCadastroProfessor();
                ctcp.executar();
            }
        });

        //Para acessar a tela de cadastro de Sala
        ti.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala ctcs = new ControladorTelaCadastroSala();
                ctcs.executar();
            }
        });

        //Para acessar a tela de cadastro de Sala
        ti.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               ControladorTelaCadastroCurso ctcc = new ControladorTelaCadastroCurso();
               ctcc.executar();
            }
        });

    }

    public void executar() {
        ti.setVisible(true);
    }

}
