/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.view;

/**
 *
 * @author anderson
 */
public class TelaCadastroDisciplina extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroDisciplina
     */
    public TelaCadastroDisciplina() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        conteudoPanel = new javax.swing.JPanel();
        fieldCreditos = new javax.swing.JTextField();
        creditosLabel = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        faseLabel = new javax.swing.JLabel();
        fieldFase = new javax.swing.JTextField();
        tpioLabel = new javax.swing.JLabel();
        fieldTipo = new javax.swing.JTextField();
        qtdAlunoLabel = new javax.swing.JLabel();
        fieldQuantidadeAlunos = new javax.swing.JTextField();
        botaoLimpar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        comboBoxCurso = new javax.swing.JComboBox<>();
        labelCurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProfessor = new javax.swing.JComboBox<>();
        labelProfessor = new javax.swing.JLabel();
        menuRapidoPanel = new javax.swing.JPanel();
        menuLabel = new javax.swing.JLabel();
        botaoInicio = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoDisciplina = new javax.swing.JButton();

        setTitle("Cadastro de Disciplina");
        setMinimumSize(new java.awt.Dimension(440, 390));

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloLabel.setText("Cadastro de Disciplina");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fieldCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCreditosActionPerformed(evt);
            }
        });

        creditosLabel.setText("Créditos");

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        faseLabel.setText("Fase");

        fieldFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFaseActionPerformed(evt);
            }
        });

        tpioLabel.setText("Tipo");

        fieldTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTipoActionPerformed(evt);
            }
        });

        qtdAlunoLabel.setText("Quantidade de Alunos");

        fieldQuantidadeAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQuantidadeAlunosActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");

        comboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursoActionPerformed(evt);
            }
        });

        labelCurso.setText("Curso");

        jLabel1.setText("Nome");

        comboBoxProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelProfessor.setText("Professor");

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(conteudoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(qtdAlunoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldQuantidadeAlunos))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, conteudoPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(faseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldFase, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(tpioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, conteudoPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelCurso)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(conteudoPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(creditosLabel)
                                .addGap(18, 18, 18)
                                .addComponent(fieldCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(conteudoPanelLayout.createSequentialGroup()
                                .addComponent(labelProfessor)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCurso))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditosLabel))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpioLabel))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldQuantidadeAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdAlunoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProfessor))
                .addGap(19, 19, 19)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        menuLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        menuLabel.setText("Menu");

        botaoInicio.setText("Início");
        botaoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBotao3ActionPerformed(evt);
            }
        });

        botaoSala.setText("Sala");
        botaoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSala4ActionPerformed(evt);
            }
        });

        botaoProfessor.setText("Professor");

        botaoDisciplina.setText("Disciplina");
        botaoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinaBotao3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuRapidoPanelLayout = new javax.swing.GroupLayout(menuRapidoPanel);
        menuRapidoPanel.setLayout(menuRapidoPanelLayout);
        menuRapidoPanelLayout.setHorizontalGroup(
            menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuRapidoPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botaoProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addComponent(botaoSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRapidoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuLabel)
                .addGap(36, 36, 36))
        );
        menuRapidoPanelLayout.setVerticalGroup(
            menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuRapidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuLabel)
                .addGap(18, 18, 18)
                .addComponent(botaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoSala)
                .addGap(18, 18, 18)
                .addComponent(botaoProfessor)
                .addGap(18, 18, 18)
                .addComponent(botaoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conteudoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuRapidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuRapidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(conteudoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCreditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCreditosActionPerformed

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void fieldFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFaseActionPerformed

    private void fieldTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTipoActionPerformed

    private void fieldQuantidadeAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQuantidadeAlunosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldQuantidadeAlunosActionPerformed

    private void disciplinaBotao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinaBotao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disciplinaBotao3ActionPerformed

    private void botaoSala4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSala4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSala4ActionPerformed

    private void inicioBotao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBotao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioBotao3ActionPerformed

    private void comboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCursoActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoLimparActionPerformed

    /**
     * @param args the command line arguments
     */

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botaoDisciplina;
    public javax.swing.JButton botaoInicio;
    public javax.swing.JButton botaoLimpar;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoSala;
    public javax.swing.JButton botaoSalvar;
    public javax.swing.JComboBox<String> comboBoxCurso;
    public javax.swing.JComboBox<String> comboBoxProfessor;
    public javax.swing.JPanel conteudoPanel;
    public javax.swing.JLabel creditosLabel;
    public javax.swing.JLabel faseLabel;
    public javax.swing.JTextField fieldCreditos;
    public javax.swing.JTextField fieldFase;
    public javax.swing.JTextField fieldNome;
    public javax.swing.JTextField fieldQuantidadeAlunos;
    public javax.swing.JTextField fieldTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelProfessor;
    public javax.swing.JLabel menuLabel;
    public javax.swing.JPanel menuRapidoPanel;
    public javax.swing.JLabel qtdAlunoLabel;
    public javax.swing.JLabel tituloLabel;
    public javax.swing.JPanel tituloPanel;
    public javax.swing.JLabel tpioLabel;
    // End of variables declaration//GEN-END:variables
}
