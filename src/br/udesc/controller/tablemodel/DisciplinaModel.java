package br.udesc.controller.tablemodel;

import br.udesc.model.entidade.Disciplina;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Classe resposável modelar a table de Disciplina.
 * Implementando todos os métodos da Interface nativa AbstractTableModel.
 * @author PIN2
 */
public class DisciplinaModel extends AbstractTableModel{
    private ArrayList<Disciplina> linhas = null;
    private String[] colunas = new String[]{"ID","Nome", "Codigo", "Créditos", "Fase"};

    public DisciplinaModel() {
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
                return linha.getCodigo();
            case 3:
                return linha.getCreditos();
            case 4:
                return linha.getFase();
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
