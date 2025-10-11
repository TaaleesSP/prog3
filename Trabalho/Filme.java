package Trabalho;

import java.time.LocalDate;

public class Filme extends Item {
    private String diretor;
    private int duracaoMinutos;

    public Filme(String titulo, String descricao, String diretor, int duracaoMinutos, LocalDate dataCadastro) {

        super(titulo, descricao, dataCadastro);

        if (diretor == null || diretor.trim().isEmpty()) {
            throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
        }
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração deve ser positiva.");
        }
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }
        
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        if (diretor == null || diretor.trim().isEmpty()) {
            throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
        }
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração deve ser positiva.");
        }
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String exibirDetalhes() {
        return String.format(
            "Tipo: Filme\nTítulo: %s\nDiretor: %s\nDescrição: %s\nDuração: %d minutos\nData de Cadastro: %s",
            getTitulo(),
            this.diretor,
            getDescricao(),
            this.duracaoMinutos,
            getDataCadastro().toString()
        );
    }

    @Override
    public String toCsvString() {
        return String.join(",", "FILME", getTitulo(), getDescricao(), getDiretor(), String.valueOf(getDuracaoMinutos()), getDataCadastro().toString());
    }
}