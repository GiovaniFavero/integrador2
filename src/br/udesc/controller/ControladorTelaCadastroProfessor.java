package br.udesc.controller;

import br.udesc.view.TelaCadastroProfessor;

public class ControladorTelaCadastroProfessor {

    private TelaCadastroProfessor tcp;

    public ControladorTelaCadastroProfessor() {
        tcp = new TelaCadastroProfessor();
        iniciar();
    }
    
    public void iniciar(){
        
    }
    
    
    public void executar(){
        tcp.setVisible(true);
    }
    
    
}
