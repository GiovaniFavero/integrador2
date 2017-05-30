/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.controller.tablemodel.SalaModel;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaCadastroSala;
import br.udesc.view.TelaTableSala;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author 5105011523
 */
public class ControladorTelaTableSala {

    private TelaTableSala tts;
    private Sala sa;
    private SalaModel sm;
    private TelaCadastroSala tcs;
    private List<Sala> listaSala;
    private SalaJpaController slc;

    public ControladorTelaTableSala() {
        tts = new TelaTableSala();
        sa = new Sala();
        sm = new SalaModel();
        tcs = new TelaCadastroSala();
        slc = new SalaJpaController();
        tts.tabelaSalas.setModel(sm);

        carregarSala();
        iniciar();
    }

    public void carregarSala() {
        sm.limpar();
        listaSala = slc.listarSala();
        for (Sala listaSalas : listaSala) {
            sm.anuncioAdd(listaSalas);
        }
    }

    public void iniciar() {
        tts.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala cts = new ControladorTelaCadastroSala();
                cts.executar();
                tts.dispose();
            }
        });

        tts.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala cts = new ControladorTelaCadastroSala();
                sa = sm.getLinha(tts.tabelaSalas.getSelectedRow());
                
                cts.executar();
                cts.editar(sa);
                tts.dispose();
            }
        });
    }

    public void executar() {
        tts.setVisible(true);
    }

}
