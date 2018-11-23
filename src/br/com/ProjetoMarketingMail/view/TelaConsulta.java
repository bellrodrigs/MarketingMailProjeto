/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.view;

import br.com.ProjetoMarketingMail.util.ConnectionFactory;
import br.com.ProjetoMarketingMail.util.MudaTelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaConsulta extends javax.swing.JFrame {

    private static void addRow(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //metodos entrametodos = new metodos();
    TelaInfoContato infocontato = new TelaInfoContato();
    private final Connection conexao;

    /**
     * Creates new form TelaCadastro
     */
    public TelaConsulta() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        conexao = new ConnectionFactory().conexao();

    }

    public void SelecionaTodos() throws SQLException {
        String sql = "select * from contato";
        PreparedStatement cmd = conexao.prepareStatement(sql);

        ResultSet resp = null;
        try {
            /*PreparedStatement ps = conexao.prepareStatement(sql);*/

            ResultSet rs = cmd.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tabelaInfo.getModel();

            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }

    public void listarNome() throws SQLException {
        String sql = "select * from contato where nome like ?";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        cmd.setString(1, "%" + nomeCliente.getText() + "%");
        ResultSet resp = null;
        try {
            /*PreparedStatement ps = conexao.prepareStatement(sql);*/

            ResultSet rs = cmd.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tabelaInfo.getModel();

            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }

    }

    public void listarCidade() throws SQLException {
        String sql = "select * from contato where estado like ?";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        cmd.setString(1, "%" + cidade.getText() + "%");

        try {
            /*PreparedStatement ps = conexao.prepareStatement(sql);*/

            ResultSet rs = cmd.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tabelaInfo.getModel();

            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }

    }

    public void listarEmail() throws SQLException {
        String sql = "select * from contato where email like ?";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        cmd.setString(1, "%" + email.getText() + "%");

        try {
            /*PreparedStatement ps = conexao.prepareStatement(sql);*/

            ResultSet rs = cmd.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tabelaInfo.getModel();

            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }

    }

    public void JogaValor() throws SQLException {

        int id = tabelaInfo.getSelectedRow();
        //id = +1;
        //System.out.println(id);
        String sql = "select * from contato, grupo where grupo.idgrupo = contato.idgrupo and idcontato like ?";
        //String sql = "select * from grupo inner join cliente on grupo.idgrupo = cliente.idgrupo";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        cmd.setString(1, "%" + tabelaInfo.getValueAt(id, 0).toString() + "%");
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            TelaInfoContato.codcontato.setText((String.valueOf(rs.getInt("idcontato"))));
            TelaInfoContato.nomeCliente.setText(rs.getString("nome"));
            TelaInfoContato.estado.setText(rs.getString("estado"));
            TelaInfoContato.email.setText(rs.getString("email"));
            TelaInfoContato.telefone.setText(rs.getString("telefone"));
            TelaInfoContato.celular.setText(rs.getString("celular"));
            TelaInfoContato.Grupo.setText((rs.getString("grupo.idgrupo")) + " " + (rs.getString("grupo.nome")));
            //TelaInfoContato.GrupoCombo.addItem((rs.getInt("grupo.idgrupo"))+(rs.getString("grupo.nome")));

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nomeCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        RBEmail = new javax.swing.JRadioButton();
        RBCidade = new javax.swing.JRadioButton();
        RBNome = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaInfo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        layout = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(nomeCliente);
        nomeCliente.setBounds(200, 240, 400, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 240, 170, 50);
        getContentPane().add(cidade);
        cidade.setBounds(730, 240, 470, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(660, 240, 170, 50);
        getContentPane().add(email);
        email.setBounds(200, 300, 400, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("E-mail:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 300, 170, 50);

        buttonGroup1.add(RBEmail);
        RBEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBEmailActionPerformed(evt);
            }
        });
        getContentPane().add(RBEmail);
        RBEmail.setBounds(610, 300, 30, 40);

        buttonGroup1.add(RBCidade);
        RBCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(RBCidade);
        RBCidade.setBounds(1210, 240, 30, 40);

        buttonGroup1.add(RBNome);
        RBNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBNomeActionPerformed(evt);
            }
        });
        getContentPane().add(RBNome);
        RBNome.setBounds(610, 240, 30, 40);

        tabelaInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Estado", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 380, 1110, 190);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconebusca.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1140, 600, 110, 40);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo3.png"))); // NOI18N
        layout.setText("jLabel1");
        layout.setMaximumSize(new java.awt.Dimension(1366, 768));
        layout.setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(layout);
        layout.setBounds(-50, -10, 1520, 880);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(5, 0, 5, 15));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(144, 32769));

        jMenu1.setText("Contato");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setText("Novo Cadastro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setText("Conultar Contatos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("E-mail");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem4.setText("Enviar novo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new MudaTelas().Sair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void RBCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCidadeActionPerformed
        if (RBCidade.isSelected()) {
            cidade.setEnabled(true);
            email.setEnabled(false);
            nomeCliente.setEnabled(false);
        }
    }//GEN-LAST:event_RBCidadeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MudaTelas().TelaDeCadastro();
        TelaConsulta.this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaEnviarEmail enviaemail = new TelaEnviarEmail();
        enviaemail.setVisible(true);
        TelaConsulta.this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void RBNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBNomeActionPerformed
        if (RBNome.isSelected()) {
            nomeCliente.setEnabled(true);
            email.setEnabled(false);
            cidade.setEnabled(false);
        }
    }//GEN-LAST:event_RBNomeActionPerformed

    private void RBEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBEmailActionPerformed
        if (RBEmail.isSelected()) {
            email.setEnabled(true);
            nomeCliente.setEnabled(false);
            cidade.setEnabled(false);
        }
    }//GEN-LAST:event_RBEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (RBNome.isSelected()) {
                listarNome();
            } else if (RBCidade.isSelected()) {
                listarCidade();
            } else if (RBEmail.isSelected()) {
                listarEmail();
            } else {
                SelecionaTodos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaInfoMouseClicked
        infocontato.setVisible(true);
        TelaConsulta.this.dispose();
        try {
            JogaValor();
        } catch (SQLException ex) {
            Logger.getLogger(TelaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelaInfoMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        TelaRelatorio relatorio = new TelaRelatorio();
        relatorio.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBCidade;
    private javax.swing.JRadioButton RBEmail;
    private javax.swing.JRadioButton RBNome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel layout;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTable tabelaInfo;
    // End of variables declaration//GEN-END:variables
}
