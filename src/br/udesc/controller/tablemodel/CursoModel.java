/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Curso;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class CursoModel extends AbstractTableModel{
    private ArrayList<Curso> linhas = null;
    private String[] colunas = new String[]{"Id","Nome", "Duração"};

    public CursoModel() {
        linhas = new ArrayList<Curso>();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Curso getLinha(int x) {
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
        Curso linha = linhas.get(numLin);
        switch (numCol) {
            case 0:
                return linha.getId();
            case 1:
                return linha.getNome();
            case 2:
                return linha.getDuracao();
        }
        return null;
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public void anuncioAdd(Curso a) {
        linhas.add(a);
        fireTableDataChanged();
    }

    public ArrayList<Curso> getLinhas() {
        return linhas;
    }
    
}
