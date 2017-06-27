package br.udesc.model.dao;

import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.model.entidade.RestricaoDisciplina;
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
    private String solve = "";

    public void geraTudo() {
        try {
            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            salvar();
            funcaoMax();
            funcaoMaxSala();
            gerarVariaveisPorDisciplina();
            gerarSomatorioDisciplinaProfessor();
            gerarSomatorioDisciplinaFase();
            gerarRestricaoDisciplinaHorarioIndisponiveis();
            somatorioHorasLaboratorio();
            gerarRestricoesObrigatorias();
            geraSolve();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Criar Variaves
    public void salvar() {
        long inicio = System.currentTimeMillis();

        try {
            Files.write(Paths.get("./teste.mod"), "# Variáveis".getBytes(), StandardOpenOption.APPEND);

            List<Disciplina> dis = djc.listarDisciplina();
            Disciplina disciplina;
            String print = "";
            for (int i = 0; i < dis.size(); i++) {
                disciplina = dis.get(i);
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        if (disciplina.getSala() != null) {
                            for (int l = 1; l <= 2; l++) {
                                if (l == 2) {
                                    print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ", binary;";
                                    if (i == dis.size() - 1 && j == 6 && k == 2) {

                                        solve += "_" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ";";

                                    } else {
                                        solve += "_" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ",";
                                    }

                                } else {

                                    print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + ", binary;";
                                    if (i == dis.size() - 1 && j == 6 && k == 2) {
                                        solve += "_" + dis.get(i).getCodigo() + "_" + j + k + ",";
                                    } else {
                                        solve += "_" + dis.get(i).getCodigo() + "_" + j + k + ",";
                                    }
                                }
                            }
                        } else {
                            print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + ", binary;";
                            if (i == dis.size() - 1 && j == 6 && k == 2) {
                                solve += "_" + dis.get(i).getCodigo() + "_" + j + k + ";";
                            } else {
                                solve += "_" + dis.get(i).getCodigo() + "_" + j + k + ",";

                            }
                        }
                    }
                }
            }

            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvar(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void funcaoMax() {
        long inicio = System.currentTimeMillis();
        try {

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
                                    print += "\n" + dis.get(i).getProfessor().getListaHorario().get(l).getValor() + "*_" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero() + ";";
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

            Files.write(Paths.get("./teste.mod"), ("\r\n\r\n" + "# somatorio de todas as variaveis da disciplina = carga horaria" + "\r\n\r\n" + "s.t. carga_horaria: ").getBytes(), StandardOpenOption.APPEND);

            Disciplina disc = new Disciplina();
            List<Disciplina> disComSala = djc.listarDisciplinaComSala();
            List<Disciplina> listaDisciplina = djc.listarDisciplina();
            int contador = 1;
            for (int i = 0; i < listaDisciplina.size(); i++) {
                String print = "";
                disc = listaDisciplina.get(i);

                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        int a = (int) Math.ceil(disc.getCreditos() / 2);
                        String aux = String.valueOf(a);
                        if (disc.getSala() != null) {
                            for (int l = 1; l <= 2; l++) {
                                if (l == 2) {
                                    if (j == 6 && k == 2) {
                                        if (i != listaDisciplina.size() - 1) {
                                            print += "_" + disc.getCodigo() + "_" + j + k + "_" + disc.getSala().getNumero() + " = " + aux + ";\r\n s.t. carga_horaria" + contador + ":";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                            contador++;
                                        } else {
                                            print += "_" + disc.getCodigo() + "_" + j + k + "_" + disc.getSala().getNumero() + " = " + aux + ";\r\n";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                        }
                                    } else {
                                        print += "_" + disc.getCodigo() + "_" + j + k + "_" + disc.getSala().getNumero() + "+";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                    }
                                } else {
                                    if (j == 6 && k == 2) {
                                        print += "_" + disc.getCodigo() + "_" + j + k + "+";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                    } else {
                                        print += "_" + disc.getCodigo() + "_" + j + k + "+";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";

                                    }
                                }
                            }
                        } else {
                            if (j == 6 && k == 2) {
                                if (i != listaDisciplina.size() - 1) {
                                    print += "_" + disc.getCodigo() + "_" + j + k + " = " + aux + ";\r\n s.t. carga_horaria" + contador + ":";
                                    Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                    print = "";
                                    contador++;
                                } else {
                                    print += "_" + disc.getCodigo() + "_" + j + k + " = " + aux + ";\r\n";
                                    Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                    print = "";
                                    contador++;
                                }
                            } else {
                                print += "_" + disc.getCodigo() + "_" + j + k + "+";
                                Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                print = "";

                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gerarVariaveisPorDisciplina(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void gerarSomatorioDisciplinaProfessor() {
        long inicio = System.currentTimeMillis();
        try {

            Files.write(Paths.get("./teste.mod"), "\r\n# somatorio_de_todas as disciplinas de um professor por horario <=1 \r\n s.t. conflito_horario_professor0:".getBytes(), StandardOpenOption.APPEND);
            List<Professor> lista = pjc.listarProfessor();
            List<Professor> listaProfessor = new ArrayList<>();
            List<Professor> listaSala = new ArrayList<>();
            Professor professor;

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getListaDisciplinaProfessor().size() != 0) {
                    listaSala.add(lista.get(i));
                }
            }

            listaProfessor = lista;

            int contador = 1;
            int contadorProfessor = 0;
            for (int i = 0; i < listaProfessor.size(); i++) {
                System.out.println(i + "valor de i");
                String print = "";
                System.out.println(i + " i");
                professor = lista.get(i);
                Disciplina disciplina = new Disciplina();

                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        for (int l = 0; l < professor.getListaDisciplinaProfessor().size(); l++) {

                            disciplina = professor.getListaDisciplinaProfessor().get(l);

                            if (disciplina.getSala() != null) {
                                for (int m = 1; m <= 2; m++) {
                                    if (m == 2) {
                                        if (l == professor.getListaDisciplinaProfessor().size() - 1) {
                                            if (contador / 12 == listaSala.size() && j == 6 && k == 2) {
                                                print += "_" + disciplina.getCodigo() + "_" + j + k + "_" + disciplina.getSala().getNumero() + "<= 1; \r\n";
                                                Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);

                                                print = "";
                                                contador++;
                                                contadorProfessor++;
                                            } else {
                                                print += "_" + disciplina.getCodigo() + "_" + j + k + "_" + disciplina.getSala().getNumero() + "<= 1; \r\n" + "s.t. conflito_horario_professor" + contador + ":";
                                                Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                                print = "";
                                                contador++;
                                                contadorProfessor++;

                                            }
                                        } else {
                                            print += "_" + disciplina.getCodigo() + "_" + j + k + "_" + disciplina.getSala().getNumero() + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                        }
                                    } else {
                                        if (l == professor.getListaDisciplinaProfessor().size() - 1) {
                                            print += "_" + disciplina.getCodigo() + "_" + j + k + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";

                                        } else {
                                            print += "_" + disciplina.getCodigo() + "_" + j + k + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                        }
                                    }
                                }
                            } else {
                                if (l == professor.getListaDisciplinaProfessor().size() - 1) {
                                    if (contadorProfessor / 12 == listaSala.size() && j == 6 && k == 2) {
                                        System.out.println("ultimo2");
                                        print += "_" + disciplina.getCodigo() + "_" + j + k + "<= 1; \r\n";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                        contador++;
                                        contadorProfessor++;
                                    } else {
                                        print += "_" + disciplina.getCodigo() + "_" + j + k + "<= 1; \r\n" + "s.t. conflito_horario_professor" + contador + ":";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                        contador++;
                                        contadorProfessor++;
                                    }
                                } else {
                                    print += "_" + disciplina.getCodigo() + "_" + j + k + "+";
                                    Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                    print = "";
                                }
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");

    }

    public void gerarSomatorioDisciplinaFase() {
        long inicio = System.currentTimeMillis();
        try {
            Files.write(Paths.get("./teste.mod"), ("\r\n\r\n" + "# somatorio de todas as disciplinas de uma turma por horario <= 1" + "\r\n" + "s.t. conflito_horario_turma0:").getBytes(), StandardOpenOption.APPEND);

            Disciplina disc = new Disciplina();
            String print = "";
            List<Disciplina> listaDisciplina;
            int contador = 1;
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 3; j++) {
                    for (int k = 1; k <= 8; k++) {
                        String a = String.valueOf(k);
                        listaDisciplina = djc.listarDisciplinaPorFase(a);
                        for (int l = 0; l < listaDisciplina.size(); l++) {
                            disc = listaDisciplina.get(l);
                            if (disc.getSala() != null) {
                                for (int m = 1; m <= 2; m++) {
                                    if (m == 2) {
                                        if (l == listaDisciplina.size() - 1) {
                                            if (k == 8 && i == 6 && j == 2) {
                                                print += "_" + disc.getCodigo() + "_" + i + j + "_" + disc.getSala().getNumero() + "<= 1; \r\n";
                                                Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                                print = "";
                                                contador++;
                                            } else {
                                                print += "_" + disc.getCodigo() + "_" + i + j + "_" + disc.getSala().getNumero() + "<= 1; \r\n" + "s.t. conflito_horario_turma" + contador + ":";
                                                Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                                print = "";
                                                contador++;
                                            }
                                        } else {
                                            print += "_" + disc.getCodigo() + "_" + i + j + "_" + disc.getSala().getNumero() + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                        }
                                    } else {
                                        if (l == listaDisciplina.size() - 1) {
                                            print += "_" + disc.getCodigo() + "_" + i + j + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);

                                            print = "";
                                        } else {
                                            System.out.println("entrei ali");
                                            print += "_" + disc.getCodigo() + "_" + i + j + "+";
                                            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                        }
                                    }
                                }
                            } else {
                                if (l == listaDisciplina.size() - 1) {
                                    if (k == 8 && j == 2 && i == 6) {
                                        print += "_" + disc.getCodigo() + "_" + i + j + "<= 1; \r\n";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                        contador++;
                                    } else {
                                        print += "_" + disc.getCodigo() + "_" + i + j + "<= 1; \r\n" + "s.t. conflito_horario_turma" + contador + ":";
                                        Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                        print = "";
                                        contador++;
                                    }
                                } else {
                                    print += "_" + disc.getCodigo() + "_" + i + j + "+";
                                    Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
                                    print = "";
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");

    }

    public void gerarRestricoesObrigatorias() throws IOException {
        long inicio = System.currentTimeMillis();

        String ini = "\r\n# horario arbitrario de disciplina\r\n";
        String inb = "s.t. horario_arbitrario_disciplina";
        int contador = 0;

        Files.write(Paths.get("./teste.mod"), (ini).getBytes(), StandardOpenOption.APPEND);

        List<RestricaoDisciplina> res = new RestricaoDisciplinaJpaController().listarRestricoesObrigatorias();

        try {
            String[] aRestricoes;

            aRestricoes = this.montaStringRestricoes(res);

            for (int i = 0; i < 12; i++) {
                if (!aRestricoes[i].equals("")) {
                    inb = "s.t. horario_arbitrario_disciplina" + contador + ":";
                    Files.write(Paths.get("./teste.mod"), (inb + aRestricoes[i] + " = 1;\r\n").getBytes(), StandardOpenOption.APPEND);
                    contador++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gerarVariaveisPorDisciplinaComSala(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    private String[] montaStringRestricoes(List<RestricaoDisciplina> res) {
        String restricao11 = "";
        String restricao12 = "";
        String restricao21 = "";
        String restricao22 = "";
        String restricao31 = "";
        String restricao32 = "";
        String restricao41 = "";
        String restricao42 = "";
        String restricao51 = "";
        String restricao52 = "";
        String restricao61 = "";
        String restricao62 = "";

        for (int i = 0; i < res.size(); i++) {
            switch (res.get(i).getHorario()) {
                case 11:
                    restricao11 += this.getStringVariavelRestricao(res.get(i), (!restricao11.equals("")));
                    break;
                case 12:
                    restricao12 += this.getStringVariavelRestricao(res.get(i), (!restricao12.equals("")));
                    break;
                case 21:
                    restricao21 += this.getStringVariavelRestricao(res.get(i), (!restricao21.equals("")));
                    break;
                case 22:
                    restricao22 += this.getStringVariavelRestricao(res.get(i), (!restricao22.equals("")));
                    break;
                case 31:
                    restricao31 += this.getStringVariavelRestricao(res.get(i), (!restricao31.equals("")));
                    break;
                case 32:
                    restricao32 += this.getStringVariavelRestricao(res.get(i), (!restricao32.equals("")));
                    break;
                case 41:
                    restricao41 += this.getStringVariavelRestricao(res.get(i), (!restricao41.equals("")));
                    break;
                case 42:
                    restricao42 += this.getStringVariavelRestricao(res.get(i), (!restricao42.equals("")));
                    break;
                case 51:
                    restricao51 += this.getStringVariavelRestricao(res.get(i), (!restricao51.equals("")));
                    break;
                case 52:
                    restricao52 += this.getStringVariavelRestricao(res.get(i), (!restricao52.equals("")));
                    break;
                case 61:
                    restricao61 += this.getStringVariavelRestricao(res.get(i), (!restricao61.equals("")));
                    break;
                case 62:
                    restricao62 += this.getStringVariavelRestricao(res.get(i), (!restricao62.equals("")));
                    break;
            }
        }

        String[] aRestricoes = new String[12];
        aRestricoes[0] = restricao11;
        aRestricoes[1] = restricao12;
        aRestricoes[2] = restricao21;
        aRestricoes[3] = restricao22;
        aRestricoes[4] = restricao31;
        aRestricoes[5] = restricao32;
        aRestricoes[6] = restricao41;
        aRestricoes[7] = restricao42;
        aRestricoes[8] = restricao51;
        aRestricoes[9] = restricao52;
        aRestricoes[10] = restricao61;
        aRestricoes[11] = restricao62;

        return aRestricoes;
    }

    private String getStringVariavelRestricao(RestricaoDisciplina oResDis, boolean bAdicionaMais) {
        String print = "";
        if (bAdicionaMais) {
            print = " + ";
        }
        print += "_" + oResDis.getDisciplina().getCodigo() + "_" + oResDis.getHorario();

        if (oResDis.getDisciplina().getSala() != null) {
            print += " + _" + oResDis.getDisciplina().getCodigo() + "_" + oResDis.getHorario() + "_" + oResDis.getDisciplina().getSala().getNumero();
        }
        return print;
    }

    public void gerarRestricaoDisciplinaHorarioIndisponiveis() {
        long inicio = System.currentTimeMillis();

        try {
            String print = "";
            String ini = "\r\n# somatorio de todas as disciplinas e horarios indisponiveis de um professor = 0 \r\n";
            String inb = "";
            Files.write(Paths.get("./teste.mod"), (ini).getBytes(), StandardOpenOption.APPEND);

            PessoaHorarioPreferenciaJpaController oPesHorJpa = new PessoaHorarioPreferenciaJpaController();
            DisciplinaJpaController oDisciplinaJpa = new DisciplinaJpaController();
            RestricaoDisciplinaJpaController rdjc = new RestricaoDisciplinaJpaController();
            List<Professor> listaProfessor = oPesHorJpa.listarProfessorComRestricoesProibitivas();
            Professor professor;
            Disciplina disciplina;
            int dia = 0;
            int contador = 1;

            for (int i = 0; i < listaProfessor.size(); i++) {

                professor = listaProfessor.get(i);
                for (int k = 0; k < professor.getListaHorario().size(); k++) {
                    if (professor.getListaHorario().get(k).getValor() == 12) {
                        dia = professor.getListaHorario().get(k).getSequencia();
                        for (int j = 0; j < professor.getListaDisciplinaProfessor().size(); j++) {
                            disciplina = professor.getListaDisciplinaProfessor().get(j);
                            if (disciplina.getSala() != null) {
                                for (int l = 1; l <= 2; l++) {
                                    if (l == 2) {
                                        if (j == professor.getListaDisciplinaProfessor().size() - 1) {
                                            System.out.println(print + "1");
                                            inb = "s.t. conflito_horario_professor_indisponivel" + contador + ":";
                                            print += "_" + disciplina.getCodigo() + "_" + dia + "_" + disciplina.getSala().getNumero() + "= 0;\r\n";
                                            Files.write(Paths.get("./teste.mod"), (inb + print).getBytes(), StandardOpenOption.APPEND);
                                            print = "";
                                            contador++;
                                        } else {
                                            System.out.println(print + "2");
                                            print += "_" + disciplina.getCodigo() + "_" + dia + "_" + disciplina.getSala().getNumero() + "+";
                                        }
                                    } else {
                                        if (j == professor.getListaDisciplinaProfessor().size() - 1) {
                                            System.out.println(print + "3");
                                            print += "_" + disciplina.getCodigo() + "_" + dia + "+";

                                        } else {
                                            System.out.println(print + "4");
                                            print += "_" + disciplina.getCodigo() + "_" + dia + "+";
                                        }
                                    }
                                }
                            } else {
                                if (j == professor.getListaDisciplinaProfessor().size() - 1) {
                                    System.out.println(print + "5");
                                    inb = "s.t. conflito_horario_professor_indisponivel" + contador + ":";
                                    print += "_" + disciplina.getCodigo() + "_" + dia + "= 0;\r\n";
                                    Files.write(Paths.get("./teste.mod"), (inb + print).getBytes(), StandardOpenOption.APPEND);
                                    contador++;
                                    print = "";
                                } else {
                                    System.out.println(print + "6");
                                    print += "_" + disciplina.getCodigo() + "_" + dia + "+";
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

    private void gerarRestricoesHorarioProibido() throws IOException {
        long inicio = System.currentTimeMillis();
        String print = "";

        String ini = "\r\n# somatorio de todas as disciplinas e horarios indisponiveis de um professor \n";
        String inb = "s.t. conflito_horario_professor: ";
        Files.write(Paths.get("./teste.mod"), (ini + inb).getBytes(), StandardOpenOption.APPEND);

        PessoaHorarioPreferenciaJpaController oPesHorJpa = new PessoaHorarioPreferenciaJpaController();
        DisciplinaJpaController oDisciplinaJpa = new DisciplinaJpaController();

        List<Professor> res = oPesHorJpa.listarProfessorComRestricoesProibitivas();

        List<Object> aHorarios;
        List<Disciplina> aDisciplinas;
//        List<PessoaHorarioPreferencia> res = new PessoaHorarioPreferenciaJpaController().listarRestricoesProibitivas();

        for (Professor oProf : res) {
            aHorarios = oPesHorJpa.getAllHorarioProibidosProfessor((int) (long) oProf.getId());
            aDisciplinas = oDisciplinaJpa.listaDisciplinaProfessor((int) (long) oProf.getId());

            for (int i = 0; i < aHorarios.size(); i++) {
                for (Disciplina oDis : aDisciplinas) {

                    if (!print.equals("")) {
                        print += " + ";
                    }

                    print += "_" + oDis.getCodigo() + "_" + aHorarios.get(i);

                    if (oDis.getSala() != null) {
                        print += " + _" + oDis.getCodigo() + "_" + aHorarios.get(i) + "_" + oDis.getSala().getNumero();
                    }
                }
            }
        }
        Files.write(Paths.get("./teste.mod"), (print + " = 0\n").getBytes(), StandardOpenOption.APPEND);
    }

    private void somatorioHorasLaboratorio() throws IOException {
        DisciplinaJpaController djp = new DisciplinaJpaController();
        List<Disciplina> dis = djp.listarDisciplinaComSala();

        Files.write(Paths.get("./teste.mod"), ("\r\n\r\n# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50% da carga horária\r\n").getBytes(), StandardOpenOption.APPEND);

        String variavel = "s.t. horario_em_laboratorio";
        int contador = 0;

        for (Disciplina d : dis) {
            String print = "";
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 6 && k == 2) {

                        int a = (int) Math.ceil(d.getCreditos() / 4.0);

                        System.out.println("VALOR DO A DEPOIS DA DIVISÃO " + a);
                        String aux = String.valueOf(a);
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero();
                        print += "= " + aux + ";\r\n";
                        variavel = "s.t. horario_em_laboratorio" + contador + ":";
                        Files.write(Paths.get("./teste.mod"), (variavel + print).getBytes(), StandardOpenOption.APPEND);
                        contador++;

                    } else {
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero() + "+";
                    }
                }
            }
        }
    }

    public void geraSolve() {
        long inicio = System.currentTimeMillis();

        try {
            Files.write(Paths.get("./teste.mod"), "\r\nsolve;\r\ndisplay ".getBytes(), StandardOpenOption.APPEND);
//            List<Disciplina> dis = djc.listarDisciplinaComSala();
//            String print = "";
//
//            for (int i = 0; i < dis.size(); i++) {
//                for (int j = 1; j <= 6; j++) {
//                    for (int k = 1; k <= 2; k++) {
//                        print += " _" + dis.get(i).getCodigo() + "_" + j + k;
//
//                        if (dis.get(i).getSala() != null) {
//                            print += ", _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero();
//                        }
//                        if (i + 1 == dis.size()) {
//                            print += ";";
//                        } else {
//                            print += ",";
//                        }
//                    }
//                }
//            }
            Files.write(Paths.get("./teste.mod"), solve.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("./teste.mod"), "\r\n\nend;".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");
    }
}
