/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.CursoModel;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.view.TelaTableCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControladorTelaTableCurso {

    private TelaTableCurso ttc;
    private Curso cur;
    private CursoModel cm;
    private List<Curso> listaCurso;
    private CursoJpaController cjc;

    public ControladorTelaTableCurso() {
        ttc = new TelaTableCurso();
        cur = new Curso();
        cm = new CursoModel();
        cjc = new CursoJpaController();
        ttc.tabelaCurso.setModel(cm);

        carregarCurso();
        iniciar();
    }

    public void carregarCurso() {
        cm.limpar();
        listaCurso = cjc.listarCurso();
        for (Curso listaCursos : listaCurso) {
            cm.anuncioAdd(listaCursos);
        }
        ttc.tabelaCurso.getSelectionModel().addSelectionInterval(0, 0);
    }

    public void destruirDisciplinasSemCurso() {
        List<Disciplina> d = new ArrayList<>();
        DisciplinaJpaController djc = new DisciplinaJpaController();
        d = djc.listarDisciplinaSemCurso();
        for (int i = 0; i < d.size(); i++) {
            try {
                djc.destroy(d.get(i).getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladorTelaTableCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pegarLinha(int linha) {
        cur.setId((long) ttc.tabelaCurso.getValueAt(linha, 0));
        cur.setNome((String) ttc.tabelaCurso.getValueAt(linha, 1));
        cur.setDuracao((int) ttc.tabelaCurso.getValueAt(linha, 2));
    }

    public void iniciar() {
        ttc.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroCurso ctc = new ControladorTelaCadastroCurso();
                ctc.executar();
                ttc.dispose();
            }
        });

        ttc.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroCurso ctc = new ControladorTelaCadastroCurso();
                int linha = ttc.tabelaCurso.getSelectedRow();
                pegarLinha(linha);
                ctc.executar();
                ctc.editar(cur);
                ttc.dispose();
            }
        });

        ttc.botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttc.tabelaCurso.getSelectedRow();
                pegarLinha(linha);

                try {
                    cjc.destroy(cur.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarCurso();
                destruirDisciplinasSemCurso();
            }
        });
        
        ttc.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttc.dispose();
            }
        });

        ttc.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                ttc.setVisible(false);
            }
        });

        ttc.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                ttc.setVisible(false);
            }
        });

        ttc.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    ttc.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
         ttc.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttc.setVisible(false);
            }
        }
        );
    }

    public void executar() {
        ttc.setVisible(true);
    }

}
