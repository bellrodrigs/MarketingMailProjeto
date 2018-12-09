
package br.com.ProjetoMarketingMail.util;

import br.com.ProjetoMarketingMail.view.TelaEnviarEmail;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class servidorsocket {


public void servidor(){    
                /*String emailUsuario;
                String senhaUsuario;
                String email;
                String assunto; 
                String mensagem; */
     while(true) {
            
            try {
            
                System.out.println("-------------------");
                
                System.out.println("INCIANDO SERVIDOR...");

                ServerSocket serverSocket = new ServerSocket(8787);

                System.out.println("AGUARDANDO CLIENTE...");

                Socket socketCliente = serverSocket.accept();

                System.out.println("CONEXÃO RECEBIDA...");
                
                
                DataInputStream  in  = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream out = new DataOutputStream(socketCliente.getOutputStream());

                System.out.println("CANAIS DE COMUNICAÇÃO OK.");

                System.out.println("RECEBENDO DADOS...");
                String emailUsuario      = in.readUTF();
                String senhaUsuario    = in.readUTF();
                String email      = in.readUTF();
                String assunto    = in.readUTF();
                String mensagem   = in.readUTF();
                

                
                System.out.println("emailUsuario: "      + emailUsuario);
                //System.out.println("senhaUsuario: "    + senhaUsuario);
                System.out.println("email: "      + email);
                System.out.println("Assunto: "    + assunto);
                System.out.println("Mensagem: "    + mensagem);
                
                //colcoar o metodo que envia email com dois parametros email - corpo da mensagem
                
                Integer resp = null;
                
                TelaEnviarEmail envia = new TelaEnviarEmail();
                
                if(envia.EnviaAndroid(emailUsuario, senhaUsuario, email, assunto, mensagem)){
                    resp = 1;
                    System.out.println("enviado com sucesso");                    
                }else if(!envia.EnviaAndroid(emailUsuario, senhaUsuario, email, assunto, mensagem)) {
                    resp = 0;
                    System.out.println("não foi enviado");
                }
                
                
                out.writeInt(resp);

                in.close();
                out.flush();
                out.close();
                socketCliente.close();
                serverSocket.close();

                System.out.println("PROCESSAMENTO FINALIZADO COM SUCESSO");
                
                

            } catch(Exception e) {

                e.printStackTrace();
                System.out.println("Erro Inesperado: " + e.getMessage());
            }
        } 
    }

     public static void main(String[] args){
      
     servidorsocket servidor = new servidorsocket();
     
     servidor.servidor();
      
       
    }
}
    

