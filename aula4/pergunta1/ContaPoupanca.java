package aula4.pergunta1;

public class ContaPoupanca extends ContaBancaria {

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("[POUPANÇA] Depósito de R$" + String.format("%.2f", valor) + " realizado. Novo saldo: R$" + String.format("%.2f", this.saldo));
        } else {
            System.out.println("[POUPANÇA] Valor de depósito inválido.");
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("[POUPANÇA] Saque de R$" + String.format("%.2f", valor) + " realizado. Novo saldo: R$" + String.format("%.2f", this.saldo));
            return true;
        }
        System.out.println("[POUPANÇA] Saque não realizado. Saldo insuficiente ou valor inválido.");
        return false;
    }
}