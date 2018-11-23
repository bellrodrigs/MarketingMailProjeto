/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.controller;

import br.com.ProjetoMarketingMail.dao.MarketingMailDao;
import br.com.ProjetoMarketingMail.model.Contato;
import br.com.ProjetoMarketingMail.model.Email;
import br.com.ProjetoMarketingMail.model.Grupo;
import br.com.ProjetoMarketingMail.util.EnviaEmail;
import br.com.ProjetoMarketingMail.util.Excecao;
import javax.swing.JOptionPane;


public class Marketingmailctrl {
    MarketingMailDao marketingmaildao = new MarketingMailDao();
    Contato contato = new Contato();
    Grupo grupo = new Grupo();
    EnviaEmail enviaemail = new EnviaEmail();
    
    
    public void incluir(Contato contato) throws Excecao {
        try {
            marketingmaildao.cadastrar(contato);
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(
                    null, ex.getMsg(),
                    "Erro ao cadastrar contato", JOptionPane.ERROR_MESSAGE
            );

        }
    }
        public void alterar(Contato contato) throws Excecao {
            
            marketingmaildao.alterar(contato);
    }
        
         public void excluir(Contato contato) throws Excecao {
             
             marketingmaildao.excluir(contato);
    }

    public void incluirGrupo(Grupo grupo) throws Excecao {
        try {
            marketingmaildao.cadastrarGrupo(grupo);

        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(
                    null, ex.getMsg(),
                    "Erro ao cadastrar grupo", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void excluirGrupo(Grupo grupo) throws Excecao {
        marketingmaildao.excluirGrupo(grupo);
    }

}
