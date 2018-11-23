/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.main;

import br.com.ProjetoMarketingMail.util.servidorsocket;
import br.com.ProjetoMarketingMail.view.TelaCadastro;

/**
 *
 * @author Bell Rodrigues
 */
public class Main {
    public static void main(String[] args) {
        TelaCadastro cadProduto = new TelaCadastro(null, true);
        cadProduto.setVisible(true);
        servidorsocket servidor = new servidorsocket();
        servidor.servidor();
}
}
