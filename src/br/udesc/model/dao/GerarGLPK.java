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
import java.util.List;

public class GerarGLPK {

    private File arquivo = new File("./teste.mod");
    private CursoJpaController cjc = new CursoJpaController();
    private DisciplinaJpaController djc = new DisciplinaJpaController();
    private FileWriter fw;
    private BufferedWriter bw;

    public void geraTudo() {
        try {
            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);

            salvar();
//            salvarComLab();
            funcaoMax();
            funcaoMaxSala();
            gerarVariaveisPorDisciplina();
            gerarRestricoesObrigatorias();
            gerarRestricoesHorarioProibido();
            somatorioHorasLaboratorio();
            geraSolve();
        } catch (Exception e) {
            int aaaa= 0;
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
                        int aaaa = 0;
                        if (dis.get(i).getSala() == null) {
                            print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + ", binary;";
                        } else {
                            print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ", binary;";
                        }

                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
        System.out.println("salvar(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

//    public void salvarComLab() {
//        long inicio = System.currentTimeMillis();
//        try {
//            List<Disciplina> dis = djc.listarDisciplinaComSala();
//            String print = "";
//
//            for (int i = 0; i < dis.size(); i++) {
//                for (int j = 1; j <= 6; j++) {
//                    for (int k = 1; k <= 2; k++) {
////                            bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + "_" + djc.listarDisciplina().get(i).getSala().getNumero() + ", binary;");
////                            bw.newLine();
//                        print += "\r\nvar _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ", binary;";
//                    }
//                }
//            }
//            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");
//    }
    public void funcaoMax() {
        long inicio = System.currentTimeMillis();
        try {
//
//            bw.newLine();
//            bw.write("maximize z: ");
            Files.write(Paths.get("./teste.mod"), "\n\n\nmaximize z: ".getBytes(), StandardOpenOption.APPEND);
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
                                    if (dis.get(i).getProfessor().getListaHorario().get(l).getValor() == 12) {
                                        print += 0 + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + " + ";
                                    } else {
                                        print += dis.get(i).getProfessor().getListaHorario().get(l).getValor() + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + " + ";
                                    }
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
                                    if (dis.get(i).getProfessor().getListaHorario().get(l).getValor() == 12) {
                                        print += 0 + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero();
                                    } else {
                                        print += dis.get(i).getProfessor().getListaHorario().get(l).getValor() + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero();
                                    }
                                } else {
                                    if (dis.get(i).getProfessor().getListaHorario().get(l).getValor() == 12) {
                                        print += 0 + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero() + " + ";
                                    } else {
                                        print += dis.get(i).getProfessor().getListaHorario().get(l).getValor() + " * _" + dis.get(i).getCodigo() + "_" + diaSemana + "_" + dis.get(i).getSala().getNumero() + " + ";
                                    }
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
                            }
                            int a = disc.getCreditos() / 2;
                            String aux = String.valueOf(a);
                            print += "_" + disc.getCodigo() + "_" + j + k + " = " + aux + "\n";
                        } else {
                            print += "_" + disc.getCodigo() + "_" + j + k + " + ";
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), (print).getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("gerarVariaveisPorDisciplina(): " + (System.currentTimeMillis() - inicio) + "ms");
    }

    public void gerarVariaveisPorDisciplinaComSala(Disciplina d) {
        try {
            String print = "";

            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 6 && k == 2) {
                        int a = (int) Math.ceil(d.getCreditos() / 2);
                        String aux = String.valueOf(a);
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero() + " = " + aux + "\n";
                        Files.write(Paths.get("./teste.mod"), (print).getBytes(), StandardOpenOption.APPEND);
                    } else {
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero() + " + ";
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarRestricoesObrigatorias() throws IOException {
        long inicio = System.currentTimeMillis();

        String ini = "\n\n# horario arbitrario de disciplina\n";
        String inb = "s.t. horario_arbitrario_disciplina: ";
        Files.write(Paths.get("./teste.mod"), (ini + inb).getBytes(), StandardOpenOption.APPEND);

        List<RestricaoDisciplina> res = new RestricaoDisciplinaJpaController().listarRestricoesObrigatorias();

        try {
            String[] aRestricoes;

            aRestricoes = this.montaStringRestricoes(res);

            for (int i = 0; i < 12; i++) {
                if (!aRestricoes[i].equals("")) {
                    Files.write(Paths.get("./teste.mod"), (aRestricoes[i] + " = 1\n").getBytes(), StandardOpenOption.APPEND);
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

    private void gerarRestricoesHorarioProibido() throws IOException {
        long inicio = System.currentTimeMillis();
        String print = "";

        String ini = "\n\n# somatorio de todas as disciplinas e horarios indisponiveis de um professor \n";
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

        Files.write(Paths.get("./teste.mod"), ("\n\n# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50% da carga horária\n\n").getBytes(), StandardOpenOption.APPEND);

        for (Disciplina d : dis) {
            String print = "";
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 6 && k == 2) {
                        int a = (int) Math.ceil(d.getCreditos() / 2);
                        String aux = String.valueOf(a);
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero();
                        print += " = " + aux + "\n";
                        Files.write(Paths.get("./teste.mod"), (print).getBytes(), StandardOpenOption.APPEND);
                    } else {
                        print += "_" + d.getCodigo() + "_" + j + k + "_" + d.getSala().getNumero() + " + ";
                    }
                }
            }
        }
    }

    public void geraSolve() {
        long inicio = System.currentTimeMillis();

        try {
            Files.write(Paths.get("./teste.mod"), "\nsolve;\ndisplay ".getBytes(), StandardOpenOption.APPEND);
            List<Disciplina> dis = djc.listarDisciplinaComSala();
            String print = "";

            for (int i = 0; i < dis.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        print += " _" + dis.get(i).getCodigo() + "_" + j + k;

                        if (dis.get(i).getSala() != null) {
                            print += ", _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero();
                        }
                        if (i + 1 == dis.size()) {
                            print += ";";
                        } else {
                            print += ",";
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("./teste.mod"), "\n\nend;".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("salvarComLab(): " + (System.currentTimeMillis() - inicio) + "ms");
    }
}
