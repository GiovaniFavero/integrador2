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
public class TelaHorarios extends javax.swing.JFrame {

    /**
     * Creates new form TelaHorarios
     */
    public TelaHorarios() {
        initComponents();
    }
    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        areaTotalPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel3 = new javax.swing.JLabel();
        conteudoPanel = new javax.swing.JPanel();
        geraHorarioBotao = new javax.swing.JButton();
        horarioScrollPane = new javax.swing.JScrollPane();
        horarioTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabela Horários");
        setMaximumSize(new java.awt.Dimension(565, 535));
        setMinimumSize(new java.awt.Dimension(565, 535));
        setPreferredSize(new java.awt.Dimension(565, 535));

        areaTotalPanel.setMaximumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setMinimumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setPreferredSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setLayout(new java.awt.GridBagLayout());

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        tituloLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tituloLabel3.setText("Tabela de Horários");
        tituloPanel.add(tituloLabel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotalPanel.add(tituloPanel, gridBagConstraints);

        conteudoPanel.setMaximumSize(new java.awt.Dimension(540, 460));
        conteudoPanel.setMinimumSize(new java.awt.Dimension(540, 460));
        conteudoPanel.setPreferredSize(new java.awt.Dimension(540, 460));

        geraHorarioBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Tabela.png"))); // NOI18N
        geraHorarioBotao.setText("Gerar Horários");
        geraHorarioBotao.setMaximumSize(new java.awt.Dimension(139, 25));
        geraHorarioBotao.setMinimumSize(new java.awt.Dimension(139, 25));
        geraHorarioBotao.setPreferredSize(new java.awt.Dimension(139, 25));
        geraHorarioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geraHorarioBotaoActionPerformed(evt);
            }
        });

        horarioScrollPane.setMaximumSize(new java.awt.Dimension(540, 400));
        horarioScrollPane.setMinimumSize(new java.awt.Dimension(540, 400));
        horarioScrollPane.setPreferredSize(new java.awt.Dimension(540, 400));
        horarioScrollPane.setRequestFocusEnabled(false);

        horarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, ""}
            },
            new String [] {
                "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"
            }
        ));
        horarioTable.setMaximumSize(new java.awt.Dimension(540, 400));
        horarioTable.setMinimumSize(new java.awt.Dimension(540, 400));
        horarioTable.setPreferredSize(new java.awt.Dimension(540, 400));
        horarioScrollPane.setViewportView(horarioTable);

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(horarioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(geraHorarioBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addComponent(horarioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(geraHorarioBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotalPanel.add(conteudoPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(areaTotalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void geraHorarioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geraHorarioBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_geraHorarioBotaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaTotalPanel;
    public javax.swing.JPanel conteudoPanel;
    public javax.swing.JButton geraHorarioBotao;
    public javax.swing.JScrollPane horarioScrollPane;
    public javax.swing.JTable horarioTable;
    public javax.swing.JLabel tituloLabel3;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
