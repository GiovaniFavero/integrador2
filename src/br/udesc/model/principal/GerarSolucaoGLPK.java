package br.udesc.model.principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        String output = executeCommand("C:\\Users\\5105011505\\Documents\\NetBeansProjects\\integrador2\\resources\\glpk_w32\\glpsol --math teste.mod");
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
        for (String var : vars) {
            String[] parts = var.split("=");
            String[] left = parts[0].substring(0, parts[0].indexOf(".")).split("_");
            for (String l : left) {
                System.out.print(l + "\t");
            }
            System.out.println(parts[1]);
        }
        System.out.println("sai");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        (new GerarSolucaoGLPK()).x();
    }

}
