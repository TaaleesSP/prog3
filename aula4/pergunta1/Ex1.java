package aula4.pergunta1;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("--- CONTA CORRENTE ---");
        ContaCorrente cc = new ContaCorrente();
        cc.depositar(100.00);
        cc.sacar(50.00);
        System.out.println("Saldo final Conta Corrente: R$" + String.format("%.2f", cc.getSaldo()));

        System.out.println("\n--- CONTA POUPANÇA ---");
        ContaPoupanca cp = new ContaPoupanca();
        cp.depositar(100.00);
        cp.sacar(50.00);
        System.out.println("Saldo final Conta Poupança: R$" + String.format("%.2f", cp.getSaldo()));
    }
}