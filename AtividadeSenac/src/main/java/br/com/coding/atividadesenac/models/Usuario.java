
package br.com.coding.atividadesenac.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    public int Id;
    public String Nome;
    public String senha;
    public String email;
    public String Logradouro;
    public String Cidade;
    public String Estado;


    public Usuario( String nome, String senha, String email, String logradouro, String cidade, String estado)
    {
        Nome = nome;
        this.senha = senha;
        this.email = email;
        Logradouro = logradouro;
        Cidade = cidade;
        Estado = estado;
        
    }
    
    public Usuario(){}
}
