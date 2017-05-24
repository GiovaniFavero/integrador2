/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.principal;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.entidade.Curso;
import java.util.List;

/**
 *
 * @author 5105011505
 */
public class CriarCurso {
    

    
    private CriarCurso() {
    }
    
    public static CriarCurso getInstance() {
          CursoJpaController cjc = new CursoJpaController();
          List<Curso> listaCurso = cjc.listarCurso();
          if(listaCurso.size() == 0){
              System.out.println("olá");
              Curso eso = new Curso("Engenharia de Software", 4);
              cjc.create(eso);
          }
          return null;
    }
    
    private static class CriarCursoHolder {

        private static final CriarCurso INSTANCE = new CriarCurso();
    }
}
