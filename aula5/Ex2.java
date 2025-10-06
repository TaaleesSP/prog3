package aula5;

public class Ex2 {
    public static int calcularRaiz(int numero){
        if(numero < 0){
            throw new IllegalArgumentException("Número negativo não tem raiz quadrada real.");
        }
        return (int) Math.sqrt(numero);
    }
    public static void main(String[] args) {
        int[] numeros = {16, 25, -4, 9, -1, 0};
        for(int numero : numeros){
            try{
                int raiz = calcularRaiz(numero);
                System.out.println("A raiz quadrada de " + numero + " é " + raiz);
            } catch (IllegalArgumentException e){
                System.out.println("Erro ao calcular a raiz de " + numero + ": " + e.getMessage());
            }
        }
    }
}
