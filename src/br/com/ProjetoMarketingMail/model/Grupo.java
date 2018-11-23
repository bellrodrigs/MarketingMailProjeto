
package br.com.ProjetoMarketingMail.model;


public class Grupo {
    private int idgrupo;
    private String nome;
    
    public Grupo (int idgrupo, String nome){
        this.idgrupo = idgrupo;
        this.nome = nome;
    }
    
    public Grupo(String nome){
        this.nome = nome;
    }
    
    public Grupo(){
        
    }
    
    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
