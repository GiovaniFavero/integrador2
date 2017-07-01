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
        LayoutMenu();
    }

    public void LayoutMenu() {
        botaoCancelar.setBorderPainted(false);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setContentAreaFilled(false);

        botaoSalvar.setBorderPainted(false);
        botaoSalvar.setFocusPainted(false);
        botaoSalvar.setContentAreaFilled(false);

        botaoInicio.setBorderPainted(false);
        botaoInicio.setFocusPainted(false);
        botaoInicio.setContentAreaFilled(false);

        botaoDisciplina.setBorderPainted(false);
        botaoDisciplina.setFocusPainted(false);
        botaoDisciplina.setContentAreaFilled(false);

        botaoProfessor.setBorderPainted(false);
        botaoProfessor.setFocusPainted(false);
        botaoProfessor.setContentAreaFilled(false);

        botaoSala.setBorderPainted(false);
        botaoSala.setFocusPainted(false);
        botaoSala.setContentAreaFilled(false);

        botaoVincular.setBorderPainted(false);
        botaoVincular.setFocusPainted(false);
        botaoVincular.setContentAreaFilled(false);

        botaoCurso.setBorderPainted(false);
        botaoCurso.setFocusPainted(false);
        botaoCurso.setContentAreaFilled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        conteudoPanel = new javax.swing.JPanel();
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
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        tituloPanel = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        menuRapidoPanel = new javax.swing.JPanel();
        botaoInicio = new javax.swing.JButton();
        botaoSala = new javax.swing.JButton();
        botaoProfessor = new javax.swing.JButton();
        botaoDisciplina = new javax.swing.JButton();
        botaoCurso = new javax.swing.JButton();
        botaoVincular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(565, 610));
        setMinimumSize(new java.awt.Dimension(565, 610));
        setPreferredSize(new java.awt.Dimension(565, 610));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        conteudoPanel.setMaximumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setMinimumSize(new java.awt.Dimension(540, 400));
        conteudoPanel.setPreferredSize(new java.awt.Dimension(540, 400));

        cbxSegunda1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSegunda1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSegunda1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSegunda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSegunda1ActionPerformed(evt);
            }
        });

        cbxSegunda2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSegunda2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSegunda2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSegunda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSegunda2ActionPerformed(evt);
            }
        });

        cbxTerca1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxTerca1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxTerca1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxTerca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTerca1ActionPerformed(evt);
            }
        });

        cbxTerca2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxTerca2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxTerca2.setName(""); // NOI18N
        cbxTerca2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxTerca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTerca2ActionPerformed(evt);
            }
        });

        cbxQuarta1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxQuarta1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxQuarta1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxQuarta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuarta1ActionPerformed(evt);
            }
        });

        cbxQuarta2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxQuarta2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxQuarta2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxQuarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuarta2ActionPerformed(evt);
            }
        });

        cbxQuinta1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxQuinta1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxQuinta1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxQuinta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuinta1ActionPerformed(evt);
            }
        });

        cbxQuinta2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxQuinta2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxQuinta2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxQuinta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuinta2ActionPerformed(evt);
            }
        });

        cbxSexta1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSexta1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSexta1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSexta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexta1ActionPerformed(evt);
            }
        });

        cbxSexta2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSexta2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSexta2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSexta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexta2ActionPerformed(evt);
            }
        });

        cbxSabado1.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSabado1.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSabado1.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSabado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSabado1ActionPerformed(evt);
            }
        });

        cbxSabado2.setMaximumSize(new java.awt.Dimension(125, 20));
        cbxSabado2.setMinimumSize(new java.awt.Dimension(125, 20));
        cbxSabado2.setPreferredSize(new java.awt.Dimension(125, 20));
        cbxSabado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSabado2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Segunda-feira");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quarta-feira");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sexta-feira");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quinta-feira");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sábado");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Terça-feira");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("1º Período");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("2º Período");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("1º Período");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("2º Período");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("1º Período");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("2º Período");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("1º Período");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("2º Período");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("1º Período");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("2º Período");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("1º Período");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("2º Período");

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoCancelar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoCancelar.setPreferredSize(new java.awt.Dimension(110, 25));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setMaximumSize(new java.awt.Dimension(110, 25));
        botaoSalvar.setMinimumSize(new java.awt.Dimension(110, 25));
        botaoSalvar.setPreferredSize(new java.awt.Dimension(110, 25));

        javax.swing.GroupLayout conteudoPanelLayout = new javax.swing.GroupLayout(conteudoPanel);
        conteudoPanel.setLayout(conteudoPanelLayout);
        conteudoPanelLayout.setHorizontalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel11))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cbxSegunda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSegunda2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxQuarta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxQuarta2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxSexta1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSexta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(cbxTerca1, 0, 153, Short.MAX_VALUE)
                    .addComponent(cbxTerca2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxQuinta1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxQuinta2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSabado2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSabado1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        conteudoPanelLayout.setVerticalGroup(
            conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxTerca1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbxSegunda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxTerca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cbxSegunda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(cbxQuarta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbxQuinta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(cbxQuarta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cbxQuinta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxSabado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbxSexta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxSabado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cbxSexta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(conteudoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(conteudoPanel, gridBagConstraints);

        tituloPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tituloPanel.setMaximumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setMinimumSize(new java.awt.Dimension(545, 50));
        tituloPanel.setPreferredSize(new java.awt.Dimension(545, 50));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTitulo.setText("Professor");
        tituloPanel.add(labelTitulo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(tituloPanel, gridBagConstraints);

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
        getContentPane().add(menuRapidoPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCancelarActionPerformed

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

    private void cbxSegunda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSegunda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSegunda1ActionPerformed

    private void botaoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoInicioActionPerformed

    private void botaoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDisciplinaActionPerformed

    private void botaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoCursoActionPerformed

    private void botaoSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botaoCancelar;
    public javax.swing.JButton botaoCurso;
    public javax.swing.JButton botaoDisciplina;
    public javax.swing.JButton botaoInicio;
    public javax.swing.JButton botaoProfessor;
    public javax.swing.JButton botaoSala;
    public javax.swing.JButton botaoSalvar;
    public javax.swing.JButton botaoVincular;
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
    private javax.swing.JPanel conteudoPanel;
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
    public javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel menuRapidoPanel;
    private javax.swing.JPanel tituloPanel;
    // End of variables declaration//GEN-END:variables
}
