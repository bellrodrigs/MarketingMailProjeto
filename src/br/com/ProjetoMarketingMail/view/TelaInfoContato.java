/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.view;

import br.com.ProjetoMarketingMail.controller.Marketingmailctrl;
import br.com.ProjetoMarketingMail.model.Contato;
import br.com.ProjetoMarketingMail.util.ConnectionFactory;
import br.com.ProjetoMarketingMail.util.Excecao;
import br.com.ProjetoMarketingMail.util.MudaTelas;
import static br.com.ProjetoMarketingMail.view.TelaCadastro.selecionaGrupo;
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
public class TelaInfoContato extends javax.swing.JFrame {
    
    //metodos entrametodos = new metodos();
    private final Connection conexao;

    /**
     * Creates new form TelaCadastro
     */
    public TelaInfoContato() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        conexao = new ConnectionFactory().conexao();   
    }
    
    Marketingmailctrl marketingctrl = new Marketingmailctrl();
    Contato contato = new Contato();
    String opcaoSalvar;
    String gp;
    String est;
    String contatoid;    
     
     public void limpaCampos() {
        codcontato.setText("");
        nomeCliente.setText("");
        telefone.setText("");
        celular.setText("");
        estado.setText("");
        email.setText("");
        Grupo.setText("");

    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        codcontato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("##########");
            telefone = new javax.swing.JFormattedTextField(tel);
        } catch (Exception e) {
        }
        Grupo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estado = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter est = new javax.swing.text.MaskFormatter("UU");
            estado = new javax.swing.JFormattedTextField(est);
        } catch (Exception e) {
        }
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        celular = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cel = new javax.swing.text.MaskFormatter("##########");
            celular = new javax.swing.JFormattedTextField(cel);
        } catch (Exception e) {
        }
        jLabel8 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código do Contato:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 230, 170, 50);
        getContentPane().add(nomeCliente);
        nomeCliente.setBounds(330, 290, 800, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 290, 170, 50);

        codcontato.setEditable(false);
        getContentPane().add(codcontato);
        codcontato.setBounds(330, 230, 100, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 350, 170, 50);
        getContentPane().add(telefone);
        telefone.setBounds(330, 350, 350, 40);

        Grupo.setEditable(false);
        getContentPane().add(Grupo);
        Grupo.setBounds(790, 410, 210, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Celular:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 350, 70, 50);
        getContentPane().add(estado);
        estado.setBounds(330, 410, 350, 40);

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
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconealtera.png"))); // NOI18N
        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(890, 530, 110, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Grupo:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(710, 410, 70, 50);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Alterar Grupo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1020, 410, 110, 40);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconedeleta.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1020, 530, 110, 40);
        getContentPane().add(celular);
        celular.setBounds(790, 350, 340, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Os campos marcados com * são obrigatórios");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(330, 530, 390, 20);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo3.png"))); // NOI18N
        layout.setText("jLabel1");
        layout.setMaximumSize(new java.awt.Dimension(1366, 768));
        layout.setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(layout);
        layout.setBounds(-40, -10, 1600, 910);

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
        new MudaTelas().TelaDeConsulta();
        TelaInfoContato.this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new MudaTelas().Sair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new MudaTelas().EnviarEmail();
        TelaInfoContato.this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Email = email.getText();
         if (!Email.matches("^[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
                 || Email.equals("") || Email.length() > 80) {
             JOptionPane.showMessageDialog(null, "Verifique se:\n"
                     + "- E-mail está vazio\n"
                     + "- Formato do e-mail está corrento Ex: exemplo@exemplo.com\n"
                     + "- O E-mail precisa conter no máximo 80 caracteres");
        }
         else if (nomeCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O nome não pode estar vazio");
        } else {
            contato.setIdcontato(Integer.parseInt(codcontato.getText()));
            try {
                marketingctrl.alterar(novoContato());
                JOptionPane.showMessageDialog(
                        this, "Alteração realizada com sucesso",
                        "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
            } catch (Excecao ex) {
                Logger.getLogger(TelaInfoContato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        contato.setIdcontato(Integer.parseInt(codcontato.getText()));
        try {
            excluirContato();
            limpaCampos();
        } catch (Excecao ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MudaTelas().TelaDeCadastro();
        TelaInfoContato.this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
       new MudaTelas().Relatorios();
       TelaInfoContato.this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaGrupoAltera grupoaltera = new TelaGrupoAltera();
        grupoaltera.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public Contato novoContato() {
        
        gp = String.valueOf(Grupo.getText());
        gp = gp.substring(0, 1);
        
     
        return new Contato(
                Integer.parseInt(codcontato.getText()),
                nomeCliente.getText(),
                telefone.getText(),
                celular.getText(),
                estado.getText(),
                email.getText(),
                gp                
        );
    }
    
    public void excluirContato() throws Excecao {
        marketingctrl.excluir(contato);
        JOptionPane.showMessageDialog(null, "Contato excluído com sucesso.");
    }

    
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
            java.util.logging.Logger.getLogger(TelaInfoContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInfoContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInfoContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInfoContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInfoContato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Grupo;
    public static javax.swing.JTextField celular;
    public static javax.swing.JTextField codcontato;
    public static javax.swing.JTextField email;
    public static javax.swing.JTextField estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel layout;
    public static javax.swing.JTextField nomeCliente;
    public static javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
