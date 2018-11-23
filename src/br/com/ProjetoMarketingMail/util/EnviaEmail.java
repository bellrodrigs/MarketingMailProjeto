/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.util;

import br.com.ProjetoMarketingMail.model.Email;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
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
import javax.imageio.ImageIO;



public class EnviaEmail {
    
    public void EnviaMensagem(Email email){
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
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "marketingshowshow@gmail.com",
                        "De@thnote1"
                );
            }
        });

        // Ativa Debug para sessão /
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("marketingshowshow@gmail.com"));
            //Quem manda

            Address[] toUser = InternetAddress.parse("isabelrodrgs@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("teste");//Assunto
            message.setContent("teste", "text/html;charset=utf-8");
            //Método para enviar a mensagem criada
            Transport.send(message);
            //JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void EnviaTexto(String enderecoemail,String assunto, String mensagem){
         
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
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "marketingshowshow@gmail.com",
                        "De@thnote1"
                );
            }
        });

        // Ativa Debug para sessão /
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("marketingshowshow@gmail.com"));
            //Quem manda

            Address[] toUser = InternetAddress.parse(enderecoemail);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setContent(mensagem, "text/html;charset=utf-8");
            //Método para enviar a mensagem criada
            Transport.send(message);
            //JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    

    public void EnviaTexto(Email novoEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
