package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.GLPK.GerarGLPK;
import br.udesc.model.dao.GLPK.GerarSolucaoGLPK;
import br.udesc.model.dao.GLPK.PreencherTudo;
import br.udesc.model.dao.SalaHorarioJpaController;
import br.udesc.view.TelaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do módulo inicial do sistema.
 * @author PIN2
 */
public class ControladorTelaInicio {

    private TelaInicio ti;
    private DisciplinaJpaController djc = new DisciplinaJpaController();
    private SalaHorarioJpaController sjc = new SalaHorarioJpaController();

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaInicio() {
        ti = new TelaInicio();
        iniciar();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {

        //Para acessar a tela de cadastro de Curso
        new Thread(()
                -> ti.botaoCurso.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                        cttc.executar();
                        ti.dispose();
                    }
                })).start();

        //Para acessar a tela de cadastro de disciplina
        new Thread(()
                -> ti.botaoDisciplina.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CursoJpaController cjc = new CursoJpaController();
                        if (cjc.getCursoCount() != 0) {
                            ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                            cttd.executar();
                            ti.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                })).start();

        //Para acessar a tela de cadastro de professores
        new Thread(()
                -> ti.botaoProfessor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                        cttp.executar();
                        ti.dispose();
                    }
                })).start();

        //Para acessar a tela de cadastro de Sala
        new Thread(()
                -> ti.botaoSala.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ControladorTelaTableSala cts = new ControladorTelaTableSala();
                        cts.executar();
                        ti.dispose();
                    }
                })).start();

        new Thread(()
                -> ti.botaoVincular.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (djc.getDisciplinaCount() != 0) {
                            ControladorTelaTableVinculo ctv = new ControladorTelaTableVinculo();
                            ctv.executar();
                            ti.dispose();
                        } else{
                            JOptionPane.showMessageDialog(null, "Antes cadastre uma disciplina", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                })).start();

        ti.botaoProblema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Executando o GLPK");
                GerarGLPK glpk = new GerarGLPK();
                glpk.geraTudo();
                if (djc.listarDisciplinaComProfessor().size() != 0) {
                    sjc.limparTabela();
                    GerarSolucaoGLPK gsglpk = new GerarSolucaoGLPK();
                    gsglpk.x();
                } else {
                    JOptionPane.showMessageDialog(null, "Não existem professores vinculados à disciplinas", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ti.botaoDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PreencherTudo pt = new PreencherTudo();
                pt.gerarTudo();
            }
        });

        ti.botaoRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaGerarRelatorio ctgr = new ControladorTelaGerarRelatorio();
                ctgr.executar();
                ti.dispose();
            }
        });

    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        ti.setVisible(true);
    }

}
