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
import static br.com.ProjetoMarketingMail.view.TelaPessoasGrupo.tabelaInfogp;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaRelatorio extends javax.swing.JFrame {

    private final Connection conexao;

    public TelaRelatorio() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        conexao = new ConnectionFactory().conexao();
        try {
            buscagrupo();
            ContaContato();
            ContaGrupo();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    TelaPessoasGrupo pessoasgrupo = new TelaPessoasGrupo();
    TelaPessoas pessoas = new TelaPessoas();
    TelaRelatorioEmails relatorioemails = new TelaRelatorioEmails();
    TelaRelatorioEmailsTodos relatorioemailstodos = new TelaRelatorioEmailsTodos();

    public void buscagrupo() {

        try {

            //conexao.setAutoCommit(false)persistir automaticamente no BD;//
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

    public void ContaContato() throws SQLException {
        try {

            String sql = "select count(*) from contato";
            PreparedStatement cmd = conexao.prepareStatement(sql);

            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {

                //gptotal.setText(String.valueOf(rs.getInt(1)));
                contatoTotal.setText(rs.getString(1));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar no banco de dados");

        }
    }

    public void ContaGrupo() throws SQLException {
        try {

            String sql = "select count(*) from grupo";
            PreparedStatement cmd = conexao.prepareStatement(sql);

            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {

                grupoTotal.setText(rs.getString(1));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao consultar no banco de dados");

        }
    }

    public void JogaValor() throws SQLException {

        String grupo = String.valueOf(selecionaGrupo.getSelectedItem());
        grupo = grupo.substring(0,1);

        String sql = "select count(*) from contato where idgrupo like ?";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        cmd.setString(1, "%" + grupo + "%");
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(1));
            gptotal.setText(rs.getString(1));
        }
        System.out.println(grupo);
    }

    public void mandaDadosGrupo() throws SQLException {

        String grupo = String.valueOf(selecionaGrupo.getSelectedItem());
        grupo = grupo.substring(0, 1);

        String sql = "select nome,email,idgrupo from contato where idgrupo like ?";
        PreparedStatement cmd = conexao.prepareStatement(sql);

        cmd.setString(1, "%" + grupo + "%");
        ResultSet rs = cmd.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) TelaPessoasGrupo.tabelaInfogp.getModel();

        modelo.setNumRows(0);

        while (rs.next()) {
           modelo.addRow(new String[]{rs.getString(1), rs.getString(2)});
          TelaPessoasGrupo.gptxt.setText(rs.getString("idgrupo"));
        }
    }

    public void mandaDadosContato() throws SQLException {
        String sql = "select contato.nome,contato.email,grupo.nome  from contato INNER JOIN grupo on grupo.idgrupo = contato.idgrupo ORDER BY grupo.nome";

        PreparedStatement cmd = conexao.prepareStatement(sql);

        ResultSet rs = cmd.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) TelaPessoas.tabelaInfogp.getModel();

        modelo.setNumRows(0);

        while (rs.next()) {
            System.out.println(rs.getString("contato.nome"));
            modelo.addRow(new String[]{rs.getString("contato.nome"), rs.getString("contato.email"), rs.getString("grupo.nome")});
        }
    }

    public void buscaEmai() throws SQLException {
        String sql = "select count(*) from email";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            emailTotal.setText(rs.getString(1));
        }
    }

    public void periodoDias() throws SQLException {

        int data = Integer.parseInt(totalDias.getText());

        //Pega data atual e diminui por 30
        LocalDate date = LocalDate.now().minusDays(data);

        String sql = "select count(idemail) from email where data >  " + "'" + date + "'" + ";";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            diasTotal.setText(rs.getString(1));
        }
    }

    public void JogaDataEmail() throws SQLException {

        String sql = "select * from email ORDER BY data";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) TelaRelatorioEmailsTodos.tabelaInfogp.getModel();

        modelo.setNumRows(0);

        while (rs.next()) {
            modelo.addRow(new String[]{rs.getString("email"), rs.getString("data")});
        }
    }

    public void JogaDiasEmail() throws SQLException {

        int data = Integer.parseInt(totalDias.getText());
        LocalDate date = LocalDate.now().minusDays(data);

        String sql = "select * from email where data >  " + "'" + date + "'" + "ORDER BY data;";
        PreparedStatement cmd = conexao.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) TelaRelatorioEmails.tabelaInfogp.getModel();

        modelo.setNumRows(0);

        while (rs.next()) {
            modelo.addRow(new String[]{rs.getString("email"), rs.getString("data")});
        }
    }
    
    

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        contatoTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        grupoTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        selecionaGrupo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        gptotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        emailTotal = new javax.swing.JTextField();
        diasTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalDias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
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

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(70, 60));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Todos os contatos;");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 30, 170, 50);

        contatoTotal.setEditable(false);
        contatoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contatoTotalActionPerformed(evt);
            }
        });
        jPanel1.add(contatoTotal);
        contatoTotal.setBounds(180, 30, 190, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Todos os Grupos;");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 170, 50);

        grupoTotal.setEditable(false);
        grupoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupoTotalActionPerformed(evt);
            }
        });
        jPanel1.add(grupoTotal);
        grupoTotal.setBounds(180, 100, 190, 40);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Expandir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 160, 100, 30);

        jTabbedPane1.addTab("Todos", jPanel1);

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        selecionaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaGrupoActionPerformed(evt);
            }
        });
        jPanel2.add(selecionaGrupo);
        selecionaGrupo.setBounds(20, 70, 190, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Contatos por grupo:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 10, 170, 50);

        gptotal.setEditable(false);
        gptotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gptotalActionPerformed(evt);
            }
        });
        jPanel2.add(gptotal);
        gptotal.setBounds(220, 70, 160, 40);

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("Expandir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(280, 120, 100, 30);

        jTabbedPane1.addTab("Grupos", jPanel2);

        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Todos os E-mais:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 30, 170, 50);

        emailTotal.setEditable(false);
        emailTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTotalActionPerformed(evt);
            }
        });
        jPanel3.add(emailTotal);
        emailTotal.setBounds(160, 30, 210, 40);

        diasTotal.setEditable(false);
        diasTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasTotalActionPerformed(evt);
            }
        });
        jPanel3.add(diasTotal);
        diasTotal.setBounds(250, 100, 110, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("dias:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(200, 100, 50, 50);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconebusca.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(370, 110, 110, 30);
        jPanel3.add(totalDias);
        totalDias.setBounds(110, 100, 80, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Nos últimos ");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 100, 110, 50);

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("Expandir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(490, 110, 120, 30);

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setText("Expandir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(380, 40, 100, 30);

        jTabbedPane1.addTab("E-mail", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(340, 190, 700, 250);

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
        TelaConsulta telaconsulta = new TelaConsulta();
        telaconsulta.setVisible(true);
        TelaRelatorio.this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new MudaTelas().Sair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaEnviarEmail enviaemail = new TelaEnviarEmail();
        enviaemail.setVisible(true);
        TelaRelatorio.this.dispose();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MudaTelas().TelaDeCadastro();
        TelaRelatorio.this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        TelaRelatorio relatorio = new TelaRelatorio();
        relatorio.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void contatoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contatoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contatoTotalActionPerformed

    private void grupoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupoTotalActionPerformed

    private void gptotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gptotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gptotalActionPerformed

    private void selecionaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaGrupoActionPerformed
        
        try {
            JogaValor();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selecionaGrupoActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try {
            ContaContato();
            buscaEmai();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        //buscagrupo();
        

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            mandaDadosGrupo();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        pessoasgrupo.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            mandaDadosContato();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        pessoas.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emailTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTotalActionPerformed

    private void diasTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (totalDias.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso que informe o número de dias para fazer a busca.");
        } else {
            try {
                periodoDias();
            } catch (SQLException ex) {
                Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (totalDias.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "É preciso que informe o número de dias para fazer a busca.");
        } else {
            try {
                JogaDiasEmail();
            } catch (SQLException ex) {
                Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
            relatorioemails.setVisible(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            JogaDataEmail();
        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        relatorioemailstodos.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       
    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contatoTotal;
    private javax.swing.JTextField diasTotal;
    private javax.swing.JTextField emailTotal;
    private javax.swing.JTextField gptotal;
    private javax.swing.JTextField grupoTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel layout;
    public static javax.swing.JComboBox<String> selecionaGrupo;
    public static javax.swing.JTextField totalDias;
    // End of variables declaration//GEN-END:variables
}
