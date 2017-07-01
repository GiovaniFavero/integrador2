/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.principal;

import br.udesc.controller.ControladorTelaInicio;

/**
 * Classe responsável por iniciar o programa.
 * @author PIN2
 */
public class Principal {

    public static void main(String[] args) {
        ControladorTelaInicio cti = new ControladorTelaInicio();
        cti.executar();
    }

}
