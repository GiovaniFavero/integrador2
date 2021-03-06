package br.udesc.controller;

import br.udesc.controller.tablemodel.DisciplinaModel;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.RestricaoDisciplinaJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.RestricaoDisciplina;
import br.udesc.view.TelaTableDisciplina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do módulo que exibe a tabela de disciplinas.
 * @author PIN2
 */
public class ControladorTelaTableDisciplina {
    private TelaTableDisciplina ttd;
    private Disciplina dis;
    private DisciplinaModel dm;
    private List<Disciplina> listaDisciplina;
    private DisciplinaJpaController djc;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaTableDisciplina() {
        ttd = new TelaTableDisciplina();
        dis = new Disciplina();
        dm = new DisciplinaModel();
        djc = new DisciplinaJpaController();
        ttd.tabelaDisciplina.setModel(dm);

        carregarDisciplina();
        Iniciar();
    }
  
    /**
     * Método responsável por guardar a disciplina selecionada na variável do "dis" do tipo Disciplina.
     * @param linha Linha selecionada da table.
     */
    public void pegarLinha(int linha) {
        dis = djc.findDisciplina((long) ttd.tabelaDisciplina.getValueAt(linha, 0));
//        dis.setId((long) ttd.tabelaDisciplina.getValueAt(linha, 0));
//        dis.setNome((String) ttd.tabelaDisciplina.getValueAt(linha, 1));
//        dis.setCodigo((String) ttd.tabelaDisciplina.getValueAt(linha, 2));
//        dis.setCreditos((int) ttd.tabelaDisciplina.getValueAt(linha, 3));
//        dis.setFase((String) ttd.tabelaDisciplina.getValueAt(linha, 4));
        
    }
    
    /**
     * Método responsável por carregar disciplinas existentes na tabela.
     */
    public void carregarDisciplina(){
        dm.limpar();
        listaDisciplina = djc.listarDisciplina();
        for (Disciplina listaDisciplinas : listaDisciplina) {
            dm.anuncioAdd(listaDisciplinas);
        }
        ttd.tabelaDisciplina.getSelectionModel().addSelectionInterval(0, 0);
    }
    
    /**
     * Ao remover uma disciplina, todas as restrições desta disciplina são removidas através deste método.
     */
    public void destruirRestrições(){
        List<RestricaoDisciplina> rd = new ArrayList<>();
        RestricaoDisciplinaJpaController rdjc = new RestricaoDisciplinaJpaController();
        rd = rdjc.listarRestriçõesSemDisciplina();
        for (int i = 0; i < rd.size(); i++) {
            try {
                rdjc.destroy(rd.get(i).getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladorTelaTableDisciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void Iniciar(){
        ttd.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                ctcd.executar();
                ttd.dispose();
            }
        });
        
        ttd.botaoEditar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);
                ctcd.editar(dis);
                ttd.dispose();
                ctcd.executar();
            }
        });
        
        ttd.boataoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);

                try {
                    djc.destroy(dis.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarDisciplina();
                destruirRestrições();
            }
        });
        
        ttd.botaoRestricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttd.tabelaDisciplina.getSelectedRow();
                pegarLinha(linha);
                ControladorTelaRestricoesDisciplina ctr = new ControladorTelaRestricoesDisciplina(dis.getId());
                ttd.dispose();
                ctr.executar();
            }
        });
        
        ttd.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttd.dispose();
            }
        }
        );

        ttd.botaoProfessor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableProfessor ctp = new ControladorTelaTableProfessor();
                ctp.executar();
                ttd.setVisible(false);
            }
        }
        );

        ttd.botaoSala.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableSala ctts = new ControladorTelaTableSala();
                ctts.executar();
                ttd.setVisible(false);
            }
        }
        );

        ttd.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttd.setVisible(false);
            }
        }
        );
        
        ttd.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                ttd.dispose();
            }
        });
    }
    
    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar(){
        ttd.setVisible(true);
    }

    
}
