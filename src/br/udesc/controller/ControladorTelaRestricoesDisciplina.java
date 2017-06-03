/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.RestricaoDisciplinaJpaController;
import br.udesc.model.entidade.Disciplina;
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

/* Classe resposável por realizar o controle da tela "TelaRestricoesDisciplina.java".
Este módulo permite o usuário definir uma restrição para cada disciplina. Esta restrição
se baseia na obrigação de a disciplina ser lecionada em dias específicos da semana. 
Cada dia da semana é divido em primeiro e segundo horário. */
public class ControladorTelaRestricoesDisciplina {

    private TelaRestricoesDisciplina trd;
    private Disciplina dis;
    private DisciplinaJpaController djc;
    private RestricaoDisciplinaJpaController rdjc;
    private JComboBox[][] restricoes;
    private List<RestricaoDisciplina> restricoesAntigas;
    private List<RestricaoDisciplina> restricoesNovas;

    public ControladorTelaRestricoesDisciplina(long id) {
        trd = new TelaRestricoesDisciplina();
        dis = new Disciplina();
        djc = new DisciplinaJpaController();
        rdjc = new RestricaoDisciplinaJpaController();
        /* Localiza disciplina com a "id" no banco e salva na variável "dis" */
        this.buscaDisciplina(id);
        /* Salva as restrições atuais desta disciplina na lista "restricoesAntigas" */
        restricoesAntigas = dis.getListaRestricaoDisciplina();
        /* Carrega opções padrões nos ComboBox de cada dia/período da semana */
        carregaListaCbxRestricoes();
        /* Carrega os valores das restrições atuais da disciplina nos ComboBox. */
        carregaListaCbxRestricoesDisciplina();
        /* Carrega o nome da disciplina no cabeçalho da tela */
        carregaLabel();
        /* Inicializa os componentes do JFrame */
        iniciar();
    }

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

    }

    /* Método resposável por adicionar a opção disponível de cada ComboBox de restrição, 
    que é: "Obrigatório" */
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
            }
        }
    }

    /* Método responsável por carregar as restrições já existentes para a disciplina na tela. */
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
            restricoes[dia - 1][horario - 1].setSelectedIndex(p.getCondicao());
        }
    }

    /* Método responsável por adicionar as restrições que estão definidas na tela
    no array "novasRestrições" que será atualizado para a disciplina. */
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
                } 
            }
        }
    }
    
    /* Método responsável por salvar as novas restrições no banco */
    public void persistirRestricoes() {
        for (RestricaoDisciplina p : restricoesNovas) {
            try {
                rdjc.create(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /* Método responsável por remover do banco as antigas restrições da disciplina */
    public void removerRestricoesAntigas() {
        for (RestricaoDisciplina p : restricoesAntigas) {
            try {
                rdjc.destroy(p.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* Método responsável por inicializar a tela controlada por esta classe. */
    public void executar() {
        trd.setVisible(true);
    }

    /* Método responsável por buscar a disciplina com "id" definida no parâmetro do 
    construtor desta classe, e salvar na variável aqui instanciada. */
    public void buscaDisciplina(long id) {
        this.dis = djc.findDisciplina(id);
    }

    /* Método responsável por carregar o nome da disciplina em questão no cabeçalho da tela. */
    public void carregaLabel() {
        trd.labelTitulo.setText("Restrições para " + this.dis.getNome());
    }

}
