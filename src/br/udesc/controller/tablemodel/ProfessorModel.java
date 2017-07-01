package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Professor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Classe resposável modelar a table de Professor.
 * Implementando todos os métodos da Interface nativa AbstractTableModel.
 * @author PIN2
 */
public class ProfessorModel extends AbstractTableModel{
    private ArrayList<Professor> linhas = null;
    private String[] colunas = new String[]{"ID","Nome", "CPF"};

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
