/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.RestricaoDisciplinaJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.RestricaoDisciplina;
import br.udesc.view.TelaRestricoesDisciplina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */

/**
 * Classe resposável por realizar o controle da tela "TelaRestricoesDisciplina.java".
 * Este módulo permite o usuário definir uma restrição para cada disciplina. Esta restrição
 * se baseia na obrigação ou na proibição de a disciplina ser lecionada em dias específicos da semana. 
 * Cada dia da semana é divido em primeiro e segundo horário.
 * @author Favero
 */    
public class ControladorTelaRestricoesDisciplina {

    private TelaRestricoesDisciplina trd;
    private Disciplina dis;
    private DisciplinaJpaController djc;
    private RestricaoDisciplinaJpaController rdjc;
    private JComboBox[][] restricoes;
    private List<RestricaoDisciplina> restricoesAntigas;
    private List<RestricaoDisciplina> restricoesNovas;
    private int qtTotalRestricoes;

    /**
     * Método construtor. Reponsável por executar os métodos necessários para instanciação da classe.
     * @param id Id da disciplina na qual as restrições se referem.
     */
    public ControladorTelaRestricoesDisciplina(long id) {
        trd = new TelaRestricoesDisciplina();
        dis = new Disciplina();
        djc = new DisciplinaJpaController();
        rdjc = new RestricaoDisciplinaJpaController();
        this.buscaDisciplina(id);
        //restricoesAntigas = dis.getListaRestricaoDisciplina();
        carregaListaCbxRestricoes();
        carregaListaCbxRestricoesDisciplina();
        carregaLabel();
        iniciar();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        /* Define as ações que serão realizadas a partir do clique no botão "Salvar" */
        trd.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /* Salva as restrições definidas na tela no array "restricoesNovas" */
                salvarRestricoes();
                /* Remove-se do banco as restrições antigas para a disciplina em questão */
                removerRestricoesAntigas();
                /* Insere-se no banco as novas restrições para esta disciplina */
                persistirRestricoes();
                JOptionPane.showMessageDialog(null, "Restrições salvas com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                trd.dispose();
            }
        });
        /* Define as ações que serão realizadas a partir do clique no botão "Cancelar" */
        trd.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /* Fecha-se a tela atual */
                trd.dispose();
            }
        });
        
        trd.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                trd.dispose();
            }
        });

        trd.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                trd.setVisible(false);
            }
        });

        trd.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                trd.setVisible(false);
            }
        });

        trd.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    trd.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
        trd.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                trd.setVisible(false);
            }
        });
        
        trd.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctr = new ControladorTelaVinculo();
                ctr.executar();
                trd.setVisible(false);
            }
        });

    }

    /**
     * Método resposável por adicionar a opções disponíveis de cada ComboBox de restrição, 
     * que é: "Obrigatório" ou "Proibido". 
     */
    public void carregaListaCbxRestricoes() {
        /* Carrega-se todos os ComboBox na matriz "restricoes" */
        /* Os índices de cada ComboBox é definido como código para o dia da semana.
        No momento de salvar será somado 1 a cada código para iniciar com 1.
        Segunda-feira: 1
        Terça-feira: 2
        Quarta-feira: 3
        Quinta-feira: 4
        Sexta-feira: 5
        Sábado: 6 
        ---------------
        1º Período: 1
        2º Período: 2 */
        restricoes = new JComboBox[6][2];
        restricoes[0][0] = trd.cbxSegunda1;
        restricoes[0][1] = trd.cbxSegunda2;
        restricoes[1][0] = trd.cbxTerca1;
        restricoes[1][1] = trd.cbxTerca2;
        restricoes[2][0] = trd.cbxQuarta1;
        restricoes[2][1] = trd.cbxQuarta2;
        restricoes[3][0] = trd.cbxQuinta1;
        restricoes[3][1] = trd.cbxQuinta2;
        restricoes[4][0] = trd.cbxSexta1;
        restricoes[4][1] = trd.cbxSexta2;
        restricoes[5][0] = trd.cbxSabado1;
        restricoes[5][1] = trd.cbxSabado2;
        for (int i = 0; i < restricoes.length; i++) {
            for (int j = 0; j < 2; j++) {
                restricoes[i][j].addItem(" ");
                restricoes[i][j].addItem("Obrigatório");
                restricoes[i][j].addItem("Proibido");
            }
        }
    }

    /**
     * Método responsável por carregar as restrições já existentes para a disciplina na tela. 
     */
    public void carregaListaCbxRestricoesDisciplina() {
        for (RestricaoDisciplina p : restricoesAntigas) {
            String seq = String.valueOf(p.getHorario());
            /* Armazena-se o primeiro caractere da variável "horario" do objeto 
            "RestricaoDisciplina" que se trata do dia da semana*/
            String diaAux = String.valueOf(seq.charAt(0));
            int dia = Integer.parseInt(diaAux);
            /* Armazena-se o segundo caractere da variável "horario" do objeto 
            "RestricaoDisciplina" que se trata do período do dia */
            String horarioAux = String.valueOf(seq.charAt(1));
            int horario = Integer.parseInt(horarioAux);
            /* Define o valor atual para o ComboBox referente ao dia/período em questão */
            if(p.getCondicao() == 3){
                restricoes[dia - 1][horario - 1].setSelectedIndex(p.getCondicao()-1);
            }else{
                restricoes[dia - 1][horario - 1].setSelectedIndex(p.getCondicao());
            }
            
        }
    }

    /**
     * Método responsável por adicionar as restrições que estão definidas na tela
     * no array "novasRestrições" que será atualizado para a disciplina. 
     */
    public void salvarRestricoes() {
        RestricaoDisciplina ph;
        restricoesNovas = new ArrayList<RestricaoDisciplina>();
        /* Percorre-se a matriz verificando qual foi o valor definido pelo usuário */
        for (int i = 0; i < restricoes.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (restricoes[i][j].getSelectedItem().equals("Obrigatório")) {
                    ph = new RestricaoDisciplina();
                    String seq = String.valueOf(i + 1) + String.valueOf(j + 1);
                    ph.setHorario(Integer.parseInt(seq));
                    /* Obrigatório recebe valor 1 */
                    ph.setCondicao(1);
                    ph.setDisciplina(this.dis);
                    restricoesNovas.add(ph);
                }else if(restricoes[i][j].getSelectedItem().equals("Proibido")){
                    ph = new RestricaoDisciplina();
                    String seq = String.valueOf(i + 1) + String.valueOf(j + 1);
                    ph.setHorario(Integer.parseInt(seq));
                    /* Obrigatório recebe valor 1 */
                    ph.setCondicao(3);
                    ph.setDisciplina(this.dis);
                    restricoesNovas.add(ph);
                }
            }
        }
    }
    
    /**
     * Método responsável por salvar as novas restrições no banco de dados.
     */
    public void persistirRestricoes() {
        for (RestricaoDisciplina p : restricoesNovas) {
            try {
                rdjc.create(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Método responsável por remover do banco de dados as antigas restrições da disciplina.
     */
    public void removerRestricoesAntigas() {
        for (RestricaoDisciplina p : restricoesAntigas) {
            try {
                rdjc.destroy(p.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    *
    */
    public void executar() {
        trd.setVisible(true);
    }

    /**
     * Método responsável por buscar a disciplina com "id" definida no parâmetro do 
     * construtor desta classe, e salvar na variável aqui instanciada.
     *
     * @param  id  id da disciplina na qual se refere.
     */
    public void buscaDisciplina(long id) {
        this.dis = djc.findDisciplina(id);
        this.restricoesAntigas = rdjc.buscarRestricoes(id);
    }

    /*  */
    
    /**
     * Método responsável por carregar o nome da disciplina em questão no cabeçalho da tela.
     *
     */
    public void carregaLabel() {
        trd.labelTitulo.setText("Restrições para " + this.dis.getNome());
    }

}
