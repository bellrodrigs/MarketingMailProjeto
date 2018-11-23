/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.util;

import br.com.ProjetoMarketingMail.view.TelaCadastro;
import br.com.ProjetoMarketingMail.view.TelaConsulta;
import br.com.ProjetoMarketingMail.view.TelaEnviarEmail;
import br.com.ProjetoMarketingMail.view.TelaGrupo;
import br.com.ProjetoMarketingMail.view.TelaRelatorio;

/**
 *
 * @author Bell Rodrigues
 */
public class MudaTelas {
    
    public void TelaDeGrupos(){
        TelaGrupo telagrupo = new TelaGrupo();
        telagrupo.setVisible(true);
    }

    public void TelaDeConsulta() {
        TelaConsulta telaconsulta = new TelaConsulta();
        telaconsulta.setVisible(true);
    }
    public void TelaDeCadastro(){
        TelaCadastro telacadastro = new TelaCadastro(null,true);
        telacadastro.setVisible(true);
    }
    public void EnviarEmail(){
        TelaEnviarEmail enviaemail = new TelaEnviarEmail();
        enviaemail.setVisible(true);
    }
    public void CadastraGrupo(){
        TelaGrupo telagrupo = new TelaGrupo();
        telagrupo.setVisible(true);
    }
    public void Relatorios(){
        TelaRelatorio relatorio = new TelaRelatorio();
       relatorio.setVisible(true);
    }
    /* Sair */
    public void Sair(){
        System.exit(1);
    }
    
}
