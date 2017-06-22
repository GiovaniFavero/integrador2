package br.udesc.model.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GerarGLPK {

    private File arquivo;
    private CursoJpaController cjc = new CursoJpaController();
    private DisciplinaJpaController djc = new DisciplinaJpaController();

    private String funcao = "";

    public void salvar() {
        try {
            arquivo = new File("teste.mod");

            FileWriter fw = new FileWriter(arquivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("# Variáveis");
            bw.newLine();

            int diaSemana = 1;
            int horario = 1;

            djc.listarDisciplina();

            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + ", binary;");
                        bw.newLine();

                    }
                }
            }

            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salvarComLab() {
        try {
            arquivo = new File("teste.mod");

            FileWriter fw = new FileWriter(arquivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

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

            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void funcaoMax() {
        try {
            String a = "";
            arquivo = new File("teste.mod");
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("maximize z: ");

            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
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
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void funcaoMaxSala() {
        try {
            String a = "";
            arquivo = new File("teste.mod");
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < djc.listarDisciplina().size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        for (int l = 0; l < djc.listarDisciplina().get(i).getProfessor().getListaHorario().size(); l++) {
                            String diaSemana = j + "" + k;
                            int aux = Integer.parseInt(diaSemana);
                            if (djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getSequencia() == aux) {
                                System.out.println("VALOR DE I " + i + "\nVALOR DO ARRAY" + djc.listarDisciplina().size());
                                if (djc.listarDisciplina().get(i).getSala() != null) {
                                    if (i == djc.listarDisciplina().size() - 1 && aux == 62) {
                                        bw.write(djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + djc.listarDisciplina().get(i).getCodigo() + "_" + diaSemana + "_" + djc.listarDisciplina().get(i).getSala().getNumero());
                                    } else {
                                        bw.write(djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + djc.listarDisciplina().get(i).getCodigo() + "_" + diaSemana + "_" + djc.listarDisciplina().get(i).getSala().getNumero() + "+");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
