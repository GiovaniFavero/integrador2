package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaCadastroDisciplina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorTelaCadastroDisciplina {

    private TelaCadastroDisciplina tcd;

    public ControladorTelaCadastroDisciplina() {
        tcd = new TelaCadastroDisciplina();
        iniciar();
    }

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
        if (tcd.fieldTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher o tipo da disciplina", "Erro", JOptionPane.WARNING_MESSAGE);
            tcd.fieldTipo.requestFocus();
            return false;
        }
        if (tcd.fieldQuantidadeAlunos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher a quantidade de alunos", "Erro", JOptionPane.WARNING_MESSAGE);
            tcd.fieldQuantidadeAlunos.requestFocus();
            return false;
        }

        return true;
    }

    public void carregarCursos() {
        CursoJpaController cjc = new CursoJpaController();
        tcd.comboBoxCurso.removeAllItems();
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso : listaCurso) {
            tcd.comboBoxCurso.addItem(curso.getNome());
        }

    }

    public void iniciar() {
        carregarCursos();

        tcd.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DisciplinaJpaController djc = new DisciplinaJpaController();
                CursoJpaController cjc = new CursoJpaController();
                ProfessorJpaController pjc = new ProfessorJpaController();

                //Localizar o curso
                String nomeCurso = (String) tcd.comboBoxCurso.getSelectedItem();
                List<Curso> curso = cjc.validaCurso(nomeCurso);

                try {
                    if (validarCampos() == true) {
                        if (djc.validaDisciplina(tcd.fieldCodigo.getText()) == null) {

                            //Converter os campos
                            int creditos = Integer.parseInt(tcd.fieldCreditos.getText());
                            int tipo = Integer.parseInt(tcd.fieldTipo.getText());
                            int quantidade = Integer.parseInt(tcd.fieldQuantidadeAlunos.getText());

                            //Para quando NÃO houver professor
                            //Cria a disciplina
                            Disciplina disciplina = new Disciplina(tcd.fieldNome.getText(), creditos, tcd.fieldFase.getText(), tipo, quantidade, tcd.fieldCodigo.getText(), curso.get(0), null);
                            djc.create(disciplina);

                            curso.get(0).addListaDisciplina(disciplina);
                            cjc.edit(curso.get(0));
                            System.out.println(curso.get(0).getListaDisciplina().size() + "Size arraydisciplina em curso");
                            System.out.println(disciplina.toString());
                            JOptionPane.showMessageDialog(null, "Disciplina criado com sucesso");
                            tcd.fieldTipo.setText("");
                            tcd.fieldFase.setText("");
                            tcd.fieldNome.setText("");
                            tcd.fieldQuantidadeAlunos.setText("");
                            tcd.fieldCreditos.setText("");
                            tcd.fieldCodigo.setText("");

                        } else {
                            JOptionPane.showMessageDialog(null, "Matéria já existente", "Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        tcd.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcd.fieldCreditos.setText("");
                tcd.fieldFase.setText("");
                tcd.fieldNome.setText("");
                tcd.fieldQuantidadeAlunos.setText("");
                tcd.fieldTipo.setText("");
                tcd.fieldCodigo.setText("");
            }
        });

        //Botões do menu lateral
        tcd.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tcd.setVisible(false);
            }
        });

        tcd.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala ctcs = new ControladorTelaCadastroSala();
                ctcs.executar();
                tcd.setVisible(false);
            }
        });

        tcd.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroProfessor ctcp = new ControladorTelaCadastroProfessor();
                ctcp.executar();
                tcd.setVisible(false);
            }
        });
        
         tcd.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                tcd.setVisible(false);
            }
        });

    }

    public void executar() {
        tcd.setVisible(true);
    }

}
