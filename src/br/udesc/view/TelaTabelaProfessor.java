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
public class TelaTabelaProfessor extends javax.swing.JFrame {

    /**
     * Creates new form TelaTabelaProfessor
     */
    public TelaTabelaProfessor() {
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

        areaTotalPanel = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabelaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        acoesPanel = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoRestricoes = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(565, 535));
        setMinimumSize(new java.awt.Dimension(565, 535));

        areaTotalPanel.setMaximumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setMinimumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setPreferredSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setLayout(new java.awt.GridBagLayout());

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Professor");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        areaTotalPanel.add(tituloPanel, new java.awt.GridBagConstraints());

        tabelaPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        tabelaPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        tabelaPanel.setPreferredSize(new java.awt.Dimension(540, 400));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(540, 400));

        tabelaProfessores.setAutoCreateRowSorter(true);
        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaProfessores.setMaximumSize(new java.awt.Dimension(540, 400));
        tabelaProfessores.setMinimumSize(new java.awt.Dimension(540, 400));
        tabelaProfessores.setPreferredSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setViewportView(tabelaProfessores);

        javax.swing.GroupLayout tabelaPanelLayout = new javax.swing.GroupLayout(tabelaPanel);
        tabelaPanel.setLayout(tabelaPanelLayout);
        tabelaPanelLayout.setHorizontalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        tabelaPanelLayout.setVerticalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 52;
        areaTotalPanel.add(tabelaPanel, gridBagConstraints);

        acoesPanel.setMaximumSize(new java.awt.Dimension(550, 40));
        acoesPanel.setMinimumSize(new java.awt.Dimension(550, 40));

        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save.png"))); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setMaximumSize(new java.awt.Dimension(125, 25));
        botaoAdicionar.setMinimumSize(new java.awt.Dimension(125, 25));
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(125, 25));

        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit-interface-sign.png"))); // NOI18N
        botaoEditar.setText("Editar");
        botaoEditar.setMaximumSize(new java.awt.Dimension(125, 25));
        botaoEditar.setMinimumSize(new java.awt.Dimension(125, 25));
        botaoEditar.setPreferredSize(new java.awt.Dimension(125, 25));

        botaoRestricoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/warning.png"))); // NOI18N
        botaoRestricoes.setText("Restrições");
        botaoRestricoes.setMaximumSize(new java.awt.Dimension(125, 25));
        botaoRestricoes.setMinimumSize(new java.awt.Dimension(125, 25));
        botaoRestricoes.setPreferredSize(new java.awt.Dimension(125, 25));

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.setMaximumSize(new java.awt.Dimension(125, 25));
        botaoExcluir.setMinimumSize(new java.awt.Dimension(125, 25));
        botaoExcluir.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout acoesPanelLayout = new javax.swing.GroupLayout(acoesPanel);
        acoesPanel.setLayout(acoesPanelLayout);
        acoesPanelLayout.setHorizontalGroup(
            acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoRestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        acoesPanelLayout.setVerticalGroup(
            acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(4, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotalPanel.add(acoesPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acoesPanel;
    private javax.swing.JPanel areaTotalPanel;
    public javax.swing.JButton botaoAdicionar;
    public javax.swing.JButton botaoEditar;
    public javax.swing.JButton botaoExcluir;
    public javax.swing.JButton botaoRestricoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tabelaPanel;
    public javax.swing.JTable tabelaProfessores;
    private javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
