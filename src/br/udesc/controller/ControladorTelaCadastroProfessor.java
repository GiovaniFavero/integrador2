package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.PessoaHorarioPreferenciaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.PessoaHorarioPreferencia;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroProfessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do cadastro/alteração de professores.
 * @author PIN2
 */
public class ControladorTelaCadastroProfessor {

    private TelaCadastroProfessor tcp;
    private Professor professor;
    private int edit = 0;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaCadastroProfessor() {
        professor = new Professor();
        tcp = new TelaCadastroProfessor();
        iniciar();
    }

    /**
     * Método resposável por validar se os campos obrigatórios foram preenchidos.
     * @return Caso os campos obrigatórios não estiverem preenchidos retorna uma mensagem de aviso e também "false",
     * caso contrário retorna "true".
     */
    public boolean validarCampos() {
        if (tcp.fieldNome.getText().isEmpty()) {
            tcp.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor informar o nome do professor", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (tcp.fieldCpf.getText().isEmpty()) {
            tcp.fieldCpf.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor informar o cpf do professor", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {

        tcp.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcp.fieldNome.setText("");
                tcp.fieldCpf.setText("");
            }
        });

        tcp.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (validarCampos() == true) {
                    ProfessorJpaController pjc = new ProfessorJpaController();
                    String nome = tcp.fieldNome.getText();
                    String cpf = tcp.fieldCpf.getText();
                    if (edit == 0) {
                        if (pjc.validaProfessor(tcp.fieldNome.getText()) == null) {
                            professor = new Professor();
                            professor.setNome(nome);
                            professor.setCpf(cpf);
                            pjc.create(professor);

                            PessoaHorarioPreferenciaJpaController phpjc = new PessoaHorarioPreferenciaJpaController();


                            for (int i = 1; i <= 6; i++) {
                                for (int j = 1; j <= 2; j++) {
                                    String a = i+""+j;
                                    PessoaHorarioPreferencia php = new PessoaHorarioPreferencia();
                                    
                                    php.setProfessor(professor);
                                    php.setSequencia(Integer.parseInt(a));
                                    php.setValor(10);
                                    phpjc.create(php);
                                    professor.addListHorario(php);

                                }
                            }
                            
                            
                            try {
                                pjc.edit(professor);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            professor.getListaHorario();
                            tcp.fieldNome.setText("");
                            tcp.fieldCpf.setText("");
                            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Professor já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);

                        }
                    } else {
                        professor.setNome(nome);
                        professor.setCpf(cpf);
                        try {
                            pjc.edit(professor);
                        } catch (Exception ex) {
                            Logger.getLogger(ControladorTelaCadastroProfessor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tcp.fieldNome.setText("");
                        tcp.fieldCpf.setText("");
                        JOptionPane.showMessageDialog(null, "Professor editado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        ControladorTelaTableProfessor ctt = new ControladorTelaTableProfessor();
                        tcp.setVisible(false);
                        ctt.executar();
                    }
                }
            }
        });

        tcp.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tcp.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tcp.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tcp.dispose();
            }
        });

        tcp.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                tcp.setVisible(false);
            }
        });

        tcp.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tcp.setVisible(false);
            }
        });

        tcp.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableProfessor ctt = new ControladorTelaTableProfessor();
                ctt.executar();
                tcp.dispose();
            }
        });
        
        tcp.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tcp.dispose();
            }
        });

    }

    /**
     * Método resposável por preencher campos para edição de Professor.
     * @param p Professor em questão a ser editado. 
     */
    public void editar(Professor p) {
        professor = p;
        edit = 1;
        tcp.fieldNome.setText(professor.getNome());
        tcp.fieldCpf.setText(professor.getCpf());
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    *
    */
    public void executar() {
        tcp.setVisible(true);
    }

}
