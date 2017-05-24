package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.view.TelaCadastroDisciplina;
import java.util.List;

public class ControladorTelaCadastroDisciplina {

    private TelaCadastroDisciplina tcd;

    public ControladorTelaCadastroDisciplina() {
        tcd = new TelaCadastroDisciplina();
        iniciar();
    }
    
    public void carregarCursos(){
        CursoJpaController cjc = new CursoJpaController();
        tcd.comboBoxCurso.removeAllItems();
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso: listaCurso) {
            tcd.comboBoxCurso.addItem(curso.getNome());
        }
        
    }
    
    
    public void iniciar(){
        carregarCursos();
        
    }
    
    public void executar(){
        tcd.setVisible(true);
    }
    
    
    
    
}
