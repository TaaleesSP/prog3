package aula4.pergunta1;

public abstract class ContaBancaria {
    protected double saldo;

    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);

    public double getSaldo() {
        return this.saldo;
    }
}