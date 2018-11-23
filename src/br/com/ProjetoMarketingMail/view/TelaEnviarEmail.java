/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.view;

import br.com.ProjetoMarketingMail.model.Email;
import br.com.ProjetoMarketingMail.util.ConnectionFactory;
import br.com.ProjetoMarketingMail.util.EnviaEmail;
import br.com.ProjetoMarketingMail.util.Excecao;
import br.com.ProjetoMarketingMail.util.MudaTelas;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import java.io.*;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Bell Rodrigues
 */
public class TelaEnviarEmail extends javax.swing.JFrame {

    private final Connection conexao;

    public String URLImagem;
    public int i;

    /**
     * Creates new form TelaCadastro
     */
    public TelaEnviarEmail() {

        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        conexao = new ConnectionFactory().conexao();
        EnviaEmail enviaemail = new EnviaEmail();
        Email email = new Email();
        buscaGrupo();
        this.enderecoemail = enderecoEmail.getText();
        this.assunto = Assunto.getText();
        RBTodos.setSelected(true);
    }

    EnviaEmail enviaemail;
    String enviaEmail;
    String enderecoemail;
    String assunto;
    String mensagem;

    public void salvaEmai() throws SQLException {

        //Pega data e Formata
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        formatador.format(data);
        String emails;

        if (RBTodos.isSelected()) {
            //Pega os emails
            emails = enviaEmailTodos();

            //Trasforma os emails em Array
            String[] emailsArray = emails.split(", ");

            //Cria o contador para os array do e-mail
            for (int i = 0; emailsArray.length > i; i++) {
                System.out.println(emailsArray[i]);

                conexao.setAutoCommit(false);
                String sql = "INSERT INTO email (email,data) VALUES (?,?)";
                PreparedStatement rs = conexao.prepareStatement(sql);

                rs.setString(1, emailsArray[i]);
                rs.setString(2, formatador.format(data));

                rs.execute();
                conexao.commit();
                rs.close();

            }
        } else if (RBGrupo.isSelected()) {
            //Pega os emails
            emails = enviaEmailGrupo();

            //Trasforma os emails em Array
            String[] emailsArray = emails.split(", ");

            //Cria o contador para os array do e-mail
            for (int i = 0; emailsArray.length > i; i++) {
                System.out.println(emailsArray[i]);

                conexao.setAutoCommit(false);
                String sql = "INSERT INTO email (email,data) VALUES (?,?)";
                PreparedStatement rs = conexao.prepareStatement(sql);

                rs.setString(1, emailsArray[i]);
                rs.setString(2, formatador.format(data));

                rs.execute();
                conexao.commit();
                rs.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        enderecoEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        RBTodos = new javax.swing.JRadioButton();
        RBGrupo = new javax.swing.JRadioButton();
        selecionaGrupo = new javax.swing.JComboBox<>();
        Assunto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Urlimagem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        endDocumento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        imagemPreview = new javax.swing.JLabel();
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
        getContentPane().add(enderecoEmail);
        enderecoEmail.setBounds(410, 210, 240, 40);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconeenvia.png"))); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(930, 530, 120, 40);

        buttonGroup1.add(RBTodos);
        RBTodos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        RBTodos.setForeground(new java.awt.Color(255, 255, 255));
        RBTodos.setText("Todos");
        RBTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBTodosActionPerformed(evt);
            }
        });
        getContentPane().add(RBTodos);
        RBTodos.setBounds(410, 280, 93, 25);

        buttonGroup1.add(RBGrupo);
        RBGrupo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        RBGrupo.setForeground(new java.awt.Color(255, 255, 255));
        RBGrupo.setText("Grupo");
        getContentPane().add(RBGrupo);
        RBGrupo.setBounds(560, 280, 70, 25);

        selecionaGrupo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(selecionaGrupo);
        selecionaGrupo.setBounds(650, 270, 210, 40);
        getContentPane().add(Assunto);
        Assunto.setBounds(410, 330, 640, 40);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/inconebusca.png"))); // NOI18N
        jButton2.setText("Buscar Imagem");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(470, 450, 150, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Escolha sua imagem:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 470, 180, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("URL Imagem:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(290, 400, 130, 30);
        getContentPane().add(Urlimagem);
        Urlimagem.setBounds(410, 390, 640, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enviar para:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 280, 110, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*E-mail:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 220, 90, 30);
        getContentPane().add(Senha);
        Senha.setBounds(760, 210, 290, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Senha:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(670, 220, 90, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Assunto:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 340, 90, 30);

        endDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        endDocumento.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(endDocumento);
        endDocumento.setBounds(630, 460, 280, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Os campos marcados com * são obrigatórios");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(410, 520, 390, 20);
        getContentPane().add(imagemPreview);
        imagemPreview.setBounds(950, 440, 90, 70);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ProjetoMarketingMail/view/imagem/fundo3.png"))); // NOI18N
        layout.setText("jLabel1");
        layout.setMaximumSize(new java.awt.Dimension(1366, 768));
        layout.setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(layout);
        layout.setBounds(0, 0, 1470, 880);

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
        TelaEnviarEmail.this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new MudaTelas().Sair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new MudaTelas().TelaDeCadastro();
        TelaEnviarEmail.this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void RBTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBTodosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(enderecoEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null,"É preciso informar uma conta de e-mail");
        }else if(Senha.getText().equals("")){
            JOptionPane.showMessageDialog(null,"A senha precisa ser preenchida");
        }else{
        try {
            enviaEmail();
            salvaEmai();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar E-mail.\nVerifique se o E-mail e a senha estão corretos ou "
                    + "se seu e-mail está configurado corretamente");
        }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        this.URLImagem = getImgurContent();
        this.URLImagem = this.URLImagem.replaceAll("{}".format("\\\\"), "");
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new MudaTelas().Relatorios();
        TelaEnviarEmail.this.dispose();

    }//GEN-LAST:event_jMenu3MouseClicked

    public void buscaGrupo() {

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

    public String enviaEmailTodos() throws SQLException {
        String emails = "";

        String sql = "SELECT email FROM contato";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            if (emails == "") {
                emails = emails + rs.getString(1);
            } else {
                emails = emails + ", " + rs.getString(1);
            }
        }
        return emails;
    }

    public String enviaEmailGrupo() throws SQLException {
        String emails = "";

        String grupo = String.valueOf(selecionaGrupo.getSelectedItem());
        grupo = grupo.substring(0, 1);

        String sql = "select email from contato where idgrupo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, Integer.parseInt(grupo));
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (emails == "") {
                emails = emails + rs.getString(1);
            } else {
                emails = emails + ", " + rs.getString(1);
            }

        }
        return emails;
    }

    //Envia Email a partir de URL da imagem   
    public void enviaEmail() throws SQLException {
        String emails;
        String assunto = Assunto.getText();
        String urlimagem = Urlimagem.getText();
        String mensagemURL = null;

        if (urlimagem.isEmpty()) {
            urlimagem = this.URLImagem;
        }

        mensagemURL = "<img src='" + urlimagem + "' style='background-repeat: no-repeat; margin-left: 10%;' />";

        //Separando para enviar para TODOS ou para um GRUPO
        if (RBTodos.isSelected()) {
            emails = enviaEmailTodos();
        } else {
            emails = enviaEmailGrupo();
        }

        Properties props = new Properties();
        // Parâmetros de conexão com servidor Gmail 
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put(
                "mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"
        );
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        //Aqui entra o E-mail e a senha do usuário
                        enderecoEmail.getText(),
                        Senha.getText()
                );
            }
        });

        // Ativa Debug para sessão /
        session.setDebug(true);

        try {
            //Quem manda
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(enderecoEmail.getText()));

            Address[] toUser = InternetAddress.parse(emails);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setContent(mensagemURL, "text/html;charset=utf-8");
            //Método para enviar a mensagem criada
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, e + "\n" + "Erro no login. Verfique se seu e-mail e sua senha estão corretos."
                    + "\nVerifique também a configuração do seu e-mail.");
            throw new RuntimeException(e);
        }
    }

    //Busca arquivos no Computador
    public String BuscaArquivo() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        String endereco = chooser.getSelectedFile().getAbsolutePath();
        endDocumento.setText(endereco);
        ImageIcon icon=new ImageIcon(endereco);
        Image image = icon.getImage().getScaledInstance(imagemPreview.getWidth(), imagemPreview.getHeight(), Image.SCALE_SMOOTH);
        imagemPreview.setIcon(new ImageIcon(image));
        return endereco;
    }

    //Conexão com API do IMGUR
    public String getImgurContent() {
        URL url;
        String clientID = "6d477cbe0a90a32";

        try {
            url = new URL("https://api.imgur.com/3/image");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //cria base64 da imagem
            BufferedImage image = null;
            File file = new File(BuscaArquivo());
            //lê image

            image = ImageIO.read(file);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArray);
            byte[] byteImage = byteArray.toByteArray();
            String dataImage = Base64.encode(byteImage);
            String data = URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(dataImage, "UTF-8");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Client-ID " + clientID);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.connect();
            StringBuilder stb = new StringBuilder();
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Recebe a resposta
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                stb.append(line).append("\n");
                System.out.println(stb.toString());
            }
            //Substitui os caracteres '\' por '/'
            String[] stringArray = stb.toString().split("\"");
            wr.close();
            rd.close();
            return stringArray[67];
        } catch (IOException e) {
            System.out.println("Erro de Conexão com a API Imgur");
        }
        return null;
    }

    ///Envia mensagem por Android a partir do servidor socket
    public boolean EnviaAndroid(String emailUsuario, String senhaUsuario, String email, String assunto, String mensagem) {
        Boolean resposta = false;
        Properties props = new Properties();
        // Parâmetros de conexão com servidor Gmail 
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put(
                "mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"
        );
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() { //Original 'protected', mas para utilizar metodo fora precisa colocar 'public'.
                return new PasswordAuthentication(
                        emailUsuario,
                        senhaUsuario
                );
            }
        });

        // Ativa Debug para sessão /
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailUsuario));
            //Quem manda

            Address[] toUser = InternetAddress.parse(email);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setContent(mensagem, "text/html;charset=utf-8");
            //Método para enviar a mensagem criada
            Transport.send(message);
            
            resposta = true;
        } catch (MessagingException e) {
            System.out.println(e + "\nErro ao enviar o email");
        }
        
        return resposta;
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
            java.util.logging.Logger.getLogger(TelaEnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEnviarEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaEnviarEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Assunto;
    private javax.swing.JRadioButton RBGrupo;
    private javax.swing.JRadioButton RBTodos;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JTextField Urlimagem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel endDocumento;
    private javax.swing.JTextField enderecoEmail;
    private javax.swing.JLabel imagemPreview;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JComboBox<String> selecionaGrupo;
    // End of variables declaration//GEN-END:variables
}