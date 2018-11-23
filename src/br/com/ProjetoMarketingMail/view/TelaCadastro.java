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
import br.com.ProjetoMarketingMail.util.servidorsocket;
import com.mysql.jdbc.Util;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaCadastro extends javax.swing.JFrame {

    private final Connection conexao;

    /**
     * Creates new form TelaCadastro
     *
     * @param parent
     * @param modal
     */
    public TelaCadastro(java.awt.Frame parent, boolean modal) {

        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        conexao = new ConnectionFactory().conexao();
        buscagrupo();
    }

    String gp;
    String est;
    Contato contato = new Contato();
    Grupo grupo = new Grupo();
    Marketingmailctrl marketingmailctrl = new Marketingmailctrl();
    MarketingMailDao marketingdao = new MarketingMailDao();
    servidorsocket servidor = new servidorsocket();
    String opcaoSalvar;

    public void buscagrupo() {

        try {

            String sql;
            sql = "select * from grupo";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                selecionaGrupo.addItem(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar o Banco de dados. Reporte ao administrador");
        }
    }

    public void limpaCampos() {
        nomeCliente.setText("");
        telefone.setText("");
        celular.setText("");
        estado1.removeAll();
        email.setText("");
        selecionaGrupo.removeAll();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("##########");
            telefone = new javax.swing.JFormattedTextField(tel);
        } catch (Exception e) {
        }
        celular = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cel = new javax.swing.text.MaskFormatter("##########");
            celular = new javax.swing.JFormattedTextField(cel);
        } catch (Exception e) {
        }
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        selecionaGrupo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        estado1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(nomeCliente);
        nomeCliente.setBounds(330, 290, 800, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 290, 170, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 350, 170, 50);
        getContentPane().add(telefone);
        telefone.setBounds(330, 350, 350, 40);
        getContentPane().add(celular);
        celular.setBounds(790, 350, 340, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Celular:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 350, 170, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 410, 170, 50);
        getContentPane().add(email);
        email.setBounds(330, 470, 800, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*E-mail:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(160, 470, 170, 50);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconesalvar_1.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1000, 530, 130, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Grupo:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(710, 410, 70, 50);

        getContentPane().add(selecionaGrupo);
        selecionaGrupo.setBounds(790, 410, 190, 40);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Cadastrar Grupo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(990, 410, 140, 40);

        estado1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        estado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado1ActionPerformed(evt);
            }
        });
        getContentPane().add(estado1);
        estado1.setBounds(330, 410, 350, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Os campos marcados com * são obrigatórios");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 530, 390, 20);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo3.png"))); // NOI18N
        layout.setText("jLabel1");
        layout.setMaximumSize(new java.awt.Dimension(1366, 768));
        layout.setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(layout);
        layout.setBounds(-40, -10, 1450, 910);

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

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem6.setText("Consultar Contatos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new MudaTelas().Sair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new MudaTelas().EnviarEmail();
        TelaCadastro.this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new MudaTelas().TelaDeConsulta();
        TelaCadastro.this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MudaTelas().CadastraGrupo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (nomeCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome não pode estar vazio");
        } else if (selecionaGrupo.equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso ter ao menos um grupo cadastrado");
        } else if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O E-mail não pode estar vazio");
        } else {
            try {
                marketingmailctrl.incluir(novoContato());
                JOptionPane.showMessageDialog(
                        this, "Cadastro realizado com sucesso",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE
                );
                limpaCampos();
            } catch (Excecao ex) {
                JOptionPane.showMessageDialog(
                        null, ex.getMsg(),
                        "Problema e Validaçãoo", JOptionPane.ERROR_MESSAGE
                );
            }
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new MudaTelas().Relatorios();
        TelaCadastro.this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void estado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estado1ActionPerformed

    public Contato novoContato() {

        gp = String.valueOf(selecionaGrupo.getSelectedItem());
        gp = gp.substring(0, 1);
        
        est = String.valueOf(estado1.getSelectedItem());
        est = est.substring(0,2);
        if (opcaoSalvar == "novo") {
            return new Contato(
                    nomeCliente.getText(),
                    telefone.getText(),
                    celular.getText(),
                    est,
                    email.getText(),
                    gp
            );
        } else {
            return new Contato(
                    nomeCliente.getText(),
                    telefone.getText(),
                    celular.getText(),
                    est,
                    email.getText(),
                    gp
            );
        }
    }

    /**
     * public void localizarGrupo() { marketingdao.consultarGrupo(grupo);
     * preencherGrupo(); }
     *
     * public void preencherGrupo() {
     * selecionaGrupo.addItem(String.valueOf(grupo.getIdgrupo()) + " " +
     * grupo.getNome());
    }*
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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaCadastro dialog = new TelaCadastro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField celular;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> estado1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel layout;
    private javax.swing.JTextField nomeCliente;
    public static javax.swing.JComboBox<String> selecionaGrupo;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
