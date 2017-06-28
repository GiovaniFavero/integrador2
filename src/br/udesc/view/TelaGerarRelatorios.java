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
        btm01.setBorderPainted(false);
        btm01.setFocusPainted(false);
        btm01.setContentAreaFilled(false);
        
        btm02.setBorderPainted(false);
        btm02.setFocusPainted(false);
        btm02.setContentAreaFilled(false);
        
        btm03.setBorderPainted(false);
        btm03.setFocusPainted(false);
        btm03.setContentAreaFilled(false);
        
        btm04.setBorderPainted(false);
        btm04.setFocusPainted(false);
        btm04.setContentAreaFilled(false);
        
        btm05.setBorderPainted(false);
        btm05.setFocusPainted(false);
        btm05.setContentAreaFilled(false);
        
        btm06.setBorderPainted(false);
        btm06.setFocusPainted(false);
        btm06.setContentAreaFilled(false);
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
        btm01 = new javax.swing.JButton();
        btm03 = new javax.swing.JButton();
        btm05 = new javax.swing.JButton();
        btmD = new javax.swing.JPanel();
        btm02 = new javax.swing.JButton();
        btm04 = new javax.swing.JButton();
        btm06 = new javax.swing.JButton();

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

        espacoD.setMaximumSize(new java.awt.Dimension(100, 125));
        espacoD.setMinimumSize(new java.awt.Dimension(100, 125));

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
        btmE.setLayout(new java.awt.GridLayout(4, 1));

        btm01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm01.setText("btm01");
        btm01.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm01ActionPerformed(evt);
            }
        });
        btmE.add(btm01);

        btm03.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm03.setText("btm03");
        btm03.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm03ActionPerformed(evt);
            }
        });
        btmE.add(btm03);

        btm05.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm05.setText("btm05");
        btm05.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm05ActionPerformed(evt);
            }
        });
        btmE.add(btm05);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        areaBtm.add(btmE, gridBagConstraints);

        btmD.setMaximumSize(new java.awt.Dimension(165, 225));
        btmD.setMinimumSize(new java.awt.Dimension(165, 225));
        btmD.setPreferredSize(new java.awt.Dimension(165, 225));
        btmD.setLayout(new java.awt.GridLayout(4, 1));

        btm02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm02.setText("btm02");
        btm02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm02ActionPerformed(evt);
            }
        });
        btmD.add(btm02);

        btm04.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm04.setText("btm04");
        btm04.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm04ActionPerformed(evt);
            }
        });
        btmD.add(btm04);

        btm06.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btm06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newspaper.png"))); // NOI18N
        btm06.setText("btm06");
        btm06.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btm06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btm06ActionPerformed(evt);
            }
        });
        btmD.add(btm06);

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
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 50, 4);
        areaTotal.add(conteudoPanel, gridBagConstraints);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btm01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm01ActionPerformed

    private void btm03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm03ActionPerformed

    private void btm06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm06ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btm06ActionPerformed

    private void btm04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm04ActionPerformed

    private void btm02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm02ActionPerformed

    private void btm05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btm05ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btm05ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBtm;
    private javax.swing.JPanel areaLabelConteudo;
    private javax.swing.JPanel areaTotal;
    public javax.swing.JButton btm01;
    public javax.swing.JButton btm02;
    public javax.swing.JButton btm03;
    public javax.swing.JButton btm04;
    public javax.swing.JButton btm05;
    public javax.swing.JButton btm06;
    private javax.swing.JPanel btmD;
    private javax.swing.JPanel btmE;
    public javax.swing.JPanel conteudoPanel;
    private javax.swing.JPanel espacoD;
    private javax.swing.JPanel espacoE;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel selecioneLabel;
    public javax.swing.JLabel tituloLabel;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
