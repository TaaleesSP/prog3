package aula3;

public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    static class Aluno extends Pessoa {
    
        public Aluno(String nome, int idade) {
            super(nome, idade);
            this.nome = nome;
            this.idade = idade;
        }
    }

    public static void main(String[] args){
        Pessoa pessoa1 = new Pessoa ("Alice", 30);
        Pessoa pessoa2 = new Pessoa("Bob", 25);
        System.out.println("Pessoa 2: " + pessoa2.nome + ", " + pessoa2.idade);
        System.out.println("Pessoa 1: " + pessoa1.nome + ", " + pessoa1.idade);

        Aluno aluno1 = new Aluno("Carlos", 20);
        System.out.println("Aluno 1: " + aluno1.nome + ", " + aluno1.idade);
    }
}