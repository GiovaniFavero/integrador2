/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.dao.SalaJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.model.entidade.Sala;
import br.udesc.view.TelaEditar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 5105011523
 */
public class ControladorTelaEditar {

    private TelaEditar ted;

    public ControladorTelaEditar() {
        ted = new TelaEditar();
        iniciar();
        validarComponentesProfessor(false);
        validarComponentesDisciplina(false);

    }

    public void carregarProfessor() {
        ProfessorJpaController pjc = new ProfessorJpaController();
        ted.comboBoxProfessorProfessor.removeAllItems();
        ted.comboBoxProfessorDisciplina.removeAllItems();
        ted.comboBoxProfessorDisciplina.addItem("Null");
        List<Professor> listaProfessor = pjc.listarProfessor();
        for (Professor professor : listaProfessor) {
            ted.comboBoxProfessorProfessor.addItem(professor.getNome());
            ted.comboBoxProfessorDisciplina.addItem(professor.getNome());
        }
    }

    public void carregarCurso() {
        CursoJpaController cjc = new CursoJpaController();
        ted.comboBoxCursoDisciplina.removeAllItems();
        ted.comboBoxDisciplinaDisciplina.removeAllItems();
        ted.comboBoxFaseDesciplina.removeAllItems();
        Curso s;
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso : listaCurso) {
            ted.comboBoxCursoDisciplina.addItem(curso.getNome());
        }

    }

    public void carregarDisciplina(List<Disciplina> list) {
        DisciplinaJpaController djc = new DisciplinaJpaController();
        ted.comboBoxDisciplinaDisciplina.removeAllItems();
        List<Disciplina> listaDisciplina = list;
        for (Disciplina disciplina : listaDisciplina) {
            ted.comboBoxDisciplinaDisciplina.addItem(disciplina.getNome());
        }

    }

    public void carregarSala() {
        SalaJpaController sjc = new SalaJpaController();
        ted.comboBoxSalaSala.removeAllItems();
        List<Sala> listaSala = sjc.listarSala();
        ArrayList<Integer> aux = new ArrayList<>();
        if (sjc.getSalaCount() == 1 && aux.size() == 0) {
            ted.comboBoxSalaSala.addItem(listaSala.get(0).getNumero());
        } else {
            boolean achou = false;
            for (int i = 0; i < listaSala.size(); i++) {
                achou = false;
                int x = Integer.parseInt(listaSala.get(i).getNumero());
                for (int j = 0; j < aux.size(); j++) {
                    if (x == aux.get(j)) {
                        achou = true;
                        break;
                    }
                }
                if (achou == false) {
                    aux.add(x);
                }
            }

            Collections.sort(aux);
            for (int i = 0; i < aux.size(); i++) {
                ted.comboBoxSalaSala.addItem(String.valueOf(aux.get(i)));
            }
        }
    }

    public void carregarFase(List<Disciplina> list) {
        DisciplinaJpaController djc = new DisciplinaJpaController();
        ted.comboBoxFaseDesciplina.removeAllItems();
        List<Disciplina> listaDisciplina = list;
        ArrayList<Integer> aux = new ArrayList<>();
        if (djc.getDisciplinaCount() == 1 && aux.size() == 0) {
            ted.comboBoxFaseDesciplina.addItem(listaDisciplina.get(0).getFase());
        } else {
            boolean achou = false;
            for (int i = 0; i < listaDisciplina.size(); i++) {
                achou = false;
                int x = Integer.parseInt(listaDisciplina.get(i).getFase());
                for (int j = 0; j < aux.size(); j++) {
                    if (x == aux.get(j)) {
                        achou = true;
                        break;
                    }
                }
                if (achou == false) {
                    aux.add(x);
                }
            }

            Collections.sort(aux);
            for (int i = 0; i < aux.size(); i++) {
                ted.comboBoxFaseDesciplina.addItem(String.valueOf(aux.get(i)));
            }

        }

    }

    public void validarComponentesProfessor(boolean validar) {
        ted.fieldCpfProfessor.setEditable(validar);
        ted.fieldNomeProfessor.setEditable(validar);
    }

    public void validarComponentesDisciplina(boolean val) {
        ted.comboBoxDisciplinaDisciplina.setEnabled(val);
        ted.comboBoxFaseDesciplina.setEnabled(val);
    }

    public void iniciar() {
        carregarSala();
        carregarProfessor();
        carregarCurso();

        //Botões
        ted.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ted.setVisible(false);
            }
        });
        
        ted.botaoVincular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaVinculo ctv = new ControladorTelaVinculo();
                ctv.executar();
                ted.setVisible(false);
            }
        });

        ted.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroProfessor ctcp = new ControladorTelaCadastroProfessor();
                ted.setVisible(false);
                ctcp.executar();
            }
        });

        ted.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaCadastroSala ctcs = new ControladorTelaCadastroSala();
                ted.setVisible(false);
                ctcs.executar();
            }
        });

        ted.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaCadastroDisciplina ctcd = new ControladorTelaCadastroDisciplina();
                    ted.setVisible(false);
                    ctcd.executar();
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        ted.botaoLimparProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ted.fieldCpfProfessor.setText("");
                ted.fieldNomeProfessor.setText("");
            }
        });

        //Editar professor
        ted.comboBoxProfessorProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ted.comboBoxProfessorProfessor.getItemCount() != 0) {
                    ProfessorJpaController pjc = new ProfessorJpaController();
                    List<Professor> listaProfessor;
                    String a = (String) ted.comboBoxProfessorProfessor.getSelectedItem();
                    listaProfessor = pjc.validaProfessor(a);
                    ted.fieldNomeProfessor.setText(listaProfessor.get(0).getNome());
                    ted.fieldCpfProfessor.setText(listaProfessor.get(0).getCpf());
                    validarComponentesProfessor(true);
                }
            }
        });

        ted.botaoSalvarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ted.comboBoxProfessorProfessor.getItemCount() != 0) {
                    ProfessorJpaController pjc = new ProfessorJpaController();
                    List<Professor> listaProfessor;
                    String a = (String) ted.comboBoxProfessorProfessor.getSelectedItem();

                    listaProfessor = pjc.validaProfessor(a);
                    listaProfessor.get(0).setNome(ted.fieldNomeProfessor.getText());
                    listaProfessor.get(0).setCpf(ted.fieldCpfProfessor.getText());
                    JOptionPane.showMessageDialog(null, "Professor editado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        pjc.edit(listaProfessor.get(0));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    carregarProfessor();

                    ted.fieldNomeProfessor.setText("");
                    ted.fieldCpfProfessor.setText("");
                    validarComponentesProfessor(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Primeiro cadastre um professor antes de tentar editar ele", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Editar Sala
        ted.comboBoxSalaSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ted.comboBoxSalaSala.getItemCount() != 0) {
                    SalaJpaController sjc = new SalaJpaController();
                    String box = (String) ted.comboBoxSalaSala.getSelectedItem();
                    List<Sala> listaSala = sjc.validaSala(box);
                    Sala aux = listaSala.get(0);

                    ted.fieldNumeroSala.setText(aux.getNumero());
                    ted.fieldLimiteSalas.setText(String.valueOf(aux.getLimite()));
                    if (aux.getTipo() == false) {
                        ted.radioSala.doClick();

                    } else {
                        ted.radioLaboratorio.doClick();
                    }
                }
            }
        });
        
        ted.botaoSalvarSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ted.comboBoxSalaSala.getItemCount() != 0){
                    SalaJpaController sjc = new SalaJpaController();
                    String box = (String) ted.comboBoxSalaSala.getSelectedItem();
                    List<Sala> listaSala = sjc.validaSala(box);
                    Sala aux = listaSala.get(0);
                    
                    aux.setNumero(ted.fieldNumeroSala.getText());
                    aux.setLimite(Integer.parseInt(ted.fieldLimiteSalas.getText()));
                    if(ted.radioSala.isSelected()){
                        aux.setTipo(false);
                    } else{
                        aux.setTipo(true);
                    }
                    
                    try {
                        sjc.edit(aux);
                        JOptionPane.showMessageDialog(null, "Sala editada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                } else{
                     JOptionPane.showMessageDialog(null, "Primeiro cadastre uma sala antes de tentar edita-a", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

//        //Editar disciplina
//        ted.comboBoxCursoDisciplina.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (ted.comboBoxCursoDisciplina.getItemCount() != 0) {
//                    DisciplinaJpaController djc = new DisciplinaJpaController();
//                    CursoJpaController cjc = new CursoJpaController();
//                    String a = (String) ted.comboBoxCursoDisciplina.getSelectedItem();
//                    List<Curso> listCurso = cjc.validaCurso(a);
//                    carregarFase(listCurso.get(0).getListaDisciplina());
//                    ted.comboBoxFaseDesciplina.setEnabled(true);
//
//                }
//            }
//        });
//
//        ted.comboBoxFaseDesciplina.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (ted.comboBoxFaseDesciplina.getItemCount() != 0) {
//                    CursoJpaController cjc = new CursoJpaController();
//                    String a = (String) ted.comboBoxCursoDisciplina.getSelectedItem();
//                    String b = (String) ted.comboBoxFaseDesciplina.getSelectedItem();
//                    List<Curso> listCurso = cjc.validaCurso(a);
//                    List<Disciplina> aux = new ArrayList<>();
//                    for (int i = 0; i < listCurso.get(0).getListaDisciplina().size(); i++) {
//                        if (!(listCurso.get(0).getListaDisciplina().get(i).getFase().equals(b))) {
//                        } else {
//                            aux.add(listCurso.get(0).getListaDisciplina().get(i));
//                        }
//                    }
//                    carregarDisciplina(aux);
//                    ted.comboBoxDisciplinaDisciplina.setEnabled(true);
//                }
//            }
//        });
//
//        ted.comboBoxDisciplinaDisciplina.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (ted.comboBoxDisciplinaDisciplina.getItemCount() != 0) {
//                    String a = (String) ted.comboBoxDisciplinaDisciplina.getSelectedItem();
//                    DisciplinaJpaController djc = new DisciplinaJpaController();
//                    List<Disciplina> disciplina = djc.validaDisciplinaNome(a);
//                    Disciplina aux = disciplina.get(0);
//                    ted.fieldNomeDisciplina.setText(aux.getNome());
//                    ted.fieldFaseDisciplina.setText(aux.getFase());
//                    ted.fieldCodigoDisciplina.setText(aux.getCodigo());
//                    ted.fieldCreditosDisciplina.setText(String.valueOf(aux.getCreditos()));
//                    ted.fieldTipoDisciplina.setText(String.valueOf(aux.getTipo()));
//                    ted.fieldQuantidadeAlunosDisciplina.setText(String.valueOf(aux.getQtdAlunos()));
//
//                }
//            }
//        });
//
//        ted.botaoSalvarDisplina.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (ted.comboBoxDisciplinaDisciplina.getItemCount() != 0) {
//                    ProfessorJpaController pjc = new ProfessorJpaController();
//                    String a = (String) ted.comboBoxDisciplinaDisciplina.getSelectedItem();
//                    List<Professor> listaProfessor;
//                    DisciplinaJpaController djc = new DisciplinaJpaController();
//                    List<Disciplina> disciplina = djc.validaDisciplinaNome(a);
//                    Disciplina aux = disciplina.get(0);
//                    String professor = (String) ted.comboBoxProfessorDisciplina.getSelectedItem();
//
//                    if (aux.getProfessor() == null) {
//                        //Caso seja o mesmo código de disciplina
//                        if (ted.fieldCodigoDisciplina.getText().equals(aux.getCodigo())) {
//                            aux.setNome(ted.fieldNomeDisciplina.getText());
//                            aux.setFase(ted.fieldFaseDisciplina.getText());
//                            aux.setQtdAlunos(Integer.parseInt(ted.fieldQuantidadeAlunosDisciplina.getText()));
//                            aux.setCreditos(Integer.parseInt(ted.fieldCreditosDisciplina.getText()));
//                            aux.setTipo(Integer.parseInt(ted.fieldTipoDisciplina.getText()));
//
//                            //Caso queira manter a disciplina sem professor por enquanto
//                            if (professor.equalsIgnoreCase("null")) {
//                                try {
//                                    djc.edit(aux);
//                                } catch (Exception ex) {
//                                    ex.printStackTrace();
//                                }
//
//                            } else {
//                                //Caso queria acrescer um professor em uma disciplina que não tinha
//                                listaProfessor = pjc.validaProfessor(professor);
//                                aux.setProfessor(listaProfessor.get(0));
//                                listaProfessor.get(0).addDisciplina(aux);
//                                try {
//
//                                } catch (Exception ex) {
//                                    ex.printStackTrace();
//                                }
//
//                            }
//                        } else {
//                            //Caso seja um outro codigo de disciplina ele verifica se já existe alguma com esse codigo
//                            if (djc.validaDisciplina(ted.fieldCodigoDisciplina.getText()) == null) {
//
//                            }
//
//                        }
//
//                    } else {
//                        if (ted.fieldCodigoDisciplina.getText().equals(aux.getCodigo())) {
//                            aux.setNome(ted.fieldNomeDisciplina.getText());
//                            aux.setFase(ted.fieldFaseDisciplina.getText());
//                            aux.setQtdAlunos(Integer.parseInt(ted.fieldQuantidadeAlunosDisciplina.getText()));
//                            aux.setCreditos(Integer.parseInt(ted.fieldCreditosDisciplina.getText()));
//                            aux.setTipo(Integer.parseInt(ted.fieldTipoDisciplina.getText()));
//
//                        } else {
//
//                        }
//
//                    }
//
//                }
//
//            }
//        });
    }

    public void executar() {
        ted.setVisible(true);
    }

}
