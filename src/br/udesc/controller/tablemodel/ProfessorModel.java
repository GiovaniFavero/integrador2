/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Professor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ProfessorModel extends AbstractTableModel{
    private ArrayList<Professor> linhas = null;
    private String[] colunas = new String[]{"Id","Nome", "Cpf"};

    public ProfessorModel() {
        linhas = new ArrayList<Professor>();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Professor getLinha(int x) {
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
        Professor linha = linhas.get(numLin);
        switch (numCol) {
            case 0:
                return linha.getId();
            case 1:
                return linha.getNome();
            case 2:
                return linha.getCpf();
        }
        return null;
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public void anuncioAdd(Professor a) {
        linhas.add(a);
        fireTableDataChanged();
    }

    public ArrayList<Professor> getLinhas() {
        return linhas;
    }
    
}
