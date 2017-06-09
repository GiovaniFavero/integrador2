/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Sala;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 5105011523
 */
public class SalaModel extends AbstractTableModel {

    private ArrayList<Sala> linhas = null;
    private String[] colunas = new String[]{"ID","Número Sala", "Limite", "Tipo"};

    public SalaModel() {
        linhas = new ArrayList<Sala>();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Sala getLinha(int x) {
        return linhas.get(x);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int numLin, int numCol) {
        Sala linha = linhas.get(numLin);
        switch (numCol) {
            case 0:
                return linha.getId();
            case 1:
                return linha.getNumero();
            case 2:
                return linha.getLimite();
            case 3:
                if (linha.getTipo()) {
                    return "Laboratorio";
                } else {
                    return "Sala";
                }

        }
        return null;
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public void anuncioAdd(Sala a) {
        linhas.add(a);
        fireTableDataChanged();
    }

    public ArrayList<Sala> getLinhas() {
        return linhas;
    }

}
