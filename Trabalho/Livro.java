package Trabalho;

import java.time.LocalDate;
import java.util.Scanner;

public class Livro extends Item {
    private String autor;
    private int numeroPaginas;

    public Livro(String titulo, String descricao, String autor, int numeroPaginas, LocalDate dataCadastro) {

        super(titulo, descricao, dataCadastro);
        
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser positivo.");
        }
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser positivo.");
        }
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String exibirDetalhes() {
        return String.format(
            "Tipo: Livro\nTítulo: %s\nAutor: %s\nDescrição: %s\nNúmero de Páginas: %d\nData de Cadastro: %s",
            getTitulo(),
            this.autor,
            getDescricao(),
            this.numeroPaginas,
            getDataCadastro().toString()
        );
    }

    @Override
    public String toCsvString() {
        return String.join(",", "LIVRO", getTitulo(), getDescricao(), getAutor(), String.valueOf(getNumeroPaginas()), getDataCadastro().toString());
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Livro");
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição do livro: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o número de páginas do livro: ");
        int numeroPaginas = Integer.parseInt(scanner.nextLine());
        LocalDate dataCadastro = LocalDate.now();
        Livro livro = new Livro(titulo, descricao, autor, numeroPaginas, dataCadastro);
        System.out.println(livro.exibirDetalhes());
        scanner.close();
    }
}