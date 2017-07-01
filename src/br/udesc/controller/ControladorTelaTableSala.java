package br.udesc.controller;

import br.udesc.controller.tablemodel.SalaModel;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaCadastroSala;
import br.udesc.view.TelaTableSala;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe resposável pelo controle do módulo que exibe a tabela de salas.
 * @author PIN2
 */
public class ControladorTelaTableSala {

    private TelaTableSala tts;
    private Sala sa;
    private SalaModel sm;
    private List<Sala> listaSala;
    private SalaJpaController slc;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaTableSala() {
        tts = new TelaTableSala();
        sa = new Sala();
        sm = new SalaModel();
        slc = new SalaJpaController();
        tts.tabelaSalas.setModel(sm);

        carregarSala();
        iniciar();
    }

    /**
     * Método responsável por carregar salas existentes na tabela.
     */
    public void carregarSala() {
        sm.limpar();
        listaSala = slc.listarSala();
        for (Sala listaSalas : listaSala) {
            sm.anuncioAdd(listaSalas);
        }
        tts.tabelaSalas.getSelectionModel().addSelectionInterval(0, 0);
    }

    /**
     * Método responsável por guardar a sala selecionada na variável do "sa" do tipo Sala.
     * @param linha Linha selecionada da table.
     */
    public void pegarLinha(int linha) {
        sa.setId((long) tts.tabelaSalas.getValueAt(linha, 0));
        sa.setNumero((String) tts.tabelaSalas.getValueAt(linha, 1));
        sa.setLimite((int) tts.tabelaSalas.getValueAt(linha, 2));
        String comparar = ((String) tts.tabelaSalas.getValueAt(linha, 3));
        if (comparar.equalsIgnoreCase("Laboratorio")) {
            sa.setTipo(true);
        } else {
            sa.setTipo(false);
        }
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        tts.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala cts = new ControladorTelaCadastroSala();
                cts.executar();
                tts.dispose();
            }
        });

        tts.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala cts = new ControladorTelaCadastroSala();
                int linha = tts.tabelaSalas.getSelectedRow();
                pegarLinha(linha);
                cts.executar();
                cts.editar(sa);
                tts.dispose();
            }
        });

        tts.boataoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = tts.tabelaSalas.getSelectedRow();
                pegarLinha(linha);
                
                try {
                    slc.destroy(sa.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarSala();
            }
        });
        
        tts.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
               ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tts.dispose();
            }
        }
        );

        tts.botaoProfessor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableProfessor ctp = new ControladorTelaTableProfessor();
                ctp.executar();
                tts.setVisible(false);
            }
        }
        );

        tts.botaoDisciplina.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                cttd.executar();
                tts.setVisible(false);
            }
        }
        );

        tts.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tts.setVisible(false);
            }
        }
        );
        
        tts.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tts.dispose();
            }
        });
    }

   /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        tts.setVisible(true);
    }

}
