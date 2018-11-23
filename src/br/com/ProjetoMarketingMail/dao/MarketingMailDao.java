
package br.com.ProjetoMarketingMail.dao;

import br.com.ProjetoMarketingMail.model.Contato;
import br.com.ProjetoMarketingMail.model.Grupo;
import br.com.ProjetoMarketingMail.util.ConnectionFactory;
import br.com.ProjetoMarketingMail.util.Excecao;
import br.com.ProjetoMarketingMail.view.TelaCadastro;
import br.com.ProjetoMarketingMail.view.TelaInfoContato;
import static br.com.ProjetoMarketingMail.view.TelaInfoContato.celular;
import static br.com.ProjetoMarketingMail.view.TelaInfoContato.codcontato;
import static br.com.ProjetoMarketingMail.view.TelaInfoContato.email;
import static br.com.ProjetoMarketingMail.view.TelaInfoContato.telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static br.com.ProjetoMarketingMail.view.TelaInfoContato.estado;

public class MarketingMailDao {
    private Connection conexao;
    
    public MarketingMailDao() {
        conexao = new ConnectionFactory().conexao();
    }
    
    public void cadastrar(Contato contato) throws Excecao {
        try {
            conexao.setAutoCommit(false);
            
            //String grupo = String.valueOf(selecionaGrupo.getSelectedItem());
            //grupo = grupo.substring( 0,1);
            
            String sql = "INSERT INTO contato (nome,telefone,celular,estado,email,idgrupo) VALUES (?,?,?,?,?,?)";                       
            
            PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, contato.getNome());
                ps.setString(2, contato.getTelefone());
                ps.setString(3, contato.getCelular());
                ps.setString(4, contato.getEstado());
                ps.setString(5, contato.getEmail());
                ps.setString(6, contato.getIdgrupo());
                
            ps.execute();
            
            conexao.commit();
            ps.close();
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar contato no banco de dados. Reporte ao administrador");
        }
    }
    
    public void cadastrarGrupo(Grupo grupo) throws Excecao {
        try {
            conexao.setAutoCommit(false);

            String sql = "INSERT INTO grupo(nome)"
                    + "VALUES ('" + grupo.getNome() + "');";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
            conexao.commit();
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar grupo no banco de dados. Reporte ao administrador");
        }
    }
    
    
    
    public void consultar(Contato contato) {
        String sql = "select * from contato where nome = " + contato.getNome();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {                
                contato.setIdcontato(rs.getInt("idcontato"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setCelular(rs.getString("celular"));
                contato.setEstado(rs.getString("estado"));
                contato.setEmail(rs.getString("email"));
                contato.setIdgrupo(rs.getString("idgrupo"));
                           
            } 
                        
            System.out.println(contato.getIdgrupo());
            
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao consultar banco de dados. Reporte ao administrador");
        }                
    }
    
    public void alterar(Contato contato){
        
        try {
            String query = "UPDATE contato SET nome=?,telefone=?,celular=?,estado=?,email=?, idgrupo=? WHERE idcontato = ?";
            
            PreparedStatement ps = conexao.prepareStatement(query);
            
                ps.setString(1, contato.getNome());
                ps.setString(2, contato.getTelefone());
                ps.setString(3, contato.getCelular());
                ps.setString(4, contato.getEstado());
                ps.setString(5, contato.getEmail());
                ps.setString(6, contato.getIdgrupo());
                ps.setInt(7, contato.getIdcontato());
                
                ps.execute();
                ps.close();
               
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao alterar o contato");
        }
    }
    
    public void excluir(Contato contato) {
        String sql = "delete from contato where idcontato = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, contato.getIdcontato());
            ps.execute();
            
            ps.close();            
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao excluir o registro no banco de dados. Reporte ao administrador");
        }
    }
    
    public void consultarGrupo(Grupo gp) {

        //String grupo = String.valueOf(TelaCadastro.selecionaGrupo.getSelectedItem());
        //grupo = grupo.substring(0, 1);

        String sql = "select * from grupo";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                gp.setIdgrupo(rs.getInt("idgrupo"));
                gp.setNome(rs.getString("nome"));

            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar");
        }
    }
    
    public void excluirGrupo(Grupo grupo) {
        String sql = "delete from grupo where idgrupo = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, grupo.getIdgrupo());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir o grupo no banco de dados. Reporte ao administrador");
        }

    }
    
}
