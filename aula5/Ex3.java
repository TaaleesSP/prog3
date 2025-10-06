package aula5;

public class Ex3 {
    public static int converterStringParaInteiro(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        String[] strings = {"123", "456", "abc", "789", "12.34", "0"};
        for (String str : strings) {
            try {
                int numero = converterStringParaInteiro(str);
                System.out.println("A string \"" + str + "\" convertida para inteiro é: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter a string \"" + str + "\": " + e.getMessage());
            }
        }
        System.out.println("Encerrando programa...");
    }
}
