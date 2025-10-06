package aula2;

import java.util.ArrayList;
import java.util.Iterator;

public class Aluno {
    ArrayList<String> nomes = new ArrayList<>();

    public void adicionarNome(String nome) {
        nomes.add(nome);
        System.out.println("Nome adicionado: " + nome);

        Iterator<String> iterator = nomes.iterator();
        System.out.println("Nomes na lista:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void removerNome(String nome) {
        if (nomes.remove(nome)) {
            System.out.println("Nome removido: " + nome);
        } else {
            System.out.println("Nome não encontrado: " + nome);
        }
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.adicionarNome("Ana");
        aluno.adicionarNome("Bruno");
        aluno.adicionarNome("Carla");
        aluno.removerNome("Bruno");
        aluno.removerNome("Diego");
    }
}
