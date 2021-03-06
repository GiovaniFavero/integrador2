package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaCadastroSala;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do cadastro/alteração de salas.
 * @author PIN2
 */
public class ControladorTelaCadastroSala {

    private TelaCadastroSala tcs;
    private int edit = 0;
    private Sala sala;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaCadastroSala() {
        tcs = new TelaCadastroSala();
        sala = new Sala();
        iniciar();
    }

    /**
     * Método resposável por validar se os campos obrigatórios foram preenchidos.
     * @return Caso os campos obrigatórios não estiverem preenchidos retorna uma mensagem de aviso e também "false",
     * caso contrário retorna "true".
     */
    public boolean validarCampos() {

        if (tcs.fieldNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o numero da sala", "Erro", JOptionPane.WARNING_MESSAGE);
            tcs.fieldNumero.requestFocus();
            return false;
        }
        if (tcs.fieldLimite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor informar o limite de vagas na sala", "Erro", JOptionPane.WARNING_MESSAGE);
            tcs.fieldLimite.requestFocus();
            return false;
        }

        if ((!(tcs.radioLaboratorio.isSelected())) && (!(tcs.radioSala.isSelected()))) {
            JOptionPane.showMessageDialog(null, "Favor escolha entre Lab ou Sala", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {

        tcs.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tcs.dispose();;
            }
        });

        tcs.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tcs.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tcs.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tcs.setVisible(false);
            }
        });

        tcs.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcs.fieldLimite.setText("");

            }
        });

        tcs.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (validarCampos() == true) {
                    SalaJpaController sjc = new SalaJpaController();

                    boolean verdade = true;
                    if (tcs.radioSala.isSelected()) {
                        verdade = false;
                    }
                    int a = Integer.parseInt(tcs.fieldLimite.getText());
                    String numero = tcs.fieldNumero.getText();
                    List<Sala> listaSala = sjc.listarSala();
                    //--------------------se edit = 0 logo criar um novo---------------
                    if (edit == 0) {
                        if (sjc.validaSala(tcs.fieldNumero.getText()) == null) {
                            sala = new Sala();
                            sala.setNumero(numero);
                            sala.setLimite(a);
                            sala.setTipo(verdade);
                            sjc.create(sala);

                            JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            tcs.fieldLimite.setText("");
                            tcs.fieldNumero.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Sala já cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        //----------------- senão editar um existente -----------------------
                        sala.setNumero(numero);
                        sala.setLimite(a);
                        sala.setTipo(verdade);
                        try {
                            sjc.edit(sala);
                        } catch (Exception ex) {
                            Logger.getLogger(ControladorTelaCadastroSala.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        JOptionPane.showMessageDialog(null, "Sala editda com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        tcs.fieldLimite.setText("");
                        tcs.fieldNumero.setText("");
                        ControladorTelaTableSala ctt = new ControladorTelaTableSala();
                        tcs.setVisible(false);
                        ctt.executar();
                    }

                }
            }
        });

        tcs.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableSala ctt = new ControladorTelaTableSala();
                ctt.executar();
                tcs.dispose();
            }
        });
        
         tcs.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tcs.dispose();
            }
        });
         
         tcs.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tcs.dispose();
            }
        });

    }

    /**
     * Método resposável por preencher campos para edição de sala.
     * @param s Sala em questão a ser editada. 
     */
    public void editar(Sala s) {
        sala = s;
        edit = 1;
        tcs.fieldNumero.setText(s.getNumero());
        tcs.fieldLimite.setText(String.valueOf(s.getLimite()));
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        tcs.setVisible(true);
    }

}
