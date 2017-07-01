package br.udesc.controller;

import br.udesc.controller.tablemodel.VinculoModel;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaTableVinculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do modulo que exibe a tabela com os Vínculos já realizados.
 * @author PIN2
 */
public class ControladorTelaTableVinculo {

    private TelaTableVinculo ttv;
    private Disciplina dis;
    private VinculoModel vm;
    private List<Disciplina> listaVinculo;
    private DisciplinaJpaController djc;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaTableVinculo() {
        ttv = new TelaTableVinculo();
        dis = new Disciplina();
        vm = new VinculoModel();
        djc = new DisciplinaJpaController();
        ttv.tabelaVinculacao.setModel(vm);
        iniciar();
        carregarVinculo();
    }

    /**
     * Método responsável por guardar a disciplina do vínculo selecionado na variável do "dis" do tipo Disciplina.
     * @param linha Linha da tabela.
     */
    public void pegarLinha(int linha) {
        dis = djc.findDisciplina((long) ttv.tabelaVinculacao.getValueAt(linha, 0));
    }

    /**
     * Método responsável por carregar vínculos existentes para a disciplina.
     */
    public void carregarVinculo() {
        vm.limpar();
        listaVinculo = djc.listarDisciplina();
        for (Disciplina listaDisciplinas : listaVinculo) {
            vm.anuncioAdd(listaDisciplinas);
        }
        ttv.tabelaVinculacao.getSelectionModel().addSelectionInterval(0, 0);
    }

    /**
     * Método responsável por eliminar vínculo.
     */
    public void tirarVinculo() {
        pegarLinha(ttv.tabelaVinculacao.getSelectedRow());
        ProfessorJpaController pjc = new ProfessorJpaController();
        Professor p = new Professor();

        p = dis.getProfessor();
        if (dis.getProfessor() != null) {
            //---------------caso esse não funcione tente o comentado -------------
            p.getListaDisciplinaProfessor().remove(dis);
            dis.setProfessor(null);
            try {
                djc.edit(dis);
                pjc.edit(p);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro, Disciplina sem professor", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        carregarVinculo();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        ttv.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                int linha = ttv.tabelaVinculacao.getSelectedRow();
                pegarLinha(linha);
                ctv.carregarSelecionado(dis);
                ctv.executar();
                ttv.dispose();
            }
        });

        ttv.botaoEditar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                int linha = ttv.tabelaVinculacao.getSelectedRow();
                pegarLinha(linha);
                ctv.editar(dis);
                ttv.dispose();

            }
        });

        ttv.boataoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tirarVinculo();
            }
        });
        ttv.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttv.dispose();
            }
        }
        );

        ttv.botaoProfessor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableProfessor ctp = new ControladorTelaTableProfessor();
                ctp.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoSala.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableSala ctts = new ControladorTelaTableSala();
                ctts.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoDisciplina.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                cttd.executar();
                ttv.setVisible(false);
            }
        }
        );

        ttv.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                ttv.dispose();
            }
        });
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        ttv.setVisible(true);
    }

}
