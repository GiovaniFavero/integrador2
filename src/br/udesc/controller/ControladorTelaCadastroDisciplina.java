package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaCadastroDisciplina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do cadastro/alteração de disciplinas.
 * @author PIN2
 */
public class ControladorTelaCadastroDisciplina {

    private TelaCadastroDisciplina tcd;
    private Disciplina disciplina;
    private int edit = 0;

    /**
     * Construtor intanciando a tela do controlador em questão, e instanciando nova disciplina.
     */
    public ControladorTelaCadastroDisciplina() {
        tcd = new TelaCadastroDisciplina();
        disciplina = new Disciplina();
        iniciar();
    }

    
    /**
     * Método resposável por validar se os campos foram preenchidos.
     * @return Caso os campos não estiverem preenchidos retorna uma mensagem de aviso e também "false",
     * caso contrário retorna "true".
     */
    public boolean validarCampos() {
        CursoJpaController cjc = new CursoJpaController();
        int a = cjc.getCursoCount();

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Favor cadastrar um curso", "Erro", JOptionPane.WARNING_MESSAGE);
        }

        if (tcd.fieldNome.getText().isEmpty()) {
            tcd.fieldNome.requestFocus();
            JOptionPane.showMessageDialog(null, "Favor preencher o nome da disciplina", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (tcd.fieldCreditos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher os créditos da dsiciplina", "Erro", JOptionPane.WARNING_MESSAGE);
            tcd.fieldCreditos.requestFocus();
            return false;
        }
        if (tcd.fieldFase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher a fase da disciplina", "Erro", JOptionPane.WARNING_MESSAGE);
            tcd.fieldFase.requestFocus();
            return false;
        }

        if (tcd.fieldQuantidadeAlunos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher a quantidade de alunos", "Erro", JOptionPane.WARNING_MESSAGE);
            tcd.fieldQuantidadeAlunos.requestFocus();
            return false;
        }

        return true;
    }

    
    /**
     * Método responsável por carregar os cursos disponíveis.
     */
    public void carregarCursos() {
        CursoJpaController cjc = new CursoJpaController();
        tcd.comboBoxCurso.removeAllItems();
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso : listaCurso) {
            tcd.comboBoxCurso.addItem(curso.getNome());
        }
    }

    /**
     * Método responsável por carregar as salas disponíveis.
     */
    public void carregaSala() {
        SalaJpaController sjc = new SalaJpaController();
        tcd.comboBoxSala.removeAllItems();
        List<Sala> listaSala = sjc.listarSala();
        List<Sala> comboBox = new ArrayList<>();
        if (sjc.getSalaCount() != 0) {
            for (int i = 0; i < sjc.getSalaCount(); i++) {
                if (listaSala.get(i).getTipo() == true) {
                    comboBox.add(listaSala.get(i));
                }
            }

            tcd.comboBoxSala.addItem("Sala Normal");
            for (Sala sala : comboBox) {
                tcd.comboBoxSala.addItem(sala.getNumero());
            }
        }
    }

    /**
     * Método responsável por preencher campos para edição de disciplina.
     * @param d Disciplina a ser editada
     */
    public void editar(Disciplina d) {
        disciplina = d;
        edit = 1;
        tcd.fieldNome.setText(disciplina.getNome());
        tcd.fieldCodigo.setText(disciplina.getCodigo());
        tcd.fieldCreditos.setText(String.valueOf(disciplina.getCreditos()));
        tcd.fieldFase.setText(disciplina.getFase());
        tcd.fieldQuantidadeAlunos.setText(String.valueOf(disciplina.getQtdAlunos()));

        int aux = 0;
        if (edit == 1 && disciplina.getSala() != null) {
            for (int i = 0; i < tcd.comboBoxSala.getItemCount(); i++) {
                if (tcd.comboBoxSala.getItemAt(i).equalsIgnoreCase(disciplina.getSala().getNumero())) {
                    aux = i;
                    break;
                }

            }
            tcd.comboBoxSala.setSelectedIndex(aux);
        }

    }

    
    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {
        carregarCursos();
        carregaSala();
        tcd.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DisciplinaJpaController djc = new DisciplinaJpaController();
                CursoJpaController cjc = new CursoJpaController();
                ProfessorJpaController pjc = new ProfessorJpaController();
                SalaJpaController sjc = new SalaJpaController();

                //Localizar o curso
                String nomeCurso = (String) tcd.comboBoxCurso.getSelectedItem();
                List<Curso> curso = cjc.validaCurso(nomeCurso);

                String tipoSala = (String) tcd.comboBoxSala.getSelectedItem();
                List<Sala> sala = sjc.validaSala(tipoSala);

                try {
                    if (validarCampos() == true) {

                        //Converter os campos
                        String nome = tcd.fieldNome.getText();
                        int creditos = Integer.parseInt(tcd.fieldCreditos.getText());

                        int quantidade = Integer.parseInt(tcd.fieldQuantidadeAlunos.getText());
                        String fase = tcd.fieldFase.getText();
                        String codigo = tcd.fieldCodigo.getText();

                        //Cria a disciplina
                        if (edit == 0) {
                            if (djc.validaDisciplina(tcd.fieldCodigo.getText()) == null) {

                                disciplina = new Disciplina();
                                disciplina = new Disciplina();
                                disciplina.setNome(nome);
                                disciplina.setCreditos(creditos);
                                disciplina.setQtdAlunos(quantidade);
                                disciplina.setFase(fase);
                                disciplina.setCodigo(codigo);
                                disciplina.setCurso(curso.get(0));
                                disciplina.setProfessor(null);
                                if ((sala != null)) {
                                    disciplina.setSala(sala.get(0));
                                }
                                djc.create(disciplina);

                                curso.get(0).addListaDisciplina(disciplina);
                                if ((sala != null)) {
                                    sala.get(0).addDisciplina(disciplina);
                                    sjc.edit(sala.get(0));
                                }

                                cjc.edit(curso.get(0));
                                JOptionPane.showMessageDialog(null, "Disciplina criado com sucesso");
                                tcd.fieldFase.setText("");
                                tcd.fieldNome.setText("");
                                tcd.fieldQuantidadeAlunos.setText("");
                                tcd.fieldCreditos.setText("");
                                tcd.fieldCodigo.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Matéria já existente", "Erro", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            System.out.println(disciplina.getId());
                            disciplina.setNome(nome);
                            disciplina.setCreditos(creditos);
                            disciplina.setQtdAlunos(quantidade);
                            disciplina.setFase(fase);
                            disciplina.setCodigo(codigo);
                            disciplina.setCurso(curso.get(0));
                            
                            tipoSala = (String) tcd.comboBoxSala.getSelectedItem();
                            sala = sjc.validaSala(tipoSala);
                            if ((tcd.comboBoxSala.getSelectedIndex() == 0)) {
                                disciplina.setSala(null);
                            }else{
                                disciplina.setSala(sala.get(0));
                            }

                            try {
                                djc.edit(disciplina);
                            } catch (Exception ex) {
                                Logger.getLogger(ControladorTelaCadastroCurso.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            curso.get(0).addListaDisciplina(disciplina);
                            if ((sala != null)) {
                                sala.get(0).addDisciplina(disciplina);
                                sjc.edit(sala.get(0));
                            }

                            JOptionPane.showMessageDialog(null, "Disciplina Editado com sucesso");
                            tcd.fieldFase.setText("");
                            tcd.fieldNome.setText("");
                            tcd.fieldQuantidadeAlunos.setText("");
                            tcd.fieldCreditos.setText("");
                            tcd.fieldCodigo.setText("");
                            ControladorTelaTableDisciplina ctt = new ControladorTelaTableDisciplina();
                            tcd.setVisible(false);
                            ctt.executar();

                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );

        tcd.botaoLimpar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                tcd.fieldCreditos.setText("");
                tcd.fieldFase.setText("");
                tcd.fieldNome.setText("");
                tcd.fieldQuantidadeAlunos.setText("");
                tcd.fieldCodigo.setText("");
            }
        }
        );

        //Botões do menu lateral
        tcd.botaoInicio.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tcd.dispose();
            }
        }
        );

        tcd.botaoSala.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableSala cts = new ControladorTelaTableSala();
                cts.executar();
                tcd.setVisible(false);
            }
        }
        );

        tcd.botaoProfessor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tcd.setVisible(false);
            }
        }
        );

        tcd.botaoVincular.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tcd.setVisible(false);
            }
        }
        );

        tcd.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableDisciplina ctt = new ControladorTelaTableDisciplina();
                ctt.executar();
                tcd.dispose();
            }
        });
        
        tcd.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tcd.dispose();
            }
        });

    }

    
    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    *
    */
    public void executar() {
        tcd.setVisible(true);
    }

}
