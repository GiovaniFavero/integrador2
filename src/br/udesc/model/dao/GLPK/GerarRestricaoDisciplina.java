/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.RestricaoDisciplinaJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.RestricaoDisciplina;
import java.util.List;

public class GerarRestricaoDisciplina {

    private RestricaoDisciplina rd = new RestricaoDisciplina();
    private RestricaoDisciplinaJpaController rdj = new RestricaoDisciplinaJpaController();
    private DisciplinaJpaController dj = new DisciplinaJpaController();

    public void criaRestricao() {
        List<Disciplina> dis = dj.listarDisciplinaPorFase("1");
        RestricaoDisciplina res = new RestricaoDisciplina();
        Disciplina d = new Disciplina();
        try {
            for (int i = 0; i < dis.size(); i++) {
                d = dis.get(i);
                for (int j = 1; j <= 2; j++) {
                    res = new RestricaoDisciplina();
                    res.setDisciplina(d);
                    res.setHorario(60 + j);
                    res.setCondicao(3);
                    rdj.create(res);
                    d.addListaRestricao(res);
                    dj.edit(d);
                }
            }

            dis = dj.listarDisciplinaPorFase("2");
            for (int i = 0; i < dis.size(); i++) {
                d = dis.get(i);
                for (int j = 1; j <= 2; j++) {
                    res = new RestricaoDisciplina();
                    res.setDisciplina(d);
                    res.setHorario(60 + j);
                    res.setCondicao(3);
                    rdj.create(res);
                    d.addListaRestricao(res);
                    dj.edit(d);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
