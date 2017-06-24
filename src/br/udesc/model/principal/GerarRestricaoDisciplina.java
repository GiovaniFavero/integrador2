/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.principal;

import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.RestricaoDisciplinaJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.RestricaoDisciplina;
import java.util.List;

/**
 * @author luisr
 */
public class GerarRestricaoDisciplina {

    private RestricaoDisciplina rd = new RestricaoDisciplina();
    private RestricaoDisciplinaJpaController rdj = new RestricaoDisciplinaJpaController();
    private DisciplinaJpaController dj = new DisciplinaJpaController();

    public  void criaRestricao() {
        List<Disciplina> dis = dj.listarDisciplinaComSala();
        RestricaoDisciplina res = null;
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 3; j++) {
                for (int k = 1; k < 7; k++) {
                    res = new RestricaoDisciplina(dis.get(i), Integer.parseInt(k + "" + j), 12);
                    rdj.create(res);
                }
            }
        }
    }
}