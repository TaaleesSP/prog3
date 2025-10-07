package Trabalho;

public class ItemNuloException extends Exception {
    public ItemNuloException() {
        super("Não é possível adicionar um item que seja nulo.");
    }
}