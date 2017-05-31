/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.CursoModel;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Curso;
import br.udesc.view.TelaTableCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        for (Curso listaProfessores : listaCurso) {
            cm.anuncioAdd(listaProfessores);
        }
    }
    
    public void pegarLinha(int linha) {
        cur.setId((long) ttc.tabelaCurso.getValueAt(linha, 0));
        cur.setNome((String) ttc.tabelaCurso.getValueAt(linha, 1));
        cur.setDuracao((int) ttc.tabelaCurso.getValueAt(linha, 2));
    }
    
    public void iniciar(){
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
            }
        });
    }
    public void executar() {
        ttc.setVisible(true);
    }
    

}
