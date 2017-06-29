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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class GerarRestricaoDisciplina {

    private RestricaoDisciplina rd = new RestricaoDisciplina();
    private RestricaoDisciplinaJpaController rdj = new RestricaoDisciplinaJpaController();
    private DisciplinaJpaController dj = new DisciplinaJpaController();

    public void criaRestricaoAteSegundaFase() {
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

    public void criarRestricaoGeral() {
        RestricaoDisciplina res = new RestricaoDisciplina();
        Disciplina d = new Disciplina();
        List<Disciplina> dis;
        for (int i = 1; i <= 8; i++) {
            dis = dj.listarDisciplinaPorFase(String.valueOf(i));
            for (int j = 0; j < dis.size(); j++) {
                d = dis.get(j);
                if (!d.getCodigo().contains("pin")) {
                    for (int k = 1; k <= 2; k++) {
                        res = new RestricaoDisciplina();
                        res.setDisciplina(d);
                        res.setHorario(60 + k);
                        res.setCondicao(3);
                        rdj.create(res);
                        d.addListaRestricao(res);
                        try {
                            dj.edit(d);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
