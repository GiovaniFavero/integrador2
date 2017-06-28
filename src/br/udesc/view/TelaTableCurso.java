/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.view;

/**
 *
 * @author Usuario
 */
public class TelaTableCurso extends javax.swing.JFrame {

    /**
     * Creates new form TelaTableCuro
     */
    public TelaTableCurso() {
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
        tabelaCursoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCurso = new javax.swing.JTable();
        tituloPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        acoesPanel = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(565, 535));
        setMinimumSize(new java.awt.Dimension(565, 535));
        setPreferredSize(new java.awt.Dimension(565, 535));

        areaTotalPanel.setMaximumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setMinimumSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setPreferredSize(new java.awt.Dimension(553, 500));
        areaTotalPanel.setLayout(new java.awt.GridBagLayout());

        tabelaCursoPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        tabelaCursoPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        tabelaCursoPanel.setPreferredSize(new java.awt.Dimension(540, 400));
        tabelaCursoPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(540, 400));

        tabelaCurso.setAutoCreateRowSorter(true);
        tabelaCurso.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCurso.setMaximumSize(new java.awt.Dimension(540, 400));
        tabelaCurso.setMinimumSize(new java.awt.Dimension(540, 400));
        tabelaCurso.setPreferredSize(new java.awt.Dimension(540, 400));
        jScrollPane1.setViewportView(tabelaCurso);

        tabelaCursoPanel.add(jScrollPane1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        areaTotalPanel.add(tabelaCursoPanel, gridBagConstraints);

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Curso");
        tituloPanel.add(jLabel1);

        areaTotalPanel.add(tituloPanel, new java.awt.GridBagConstraints());

        acoesPanel.setMaximumSize(new java.awt.Dimension(550, 40));
        acoesPanel.setMinimumSize(new java.awt.Dimension(550, 40));
        acoesPanel.setName(""); // NOI18N
        acoesPanel.setPreferredSize(new java.awt.Dimension(550, 40));

        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus-symbol-in-a-rounded-black-square.png"))); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoAdicionar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(110, 25));

        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit-interface-sign.png"))); // NOI18N
        botaoEditar.setText("Editar");
        botaoEditar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoEditar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoEditar.setPreferredSize(new java.awt.Dimension(110, 25));

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoExcluir.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoExcluir.setPreferredSize(new java.awt.Dimension(110, 25));

        javax.swing.GroupLayout acoesPanelLayout = new javax.swing.GroupLayout(acoesPanel);
        acoesPanel.setLayout(acoesPanelLayout);
        acoesPanelLayout.setHorizontalGroup(
            acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acoesPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        acoesPanelLayout.setVerticalGroup(
            acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acoesPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(acoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        areaTotalPanel.add(acoesPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acoesPanel;
    private javax.swing.JPanel areaTotalPanel;
    public javax.swing.JButton botaoAdicionar;
    public javax.swing.JButton botaoEditar;
    public javax.swing.JButton botaoExcluir;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaCurso;
    private javax.swing.JPanel tabelaCursoPanel;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
