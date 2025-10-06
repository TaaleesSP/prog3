package Trabalho;

import java.time.LocalDate;
import java.util.Scanner;

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

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Filme");
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição do filme: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o diretor do filme: ");
        String diretor = scanner.nextLine();
        System.out.print("Digite a duração do filme em minutos: ");
        int duracaoMinutos = Integer.parseInt(scanner.nextLine());
        LocalDate dataCadastro = LocalDate.now();
        Filme filme = new Filme(titulo, descricao, diretor, duracaoMinutos, dataCadastro);
        System.out.println(filme.exibirDetalhes());
        scanner.close();
    }
}