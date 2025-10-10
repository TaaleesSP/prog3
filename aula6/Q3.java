package aula6;

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> pessoas = new HashMap<>();

        System.out.println("--- Cadastro de 5 Pessoas ---");
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade de " + nome + ": ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            pessoas.put(nome, idade);
        }

        System.out.println("\nMapa de pessoas inicial: " + pessoas);

        System.out.println("\n--- Consulta de Idade ---");
        System.out.print("Digite um nome para buscar a idade: ");
        String nomeBusca = scanner.nextLine();

        Integer idadeEncontrada = pessoas.get(nomeBusca);
        
        if (idadeEncontrada != null) {
            System.out.println("A idade de " + nomeBusca + " é: " + idadeEncontrada + " anos.");
        } else {
            System.out.println("O nome '" + nomeBusca + "' não foi encontrado no cadastro.");
        }

        System.out.println("\n--- Remoção de Pessoa ---");
        System.out.print("Digite um nome para remover do cadastro: ");
        String nomeRemover = scanner.nextLine();

        Integer idadeRemovida = pessoas.remove(nomeRemover);

        if (idadeRemovida != null) {
            System.out.println(nomeRemover + " (idade " + idadeRemovida + ") foi removido com sucesso.");
        } else {
            System.out.println("Não foi possível remover, pois o nome '" + nomeRemover + "' não foi encontrado.");
        }

        System.out.println("\nMapa de pessoas atualizado: " + pessoas);

        scanner.close();
    }
}