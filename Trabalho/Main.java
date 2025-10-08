package Trabalho;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Adicionando itens a biblioteca ---");
        GerenciadorItens gerenciador = new GerenciadorItens();
        String nomeArquivo = "biblioteca.csv";

        try {
            gerenciador.adicionarItem(new Livro(
                "Duna", 
                "A jornada de Paul Atreides em Arrakis.", 
                "Frank Herbert", 
                688, 
                LocalDate.of(2021, 9, 1))
            );
            gerenciador.adicionarItem(new Filme(
                "O Poderoso Chefão", 
                "A história da família Corleone.", 
                "Francis Ford Coppola", 
                175, 
                LocalDate.of(1972, 3, 24))
            );
            gerenciador.adicionarItem(new Livro(
                "O Guia do Mochileiro das Galáxias", 
                "Aventuras de Arthur Dent pelo espaço.", 
                "Douglas Adams", 
                208, 
                LocalDate.of(1979, 10, 12))
            );
            System.out.println("Adicionando................\n");
            System.out.println("Itens adicionados com sucesso a biblioteca!");
        } catch (ItemNuloException e) {
            System.err.println("Erro inesperado ao adicionar item: " + e.getMessage());
        }

        System.out.println("\n----------------------------------\n");

        //Exportar os dados para o arquivo CSV
        System.out.println("--- 2. Exportando dados para '" + nomeArquivo + "' ---");
        try {
            gerenciador.exportarParaArquivo(nomeArquivo);
            System.out.println("Exportação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao exportar o arquivo: " + e.getMessage());
        }

        System.out.println("\n----------------------------------\n");

        //Criando uma nova biblioteca e importar os dados
        System.out.println("--- 3. Importando dados para uma nova biblioteca ---");
        GerenciadorItens gerenciadorImportado = new GerenciadorItens();
        try {
            gerenciadorImportado.importarDeArquivo(nomeArquivo);
            System.out.println("Importação concluída com sucesso.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao importar o arquivo: " + e.getMessage());
        }

        System.out.println("\n----------------------------------\n");

        //Verificar se os itens foram importados corretamente
        System.out.println("--- 4. Verificando os itens importados na biblioteca ---");
        List<Item> itensImportados = gerenciadorImportado.listarItens();

        if (itensImportados.isEmpty()) {
            System.out.println("Nenhum item foi importado.");
        } else {
            System.out.println("Total de itens importados: " + itensImportados.size() + "\n");
            for (Item item : itensImportados) {
                System.out.println(item.exibirDetalhes());
                System.out.println("--------------------");
            }
        }
    }
}