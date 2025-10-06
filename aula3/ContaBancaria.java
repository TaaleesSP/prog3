package aula3;

public class ContaBancaria {
    int numeroConta;

    public ContaBancaria(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "NumeroConta: " + numeroConta;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        ContaBancaria conta = (ContaBancaria) obj;
        return numeroConta == conta.numeroConta;
    }

    public static void main(String[] args){
        ContaBancaria conta1 = new ContaBancaria(12345);
        ContaBancaria conta2 = new ContaBancaria(12345);
        ContaBancaria conta3 = new ContaBancaria(67890);

        System.out.println("Conta 1: " + conta1.toString());
        System.out.println("Conta 2: " + conta2.toString());
        System.out.println("Conta 3: " + conta3.toString());
        System.out.print("\n");
        System.out.println("Conta 1 é igual a Conta 2? " + conta1.equals(conta2));
        System.out.println("Conta 1 é igual a Conta 3? " + conta1.equals(conta3));
    }
}
