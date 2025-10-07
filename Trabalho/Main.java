package Trabalho;

public class Main {
    public static void main(String[] args) {
        GerenciadorItens gerenciador = new GerenciadorItens();

        // --- Testando a exceção ItemNuloException ---
        System.out.println("Tentando adicionar um item nulo...");
        try {
            gerenciador.adicionarItem(null);
        } catch (ItemNuloException e) {
            System.err.println("Capturou a exceção esperada: " + e.getMessage());
        }

        System.out.println("\n----------------------------------\n");

        // --- Testando a exceção CampoVazioException ---
        System.out.println("Tentando buscar com um termo vazio...");
        try {
            gerenciador.buscarPorTitulo("   ");
        } catch (CampoVazioException e) {
            System.err.println("Capturou a exceção esperada: " + e.getMessage());
        }
    }
}