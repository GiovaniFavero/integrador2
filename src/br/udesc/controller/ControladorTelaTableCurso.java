package br.udesc.controller;

import br.udesc.controller.tablemodel.CursoModel;
import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.exceptions.NonexistentEntityException;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.view.TelaTableCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle módulo que exibe uma tabela com os cursos existentes.
 * @author PIN2
 */
public class ControladorTelaTableCurso {

    private TelaTableCurso ttc;
    private Curso cur;
    private CursoModel cm;
    private List<Curso> listaCurso;
    private CursoJpaController cjc;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaTableCurso() {
        ttc = new TelaTableCurso();
        cur = new Curso();
        cm = new CursoModel();
        cjc = new CursoJpaController();
        ttc.tabelaCurso.setModel(cm);

        carregarCurso();
        iniciar();
    }

    /**
     * Método responsável por carregar cursos existentes na tabela.
     */
    public void carregarCurso() {
        cm.limpar();
        listaCurso = cjc.listarCurso();
        for (Curso listaCursos : listaCurso) {
            cm.anuncioAdd(listaCursos);
        }
        ttc.tabelaCurso.getSelectionModel().addSelectionInterval(0, 0);
    }

    /**
     * Ao remover um curso, todas as disciplinas deste curso são removidas através deste método.
     */
    public void destruirDisciplinasSemCurso() {
        List<Disciplina> d = new ArrayList<>();
        DisciplinaJpaController djc = new DisciplinaJpaController();
        d = djc.listarDisciplinaSemCurso();
        for (int i = 0; i < d.size(); i++) {
            try {
                djc.destroy(d.get(i).getId());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladorTelaTableCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método responsável por guardar o curso selecionado na variável do "cur" do tipo Curso.
     * @param linha Linha selecionada da table.
     */
    public void pegarLinha(int linha) {
        cur.setId((long) ttc.tabelaCurso.getValueAt(linha, 0));
        cur.setNome((String) ttc.tabelaCurso.getValueAt(linha, 1));
        cur.setDuracao((int) ttc.tabelaCurso.getValueAt(linha, 2));
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        ttc.botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroCurso ctc = new ControladorTelaCadastroCurso();
                ctc.executar();
                ttc.dispose();
            }
        });

        ttc.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaCadastroCurso ctc = new ControladorTelaCadastroCurso();
                int linha = ttc.tabelaCurso.getSelectedRow();
                pegarLinha(linha);
                ctc.executar();
                ctc.editar(cur);
                ttc.dispose();
            }
        });

        ttc.botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = ttc.tabelaCurso.getSelectedRow();
                pegarLinha(linha);

                try {
                    cjc.destroy(cur.getId());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorTelaTableProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
                carregarCurso();
                destruirDisciplinasSemCurso();
            }
        });
        
        ttc.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                ttc.dispose();
            }
        });

        ttc.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                ttc.setVisible(false);
            }
        });

        ttc.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                ttc.setVisible(false);
            }
        });

        ttc.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    ttc.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
         ttc.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ttc.setVisible(false);
            }
        }
        );
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        ttc.setVisible(true);
    }

}
