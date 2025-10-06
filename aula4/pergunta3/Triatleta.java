package aula4.pergunta3;

public class Triatleta implements Corredor, Nadador, Ciclista {

    @Override
    public void correr() {
        System.out.println("Triatleta está correndo...");
    }

    @Override
    public void nadar() {
        System.out.println("Triatleta está nadando...");
    }

    @Override
    public void pedalar() {
        System.out.println("Triatleta está pedalando...");
    }

    public static void main(String[] args) {
        Triatleta triatleta = new Triatleta();
        triatleta.correr();
        triatleta.nadar();
        triatleta.pedalar();
    }
}