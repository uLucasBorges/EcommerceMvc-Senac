
package br.com.coding.atividadesenac.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Product {
    @Id
    public long Id;
    public String Nome;
    public String Categoria;
    public String Descricao;
    public float Preco;
    public int Quantidade;

    public Product(long id, String nome, String categoria, String descricao, float preco, int quantidade){
    Id = id;
    Nome = nome;
    Categoria = categoria;
    Descricao = descricao;
    Preco = preco;
    Quantidade = quantidade;
    }
    
    public Product(){}

}
