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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaPessoasGrupo extends javax.swing.JFrame {
    
    
    private final Connection conexao;

    public TelaPessoasGrupo() {
        initComponents();
        this.setSize(600,540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        conexao = new ConnectionFactory().conexao();
        
    }
    
    String opcaoSalvar;
    
   Marketingmailctrl marketingctrl = new Marketingmailctrl();
   Contato contato = new Contato();
   Grupo grupo = new Grupo();
  
   
   
            
   
        public void geradorPdfGrupo() {

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        formatador.format(data);


        String nomeDoc = JOptionPane.showInputDialog("Digite o nome do documento:");
        Document doc = new Document(PageSize.A4);

        try {                                                   //home/lab03/Documentos/
            PdfWriter.getInstance(doc, new FileOutputStream( nomeDoc + ".pdf"));
            doc.open();

            doc.add(new Paragraph("Relatório de Grupo", FontFactory.getFont(
                    FontFactory.COURIER, 20, Font.BOLD, BaseColor.BLACK)));
            doc.add(new Paragraph("Data: "+formatador.format(data)));
            doc.add(new Paragraph("\n"));

            PdfPTable tabela = new PdfPTable(2);

            PdfPCell cabeçalho = new PdfPCell(new Paragraph("Informações dos contatos"));
            cabeçalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabeçalho.setColspan(2);

            tabela.addCell(cabeçalho);
            tabela.addCell("Nome");
            tabela.addCell("E-mail");

            String sql = "select nome,email from contato where idgrupo like ?";
            PreparedStatement cmd = conexao.prepareStatement(sql);
            cmd.setString(1, "%" + gptxt.getText() + "%");
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                tabela.addCell(rs.getString("nome"));
                tabela.addCell(rs.getString("email"));

            }

            doc.add(tabela);

            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso");

        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(TelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }

        try {
            Desktop.getDesktop().open(
                    new File(nomeDoc + ".pdf"));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaInfogp = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtgp = new javax.swing.JLabel();
        gptxt = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tabelaInfogp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaInfogp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 560, 400);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/pdf.png"))); // NOI18N
        jButton2.setText("Gerar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 420, 130, 40);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 420, 80, 30);

        txtgp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo3.png"))); // NOI18N
        txtgp.setText("jLabel1");
        getContentPane().add(txtgp);
        txtgp.setBounds(0, 0, 600, 500);

        gptxt.setText("jLabel2");
        getContentPane().add(gptxt);
        gptxt.setBounds(380, 450, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        geradorPdfGrupo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaPessoasGrupo.this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    
    
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
            java.util.logging.Logger.getLogger(TelaPessoasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPessoasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPessoasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPessoasGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new TelaPessoasGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel gptxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabelaInfogp;
    private javax.swing.JLabel txtgp;
    // End of variables declaration//GEN-END:variables
}
