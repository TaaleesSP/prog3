package aula3;

public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args){
    Calculadora calc = new Calculadora();

    int resultado = calc.somar(5,3);
    System.out.println("Resultado da soma int: " + resultado);

    double resultadoDouble = calc.somar(5.0,3.0);
    System.out.println("Resultado da soma double: " + resultadoDouble);

    int resultadoTres = calc.somar(5,3,1);
    System.out.println("Resultado da soma de tres int: " + resultadoTres);

}
}
