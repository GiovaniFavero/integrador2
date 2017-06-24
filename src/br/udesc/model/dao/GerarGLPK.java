package br.udesc.model.dao;

import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GerarGLPK {

    private File arquivo = new File("./teste.mod");
    private CursoJpaController cjc = new CursoJpaController();
    private DisciplinaJpaController djc = new DisciplinaJpaController();
    private ProfessorJpaController pjc = new ProfessorJpaController();
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
//            gerarRestricoesObrigatorias();
        } catch (Exception e) {

        }

    }

    public void salvar() {
        long inicio = System.currentTimeMillis();
        try {
            Files.write(Paths.get("./teste.mod"), "# Variáveis".getBytes(), StandardOpenOption.APPEND);

            List<Disciplina> dis = djc.listarDisciplina();
            String print = "";
            for (int i = 0; i < dis.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + ", binary;";

                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
        System.out.println("salvar(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void salvarComLab() {
        long inicio = System.currentTimeMillis();
        try {
            List<Disciplina> dis = djc.listarDisciplinaComSala();
            String print = "";

            for (int i = 0; i < dis.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
//                            bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + "_" + djc.listarDisciplina().get(i).getSala().getNumero() + ", binary;");
//                            bw.newLine();
                        print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ", binary;";
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void funcaoMax() {
        long inicio = System.currentTimeMillis();
        try {
//
//            bw.newLine();
//            bw.write("maximize z: ");
            Files.write(Paths.get("./teste.mod"), "\r\nmaximize z: ".getBytes(), StandardOpenOption.APPEND);
            String print = "";
            ProfessorJpaController pjc = new ProfessorJpaController();

            List<Disciplina> dis = djc.listarDisciplinaComProfessor();

            if (pjc.getProfessorCount() != 0) {
                for (int i = 0; i < dis.size(); i++) {
                    for (int j = 1; j <= 6; j++) {
                        for (int k = 1; k <= 2; k++) {
                            for (int l = 0; l < dis.get(i).getProfessor().getListaHorario().size(); l++) {
                                String diaSemana = j + "" + k;
                                int aux = Integer.parseInt(diaSemana);
                                if (dis.get(i).getProfessor().getListaHorario().get(l).getSequencia() == aux) {
//                                        bw.write(djc.listarDisciplina().get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + djc.listarDisciplina().get(i).getCodigo() + "_" + diaSemana + "+");
                                    print += "\n" + dis.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + dis.get(i).getCodigo() + "_" + diaSemana + "+";
                                }
                            }
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException | NumberFormatException e) {
        }
        System.out.println("funcaoMax(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void funcaoMaxSala() {
        long inicio = System.currentTimeMillis();
        try {
            List<Disciplina> dis = djc.listarDisciplinaComProfessorComSala();
            String print = "";
            for (int i = 0; i < dis.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        for (int l = 0; l < dis.get(i).getProfessor().getListaHorario().size(); l++) {
                            String diaSemana = j + "" + k;
                            int aux = Integer.parseInt(diaSemana);
                            if (dis.get(i).getProfessor().getListaHorario().get(l).getSequencia() == aux) {
                                if (i == dis.size() - 1 && aux == 62) {
//                                    bw.write(listaDisciplinas.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + listaDisciplinas.get(i).getCodigo() + "_" + diaSemana + "_" + listaDisciplinas.get(i).getSala().getNumero());
                                    print += "\n" + dis.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero();
                                } else {
//                                    bw.write(listaDisciplinas.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + listaDisciplinas.get(i).getCodigo() + "_" + diaSemana + "_" + listaDisciplinas.get(i).getSala().getNumero() + "+");
                                    print += "\n" + dis.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero() + "+";
                                }
                            }
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException | NumberFormatException e) {
        }
        System.out.println("funcaoMaxSala(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void gerarVariaveisPorDisciplina() {
        long inicio = System.currentTimeMillis();
        try {

            String print = "";
            Files.write(Paths.get("./teste.mod"), ("\r\n\r\n" + "# somatorio de todas as variaveis da disciplina = carga horaria" + "\n" + "s.t. carga_horaria: ").getBytes(), StandardOpenOption.APPEND);

            Disciplina disc = new Disciplina();
            List<Disciplina> disComSala = djc.listarDisciplinaComSala();
            List<Disciplina> listaDisciplina = djc.listarDisciplina();

            for (int x = 0; x < listaDisciplina.size(); x++) {
                disc = listaDisciplina.get(x);
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        if (j == 6 && k == 2) {
                            if (listaDisciplina.get(x).getSala() != null) {
                                gerarVariaveisPorDisciplinaComSala(disc);
                                System.out.println("VORTEI");
                            } else {
                                int a = (int) Math.ceil(disc.getCreditos() / 2);
                                String aux = String.valueOf(a);
                                print += "_" + disc.getCodigo() + "_" + j + k + " = " + aux + "\r\n";
                            }
                        } else {
                            print += "_" + disc.getCodigo() + "_" + j + k + "+";
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gerarVariaveisPorDisciplina(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void gerarVariaveisPorDisciplinaComSala(Disciplina d) {
        long inicio = System.currentTimeMillis();

        try {
            String print = "";

            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 6 && k == 2) {
                        int a = (int) Math.ceil(d.getCreditos() / 2);
                        String aux = String.valueOf(a);
                        print += "_" + d.getCodigo() + "_" + j + k + d.getSala().getNumero() + " = " + aux + "\r\n";
                        Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);
                    } else {
                        print += "_" + d.getCodigo() + "_" + j + k + d.getSala().getNumero() + "+";
                    }
                }
            }

//            Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gerarVariaveisPorDisciplinaComSala(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void gerarSomatorioDisciplinaProfessor() {
        long inicio = System.currentTimeMillis();
        try {
            String print = "";
            Files.write(Paths.get("./teste.mod"), "\r\n# somatorio_de_todas as disciplinas de um professor por horario <=1 ".getBytes(), StandardOpenOption.APPEND);
            List<Professor> lista = pjc.listarProfessor();
            List<Professor> listaProfessor = new ArrayList<>();
            Professor professor;
            Disciplina disciplina;

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getListaDisciplinaProfessor().size() != 0) {
                    System.out.println("adicionei");
                    listaProfessor.add(lista.get(i));
                }
            }

            for (int i = 0; i < listaProfessor.size(); i++) {
                System.out.println("entrei ali");
                professor = lista.get(i);
                System.out.println(professor.getListaDisciplinaProfessor().size());
                for (int j = 0; j < professor.getListaDisciplinaProfessor().size(); j++) {
                    System.out.println("entrei aqui");
                    disciplina = professor.getListaDisciplinaProfessor().get(i);
                    int x = 1;
                    int z = 1;
                    print += disciplina.getCodigo() + "_" + x + z;

                }
            }

            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");

    }

//    public void gerarRestricoesObrigatorias() throws IOException {
//        long inicio = System.currentTimeMillis();
//
//        String ini = "\n\n# horario arbitrario de disciplina\n";
//        String inb = "s.t. horario_arbitrario_disciplina: ";
//        Files.write(Paths.get("./teste.mod"), (ini + inb).getBytes(), StandardOpenOption.APPEND);
//
////        List<RestricaoDisciplina> res = new RestricaoDisciplinaJpaController().listarRestricoesObrigatorias();
//
//        try {
//            String print = "";
//            for (int i = 0; i < res.size(); i++) {
//                print += "_" + res.get(i).getDisciplina().getCodigo() + "_" + res.get(i).getHorario() + " + ";
//                if (res.get(i).getDisciplina().getSala() != null) {
//                    print += "_" + res.get(i).getDisciplina().getCodigo() + "_" + res.get(i).getHorario() +"_"+ res.get(i).getDisciplina().getSala().getNumero() + " + ";
//                }
//            }
//            Files.write(Paths.get("./teste.mod"), (print + " = 1").getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("gerarVariaveisPorDisciplinaComSala(): " + (System.currentTimeMillis() - inicio) + "ms");
//    }
}
