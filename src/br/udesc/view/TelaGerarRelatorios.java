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
public class TelaGerarRelatorios extends javax.swing.JFrame {

    
    public TelaGerarRelatorios() {
        initComponents();
        layoutBtms();
    }
    
    public void layoutBtms() {
        botaoConflitoCreditos.setBorderPainted(false);
        botaoConflitoCreditos.setFocusPainted(false);
        botaoConflitoCreditos.setContentAreaFilled(false);
        
        botaoConHorarioProibido.setBorderPainted(false);
        botaoConHorarioProibido.setFocusPainted(false);
        botaoConHorarioProibido.setContentAreaFilled(false);
        
        botaoDisciplinaOrfao.setBorderPainted(false);
        botaoDisciplinaOrfao.setFocusPainted(false);
        botaoDisciplinaOrfao.setContentAreaFilled(false);
        
        botaoPorFase.setBorderPainted(false);
        botaoPorFase.setFocusPainted(false);
        botaoPorFase.setContentAreaFilled(false);
        
        botaoPorProfessor.setBorderPainted(false);
        botaoPorProfessor.setFocusPainted(false);
        botaoPorProfessor.setContentAreaFilled(false);
        
        botaoPorLaboratorio.setBorderPainted(false);
        botaoPorLaboratorio.setFocusPainted(false);
        botaoPorLaboratorio.setContentAreaFilled(false);
        
        botaoCurso.setBorderPainted(false);
        botaoCurso.setFocusPainted(false);
        botaoCurso.setContentAreaFilled(false);
        
        botaoDisciplina.setBorderPainted(false);
        botaoDisciplina.setFocusPainted(false);
        botaoDisciplina.setContentAreaFilled(false);
        
        botaoInicio.setBorderPainted(false);
        botaoInicio.setFocusPainted(false);
        botaoInicio.setContentAreaFilled(false);
        
        botaoProfessor.setBorderPainted(false);
        botaoProfessor.setFocusPainted(false);
        botaoProfessor.setContentAreaFilled(false);
        
        botaoSala.setBorderPainted(false);
        botaoSala.setFocusPainted(false);
        botaoSala.setContentAreaFilled(false);
        
        botaoVincular.setBorderPainted(false);
        botaoVincular.setFocusPainted(false);
        botaoVincular.setContentAreaFilled(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        areaTotal = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        conteudoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        areaLabelConteudo = new javax.swing.JPanel();
        selecioneLabel = new javax.swing.JLabel();
        areaBtm = new javax.swing.JPanel();
        espacoE = new javax.swing.JPanel();
        espacoD = new javax.swing.JPanel();
        btmE = new javax.swing.JPanel();
        botaoConflitoCreditos = new javax.swing.JButton();
        botaoDisciplinaOrfao = new javax.swing.JButton();
        botaoPorProfessor = new javax.swing.JButton();
        btmD = new javax.swing.JPanel();
        botaoConHorarioProibido = new javax.swing.JButton();
        botaoPorFase = new javax.swing.JButton();
        botaoPorLaboratorio = new javax.swing.JButton();
        menuRapidoPanel = new javax.swing.JPanel();
        botaoInicio = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoDisciplina = new javax.swing.JButton();
        botaoCurso = new javax.swing.JButton();
        botaoVincular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(565, 610));
        setMinimumSize(new java.awt.Dimension(565, 610));
        setPreferredSize(new java.awt.Dimension(565, 610));

        areaTotal.setMaximumSize(new java.awt.Dimension(553, 555));
        areaTotal.setMinimumSize(new java.awt.Dimension(553, 555));
        areaTotal.setPreferredSize(new java.awt.Dimension(553, 555));
        areaTotal.setLayout(new java.awt.GridBagLayout());

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloLabel.setText("Gerar Relatórios");
        tituloPanel.add(tituloLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotal.add(tituloPanel, gridBagConstraints);

        conteudoPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setPreferredSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(545, 30));
        jPanel1.setMinimumSize(new java.awt.Dimension(545, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        conteudoPanel.add(jPanel1, gridBagConstraints);

        areaLabelConteudo.setMaximumSize(new java.awt.Dimension(530, 30));
        areaLabelConteudo.setMinimumSize(new java.awt.Dimension(545, 30));
        areaLabelConteudo.setPreferredSize(new java.awt.Dimension(545, 30));

        selecioneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selecioneLabel.setText("Selecione uma opção");
        areaLabelConteudo.add(selecioneLabel);

        conteudoPanel.add(areaLabelConteudo, new java.awt.GridBagConstraints());

        areaBtm.setMaximumSize(new java.awt.Dimension(500, 125));
        areaBtm.setMinimumSize(new java.awt.Dimension(500, 125));
        areaBtm.setPreferredSize(new java.awt.Dimension(500, 125));
        areaBtm.setLayout(new java.awt.GridBagLayout());

        espacoE.setMaximumSize(new java.awt.Dimension(70, 125));
        espacoE.setMinimumSize(new java.awt.Dimension(70, 125));

        javax.swing.GroupLayout espacoELayout = new javax.swing.GroupLayout(espacoE);
        espacoE.setLayout(espacoELayout);
        espacoELayout.setHorizontalGroup(
            espacoELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        espacoELayout.setVerticalGroup(
            espacoELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        areaBtm.add(espacoE, new java.awt.GridBagConstraints());

        espacoD.setMaximumSize(new java.awt.Dimension(125, 125));
        espacoD.setMinimumSize(new java.awt.Dimension(125, 125));
        espacoD.setPreferredSize(new java.awt.Dimension(125, 125));

        javax.swing.GroupLayout espacoDLayout = new javax.swing.GroupLayout(espacoD);
        espacoD.setLayout(espacoDLayout);
        espacoDLayout.setHorizontalGroup(
            espacoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );
        espacoDLayout.setVerticalGroup(
            espacoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        areaBtm.add(espacoD, gridBagConstraints);

        btmE.setMaximumSize(new java.awt.Dimension(190, 225));
        btmE.setMinimumSize(new java.awt.Dimension(190, 225));
        btmE.setPreferredSize(new java.awt.Dimension(190, 225));
        btmE.setLayout(new java.awt.GridLayout(4, 1));

        botaoConflitoCreditos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoConflitoCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoConflitoCreditos.setText("Conflito Creditos");
        botaoConflitoCreditos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoConflitoCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConflitoCreditosActionPerformed(evt);
            }
        });
        btmE.add(botaoConflitoCreditos);

        botaoDisciplinaOrfao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoDisciplinaOrfao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoDisciplinaOrfao.setText("Disciplina Orfão");
        botaoDisciplinaOrfao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoDisciplinaOrfao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDisciplinaOrfaoActionPerformed(evt);
            }
        });
        btmE.add(botaoDisciplinaOrfao);

        botaoPorProfessor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPorProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoPorProfessor.setText("Por Professor");
        botaoPorProfessor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoPorProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPorProfessorActionPerformed(evt);
            }
        });
        btmE.add(botaoPorProfessor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        areaBtm.add(btmE, gridBagConstraints);

        btmD.setMaximumSize(new java.awt.Dimension(190, 225));
        btmD.setMinimumSize(new java.awt.Dimension(190, 225));
        btmD.setPreferredSize(new java.awt.Dimension(190, 225));
        btmD.setLayout(new java.awt.GridLayout(4, 1));

        botaoConHorarioProibido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoConHorarioProibido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoConHorarioProibido.setText("Conflito Hr. Proibido ");
        botaoConHorarioProibido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoConHorarioProibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConHorarioProibidoActionPerformed(evt);
            }
        });
        btmD.add(botaoConHorarioProibido);

        botaoPorFase.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPorFase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoPorFase.setText("Por Fase");
        botaoPorFase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoPorFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPorFaseActionPerformed(evt);
            }
        });
        btmD.add(botaoPorFase);

        botaoPorLaboratorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoPorLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoPorLaboratorio.setText("Por Laboratorio");
        botaoPorLaboratorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoPorLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPorLaboratorioActionPerformed(evt);
            }
        });
        btmD.add(botaoPorLaboratorio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        areaBtm.add(btmD, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.ipady = 101;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        conteudoPanel.add(areaBtm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotal.add(conteudoPanel, gridBagConstraints);

        menuRapidoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Menu de Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        menuRapidoPanel.setMaximumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setMinimumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setPreferredSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setLayout(new java.awt.GridLayout());

        botaoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon (1).png"))); // NOI18N
        botaoInicio.setText("Início");
        botaoInicio.setMaximumSize(new java.awt.Dimension(59, 25));
        botaoInicio.setMinimumSize(new java.awt.Dimension(59, 25));
        botaoInicio.setPreferredSize(new java.awt.Dimension(59, 25));
        botaoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicioActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoInicio);

        botaoSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sala_24.png"))); // NOI18N
        botaoSala.setText("Sala");
        botaoSala.setMaximumSize(new java.awt.Dimension(59, 25));
        botaoSala.setMinimumSize(new java.awt.Dimension(59, 25));
        botaoSala.setPreferredSize(new java.awt.Dimension(59, 25));
        botaoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalaActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoSala);

        botaoProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/professor_24.png"))); // NOI18N
        botaoProfessor.setText("Prof");
        menuRapidoPanel.add(botaoProfessor);

        botaoDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disciplina_24.png"))); // NOI18N
        botaoDisciplina.setText("Disc");
        botaoDisciplina.setMaximumSize(new java.awt.Dimension(59, 25));
        botaoDisciplina.setMinimumSize(new java.awt.Dimension(59, 25));
        botaoDisciplina.setPreferredSize(new java.awt.Dimension(59, 25));
        botaoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDisciplinaActionPerformed(evt);
            }
        });
        menuRapidoPanel.add(botaoDisciplina);

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
        botaoVincular.setMaximumSize(new java.awt.Dimension(59, 25));
        botaoVincular.setMinimumSize(new java.awt.Dimension(59, 25));
        botaoVincular.setPreferredSize(new java.awt.Dimension(59, 25));
        menuRapidoPanel.add(botaoVincular);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
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
                .addComponent(areaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 76, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConflitoCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConflitoCreditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoConflitoCreditosActionPerformed

    private void botaoDisciplinaOrfaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaOrfaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaOrfaoActionPerformed

    private void botaoPorLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPorLaboratorioActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoPorLaboratorioActionPerformed

    private void botaoPorFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPorFaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPorFaseActionPerformed

    private void botaoConHorarioProibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConHorarioProibidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoConHorarioProibidoActionPerformed

    private void botaoPorProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPorProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPorProfessorActionPerformed

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSalaActionPerformed

    private void botaoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaActionPerformed

    private void botaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBtm;
    private javax.swing.JPanel areaLabelConteudo;
    private javax.swing.JPanel areaTotal;
    public javax.swing.JButton botaoConHorarioProibido;
    public javax.swing.JButton botaoConflitoCreditos;
    public javax.swing.JButton botaoCurso;
    public javax.swing.JButton botaoDisciplina;
    public javax.swing.JButton botaoDisciplinaOrfao;
    public javax.swing.JButton botaoInicio;
    public javax.swing.JButton botaoPorFase;
    public javax.swing.JButton botaoPorLaboratorio;
    public javax.swing.JButton botaoPorProfessor;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoSala;
    public javax.swing.JButton botaoVincular;
    private javax.swing.JPanel btmD;
    private javax.swing.JPanel btmE;
    public javax.swing.JPanel conteudoPanel;
    private javax.swing.JPanel espacoD;
    private javax.swing.JPanel espacoE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuRapidoPanel;
    public javax.swing.JLabel selecioneLabel;
    public javax.swing.JLabel tituloLabel;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
