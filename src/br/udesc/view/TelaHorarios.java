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
        layoutMenu();
    }

    public void layoutMenu() {
        geraHorarioBotao.setBorderPainted(false);
        geraHorarioBotao.setFocusPainted(false);
        geraHorarioBotao.setContentAreaFilled(false);

        botaoInicio.setBorderPainted(false);
        botaoInicio.setFocusPainted(false);
        botaoInicio.setContentAreaFilled(false);

        botaoDisciplina.setBorderPainted(false);
        botaoDisciplina.setFocusPainted(false);
        botaoDisciplina.setContentAreaFilled(false);

        botaoProfessor.setBorderPainted(false);
        botaoProfessor.setFocusPainted(false);
        botaoProfessor.setContentAreaFilled(false);

        botaoCurso.setBorderPainted(false);
        botaoCurso.setFocusPainted(false);
        botaoCurso.setContentAreaFilled(false);

        botaoVincular.setBorderPainted(false);
        botaoVincular.setFocusPainted(false);
        botaoVincular.setContentAreaFilled(false);

        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setContentAreaFilled(false);

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
        botaoVoltar = new javax.swing.JButton();
        menuRapidoPanel = new javax.swing.JPanel();
        botaoInicio = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoDisciplina = new javax.swing.JButton();
        botaoCurso = new javax.swing.JButton();
        botaoVincular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabela Horários");
        setMaximumSize(new java.awt.Dimension(565, 610));
        setMinimumSize(new java.awt.Dimension(565, 610));
        setPreferredSize(new java.awt.Dimension(565, 610));

        areaTotalPanel.setMaximumSize(new java.awt.Dimension(553, 555));
        areaTotalPanel.setMinimumSize(new java.awt.Dimension(553, 555));
        areaTotalPanel.setPreferredSize(new java.awt.Dimension(553, 555));
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

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/left-arrow.png"))); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoVoltar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoVoltar.setPreferredSize(new java.awt.Dimension(110, 25));

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(horarioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(geraHorarioBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addComponent(horarioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(geraHorarioBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        areaTotalPanel.add(conteudoPanel, gridBagConstraints);

        menuRapidoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Menu de Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        menuRapidoPanel.setMaximumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setMinimumSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setPreferredSize(new java.awt.Dimension(550, 60));
        menuRapidoPanel.setLayout(new java.awt.GridLayout(1, 0));

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
        areaTotalPanel.add(menuRapidoPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTotalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(areaTotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void geraHorarioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geraHorarioBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_geraHorarioBotaoActionPerformed

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaActionPerformed

    private void botaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaTotalPanel;
    public javax.swing.JButton botaoCurso;
    public javax.swing.JButton botaoDisciplina;
    public javax.swing.JButton botaoInicio;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoVincular;
    public javax.swing.JButton botaoVoltar;
    public javax.swing.JPanel conteudoPanel;
    public javax.swing.JButton geraHorarioBotao;
    public javax.swing.JScrollPane horarioScrollPane;
    public javax.swing.JTable horarioTable;
    private javax.swing.JPanel menuRapidoPanel;
    public javax.swing.JLabel tituloLabel3;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
