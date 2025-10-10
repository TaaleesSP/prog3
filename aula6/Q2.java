package aula6;

import java.util.HashSet;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> palavrasUnicas = new HashSet<>();

        System.out.println("Digite várias palavras. Digite 'fim' para parar.");

        while (true) {
            System.out.print("> ");
            String palavra = scanner.nextLine();

            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }

            palavrasUnicas.add(palavra);
        }

        System.out.println("\n--- Palavras Únicas Digitadas ---");
        if (palavrasUnicas.isEmpty()) {
            System.out.println("Nenhuma palavra foi digitada.");
        } else {
            for (String p : palavrasUnicas) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Verificação ---");
        if (palavrasUnicas.contains("Java")) {
            System.out.println("A palavra 'Java' FOI digitada.");
        } else {
            System.out.println("A palavra 'Java' NÃO foi digitada.");
        }

        scanner.close();
    }
}