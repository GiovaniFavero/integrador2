package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.view.TelaCadastroCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;


/**
 * Classe resposável pelo controle do cadastro/alteração de cursos.
 * @author PIN2
 */
public class ControladorTelaCadastroCurso {

    private TelaCadastroCurso tcc;
    private Curso curso;
    private int edit = 0;

    /**
     * Construtor intanciando a tela do controlador em questão, e instanciando novo curso.
     */
    public ControladorTelaCadastroCurso() {
        tcc = new TelaCadastroCurso();
        curso = new Curso();
        iniciar();
    }

    /**
     * Método resposável por validar se o campo "Nome" do curso foi preenchido.
     * @return Caso o campo "Nome" não estiver preenchido retorna uma mensagem de aviso e também "false",
     * caso contrário retorna "true".
     */
    public boolean validarCampos() {
        if (tcc.fieldNome.getText().isEmpty()) {
            tcc.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor preencher o Nome do curso", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        ((DefaultEditor) tcc.spinnerDuracao.getEditor()).getTextField().setEditable(false);

        tcc.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tcc.dispose();
            }
        });

        tcc.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tcc.setVisible(false);
            }
        });

        tcc.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                tcc.setVisible(false);
            }
        });

        tcc.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tcc.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        tcc.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcc.fieldNome.setText("");
            }
        });

        tcc.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();

                if (validarCampos() == true) {

                    int a = (int) tcc.spinnerDuracao.getValue();
                    String nome = tcc.fieldNome.getText();
                    if (edit == 0) {
                        if (cjc.validaCurso(tcc.fieldNome.getText()) == null) {
                            curso = new Curso();
                            curso.setNome(nome);
                            curso.setDuracao(a);
                            cjc.create(curso);
                            JOptionPane.showMessageDialog(null, "Curso criado com sucesso");
                            tcc.fieldNome.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Esse curso já está cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        curso.setNome(nome);
                        curso.setDuracao(a);
                        try {
                            cjc.edit(curso);
                        } catch (Exception ex) {
                            Logger.getLogger(ControladorTelaCadastroCurso.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        JOptionPane.showMessageDialog(null, "Curso Editado com sucesso");
                        tcc.fieldNome.setText("");
                        ControladorTelaTableCurso ctt = new ControladorTelaTableCurso();
                        tcc.setVisible(false);
                        ctt.executar();
                    }

                }
            }
        });

        tcc.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso ctt = new ControladorTelaTableCurso();
                ctt.executar();
                tcc.dispose();
            }
        });

    }

    
    /**
     * Método resposável por preencher campos para edição de curso.
     * @param c Curso em questão a ser editado. 
     */
    public void editar(Curso c) {
        curso = c;
        edit = 1;
        tcc.fieldNome.setText(curso.getNome());
        tcc.spinnerDuracao.setValue(curso.getDuracao());
    }

    
    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    *
    */
    public void executar() {
        tcc.setVisible(true);
    }

}
