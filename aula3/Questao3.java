package aula3;

public class Questao3 {
    private String nome;
    private int idade;

    public void setAluno(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

    public String getAluno() {
        return "Nome: " + nome + ", Idade: " + idade;
    }

    public static void main(String[] args){
        Questao3 aluno1 = new Questao3();
        aluno1.setAluno("Carlos", 20);
        System.out.println(aluno1.getAluno());
    }
}