package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.PessoaHorarioPreferenciaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaRestricoesProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Classe resposável por realizar o controle da tela
 * "TelaRestricoesProfessor.java". Este módulo permite o usuário definir
 * restrições para cada professor. Estas restrições se baseiam na preferencia,
 * ou na proibição de o professor lecionar em dias específicos da
 * semana. Cada dia da semana é divido em primeiro e segundo horário.
 * @author PIN2
 */
public class ControladorTelaRestricoesProfessor {

    private TelaRestricoesProfessor tr;
    private Professor pro;
    private ProfessorJpaController psc;
    private PessoaHorarioPreferenciaJpaController phj;
    private JComboBox[][] restricoes;
    private List<PessoaHorarioPreferencia> restricoesAntigas;
    private List<PessoaHorarioPreferencia> restricoesNovas;
    private ControladorTelaInicio cti;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     * @param id Id do Professor na qual as restrições se referem.
     */
    public ControladorTelaRestricoesProfessor(long id) {
        tr = new TelaRestricoesProfessor();
        pro = new Professor();
        psc = new ProfessorJpaController();
        phj = new PessoaHorarioPreferenciaJpaController();
        cti = new ControladorTelaInicio();
        this.buscaProfessor(id);
        restricoesAntigas = pro.getListaHorario();
        carregaListaCbxRestricoes();
        carregaListaCbxRestricoesProfessor();
        carregaLabel();
        iniciar();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        /* Define as ações que serão realizadas a partir do clique no botão "Salvar" */
        tr.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /* Salva as restrições definidas na tela no array "restricoesNovas" */
                salvarRestricoes();
                carregaListaCbxRestricoesProfessor();
                /* Remove-se do banco as restrições antigas para o professor em questão */
                removerRestricoesAntigas();
                /* Insere-se no banco as novas restrições para este professor */
                persistirRestricoes();
                JOptionPane.showMessageDialog(null, "Restrições salvas com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                cti.executar();
                tr.dispose();

            }
        });
        /* Define as ações que serão realizadas a partir do clique no botão "Cancelar" */
        tr.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cti.executar();
                tr.dispose();
            }
        });

        tr.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tr.dispose();
            }
        });

        tr.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tr.setVisible(false);
            }
        });

        tr.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                tr.setVisible(false);
            }
        });

        tr.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tr.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        tr.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tr.setVisible(false);
            }
        });

        tr.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctr = new ControladorTelaVinculo();
                ctr.executar();
                tr.setVisible(false);
            }
        });

    }

    /**
     * Método resposável por adicionar a opções disponíveis de cada ComboBox de
     * restrição, que é: "Proibido" ou "Preferencial" tendo um peso de 1 a 10.
     * Existe uma matriz de ComboBox na qual a posição "x" da matriz se refere
     * ao dia da semana, e a posição "y" ao período do dia na qual a restrição
     * será aplicada conforme abaixo:
     * Dias da semana:
     * Segunda-feira: 1
     * Terça-feira: 2
     * Quarta-feira: 3
     * Quinta-feira: 4
     * Sexta-feira: 5
     * Sábado: 6 
     * Períodos:
     * 1º Período: 1
     * 2º Período: 2
     * 
     * Exemplo: Terça-feira no primeiro horário recebe o valor "21".
     */
    public void carregaListaCbxRestricoes() {
        restricoes = new JComboBox[6][2];
        restricoes[0][0] = tr.cbxSegunda1;
        restricoes[0][1] = tr.cbxSegunda2;
        restricoes[1][0] = tr.cbxTerca1;
        restricoes[1][1] = tr.cbxTerca2;
        restricoes[2][0] = tr.cbxQuarta1;
        restricoes[2][1] = tr.cbxQuarta2;
        restricoes[3][0] = tr.cbxQuinta1;
        restricoes[3][1] = tr.cbxQuinta2;
        restricoes[4][0] = tr.cbxSexta1;
        restricoes[4][1] = tr.cbxSexta2;
        restricoes[5][0] = tr.cbxSabado1;
        restricoes[5][1] = tr.cbxSabado2;
        for (int i = 0; i < restricoes.length; i++) {
            for (int j = 0; j < 2; j++) {
                restricoes[i][j].addItem("Proibido");
                restricoes[i][j].addItem("Preferencial (1)");
                restricoes[i][j].addItem("Preferencial (2)");
                restricoes[i][j].addItem("Preferencial (3)");
                restricoes[i][j].addItem("Preferencial (4)");
                restricoes[i][j].addItem("Preferencial (5)");
                restricoes[i][j].addItem("Preferencial (6)");
                restricoes[i][j].addItem("Preferencial (7)");
                restricoes[i][j].addItem("Preferencial (8)");
                restricoes[i][j].addItem("Preferencial (9)");
                restricoes[i][j].addItem("Preferencial (10)");
            }
        }
    }

    /**
     * Método responsável por carregar as restrições já existentes para o
     * professor nos ComboBox's.
     */
    public void carregaListaCbxRestricoesProfessor() {
        for (PessoaHorarioPreferencia p : restricoesAntigas) {
            String seq = String.valueOf(p.getSequencia());
            /* Armazena-se o primeiro caractere da variável "sequencia" do objeto 
            "PessoaHorarioPreferencia" que se trata do dia da semana*/
            String diaAux = String.valueOf(seq.charAt(0));
            int dia = Integer.parseInt(diaAux);
            /* Armazena-se o segundo caractere da variável "sequencia" do objeto 
            "PessoaHorarioPreferencia" que se trata do período do dia */
            String horarioAux = String.valueOf(seq.charAt(1));
            int horario = Integer.parseInt(horarioAux);
            /* Define o valor atual para o ComboBox referente ao dia/período em questão */
            if (p.getValor() <= 10) {
                restricoes[dia - 1][horario - 1].setSelectedIndex(p.getValor());
            } else if (p.getValor() == 12) {
                restricoes[dia - 1][horario - 1].setSelectedIndex(0);
//            }else{
//                restricoes[dia - 1][horario - 1].setSelectedIndex(2);
            }

        }
    }

    /**
     * Método responsável por adicionar as restrições que estão definidas na
     * tela para o array "novasRestrições" que serão atualizadas para o professor.
     */
    public void salvarRestricoes() {
        PessoaHorarioPreferencia ph;
        restricoesNovas = new ArrayList<PessoaHorarioPreferencia>();
        /* Percorre-se a matriz verificando qual foi o valor definido pelo usuário */
        for (int i = 0; i < restricoes.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (restricoes[i][j].getSelectedItem().equals("Proibido")) {
                    ph = new PessoaHorarioPreferencia();
                    String seq = String.valueOf(i + 1) + String.valueOf(j + 1);
                    ph.setSequencia(Integer.parseInt(seq));
                    /* Preferencial recebe valor 2 */
                    ph.setValor(12);
                    ph.setProfessor(this.pro);
                    restricoesNovas.add(ph);
                } else if (String.valueOf(restricoes[i][j].getSelectedItem()).contains("Preferencial")) {
                    ph = new PessoaHorarioPreferencia();
                    String seq = String.valueOf(i + 1) + String.valueOf(j + 1);
                    ph.setSequencia(Integer.parseInt(seq));
                    String temp = String.valueOf((restricoes[i][j]).getSelectedIndex());
                    ph.setValor(Integer.parseInt(temp));
                    ph.setProfessor(this.pro);
                    restricoesNovas.add(ph);
                }
            }
        }
    }

    /**
     * Método responsável por remover do banco de dados as antigas restrições do
     * professor.
     */
    public void removerRestricoesAntigas() {
        for (PessoaHorarioPreferencia p : restricoesAntigas) {
            try {
                phj.destroy(p.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método responsável por salvar as novas restrições no banco de dados.
     */
    public void persistirRestricoes() {
        for (PessoaHorarioPreferencia p : restricoesNovas) {
            try {
                phj.create(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método responsável por buscar o Professor com "id" definida no parâmetro
     * e salvar na variável aqui instanciada.
     * @param id Id do Professor na qual se refere.
     */
    public void buscaProfessor(long id) {
        this.pro = psc.findProfessor(id);
    }

    /**
     * Método responsável por carregar o nome do Professor em questão no
     * cabeçalho da tela.
     */
    public void carregaLabel() {
        tr.labelTitulo.setText("Restrições para " + this.pro.getNome());
    }

    /**
     * Método responsável por inicializar a tela controlada por esta classe.
     */
    public void executar() {
        tr.setVisible(true);
    }

}
