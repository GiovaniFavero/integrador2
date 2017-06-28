package br.udesc.controller;

import br.udesc.view.TelaGerarRelatorios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTelaGerarRelatorio {

    private TelaGerarRelatorios tgr;

    public ControladorTelaGerarRelatorio() {
        tgr = new TelaGerarRelatorios();
        iniciar();
    }

    public void iniciar() {
        tgr.btm01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        tgr.btm02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        tgr.btm03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        tgr.btm04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        tgr.btm05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        tgr.btm06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

    }

    public void executar() {
        tgr.setVisible(true);
    }
}
