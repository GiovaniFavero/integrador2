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
public class TelaCadastroCurso extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCurso
     */
    public TelaCadastroCurso() {
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
        fieldNome = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        duracaoLabel = new javax.swing.JLabel();
        fieldDuracao = new javax.swing.JTextField();
        botaoLimpar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        menuRapidoPanel = new javax.swing.JPanel();
        menuLabel = new javax.swing.JLabel();
        botaoInicio = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoDisciplina = new javax.swing.JButton();

        setTitle("Cadastro de Curso");
        setMinimumSize(new java.awt.Dimension(440, 390));

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloLabel.setText("Cadastro de Curso");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloLabel)
                .addGap(142, 142, 142))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        nomeLabel.setText("Nome");

        duracaoLabel.setText("Duração");

        fieldDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDuracaoActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");

        botaoSalvar.setText("Salvar");

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(conteudoPanelLayout.createSequentialGroup()
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(conteudoPanelLayout.createSequentialGroup()
                        .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLabel)
                            .addComponent(duracaoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duracaoLabel)
                    .addComponent(fieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        menuLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        menuLabel.setText("Menu");

        botaoInicio.setText("Início");
        botaoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicioActionPerformed(evt);
            }
        });

        botaoSala.setText("Sala");
        botaoSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalaActionPerformed(evt);
            }
        });

        botaoProfessor.setText("Professor");

        botaoDisciplina.setText("Disciplina");
        botaoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuRapidoPanelLayout = new javax.swing.GroupLayout(menuRapidoPanel);
        menuRapidoPanel.setLayout(menuRapidoPanelLayout);
        menuRapidoPanelLayout.setHorizontalGroup(
            menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRapidoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuLabel)
                .addGap(49, 49, 49))
            .addGroup(menuRapidoPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuRapidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botaoProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addComponent(botaoSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(conteudoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuRapidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conteudoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuRapidoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void fieldDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDuracaoActionPerformed

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSalaActionPerformed

    private void botaoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaActionPerformed

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
    public javax.swing.JPanel conteudoPanel;
    public javax.swing.JLabel duracaoLabel;
    public javax.swing.JTextField fieldDuracao;
    public javax.swing.JTextField fieldNome;
    public javax.swing.JLabel menuLabel;
    public javax.swing.JPanel menuRapidoPanel;
    public javax.swing.JLabel nomeLabel;
    public javax.swing.JLabel tituloLabel;
    public javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
