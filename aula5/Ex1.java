package aula5;

import java.util.Scanner;

public class Ex1 {
    public static int divisao(int numerador, int denominador) {
        return numerador / denominador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do{
            try{
                System.out.print("Digite o numerador: ");
                int numerador = scanner.nextInt();
                System.out.print("Digite o denominador: ");
                int denominador = scanner.nextInt();

                int resultado = divisao(numerador, denominador);
                System.out.println("Resultado: " + resultado);
                continueLoop = false;
            } catch (ArithmeticException e) {
                System.out.println("Erro: Divisão por zero não é permitida. Tente novamente.");
            } finally {
                if (continueLoop) {
                    System.out.println("Tente novamente.\n");
            }
        }
        } while (continueLoop);
    }
}