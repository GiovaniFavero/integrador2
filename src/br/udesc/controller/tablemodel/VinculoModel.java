/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Disciplina;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 5105011523
 */
public class VinculoModel extends AbstractTableModel{

    private ArrayList<Disciplina> linhas = null;
    private String[] colunas = new String[]{"ID Discipliha","Nome Disciplina", "Nome Professor"};

    public VinculoModel() {
        linhas = new ArrayList<Disciplina>();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Disciplina getLinha(int x) {
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
        Disciplina linha = linhas.get(numLin);
        switch (numCol) {
            case 0:
                return linha.getId();
            case 1:
                return linha.getNome();
            case 2:
                if(linha.getProfessor() != null){
                return linha.getProfessor().getNome();
                }else{
                    return "";
                }
        }
        return null;
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    public void anuncioAdd(Disciplina a) {
        linhas.add(a);
        fireTableDataChanged();
    }

    public ArrayList<Disciplina> getLinhas() {
        return linhas;
    }
    
}