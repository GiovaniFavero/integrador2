/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.view;

/**
 *
 * @author 5105011523
 */
public class TelaRestricoesProfessor extends javax.swing.JFrame {

    /**
     * Creates new form TelaTabelaProfessor
     */
    public TelaRestricoesProfessor() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        cbxSegunda1 = new javax.swing.JComboBox<>();
        cbxSegunda2 = new javax.swing.JComboBox<>();
        cbxTerca1 = new javax.swing.JComboBox<>();
        cbxTerca2 = new javax.swing.JComboBox<>();
        cbxQuarta1 = new javax.swing.JComboBox<>();
        cbxQuarta2 = new javax.swing.JComboBox<>();
        cbxQuinta1 = new javax.swing.JComboBox<>();
        cbxQuinta2 = new javax.swing.JComboBox<>();
        cbxSexta1 = new javax.swing.JComboBox<>();
        cbxSexta2 = new javax.swing.JComboBox<>();
        cbxSabado1 = new javax.swing.JComboBox<>();
        cbxSabado2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTitulo.setText("Professor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel1.add(labelTitulo, gridBagConstraints);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 10);
        jPanel1.add(botaoCancelar, gridBagConstraints);

        botaoSalvar.setText("Salvar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 15, 0);
        jPanel1.add(botaoSalvar, gridBagConstraints);

        cbxSegunda1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSegunda1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSegunda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSegunda1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSegunda1, gridBagConstraints);

        cbxSegunda2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSegunda2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSegunda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSegunda2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSegunda2, gridBagConstraints);

        cbxTerca1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxTerca1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxTerca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTerca1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxTerca1, gridBagConstraints);

        cbxTerca2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxTerca2.setName(""); // NOI18N
        cbxTerca2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxTerca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTerca2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxTerca2, gridBagConstraints);

        cbxQuarta1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxQuarta1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxQuarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuarta1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxQuarta1, gridBagConstraints);

        cbxQuarta2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxQuarta2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxQuarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuarta2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxQuarta2, gridBagConstraints);

        cbxQuinta1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxQuinta1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxQuinta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuinta1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxQuinta1, gridBagConstraints);

        cbxQuinta2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxQuinta2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxQuinta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuinta2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxQuinta2, gridBagConstraints);

        cbxSexta1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSexta1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSexta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexta1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSexta1, gridBagConstraints);

        cbxSexta2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSexta2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSexta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexta2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSexta2, gridBagConstraints);

        cbxSabado1.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSabado1.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSabado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSabado1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSabado1, gridBagConstraints);

        cbxSabado2.setMinimumSize(new java.awt.Dimension(50, 20));
        cbxSabado2.setPreferredSize(new java.awt.Dimension(50, 20));
        cbxSabado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSabado2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 10, 10);
        jPanel1.add(cbxSabado2, gridBagConstraints);

        jLabel2.setText("Segunda-feira");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Quarta-feira");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Sexta-feira");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Quinta-feira");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Sábado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Terça-feira");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel10, gridBagConstraints);

        jLabel11.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel12.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel13.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel14.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel14, gridBagConstraints);

        jLabel15.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel15, gridBagConstraints);

        jLabel16.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel16, gridBagConstraints);

        jLabel17.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel17, gridBagConstraints);

        jLabel18.setText("1º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel18, gridBagConstraints);

        jLabel19.setText("2º Período");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel1.add(jLabel19, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void cbxSegunda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSegunda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSegunda1ActionPerformed

    private void cbxSegunda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSegunda2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSegunda2ActionPerformed

    private void cbxTerca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTerca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTerca1ActionPerformed

    private void cbxTerca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTerca2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTerca2ActionPerformed

    private void cbxQuarta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuarta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxQuarta1ActionPerformed

    private void cbxQuarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuarta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxQuarta2ActionPerformed

    private void cbxQuinta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuinta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxQuinta1ActionPerformed

    private void cbxQuinta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuinta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxQuinta2ActionPerformed

    private void cbxSexta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexta1ActionPerformed

    private void cbxSexta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexta2ActionPerformed

    private void cbxSabado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSabado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSabado1ActionPerformed

    private void cbxSabado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSabado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSabado2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botaoCancelar;
    public javax.swing.JButton botaoSalvar;
    public javax.swing.JComboBox<String> cbxQuarta1;
    public javax.swing.JComboBox<String> cbxQuarta2;
    public javax.swing.JComboBox<String> cbxQuinta1;
    public javax.swing.JComboBox<String> cbxQuinta2;
    public javax.swing.JComboBox<String> cbxSabado1;
    public javax.swing.JComboBox<String> cbxSabado2;
    public javax.swing.JComboBox<String> cbxSegunda1;
    public javax.swing.JComboBox<String> cbxSegunda2;
    public javax.swing.JComboBox<String> cbxSexta1;
    public javax.swing.JComboBox<String> cbxSexta2;
    public javax.swing.JComboBox<String> cbxTerca1;
    public javax.swing.JComboBox<String> cbxTerca2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
