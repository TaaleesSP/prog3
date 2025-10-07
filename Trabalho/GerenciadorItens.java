package Trabalho;

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