package aula2;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }

    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "Corolla", 2008);
        Carro outroCarro = new Carro("Honda", "Civic", 2009);
        meuCarro.exibirInfo();
        outroCarro.exibirInfo();
    }  

}
