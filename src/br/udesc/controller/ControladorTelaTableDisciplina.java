/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.DisciplinaModel;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Disciplina;
import br.udesc.view.TelaTableDisciplina;
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
public class ControladorTelaTableDisciplina {
    private TelaTableDisciplina ttd;
    private Disciplina dis;
    private DisciplinaModel dm;
    private List<Disciplina> listaDisciplina;
    private DisciplinaJpaController djc;

    public ControladorTelaTableDisciplina() {
    ttd = new TelaTableDisciplina();
    dis = new Disciplina();
    dm = new DisciplinaModel();
    djc = new DisciplinaJpaController();
    ttd.tabelaDisciplina.setModel(dm);
    
    carregarDisciplina();
    Iniciar();
    }
    
    public void pegarLinha(int linha) {
        dis = djc.findDisciplina((long) ttd.tabelaDisciplina.getValueAt(linha, 0));
//        dis.setId((long) ttd.tabelaDisciplina.getValueAt(linha, 0));
//        dis.setNome((String) ttd.tabelaDisciplina.getValueAt(linha, 1));
//        dis.setCodigo((String) ttd.tabelaDisciplina.getValueAt(linha, 2));
//        dis.setCreditos((int) ttd.tabelaDisciplina.getValueAt(linha, 3));
//        dis.setFase((String) ttd.tabelaDisciplina.getValueAt(linha, 4));
        
    }
    
    public void carregarDisciplina(){
        dm.limpar();
        listaDisciplina = djc.listarDisciplina();
        for (Disciplina listaDisciplinas : listaDisciplina) {
            System.out.println(listaDisciplinas.getCodigo());
            dm.anuncioAdd(listaDisciplinas);
        }
        ttd.tabelaDisciplina.getSelectionModel().addSelectionInterval(0, 0);
    }
    
    public void Iniciar(){
        ttd.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                ctcd.executar();
                ttd.dispose();
            }
        });
        
        ttd.botaoEditar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);
                ctcd.editar(dis);
                ttd.dispose();
                ctcd.executar();
            }
        });
        
        ttd.boataoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);

                try {
                    djc.destroy(dis.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarDisciplina();
            }
        });
        
        ttd.botaoRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);
                ControladorTelaRestricoesDisciplina ctr = new ControladorTelaRestricoesDisciplina(dis.getId());
                ttd.dispose();
                ctr.executar();
            }
        });
    }
    
    public void executar(){
        ttd.setVisible(true);
    }

    
}
