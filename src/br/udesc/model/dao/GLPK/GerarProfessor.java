package br.udesc.model.dao.GLPK;

import br.udesc.model.dao.PessoaHorarioPreferenciaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;

public class GerarProfessor {

    private Professor professor = new Professor();
    private ProfessorJpaController pjc = new ProfessorJpaController();

    public void gerarProfessor() {

        professor.setNome("Adermar Perfoll Junior");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Célio Antônio Sardagna");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Carlos Fernando Cruz");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Rogério Bodemüller Junior");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Paulo Roberto Farah");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Paolo Moser");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Pablo Grahl dos Santos");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Marcelo de Souza");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Processo Seletivo I");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Sérgio Roberto Villareal");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Marino Luiz Eyekaufer");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Processo Seletivo II");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Márcio José Mantau");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Jaison Ademir Sevegnani");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Geraldo Menegazzo Varela");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Tiago Luiz Schmitz");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Giovani Festa Paludo");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Adilson Vahldick");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Processo Seletivo III");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Carlos Alberto Barth");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Gabriel Willemann");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Processo Seletivo IV");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Fernando Scheeffer");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Rubens Staloch");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Processo Seletivo V");
        professor.setCpf("cpf");
        pjc.create(professor);
    }

    public void gerarRestricaoProfessor() {
        PessoaHorarioPreferencia php = new PessoaHorarioPreferencia();
        PessoaHorarioPreferenciaJpaController phpjc = new PessoaHorarioPreferenciaJpaController();
        pjc.listarProfessor();
        Professor prof = new Professor();

        for (int k = 0; k < pjc.listarProfessor().size(); k++) {
            prof = pjc.listarProfessor().get(k);
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 2; j++) {
                    String a = i + "" + j;
                    php = new PessoaHorarioPreferencia();
                    php.setProfessor(prof);
                    php.setSequencia(Integer.parseInt(a));
                    php.setValor(10);
                    phpjc.create(php);
                    prof.addListHorario(php);

                    try {

                        pjc.edit(prof);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void gerarProfessorPrimeiraSegundaFase() {

        professor.setNome("Adermar Perfoll Junior");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Célio Antônio Sardagna");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Carlos Fernando Cruz");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Paulo Roberto Farah");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Paolo Moser");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Tiago Luiz Schmitz");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Marcelo de Souza");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Giovani Festa Paludo");
        professor.setCpf("cpf");
        pjc.create(professor);

        professor = new Professor();
        professor.setNome("Márcio José Mantau");
        professor.setCpf("cpf");
        pjc.create(professor);

        gerarRestricaoProfessor();
    }

}
