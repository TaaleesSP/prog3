package aula3;

public class Animal {
    String especie; 

    public Animal(String especie){
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void emitirSom() {
        System.out.println("O animal emite um som.");
    }
    
static class Cachorro extends Animal {
    public Cachorro() {
        super("Cachorro");
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro late: Au Au!");
    }
}

static class Gato extends Animal {
    public Gato() {
        super("Gato");
    }

    @Override
    public void emitirSom() {
        System.out.println("O gato mia: Miau!");
    }
}

    public static void main(String[] args){
        Animal animal1 = new Animal("Animal Genérico");
        animal1.emitirSom();

        Cachorro cachorro = new Cachorro();
        cachorro.emitirSom();

        Gato gato = new Gato();
        gato.emitirSom();
    }
}
