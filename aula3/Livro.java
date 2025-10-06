package aula3;

public class Livro {
    String titulo;
    String autor;

    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }
    public static void main(String[] args){
        Livro livro1 = new Livro("O Senhor dos Aneis", "J.R.R. Tolkien");
        Livro livro2 = new Livro("1984","George Orwell");

        System.out.println("==== Livros ====");
        System.out.println("Titulo: " + livro1.titulo);
        System.out.println("Autor: " + livro1.autor);

        System.out.println("Titulo: " + livro2.titulo);
        System.out.println("Autor: " + livro2.autor);
    }
}