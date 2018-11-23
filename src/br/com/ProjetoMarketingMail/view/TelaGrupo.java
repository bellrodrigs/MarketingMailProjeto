/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.view;

import br.com.ProjetoMarketingMail.controller.Marketingmailctrl;
import br.com.ProjetoMarketingMail.dao.MarketingMailDao;
import br.com.ProjetoMarketingMail.model.Contato;
import br.com.ProjetoMarketingMail.model.Grupo;
import br.com.ProjetoMarketingMail.util.ConnectionFactory;
import br.com.ProjetoMarketingMail.util.Excecao;
import br.com.ProjetoMarketingMail.util.MudaTelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaGrupo extends javax.swing.JFrame {
    
    
    private final Connection conexao;

    public TelaGrupo() {
        initComponents();
        this.setSize(800,680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        conexao = new ConnectionFactory().conexao();
        buscagrupo();
    }
    
    String opcaoSalvar;
    
   Marketingmailctrl marketingctrl = new Marketingmailctrl();
   Contato contato = new Contato();
   Grupo grupo = new Grupo();
   String gp;
      
    public void buscagrupo() {
        try {
            //conexao.setAutoCommit(false)persistir automaticamente no BD;//
            String sql;
            sql = "select idgrupo from grupo";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idGrupo.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar o Banco de dados. Reporte ao administrador");
        }
    }
    
    public void mandaGrupo() throws SQLException{

        String sql = "select * from grupo";
        PreparedStatement cmd = conexao.prepareStatement(sql);

        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {

            TelaCadastro.selecionaGrupo.addItem(rs.getString(1)+" "+rs.getString(2));
        }

    }
    
    private void incluigrupo(){
        String incluiGP = null;
        try {
            conexao.setAutoCommit(false);
            incluiGP = "INSERT INTO grupo(nome)"
                    + "VALUES ('" + nomeGrupo.getText() + "');";

            PreparedStatement ps = conexao.prepareStatement(incluiGP);
            ps.execute();
            conexao.commit();
            ps.close();
            JOptionPane.showMessageDialog(null, "Grupo salvo com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar\n" + erro + "\n" + incluiGP);

        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTNcadastrar = new javax.swing.JButton();
        LABELlselecione = new javax.swing.JLabel();
        nomeGrupo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();
        idGrupo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BTNcadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BTNcadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconesalvar_1.png"))); // NOI18N
        BTNcadastrar.setText("Cadastrar");
        BTNcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNcadastrar);
        BTNcadastrar.setBounds(620, 200, 130, 40);

        LABELlselecione.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        LABELlselecione.setForeground(new java.awt.Color(255, 255, 255));
        LABELlselecione.setText("*Nome do grupo:");
        getContentPane().add(LABELlselecione);
        LABELlselecione.setBounds(40, 190, 200, 80);

        nomeGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeGrupoActionPerformed(evt);
            }
        });
        getContentPane().add(nomeGrupo);
        nomeGrupo.setBounds(210, 200, 390, 40);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(640, 270, 110, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Os campos marcados com * são obrigatórios");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(210, 280, 390, 20);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo.png"))); // NOI18N
        layout.setText("jLabel1");
        layout.setMaximumSize(new java.awt.Dimension(1366, 768));
        layout.setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(layout);
        layout.setBounds(-290, -20, 1110, 790);

        idGrupo.setText("jLabel1");
        getContentPane().add(idGrupo);
        idGrupo.setBounds(780, 260, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeGrupoActionPerformed
        
    }//GEN-LAST:event_nomeGrupoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (nomeGrupo.getText().equals("")) {
            TelaGrupo.this.dispose();
        } else {
            try {
                mandaGrupo();
            } catch (SQLException ex) {
                Logger.getLogger(TelaGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
            TelaGrupo.this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcadastrarActionPerformed
        int grupoid = Integer.parseInt(idGrupo.getText());

        if (nomeGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome do grupo não pode estar vazio");
        } else if (grupoid > 9) {
            JOptionPane.showMessageDialog(null, "Você atingiu o número máximo de grupos");} 
        else {            
            try {
                marketingctrl.incluirGrupo(novoGrupo());

                JOptionPane.showMessageDialog(
                        this, "Grupo cadastrado com sucesso",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

            } catch (Excecao ex) {
                JOptionPane.showMessageDialog(
                        null, ex.getMsg(),
                        "Validação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BTNcadastrarActionPerformed

       public  Grupo novoGrupo() {
        if (opcaoSalvar == "novo") {
            return new Grupo(
                    nomeGrupo.getText()
            );
        } else {

            return new Grupo(
                    nomeGrupo.getText()
            );

        }

    }
    
    
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
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNcadastrar;
    private javax.swing.JLabel LABELlselecione;
    private javax.swing.JLabel idGrupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel layout;
    private javax.swing.JTextField nomeGrupo;
    // End of variables declaration//GEN-END:variables
}
