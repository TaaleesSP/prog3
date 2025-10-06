public class fibonacci {
    public static void main(String[] args) {
        System.out.println("=== Atividade 1 - FIBONACCI ===");
        int n = 30;
        int a = 1, b = 1;
        System.out.print("Sequência de Fibonacci: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int proximo = a + b;
            a = b;
            b = proximo;
        }
        System.out.println("\n");
    }
}