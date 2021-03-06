package br.udesc.controller;

import br.udesc.controller.tablemodel.ProfessorModel;
import br.udesc.model.dao.PessoaHorarioPreferenciaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroProfessor;
import br.udesc.view.TelaTabelaProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 * Classe resposável pelo controle do módulo que exibe a tabela de professores.
 * @author PIN2
 */
public class ControladorTelaTableProfessor {

    private TelaTabelaProfessor ttp;
    private Professor pro;
    private ProfessorModel pm;
    private List<Professor> listaProfessor;
    private ProfessorJpaController psc;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaTableProfessor() {
        ttp = new TelaTabelaProfessor();
        pro = new Professor();
        pm = new ProfessorModel();
        psc = new ProfessorJpaController();
        ttp.tabelaProfessores.setModel(pm);
        carregarProfessor();
        iniciar();
    }

    /**
     * Método responsável por carregar professores existentes na tabela.
     */
    public void carregarProfessor() {
        pm.limpar();
        listaProfessor = psc.listarProfessor();
        for (Professor listaProfessores : listaProfessor) {
            pm.anuncioAdd(listaProfessores);
        }
        ttp.tabelaProfessores.getSelectionModel().addSelectionInterval(0, 0);
    }
    
    /**
     * Ao remover um professor, todas as restrições deste professor são removidas através deste método.
     */
    public void destruirHorarioPreferencial() {
        List<PessoaHorarioPreferencia> php = new ArrayList<>();
        PessoaHorarioPreferenciaJpaController phpjc = new PessoaHorarioPreferenciaJpaController();
        php = phpjc.HorariosPreferenciaSemProfessor();
        for (int i = 0; i < php.size(); i++) {
            try {
                phpjc.destroy(php.get(i).getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladorTelaCadastroProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método responsável por guardar o professor selecionado na variável "pro" do tipo Professor.
     * @param linha Linha selecionada da table.
     */
    public void pegarLinha(int linha) {
        pro.setId((long) ttp.tabelaProfessores.getValueAt(linha, 0));
        pro.setNome((String) ttp.tabelaProfessores.getValueAt(linha, 1));
        pro.setCpf((String) ttp.tabelaProfessores.getValueAt(linha, 2));
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        ttp.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroProfessor ctp = new ControladorTelaCadastroProfessor();
                ctp.executar();
                ttp.dispose();
            }
        });

        ttp.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroProfessor ctp = new ControladorTelaCadastroProfessor();
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);
                ctp.executar();
                ctp.editar(pro);
                ttp.dispose();
            }
        });

        ttp.botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);

                try {
                    psc.destroy(pro.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarProfessor();
                destruirHorarioPreferencial();
            }
        });
        
        ttp.botaoRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttp.tabelaProfessores.getSelectedRow();
                pegarLinha(linha);
                ControladorTelaRestricoesProfessor ctr = new ControladorTelaRestricoesProfessor(pro.getId());
                ttp.dispose();
                ctr.executar();
                
                
            }
        });
        
        ttp.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttp.dispose();
            }
        }
        );

        ttp.botaoSala.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                ttp.setVisible(false);
            }
        }
        );

        ttp.botaoDisciplina.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                cttd.executar();
                ttp.setVisible(false);
            }
        }
        );

        ttp.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttp.setVisible(false);
            }
        }
        );
        
        ttp.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                ttp.dispose();
            }
        });
    }

   /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        ttp.setVisible(true);
    }

}
