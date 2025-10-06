package aula2;

public class Contador {
    public static int totalObjetos = 0;

    public Contador() {
        totalObjetos++;
    }

    public static int mostrarTotal() {
        return totalObjetos;
    }

    public static void main(String[] args) {
        new Contador();
        new Contador();
        new Contador();

        System.out.println("Total de objetos criados: " + Contador.mostrarTotal());
    }
}