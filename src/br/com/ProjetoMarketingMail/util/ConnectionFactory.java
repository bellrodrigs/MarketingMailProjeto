
package br.com.ProjetoMarketingMail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    public Connection conexao() {
        String servidor = "localhost";
        String bancoDados = "dbMarketingMail";
        String usuario = "root";
        String senha = "";//na faetec colocar admin
        
        try {
            return DriverManager.getConnection(
                String.format("jdbc:mysql://%s/%s?useSSL=false", servidor, bancoDados), usuario, senha);                    
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(
                null, ex.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }
}
