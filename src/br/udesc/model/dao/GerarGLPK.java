package br.udesc.model.dao;

import br.udesc.model.entidade.Disciplina;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GerarGLPK {

    private File arquivo = new File("teste.mod");
    private CursoJpaController cjc = new CursoJpaController();
    private DisciplinaJpaController djc = new DisciplinaJpaController();
    private FileWriter fw;
    private BufferedWriter bw;

    public void geraTudo() {
        try {
            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            salvar();
            salvarComLab();
            funcaoMax();
            funcaoMaxSala();
            gerarVariaveisPorDisciplina();

            bw.close();
            fw.close();
        } catch (Exception e) {

        }

    }

    public void salvar() {
        try {

            bw.write("# Variáveis");
            bw.newLine();

            djc.listarDisciplina();

            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + ", binary;");
                        bw.newLine();

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salvarComLab() {
        try {
            djc.listarDisciplina();

            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        if (djc.listarDisciplina().get(i).getSala() != null) {
                            bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + "_" + djc.listarDisciplina().get(i).getSala().getNumero() + ", binary;");
                            bw.newLine();
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void funcaoMax() {
        try {

            bw.newLine();
            bw.write("maximize z: ");
            ProfessorJpaController pjc = new ProfessorJpaController();

            if (pjc.getProfessorCount() != 0) {
                for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                    for (int j = 1; j <= 6; j++) {
                        for (int k = 1; k <= 2; k++) {
                            if (djc.listarDisciplina().get(i).getProfessor() != null) {
                                for (int l = 0; l < djc.listarDisciplina().get(i).getProfessor().getListaHorario().size(); l++) {
                                    String diaSemana = j + "" + k;
                                    int aux = Integer.parseInt(diaSemana);
                                    if (djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getSequencia() == aux) {
                                        bw.write(djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + djc.listarDisciplina().get(i).getCodigo() + "_" + diaSemana + "+");
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void funcaoMaxSala() {
        try {

            List<Disciplina> listaDisciplinas = new ArrayList<>();
            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                if (djc.listarDisciplina().get(i).getProfessor() != null) {
                    if (djc.listarDisciplina().get(i).getSala() != null) {
                        listaDisciplinas.add(djc.listarDisciplina().get(i));
                    }
                }
            }
            for (int i = 0; i < listaDisciplinas.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        for (int l = 0; l < listaDisciplinas.get(i).getProfessor().getListaHorario().size(); l++) {
                            String diaSemana = j + "" + k;
                            int aux = Integer.parseInt(diaSemana);
                            if (listaDisciplinas.get(i).getProfessor().getListaHorario().get(l).getSequencia() == aux) {
                                if (i == listaDisciplinas.size() - 1 && aux == 62) {
                                    bw.write(listaDisciplinas.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + listaDisciplinas.get(i).getCodigo() + "_" + diaSemana + "_" + listaDisciplinas.get(i).getSala().getNumero());
                                } else {
                                    bw.write(listaDisciplinas.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + listaDisciplinas.get(i).getCodigo() + "_" + diaSemana + "_" + listaDisciplinas.get(i).getSala().getNumero() + "+");
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gerarVariaveisPorDisciplina() {
        try {

            bw.newLine();
            bw.write("# somatorio de todas as variaveis da disciplina = carga horaria");
            bw.newLine();
            bw.write("s.t. carga_horaria: ");

            djc.listarDisciplina();
            Disciplina disc = new Disciplina();
            List<Disciplina> listaDisciplina = new ArrayList<>();

            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                if (djc.listarDisciplina().get(i).getSala() != null) {
                    listaDisciplina.add(djc.listarDisciplina().get(i));
                }
            }

            for (int x = 0; x < djc.listarDisciplina().size(); x++) {
                disc = djc.listarDisciplina().get(x);

                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        if (j == 6 && k == 2) {

                            if (listaDisciplina.size() != 0) {
                                System.out.println(listaDisciplina.size() + " size");
                                System.out.println("ENTREI");
//                                gerarVariaveisPorDisciplinaComSala();
                            } else {
                                int a = (disc.getCreditos() / 2);
                                String aux = String.valueOf(a);
                                bw.write("_" + disc.getCodigo() + "_" + j + k + " = " + aux);
                                bw.newLine();
                            }
                        } else {
                            bw.write("_" + disc.getCodigo() + "_" + j + k + "+");
                        }
                    }
                }

                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gerarVariaveisPorDisciplinaComSala() {
        djc.listarDisciplina();
        Disciplina disc = new Disciplina();
        List<Disciplina> listaDisciplina = new ArrayList<>();

        try {
            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                if (djc.listarDisciplina().get(i).getSala() != null) {
                    listaDisciplina.add(djc.listarDisciplina().get(i));
                }
            }
            for (int i = 0; i < listaDisciplina.size(); i++) {
                disc = listaDisciplina.get(i);

                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k < 2; k++) {
                        if (j == 6 && k == 2) {
                            int a = (disc.getCreditos() / 2);
                            String aux = String.valueOf(a);
                            bw.write("_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + " = " + aux);
                            bw.newLine();
                        } else {
                            bw.write("_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + "+");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
