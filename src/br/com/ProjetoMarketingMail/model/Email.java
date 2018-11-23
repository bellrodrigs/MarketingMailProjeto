/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoMarketingMail.model;

/**
 *
 * @author Bell Rodrigues
 */
public class Email {
    private String enderecoemail;
    private String assunto;
    private String mensagem;
    private String url;
    private String urlImgur;
    
    public Email(String enderecoemail, String assunto, String mensagem, String url, String urlImgur) {        
      this.enderecoemail = enderecoemail;
      this.assunto = assunto;
      this.mensagem = mensagem;
      this.url =  url;
      this.urlImgur =  urlImgur;
    }   

    public Email() {
        
    }

  public Email(String enderecoemail,String assunto,String mensagem,String url ){
      this.enderecoemail = enderecoemail;
      this.assunto = assunto;
      this.mensagem = mensagem;
      this.url =  url;
      this.urlImgur =  urlImgur;
  }

    public Email(String text, String text0, String text1) {
        
    }

    public String getEnderecoemail() {
        return enderecoemail;
    }

    public void setEnderecoemail(String enderecoemail) {
        this.enderecoemail = enderecoemail;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImgur() {
        return urlImgur;
    }

    public void setUrlImgur(String urlImgur) {
        this.urlImgur = urlImgur;
    }
    
    
}
