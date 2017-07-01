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
public class TelaInicio extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicio
     */
    public TelaInicio() {
        initComponents();
        layoutBtms();
    }
    
     public void layoutBtms() {
        botaoCurso.setBorderPainted(false);
        botaoCurso.setFocusPainted(false);
        botaoCurso.setContentAreaFilled(false);
        
        botaoDisciplina.setBorderPainted(false);
        botaoDisciplina.setFocusPainted(false);
        botaoDisciplina.setContentAreaFilled(false);
        
        botaoProfessor.setBorderPainted(false);
        botaoProfessor.setFocusPainted(false);
        botaoProfessor.setContentAreaFilled(false);
        
        botaoSala.setBorderPainted(false);
        botaoSala.setFocusPainted(false);
        botaoSala.setContentAreaFilled(false);
        
        botaoProblema.setBorderPainted(false);
        botaoProblema.setFocusPainted(false);
        botaoProblema.setContentAreaFilled(false);
        
        botaoVincular.setBorderPainted(false);
        botaoVincular.setFocusPainted(false);
        botaoVincular.setContentAreaFilled(false);

        botaoRelatorio.setBorderPainted(false);
        botaoRelatorio.setFocusPainted(false);
        botaoRelatorio.setContentAreaFilled(false);
        
        botaoDb.setBorderPainted(false);
        botaoDb.setFocusPainted(false);
        botaoDb.setContentAreaFilled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        areaTotalPanel = new javax.swing.JPanel();
        conteudoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        areaLabelConteudo = new javax.swing.JPanel();
        selecioneLabel = new javax.swing.JLabel();
        areaBtm = new javax.swing.JPanel();
        espacoE = new javax.swing.JPanel();
        espacoD = new javax.swing.JPanel();
        btmE = new javax.swing.JPanel();
        botaoProfessor = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoVincular = new javax.swing.JButton();
        botaoDb = new javax.swing.JButton();
        btmD = new javax.swing.JPanel();
        botaoDisciplina = new javax.swing.JButton();
        botaoCurso = new javax.swing.JButton();
        botaoProblema = new javax.swing.JButton();
        botaoRelatorio = new javax.swing.JButton();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Início");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(565, 580));

        areaTotalPanel.setMaximumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setMinimumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setPreferredSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setLayout(new java.awt.GridBagLayout());

        conteudoPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setPreferredSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(545, 30));
        jPanel1.setMinimumSize(new java.awt.Dimension(545, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(545, 30));

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
        espacoE.setPreferredSize(new java.awt.Dimension(70, 125));

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

        espacoD.setMaximumSize(new java.awt.Dimension(100, 125));
        espacoD.setMinimumSize(new java.awt.Dimension(100, 125));
        espacoD.setPreferredSize(new java.awt.Dimension(100, 125));

        javax.swing.GroupLayout espacoDLayout = new javax.swing.GroupLayout(espacoD);
        espacoD.setLayout(espacoDLayout);
        espacoDLayout.setHorizontalGroup(
            espacoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        espacoDLayout.setVerticalGroup(
            espacoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        areaBtm.add(espacoD, gridBagConstraints);

        btmE.setMaximumSize(new java.awt.Dimension(165, 225));
        btmE.setMinimumSize(new java.awt.Dimension(165, 225));
        btmE.setPreferredSize(new java.awt.Dimension(165, 225));
        btmE.setLayout(new java.awt.GridLayout(5, 1));

        botaoProfessor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/professor_24.png"))); // NOI18N
        botaoProfessor.setText("Professor");
        botaoProfessor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProfessorActionPerformed(evt);
            }
        });
        btmE.add(botaoProfessor);

        botaoSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sala_24.png"))); // NOI18N
        botaoSala.setText("Sala");
        botaoSala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalaActionPerformed(evt);
            }
        });
        btmE.add(botaoSala);

        botaoVincular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoVincular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Vincular24.png"))); // NOI18N
        botaoVincular.setText("Vincular");
        botaoVincular.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVincularActionPerformed(evt);
            }
        });
        btmE.add(botaoVincular);

        botaoDb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/database.png"))); // NOI18N
        botaoDb.setText("Preencher Banco");
        botaoDb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDbActionPerformed(evt);
            }
        });
        btmE.add(botaoDb);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        areaBtm.add(btmE, gridBagConstraints);

        btmD.setMaximumSize(new java.awt.Dimension(165, 225));
        btmD.setMinimumSize(new java.awt.Dimension(165, 225));
        btmD.setPreferredSize(new java.awt.Dimension(165, 225));
        btmD.setLayout(new java.awt.GridLayout(5, 1));

        botaoDisciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disciplina_24.png"))); // NOI18N
        botaoDisciplina.setText("Disciplina");
        botaoDisciplina.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDisciplinaActionPerformed(evt);
            }
        });
        btmD.add(botaoDisciplina);

        botaoCurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Curso24.png"))); // NOI18N
        botaoCurso.setText("Curso");
        botaoCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCursoActionPerformed(evt);
            }
        });
        btmD.add(botaoCurso);

        botaoProblema.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoProblema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Problema24.png"))); // NOI18N
        botaoProblema.setText("Gerar Problema");
        botaoProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProblemaActionPerformed(evt);
            }
        });
        btmD.add(botaoProblema);

        botaoRelatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        botaoRelatorio.setText("Gerar Relatórios");
        botaoRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelatorioActionPerformed(evt);
            }
        });
        btmD.add(botaoRelatorio);

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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotalPanel.add(conteudoPanel, gridBagConstraints);

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        tituloLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloLabel3.setText("Projeto Integrador II");
        tituloPanel.add(tituloLabel3);

        areaTotalPanel.add(tituloPanel, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCursoActionPerformed

    private void botaoSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSalaActionPerformed

    private void botaoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaActionPerformed

    private void botaoVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVincularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoVincularActionPerformed

    private void botaoProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProblemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoProblemaActionPerformed

    private void botaoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoProfessorActionPerformed

    private void botaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoRelatorioActionPerformed

    private void botaoDbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBtm;
    private javax.swing.JPanel areaLabelConteudo;
    private javax.swing.JPanel areaTotalPanel;
    public javax.swing.JButton botaoCurso;
    public javax.swing.JButton botaoDb;
    public javax.swing.JButton botaoDisciplina;
    public javax.swing.JButton botaoProblema;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoRelatorio;
    public javax.swing.JButton botaoSala;
    public javax.swing.JButton botaoVincular;
    private javax.swing.JPanel btmD;
    private javax.swing.JPanel btmE;
    public javax.swing.JPanel conteudoPanel;
    private javax.swing.JPanel espacoD;
    private javax.swing.JPanel espacoE;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel selecioneLabel;
    public javax.swing.JLabel tituloLabel3;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
