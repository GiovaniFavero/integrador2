package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.relatorios.ConnectionFactory;
import br.udesc.view.TelaGerarRelatorios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Classe resposável pelo controle do módulo de geração de relatórios.
 * @author PIN2
 */
public class ControladorTelaGerarRelatorio {

    private TelaGerarRelatorios tgr;
    private ConnectionFactory cf;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaGerarRelatorio() {
        cf = new ConnectionFactory();
        tgr = new TelaGerarRelatorios();
        iniciar();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        tgr.botaoDisciplinaOrfao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConnectionFactory.getConnection();

                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\ConflitoCreditos.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
            }
        });
        tgr.botaoConflitoCreditos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConnectionFactory.getConnection();

                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\DisciplinaOrfao.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
            }
        });

        tgr.botaoConHorarioProibido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConnectionFactory.getConnection();

                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\ConflitoHorariosProibidos.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
                view.setVisible(true);
            }
        });
        tgr.botaoPorFase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConnectionFactory.getConnection();

                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\ListaResultadoPorFase.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
                view.setVisible(true);

            }
        });

        tgr.botaoPorProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\ListaResultadoprofessor.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
                view.setVisible(true);

            }
        });

        tgr.botaoPorLaboratorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String src = ".\\src\\br\\udesc\\model\\dao\\relatorios\\RelatorioResultadoPorLaboratorio.jasper";

                JasperPrint jasperprint = null;

                try {
                    jasperprint = JasperFillManager.fillReport(src, null, ConnectionFactory.getConnection());
                } catch (JRException e) {
                    e.printStackTrace();
                }

                JasperViewer view = new JasperViewer(jasperprint, false);
                view.setVisible(true);

            }
        });
        
        tgr.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                executar();
                tgr.dispose();
            }
        });

        tgr.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tgr.setVisible(false);
            }
        });

        tgr.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                tgr.setVisible(false);
            }
        });

        tgr.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tgr.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        tgr.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tgr.setVisible(false);
            }
        });

        tgr.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaVinculo ctr = new ControladorTelaVinculo();
                ctr.executar();
                tgr.setVisible(false);
            }
        });
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        tgr.setVisible(true);
    }
}
