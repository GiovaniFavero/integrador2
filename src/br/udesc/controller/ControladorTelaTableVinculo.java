/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.VinculoModel;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaTableVinculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 5105011523
 */
public class ControladorTelaTableVinculo {

    private TelaTableVinculo ttv;
    private Disciplina dis;
    private VinculoModel vm;
    private List<Disciplina> listaVinculo;
    private DisciplinaJpaController djc;

    public ControladorTelaTableVinculo() {
        ttv = new TelaTableVinculo();
        dis = new Disciplina();
        vm = new VinculoModel();
        djc = new DisciplinaJpaController();
        ttv.tabelaVinculacao.setModel(vm);
        iniciar();
        carregarVinculo();
    }

    public void pegarLinha(int linha) {
        dis = djc.findDisciplina((long) ttv.tabelaVinculacao.getValueAt(linha, 0));
    }

    public void carregarVinculo() {
        vm.limpar();
        listaVinculo = djc.listarDisciplina();
        for (Disciplina listaDisciplinas : listaVinculo) {
            System.out.println(listaDisciplinas.getCodigo());
            vm.anuncioAdd(listaDisciplinas);
        }
        ttv.tabelaVinculacao.getSelectionModel().addSelectionInterval(0, 0);
    }

    public void tirarVinculo() {
        pegarLinha(ttv.tabelaVinculacao.getSelectedRow());
        ProfessorJpaController pjc = new ProfessorJpaController();
        Professor p = new Professor();

        p = dis.getProfessor();
        if (dis.getProfessor() != null) {
            //---------------caso esse não funcione tente o comentado -------------
            p.getListaDisciplinaProfessor().remove(dis);
            dis.setProfessor(null);
            try {
                djc.edit(dis);
                pjc.edit(p);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Erro, Disciplina sem professor", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        carregarVinculo();
    }

    public void iniciar() {
        ttv.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttv.dispose();
            }
        });

        ttv.botaoEditar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                int linha = ttv.tabelaVinculacao.getSelectedRow();
                pegarLinha(linha);
                ctv.editar(dis);
                ttv.dispose();
                ctv.executar();
            }
        });

        ttv.boataoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tirarVinculo();
            }
        });
        ttv.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttv.dispose();
            }
        }
        );

        ttv.botaoProfessor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableProfessor ctp = new ControladorTelaTableProfessor();
                ctp.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoSala.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableSala ctts = new ControladorTelaTableSala();
                ctts.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                ttv.dispose();
            }
        });
    }

    public void executar() {
        ttv.setVisible(true);
    }

}
