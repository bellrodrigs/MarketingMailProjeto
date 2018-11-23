/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Bell Rodrigues
 */
public class clientsocket {
    
    public static void saida(){
          try {
              
              String mensagem = "Enviando pelo socket, apenas no java, não no android lixo studio";
              String text2 = "gui.cpaula@gmail.com";
              String text3 = "isabelrodrgs@gail.com";
            
            Socket socketCliente = new Socket("localhost", 8787); //colocar o ip da sua casa
            
            DataInputStream  in = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream out = new DataOutputStream(socketCliente.getOutputStream());
            
            out.writeUTF(""); 
            out.writeUTF("");
            out.writeUTF("");
            out.flush();
            
              System.out.println("foi!");
            
            //Integer resposta = in.readInt();
            
            /*switch(resposta) {
                
                //Sucesso
                case 0:
                    System.out.println("E-mail enviado com sucesso");
                    break;
                 
                //Menor de Idade
                case 1:
                    
                    System.out.println("ERRO: USUÁRIO MENOR DE IDADE.");
                    break;
                  
                //CPF inválido
                case 2:
                    
                    System.out.println("ERRO: CPF INVÁLIDO.");
                    break;
            }*/
            
            
            in.close();
            out.close();
            
            socketCliente.close();
            
            
        } catch(Exception e) {
            
            e.printStackTrace();
            System.out.println("Erro inesperado no Cliente: " + e.getMessage());
        }
    }
    
     public static void main(String[] args){
      
     saida();
      
       
    }
}
