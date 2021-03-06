package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Sala;

/**
 * Classe responsável por gerar Laboratórios.
 * @author PIN2
 */
public class GerarLaboratorios {

    private Sala sala = new Sala();
    private SalaJpaController sjc = new SalaJpaController();
    private DisciplinaJpaController djc = new DisciplinaJpaController();

    /**
     * Gerar labs.
     */
    public void gerarLabs() {
        SalaJpaController sjc = new SalaJpaController();

        for (int i = 0; i < 5; i++) {
            sala.setNumero("Lab_" + (i + 1));
            sala.setTipo(true);
            sala.setLimite(50);
            sjc.create(sala);
            sala = new Sala();
        }
    }

    /**
     * Vincular Labs.
     */
    public void vincularLabs() {
        Disciplina d = djc.listarDisciplina().get(0);
        Sala s = sjc.listarSala().get(0);

        d.setSala(s);
        s.addDisciplina(d);

        try {
            djc.edit(d);
            sjc.edit(s);

            System.out.println(d.getCodigo() + "A");
            System.out.println(d.getSala() + "B");

            System.out.println(s.getListaDisciplina().size() + "C");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
