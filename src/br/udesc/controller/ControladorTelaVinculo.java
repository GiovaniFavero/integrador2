package br.udesc.controller;

import br.udesc.model.dao.CursoJpaController;
import br.udesc.model.dao.DisciplinaJpaController;
import br.udesc.model.dao.ProfessorJpaController;
import br.udesc.model.entidade.Curso;
import br.udesc.model.entidade.Disciplina;
import br.udesc.model.entidade.Professor;
import br.udesc.view.TelaVinculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe resposável pelo controle do módulo que vincula Curso, Sala, Professor e Disciplina.
 * @author PIN2
 */
public class ControladorTelaVinculo {

    private TelaVinculo tv;
    private Disciplina disciplina;
    private int edit = 0;

    /**
     * Construtor intanciando os objetos necessários e iniciando os componentes da Tela.
     */
    public ControladorTelaVinculo() {
        tv = new TelaVinculo();
        disciplina = new Disciplina();
        iniciar();
        validarComponenteFase(true);
        validarComponenteDisciplina(true);
    }

    /**
     * Método responsável por carregar cursos disponíveis no ComboBox.
     */
    public void carregarCurso() {
        CursoJpaController cjc = new CursoJpaController();
        tv.comboBoxCurso.removeAllItems();
        Curso s;
        List<Curso> listaCurso = cjc.listarCurso();
        for (Curso curso : listaCurso) {
            tv.comboBoxCurso.addItem(curso.getNome());
        }
        if (cjc.getCursoCount() != 0) {
            String a = (String) tv.comboBoxCurso.getSelectedItem();
            List<Curso> listCurso = cjc.validaCurso(a);
            carregarFase(listCurso.get(0).getListaDisciplina());
            carregarDisciplina(listCurso.get(0).getListaDisciplina());
        }

    }

    /**
     * Método responsável por carregar vínculo selecionado.
     * @param d Disciplina
     */
    public void carregarSelecionado(Disciplina d) {
        String fase = "";
        disciplina = d;
        
        for (int i = 0; i < tv.comboBoxCurso.getItemCount(); i++) {
            if (tv.comboBoxCurso.getItemAt(i).equalsIgnoreCase(disciplina.getCurso().getNome())) {
                tv.comboBoxCurso.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < tv.comboBoxFase.getItemCount(); i++) {
            if (tv.comboBoxFase.getItemAt(i).equalsIgnoreCase(disciplina.getFase())) {
                
                tv.comboBoxFase.setSelectedIndex(i);
                System.out.println("asdas");
                fase = String.valueOf(tv.comboBoxFase.getSelectedItem());
                break;
            }
        }
        System.out.println(fase + "fase");

        DisciplinaJpaController djc = new DisciplinaJpaController();
        List<Disciplina> dis = djc.listarDisciplinaPorFase(fase);
        carregarDisciplina(dis);
        for (int i = 0; i < tv.comboBoxDisciplina.getItemCount(); i++) {
            if (tv.comboBoxDisciplina.getItemAt(i).equalsIgnoreCase(disciplina.getNome())) {
                System.out.println("marcelo para de olhar a tela");
                System.out.println(i);
                System.out.println(disciplina.getNome());
                tv.comboBoxDisciplina.setSelectedIndex(i);
                break;
            }
        }

    }

    /**
     * Método responsável pela edição de Vínculo
     * @param d Disciplina
     */
    public void editar(Disciplina d) {
        disciplina = d;
        edit = 1;
        String fase = "";

        if (edit == 1) {
            for (int i = 0; i < tv.comboBoxCurso.getItemCount(); i++) {
                if (tv.comboBoxCurso.getItemAt(i).equalsIgnoreCase(disciplina.getCurso().getNome())) {
                    tv.comboBoxCurso.setSelectedIndex(i);
                    break;
                }
            }
        }

        for (int i = 0; i < tv.comboBoxFase.getItemCount(); i++) {
            if (tv.comboBoxFase.getItemAt(i).equalsIgnoreCase(disciplina.getFase())) {
                tv.comboBoxFase.setSelectedIndex(i);
                fase = String.valueOf(tv.comboBoxFase.getSelectedItem());
                break;
            }
        }
        if (edit == 1) {
            DisciplinaJpaController djc = new DisciplinaJpaController();
            List<Disciplina> dis = djc.listarDisciplinaPorFase(fase);
            carregarDisciplina(dis);
            for (int i = 0; i < tv.comboBoxDisciplina.getItemCount(); i++) {
                if (tv.comboBoxDisciplina.getItemAt(i).equalsIgnoreCase(disciplina.getNome())) {
                    System.out.println(i);
                    System.out.println(disciplina.getNome());
                    tv.comboBoxDisciplina.setSelectedIndex(i);
                    break;
                }
            }
        }
        if (edit == 1 && disciplina.getProfessor() != null) {
            for (int i = 0; i < tv.comboBoxProfessor.getItemCount(); i++) {
                if (tv.comboBoxProfessor.getItemAt(i).equalsIgnoreCase(disciplina.getProfessor().getNome())) {
                    tv.comboBoxProfessor.setSelectedIndex(i);
                    break;
                }
            }
        }

    }

    /**
     * Método responsável por carregar as fases do curso.
     * @param list Lista de Disciplinas.
     */
    public void carregarFase(List<Disciplina> list) {
        DisciplinaJpaController djc = new DisciplinaJpaController();
        tv.comboBoxFase.removeAllItems();
        List<Disciplina> listaDisciplina = list;
        ArrayList<Integer> aux = new ArrayList<>();
        if (djc.getDisciplinaCount() == 1 && aux.size() == 0) {
            tv.comboBoxFase.addItem(listaDisciplina.get(0).getFase());
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
                tv.comboBoxFase.addItem(String.valueOf(aux.get(i)));
            }
        }
    }

    /**
     * Método responsável por habilitar/desabilitar ComboBox de Fase.
     * @param validar Boolean.
     */
    public void validarComponenteFase(boolean validar) {
        tv.comboBoxFase.setEnabled(validar);
    }

    /**
     * Método responsável por habilitar/desabilitar ComboBox de Disciplina.
     * @param validar Boolean.
     */
    public void validarComponenteDisciplina(boolean validar) {
        tv.comboBoxDisciplina.setEnabled(validar);
    }

    /**
     * Método responsável por carregar Lista de disciplinas no ComboBox.
     * @param list Lista de Disciplinas.
     */
    public void carregarDisciplina(List<Disciplina> list) {
        DisciplinaJpaController djc = new DisciplinaJpaController();
        tv.comboBoxDisciplina.removeAllItems();
        List<Disciplina> listaDisciplina = list;
        for (Disciplina disciplina : listaDisciplina) {
            tv.comboBoxDisciplina.addItem(disciplina.getNome());
        }

    }

    /**
     * Método responsável por carregar professores dispiníveis no ComboBox.
     */
    public void carregarProfessor() {
        ProfessorJpaController pjc = new ProfessorJpaController();
        tv.comboBoxProfessor.removeAllItems();
        List<Professor> listaProfessor = pjc.listarProfessor();
        for (Professor professor : listaProfessor) {
            tv.comboBoxProfessor.addItem(professor.getNome());
        }
    }

    /**
     * Método responsável por limpar todos os ComboBox.
     */
    public void limpar() {
        tv.comboBoxFase.removeAllItems();
        tv.comboBoxDisciplina.removeAllItems();
        tv.comboBoxProfessor.removeAllItems();
    }

    /**
     * Método que inicia os componentes do JFrame (Botões etc).
     */
    public void iniciar() {

        limpar();
        carregarCurso();
        carregarProfessor();

        tv.comboBoxCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tv.comboBoxCurso.getItemCount() != 0) {
                    DisciplinaJpaController djc = new DisciplinaJpaController();
                    CursoJpaController cjc = new CursoJpaController();
                    String a = (String) tv.comboBoxCurso.getSelectedItem();
                    List<Curso> listCurso = cjc.validaCurso(a);
                    carregarFase(listCurso.get(0).getListaDisciplina());
                    carregarDisciplina(listCurso.get(0).getListaDisciplina());
                    validarComponenteFase(true);
                }
            }
        });

        //Carregar as disciplinas por fase
        tv.comboBoxFase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tv.comboBoxFase.getItemCount() != 0) {
                    CursoJpaController cjc = new CursoJpaController();
                    String a = (String) tv.comboBoxCurso.getSelectedItem();
                    String b = (String) tv.comboBoxFase.getSelectedItem();
                    List<Curso> listCurso = cjc.validaCurso(a);
                    List<Disciplina> aux = new ArrayList<>();
                    for (int i = 0; i < listCurso.get(0).getListaDisciplina().size(); i++) {
                        if (!(listCurso.get(0).getListaDisciplina().get(i).getFase().equals(b))) {
                        } else {
                            aux.add(listCurso.get(0).getListaDisciplina().get(i));
                        }
                    }
                    carregarDisciplina(aux);
                    validarComponenteDisciplina(true);
                }
            }
        });

        tv.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (edit == 0) {
                    if (tv.comboBoxDisciplina.getItemCount() != 0 && tv.comboBoxProfessor.getItemCount() != 0) {
                        ProfessorJpaController pjc = new ProfessorJpaController();
                        List<Professor> listaProfessor;

                        DisciplinaJpaController djc = new DisciplinaJpaController();
                        List<Disciplina> listaDisciplina;

                        CursoJpaController cjc = new CursoJpaController();
                        List<Curso> listaCurso;

                        String curso = (String) tv.comboBoxCurso.getSelectedItem();
                        listaCurso = cjc.validaCurso(curso);

                        String disciplina = (String) tv.comboBoxDisciplina.getSelectedItem();
                        listaDisciplina = djc.validaDisciplinaNome(disciplina);

                        String profesor = (String) tv.comboBoxProfessor.getSelectedItem();
                        listaProfessor = pjc.validaProfessor(profesor);

                        try {
                            if (listaDisciplina.get(0).getProfessor() == null) {
                                JOptionPane.showMessageDialog(null, "O professor " + profesor + " foi colocado com a disciplina " + disciplina, "Sucesso", JOptionPane.PLAIN_MESSAGE);
                                listaDisciplina.get(0).setProfessor(listaProfessor.get(0));
                                listaProfessor.get(0).addDisciplina(listaDisciplina.get(0));
                                pjc.edit(listaProfessor.get(0));
                                djc.edit(listaDisciplina.get(0));
                            } else {
                                if (listaDisciplina.get(0).getProfessor().getNome().equalsIgnoreCase(listaProfessor.get(0).getNome())) {
                                    JOptionPane.showMessageDialog(null, "O professor " + profesor + " já estava veinculado com a disciplina: " + disciplina, "Professor já cadastrado", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Você só pode cadastrar um professor por disciplina", "Erro", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Primeiro crie dados antes de tentar veincular eles", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    ProfessorJpaController pjc = new ProfessorJpaController();
                    List<Professor> listaProfessor;

                    DisciplinaJpaController djc = new DisciplinaJpaController();
                    List<Disciplina> listaDisciplina;

                    CursoJpaController cjc = new CursoJpaController();
                    List<Curso> listaCurso;

                    String curso = (String) tv.comboBoxCurso.getSelectedItem();
                    listaCurso = cjc.validaCurso(curso);

                    String disciplina = (String) tv.comboBoxDisciplina.getSelectedItem();
                    listaDisciplina = djc.validaDisciplinaNome(disciplina);

                    String profesor = (String) tv.comboBoxProfessor.getSelectedItem();
                    listaProfessor = pjc.validaProfessor(profesor);

                    try {
                        if (listaDisciplina.get(0).getProfessor() == null) {
                            JOptionPane.showMessageDialog(null, "O professor " + profesor + " foi colocado com a disciplina " + disciplina, "Sucesso", JOptionPane.PLAIN_MESSAGE);
                            listaDisciplina.get(0).setProfessor(listaProfessor.get(0));
                            listaProfessor.get(0).addDisciplina(listaDisciplina.get(0));
                            pjc.edit(listaProfessor.get(0));
                            djc.edit(listaDisciplina.get(0));
                        } else {
                            if (listaDisciplina.get(0).getProfessor().getNome().equalsIgnoreCase(listaProfessor.get(0).getNome())) {
                                JOptionPane.showMessageDialog(null, "O professor " + profesor + " já estava veinculado com a disciplina: " + disciplina, "Professor já cadastrado", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Você só pode cadastrar um professor por disciplina", "Erro", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        tv.botaoDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CursoJpaController cjc = new CursoJpaController();
                if (cjc.getCursoCount() != 0) {
                    ControladorTelaTableDisciplina cttd = new ControladorTelaTableDisciplina();
                    cttd.executar();
                    tv.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Antes cadastre um curso", "Cadastre um curso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tv.botaoProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableProfessor cttp = new ControladorTelaTableProfessor();
                cttp.executar();
                tv.setVisible(false);
            }
        });

        tv.botaoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaInicio cti = new ControladorTelaInicio();
                cti.executar();
                tv.dispose();
            }
        });

        tv.botaoSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ControladorTelaTableSala ctts = new ControladorTelaTableSala();
                ctts.executar();
                tv.setVisible(false);
            }
        });

        tv.botaoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorTelaTableCurso cttc = new ControladorTelaTableCurso();
                cttc.executar();
                tv.dispose();
            }
        });
    }

    /**
    * Método responsável por inicializar a tela controlada por esta classe.
    */
    public void executar() {
        tv.setVisible(true);
    }
}
