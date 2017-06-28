package br.udesc.model.principal;

import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.SalaHorarioJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Sala;
import br.udesc.model.entidade.SalaHorario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class GerarSolucaoGLPK {

    private String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    public void x() {
        System.out.println("entrei");
        String output = executeCommand(".\\resources\\glpk_w32\\glpsol --math teste.mod");
        System.out.println("passei");
        if (output.contains("INTEGER OPTIMAL SOLUTION FOUND")) {
            System.out.println("achou");
            javax.swing.JOptionPane.showMessageDialog(null, "Solucao encontrada");
        } else if (output.contains("PROBLEM HAS NO PRIMAL FEASIBLE SOLUTION")) {
            System.out.println("não achou");
            javax.swing.JOptionPane.showMessageDialog(null, "Nao existe solucao para esse conjunto de restricoes");
        } else {
            System.out.println("else");
            System.out.println(output);
        }
        System.out.println("olá");
        System.out.println(output);
        output = output.split("Display statement at line")[1];
        output = output.substring(output.indexOf("\n") + 1, output.indexOf("Model has been successfully processed") - 1);
        String[] vars = output.split("\n");

        /*
        Adicionei daqui...
         */
        Disciplina dis = new Disciplina();
        Sala sala = new Sala();
        SalaHorario sh = new SalaHorario();
        DisciplinaJpaController djc = new DisciplinaJpaController();
        SalaJpaController sjc = new SalaJpaController();
        SalaHorarioJpaController shjc = new SalaHorarioJpaController();

        List<Disciplina> listaDis;
        List<Sala> listaSala;

        /*
        Até aqui pra controlar os bagulhos.
         */
        for (String var : vars) {
            String[] parts = var.split("=");
            String[] left = parts[0].substring(0, parts[0].indexOf(".")).split("_");

            /*
             Pego o left[1] que sempre será o nome/código_disciplina (peguei isso na intuicao, pq as variaveis nao ajudam (_2_41)??)
             */
            if (!parts[1].equals(" 0")) {
                listaDis = djc.validaDisciplina(left[1]);

                if (!listaDis.isEmpty()) {
                    /*
                    se a lista estiver vazia/nula quer dizer que não tem. passa pro próximo item.
                    Se tiver algo (o nome vai ter que ser único), atribuo o objeto da lista ao "dis", seto a preferencia do left[2] e seto a disciplina no SalaHorario
                     */
                    sh = new SalaHorario();
                    dis = listaDis.get(0);
                    sh.setPreferencia(Integer.parseInt(left[2]));
                    sh.setDisciplina(dis);
                    /*
                        Tento acessar o left[3] (caso tenha lab), se der caca, é pq nao tem lab, e consequentemente será nulo.
                     */
                    try {
                        /*
                        se tiver lab, valido (nao sei se é necessário, talvez nao). vejo se a lista ta vazia, se nao estiver, pego o objeto 0 da lista.
                         */
                        listaSala = sjc.validaSala(left[3]);
                        if (!listaSala.isEmpty()) {
                            /*
                            e seto a sala na SalaHorario
                             */
                            sh.setSala(listaSala.get(0));
                        }
                    } catch (Exception e) {
                        /*
                        Caso nao tenha sala, será nulo
                         */
                        sh.setSala(null);
                    }
                    /*
                    Crio o SalaHorario e zero a variavel, pra evitar problemas.
                     */
                    shjc.create(sh);
                    sh = null;
                }
            }

            for (String l : left) {
                System.out.print(l + "\t");
            }

            System.out.println(parts[1]);
        }
        System.out.println(
                "sai");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        (new GerarSolucaoGLPK()).x();
    }

}
