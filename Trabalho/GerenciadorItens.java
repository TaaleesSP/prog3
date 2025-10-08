package Trabalho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciadorItens {
    private final List<Item> itens;

    public GerenciadorItens() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) throws ItemNuloException {
        if (item == null) {
            throw new ItemNuloException();
        }
        this.itens.add(item);
    }

    public void exportarParaArquivo(String nomeArquivo) throws IOException {
        System.out.println("Exportando " + itens.size() + " itens para o arquivo: " + nomeArquivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Item item : itens) {
                writer.write(item.toCsvString());
                writer.newLine();
            }
        }
    }

    public void importarDeArquivo(String nomeArquivo) throws IOException {
        System.out.println("Importando itens do arquivo: " + nomeArquivo);
        this.itens.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String tipo = dados[0];
                
                Item item = null;
                if ("LIVRO".equals(tipo)) {
                    String titulo = dados[1];
                    String descricao = dados[2];
                    String autor = dados[3];
                    int numeroPaginas = Integer.parseInt(dados[4]);
                    LocalDate dataCadastro = LocalDate.parse(dados[5]);
                    item = new Livro(titulo, descricao, autor, numeroPaginas, dataCadastro);
                } else if ("FILME".equals(tipo)) {
                    String titulo = dados[1];
                    String descricao = dados[2];
                    String diretor = dados[3];
                    int duracaoMinutos = Integer.parseInt(dados[4]);
                    LocalDate dataCadastro = LocalDate.parse(dados[5]);
                    item = new Filme(titulo, descricao, diretor, duracaoMinutos, dataCadastro);
                }
                
                if (item != null) {
                    this.itens.add(item);
                }
            }
        }
    }
    
    public List<Item> listarItens() {
        List<Item> itensOrdenados = new ArrayList<>(this.itens);
        Collections.sort(itensOrdenados, Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER));
        return itensOrdenados;
    }

    public List<Item> buscarPorTitulo(String termoBusca) throws CampoVazioException {
        if (termoBusca == null || termoBusca.trim().isEmpty()) {
            throw new CampoVazioException("termo de busca");
        }
        String termoLowerCase = termoBusca.toLowerCase();

        return this.itens.stream()
            .filter(item -> item.getTitulo().toLowerCase().contains(termoLowerCase))
            .collect(Collectors.toList());
    }

    public Map<String, Long> contarPorTipo() {
        return this.itens.stream()
            .collect(Collectors.groupingBy(
                item -> item.getClass().getSimpleName(), Collectors.counting()));
    }
}