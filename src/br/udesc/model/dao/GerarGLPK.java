package br.udesc.model.dao;

import br.udesc.model.entidade.Disciplina;
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
    private FileWriter fw;
    private BufferedWriter bw;
    
    public void geraTudo() {
        try {
            fw = new FileWriter(arquivo, true);
            bw = new BufferedWriter(fw);
            bw.close();
            fw.close();

//            new Thread(() -> {
            salvar();
//            }).start();
//            new Thread(() -> {
            salvarComLab();
//            }).start();
//            new Thread(() -> {
            funcaoMax();
//            }).start();
//            new Thread(() -> {
            funcaoMaxSala();
//            }).start();
//            new Thread(() -> {
            gerarVariaveisPorDisciplina();
//            }).start();

//            Thread.sleep(15000);
        } catch (Exception e) {
            
        }
        
    }
    
    public void salvar() {
        long inicio = System.currentTimeMillis();
        try {
            Files.write(Paths.get("./teste.mod"), "# Variáveis".getBytes(), StandardOpenOption.APPEND);
//            bw.write("# Variáveis");
//            bw.newLine();
            List<Disciplina> dis = djc.listarDisciplina();
            String print = "";
            for (int i = 0; i < dis.size(); i++) {
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
//                        bw.write("var _" + djc.listarDisciplina().get(i).getCodigo() + "_" + j + k + ", binary;");
//                        bw.newLine();
                        print += "\nvar _" + dis.get(i).getCodigo() + "_" + j + k + ", binary;";
                        
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
            print = null;
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
                        print += "\nvar _" + dis.get(i).getCodigo() + "_" + j + k + "_" + dis.get(i).getSala().getNumero() + ", binary;";
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), print.getBytes(), StandardOpenOption.APPEND);
            print = null;
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
            Files.write(Paths.get("./teste.mod"), "\n\nmaximize z: ".getBytes(), StandardOpenOption.APPEND);
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
            print = null;
            
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
            print = null;
            
        } catch (IOException | NumberFormatException e) {
        }
        System.out.println("funcaoMaxSala(): " + (System.currentTimeMillis() - inicio) + "ms");
    }
    
    public void gerarVariaveisPorDisciplina() {
        long inicio = System.currentTimeMillis();
        try {
            
            String print = "";
            Files.write(Paths.get("./teste.mod"), ("\n" + "# somatorio de todas as variaveis da disciplina = carga horaria" + "\n" + "s.t. carga_horaria: ").getBytes(), StandardOpenOption.APPEND);
//            bw.newLine();
//            bw.write("# somatorio de todas as variaveis da disciplina = carga horaria");
//            bw.newLine();
//            bw.write("s.t. carga_horaria: ");

            djc.listarDisciplina();
            Disciplina disc = new Disciplina();
            List<Disciplina> dis = djc.listarDisciplinaComSala();
            
            for (int x = 0; x < dis.size(); x++) {
                disc = dis.get(x);
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k <= 2; k++) {
                        if (j == 6 && k == 2) {
                            if (!dis.isEmpty()) {
//                                    System.out.println(listaDisciplina.size() + " size");
//                                    System.out.println("ENTREI");
//                                gerarVariaveisPorDisciplinaComSala();
                            } else {
                                int a = (int) Math.ceil(disc.getCreditos() / 2);
                                String aux = String.valueOf(a);
//                                bw.write("_" + disc.getCodigo() + "_" + j + k + " = " + aux);
//                                bw.newLine();
                                print += "_" + disc.getCodigo() + "_" + j + k + " = " + aux + "\n";
                            }
                        } else {
//                            bw.write("_" + disc.getCodigo() + "_" + j + k + "+");
                            print += "_" + disc.getCodigo() + "_" + j + k + "+";
                        }
                    }
                }
                
            }
            Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);
            print = null;
            
        } catch (IOException e) {
        }
        System.out.println("gerarVariaveisPorDisciplina(): " + (System.currentTimeMillis() - inicio) + "ms");
    }
    
    public void gerarVariaveisPorDisciplinaComSala() {
        long inicio = System.currentTimeMillis();
        djc.listarDisciplina();
        Disciplina disc = new Disciplina();
        List<Disciplina> listaDisciplina = new ArrayList<>();
        
        try {
            String print = "";
            for (int i = 0; i < djc.listarDisciplinaComSala().size(); i++) {
                listaDisciplina.add(djc.listarDisciplina().get(i));
            }
            for (int i = 0; i < listaDisciplina.size(); i++) {
                disc = listaDisciplina.get(i);
                
                for (int j = 1; j <= 6; j++) {
                    for (int k = 1; k < 2; k++) {
                        if (j == 6 && k == 2) {
                            int a = (int) Math.ceil(disc.getCreditos() / 2);
                            String aux = String.valueOf(a);
//                            bw.write("_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + " = " + aux);
//                            bw.newLine();
                            print += "_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + " = " + aux + "\n";
                            System.out.println(print);
                        } else {
//                            bw.write("_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + "+");
                            print += "_" + disc.getCodigo() + "_" + j + k + disc.getSala().getNumero() + "+";
                        }
                    }
                }
            }
            Files.write(Paths.get("./teste.mod"), (print + "\n").getBytes(), StandardOpenOption.APPEND);
            print = null;
        } catch (IOException e) {
        }
        System.out.println("gerarVariaveisPorDisciplinaComSala(): " + (System.currentTimeMillis() - inicio) + "ms");
    }
}
