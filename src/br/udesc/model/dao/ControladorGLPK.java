package br.udesc.model.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import br.udesc.model.entidade.Disciplina;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Roberto Weck
 */
public class ControladorGLPK {

    public void escreveProblema() throws IOException {
        String text = "escreve esta merda no arquivo mod";
        Files.write(Paths.get("./fileName.mod"), text.getBytes());
    }

    public ArrayList escreveVariaveis() throws IOException {
        String variaveis = null;
        ArrayList retorno = new ArrayList();
        DisciplinaJpaController djc = new DisciplinaJpaController();
        List<Disciplina> d = djc.listarDisciplina();

        Files.write(Paths.get("./problema.mod"), ("# Variáveis").getBytes());

        for (Disciplina dis : d) {
            if (!dis.getCodigo().isEmpty()) {
                variaveis += "var " + "_" + dis.getCurso().getId() + "_" + dis.getCodigo() + ", binary;\n";
                retorno.add("_" + dis.getCurso().getId() + "_" + dis.getCodigo());
            }
        }

        Files.write(Paths.get("./problema.mod"), variaveis.getBytes());

        return retorno;
    }

}
