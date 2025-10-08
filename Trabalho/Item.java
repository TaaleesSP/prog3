package Trabalho;

import java.time.LocalDate;

public abstract class Item {
    String titulo;
    String descricao;
    LocalDate dataCadastro;

    public Item(String titulo, String descricao, LocalDate dataCadastro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setTitulo(String titulo){
       if (titulo != null && !titulo.isEmpty()){
        this.titulo = titulo;
       } else {
        throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
       }
    }

    public void setDescricao(String descricao){
        if (descricao != null && !descricao.isEmpty()){
         this.descricao = descricao;
        } else {
         throw new IllegalArgumentException("A descrição não pode ser nulo ou vazio.");
        }
     }

    public abstract String exibirDetalhes();
    public abstract String toCsvString();
}