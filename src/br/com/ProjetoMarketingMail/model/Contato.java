
package br.com.ProjetoMarketingMail.model;


public class Contato {
    private int idcontato;   
    private String nome;
    private String telefone;
    private String celular;
    private String estado;
    private String email;
    private String idgrupo;
    
    public Contato(int idcontato, String nome, String telefone, String celular, String estado, String email, String idgrupo) {        
        this.idcontato = idcontato;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.estado = estado;
        this.email = email;
        this.idgrupo = idgrupo;
    }   
    
     public Contato() {        
        
    }   

    public Contato(String nome, String telefone, String celular, String estado, String email, String idgrupo) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.estado = estado;
        this.email = email;
        this.idgrupo = idgrupo;
    }

    
    public String getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(String idgrupo) {
        this.idgrupo = idgrupo;
    }
    
    public int getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(int idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
     public void exibeDados() {
        System.out.printf("--- Dados do Produto ---%n%n");
        System.out.printf("Código do contato: %d%n", getIdcontato());        
        System.out.printf("nome: %s%n", getNome());
        System.out.printf("Unidade: %s%n", getTelefone());
        System.out.printf("Validade: %s%n", getCelular());
        System.out.printf("Caloria: %.2f%n", getEstado());
        System.out.printf("Observação: %s%n", getEmail());
        System.out.printf("Preço: %.2f%n", getIdgrupo());
        
    }
}
