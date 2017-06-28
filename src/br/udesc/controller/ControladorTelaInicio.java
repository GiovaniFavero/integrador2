package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.GLPK.GerarGLPK;
import br.udesc.model.dao.GLPK.GerarSolucaoGLPK;
import br.udesc.model.dao.GLPK.PreencherTudo;
import br.udesc.view.TelaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorTelaInicio {

    private TelaInicio ti;

    public ControladorTelaInicio() {
        ti = new TelaInicio();
        iniciar();
    }

    public void iniciar() {

        //Para acessar a tela de cadastro de Curso
        new Thread(()
                -> ti.botaoCurso.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                        cttc.executar();
                    }
                })).start();

        //Para acessar a tela de cadastro de disciplina
        new Thread(()
                -> ti.botaoDisciplina.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CursoJpaController cjc = new CursoJpaController();
                        if (cjc.getCursoCount() != 0) {
                            ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                            cttd.executar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                })).start();

        //Para acessar a tela de cadastro de professores
        new Thread(()
                -> ti.botaoProfessor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                        cttp.executar();
                    }
                })).start();

        //Para acessar a tela de cadastro de Sala
        new Thread(()
                -> ti.botaoSala.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableSala cts = new ControladorTelaTableSala();
                        cts.executar();
                    }
                })).start();

        new Thread(()
                -> ti.botaoVincular.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                        ctv.executar();
                    }
                })).start();

        ti.botaoProblema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GerarGLPK glpk = new GerarGLPK();
                glpk.geraTudo();
                GerarSolucaoGLPK gsglpk = new GerarSolucaoGLPK();
                gsglpk.x();
            }
        });

        ti.botaoDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PreencherTudo pt = new PreencherTudo();
                pt.gerarTudo();
            }
        });

    }

    public void executar() {
        ti.setVisible(true);
    }

}
