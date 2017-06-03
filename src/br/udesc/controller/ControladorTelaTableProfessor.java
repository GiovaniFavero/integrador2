/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.ProfessorModel;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroProfessor;
import br.udesc.view.TelaTabelaProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Usuario
 */
public class ControladorTelaTableProfessor {

    private TelaTabelaProfessor ttp;
    private Professor pro;
    private ProfessorModel pm;
    private List<Professor> listaProfessor;
    private ProfessorJpaController psc;

    public ControladorTelaTableProfessor() {
        ttp = new TelaTabelaProfessor();
        pro = new Professor();
        pm = new ProfessorModel();
        psc = new ProfessorJpaController();
        ttp.tabelaProfessores.setModel(pm);

        carregarProfessor();
        iniciar();
    }

    public void carregarProfessor() {
        pm.limpar();
        listaProfessor = psc.listarProfessor();
        for (Professor listaProfessores : listaProfessor) {
            pm.anuncioAdd(listaProfessores);
        }
    }

    public void pegarLinha(int linha) {
        pro.setId((long) ttp.tabelaProfessores.getValueAt(linha, 0));
        pro.setNome((String) ttp.tabelaProfessores.getValueAt(linha, 1));
        pro.setCpf((String) ttp.tabelaProfessores.getValueAt(linha, 2));
    }

    public void iniciar() {
        ttp.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroProfessor ctp = new ControladorTelaCadastroProfessor();
                ctp.executar();
                ttp.dispose();
            }
        });

        ttp.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroProfessor ctp = new ControladorTelaCadastroProfessor();
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);
                ctp.executar();
                ctp.editar(pro);
                ttp.dispose();
            }
        });

        ttp.botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);

                try {
                    psc.destroy(pro.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarProfessor();
            }
        });
        
        ttp.botaoRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);
                ControladorTelaRestricoesProfessor ctr = new ControladorTelaRestricoesProfessor(pro.getId());
                if(ctr.validarQtdRestricoes(1)){
                    ttp.dispose();
                    ctr.executar();
                }else{
                    JOptionPane.showMessageDialog(null, "Não existem créditos suficientes para este professor", "Erro", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });
    }

    public void executar() {
        ttp.setVisible(true);
    }

}
