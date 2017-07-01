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
        layoutBtms();
    }

    public void layoutBtms() {
        botaoInicio.setBorderPainted(false);
        botaoInicio.setFocusPainted(false);
        botaoInicio.setContentAreaFilled(false);
        
        botaoVincular.setBorderPainted(false);
        botaoVincular.setFocusPainted(false);
        botaoVincular.setContentAreaFilled(false);
        
        botaoProfessor.setBorderPainted(false);
        botaoProfessor.setFocusPainted(false);
        botaoProfessor.setContentAreaFilled(false);
        
        botaoSala.setBorderPainted(false);
        botaoSala.setFocusPainted(false);
        botaoSala.setContentAreaFilled(false);
        
        botaoCurso.setBorderPainted(false);
        botaoCurso.setFocusPainted(false);
        botaoCurso.setContentAreaFilled(false);
        
        botaoLimpar.setBorderPainted(false);
        botaoLimpar.setFocusPainted(false);
        botaoLimpar.setContentAreaFilled(false);
        
        botaoSalvar.setBorderPainted(false);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setContentAreaFilled(false);
        
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setContentAreaFilled(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        areaTotal = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        conteudoPanel = new javax.swing.JPanel();
        fieldCreditos = new javax.swing.JTextField();
        creditosLabel = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        faseLabel = new javax.swing.JLabel();
        fieldFase = new javax.swing.JTextField();
        tpioLabel = new javax.swing.JLabel();
        qtdAlunoLabel = new javax.swing.JLabel();
        fieldQuantidadeAlunos = new javax.swing.JTextField();
        botaoLimpar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        comboBoxCurso = new javax.swing.JComboBox<>();
        labelCurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        comboBoxSala = new javax.swing.JComboBox<>();
        menuRapidoPanel = new javax.swing.JPanel();
        botaoInicio = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoCurso = new javax.swing.JButton();
        botaoVincular = new javax.swing.JButton();

        setTitle("Cadastro de Disciplina");
        setMaximumSize(new java.awt.Dimension(565, 610));
        setMinimumSize(new java.awt.Dimension(565, 610));
        setPreferredSize(new java.awt.Dimension(565, 610));

        areaTotal.setMaximumSize(new java.awt.Dimension(553, 555));
        areaTotal.setMinimumSize(new java.awt.Dimension(553, 555));
        areaTotal.setPreferredSize(new java.awt.Dimension(553, 555));
        areaTotal.setRequestFocusEnabled(false);
        areaTotal.setLayout(new java.awt.GridBagLayout());

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setToolTipText("");
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloLabel.setText("Cadastro de Disciplina");
        tituloPanel.add(tituloLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotal.add(tituloPanel, gridBagConstraints);

        conteudoPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setPreferredSize(new java.awt.Dimension(540, 400));

        fieldCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCreditosActionPerformed(evt);
            }
        });

        creditosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        creditosLabel.setText("Créditos");

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        faseLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faseLabel.setText("Fase");

        fieldFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFaseActionPerformed(evt);
            }
        });

        tpioLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tpioLabel.setText("Sala");

        qtdAlunoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qtdAlunoLabel.setText("Qtd Alunos");

        fieldQuantidadeAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQuantidadeAlunosActionPerformed(evt);
            }
        });

        botaoLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon.png"))); // NOI18N
        botaoLimpar.setText("Limpar");
        botaoLimpar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoLimpar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoLimpar.setPreferredSize(new java.awt.Dimension(110, 25));
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoSalvar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoSalvar.setPreferredSize(new java.awt.Dimension(110, 25));

        comboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCurso.setMaximumSize(new java.awt.Dimension(39, 20));
        comboBoxCurso.setMinimumSize(new java.awt.Dimension(39, 20));
        comboBoxCurso.setPreferredSize(new java.awt.Dimension(39, 20));
        comboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursoActionPerformed(evt);
            }
        });

        labelCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCurso.setText("Curso");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código Disciplina");

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/left-arrow.png"))); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoVoltar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoVoltar.setPreferredSize(new java.awt.Dimension(110, 25));

        comboBoxSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSala.setMaximumSize(new java.awt.Dimension(39, 20));
        comboBoxSala.setMinimumSize(new java.awt.Dimension(39, 20));
        comboBoxSala.setPreferredSize(new java.awt.Dimension(39, 20));

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(creditosLabel)
                    .addComponent(labelCurso)
                    .addComponent(tpioLabel)
                    .addComponent(jLabel2)
                    .addComponent(faseLabel)
                    .addComponent(qtdAlunoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldCreditos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fieldQuantidadeAlunos)
                        .addComponent(fieldFase)
                        .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(conteudoPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCurso, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxSala, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpioLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldCreditos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditosLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldFase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(faseLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldQuantidadeAlunos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdAlunoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotal.add(conteudoPanel, gridBagConstraints);

        menuRapidoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Menu de Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        menuRapidoPanel.setMaximumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setMinimumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setPreferredSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setLayout(new java.awt.GridLayout(1, 0));

        botaoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon (1).png"))); // NOI18N
        botaoInicio.setText("Início");
        botaoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBotao3ActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoInicio);

        botaoSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sala_24.png"))); // NOI18N
        botaoSala.setText("Sala");
        botaoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSala4ActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoSala);

        botaoProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/professor_24.png"))); // NOI18N
        botaoProfessor.setText("Prof");
        menuRapidoPanel.add(botaoProfessor);

        botaoCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Curso24.png"))); // NOI18N
        botaoCurso.setText("Curso");
        botaoCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCursoActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoCurso);

        botaoVincular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Vincular.png"))); // NOI18N
        botaoVincular.setText("Vincular");
        menuRapidoPanel.add(botaoVincular);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotal.add(menuRapidoPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(areaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
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

    private void fieldQuantidadeAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQuantidadeAlunosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldQuantidadeAlunosActionPerformed

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

    private void botaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCursoActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaTotal;
    public javax.swing.JButton botaoCurso;
    public javax.swing.JButton botaoInicio;
    public javax.swing.JButton botaoLimpar;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoSala;
    public javax.swing.JButton botaoSalvar;
    public javax.swing.JButton botaoVincular;
    public javax.swing.JButton botaoVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> comboBoxCurso;
    public javax.swing.JComboBox<String> comboBoxSala;
    public javax.swing.JPanel conteudoPanel;
    public javax.swing.JLabel creditosLabel;
    public javax.swing.JLabel faseLabel;
    public javax.swing.JTextField fieldCodigo;
    public javax.swing.JTextField fieldCreditos;
    public javax.swing.JTextField fieldFase;
    public javax.swing.JTextField fieldNome;
    public javax.swing.JTextField fieldQuantidadeAlunos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCurso;
    public javax.swing.JPanel menuRapidoPanel;
    public javax.swing.JLabel qtdAlunoLabel;
    public javax.swing.JLabel tituloLabel;
    public javax.swing.JPanel tituloPanel;
    public javax.swing.JLabel tpioLabel;
    // End of variables declaration//GEN-END:variables
}
