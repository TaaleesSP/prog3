package aula6;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {

    private ArrayList<Integer> numeros;

    public Q1() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (int numero : this.numeros) {
            soma += numero;
        }
        return soma;
    }

    public double calcularMedia() {
        if (numeros.isEmpty()) {
            return 0;
        }
        return (double) calcularSoma() / numeros.size();
    }

    public void removerPares() {
        this.numeros.removeIf(n -> n % 2 == 0);
    }

    @Override
    public String toString() {
        return this.numeros.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q1 analise = new Q1();

        System.out.println("Digite 10 números inteiros:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int num = scanner.nextInt();
            analise.adicionarNumero(num);
        }
        scanner.close();
        
        System.out.println("\n--- Resultados ---");

        System.out.println("Lista original: " + analise);

        int soma = analise.calcularSoma();
        System.out.println("Soma total: " + soma);

        double media = analise.calcularMedia();
        System.out.printf("Média: %.2f\n", media);

        analise.removerPares();

        System.out.println("Lista sem os números pares: " + analise);
    }
}