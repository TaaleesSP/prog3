package aula4.pergunta1;

public class ContaCorrente extends ContaBancaria {
    private final double TAXA_SAQUE = 1.00;

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("[CORRENTE] Depósito de R$" + String.format("%.2f", valor) + " realizado. Novo saldo: R$" + String.format("%.2f", this.saldo));
        } else {
            System.out.println("[CORRENTE] Valor de depósito inválido.");
        }
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotalSaque = valor + TAXA_SAQUE;
        if (valor > 0 && valorTotalSaque <= this.saldo) {
            this.saldo -= valorTotalSaque;
            System.out.println("[CORRENTE] Saque de R$" + String.format("%.2f", valor) + " (custo total R$"+ String.format("%.2f", valorTotalSaque) +") realizado. Novo saldo: R$" + String.format("%.2f", this.saldo));
            return true;
        }
        System.out.println("[CORRENTE] Saque não realizado. Saldo insuficiente (necessário R$" + String.format("%.2f", valorTotalSaque) + ") ou valor inválido.");
        return false;
    }
}