package Trabalho;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BibliotecaGUI extends JFrame {

    private final GerenciadorItens gerenciador;
    private final Color COR_DESTAQUE = new Color(0xDC, 0x64, 0xE7);

    private JComboBox<String> comboTipo;
    private JTextField txtTitulo, txtDescricao, txtAutor, txtNumPaginas, txtDiretor, txtDuracao, txtBusca;
    private JTextArea areaResultados;
    private JPanel panelEspecifico;
    private CardLayout cardLayout;

    public BibliotecaGUI() {
        super("Biblioteca de Itens - Gerenciador de Livros e Filmes");
        this.gerenciador = new GerenciadorItens();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        //(FORMULÁRIO E AÇÕES)
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BorderLayout(10, 10));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelFormulario = criarPanelFormulario();
        panelLateral.add(panelFormulario, BorderLayout.NORTH);
        
        JPanel panelBotoesAcao = criarPanelBotoesAcao();
        panelLateral.add(panelBotoesAcao, BorderLayout.CENTER);

        //(BUSCA E RESULTADOS)
        JPanel panelCentral = new JPanel(new BorderLayout(10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelBusca = criarPanelBusca();
        panelCentral.add(panelBusca, BorderLayout.NORTH);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelLateral, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
    }

    private JPanel criarPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Item"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        //Linha 0: Tipo
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        comboTipo = new JComboBox<>(new String[]{"Livro", "Filme"});
        panel.add(comboTipo, gbc);

        //Linha 1: Título
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        txtTitulo = new JTextField(20);
        panel.add(txtTitulo, gbc);

        //Linha 2: Descrição
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        txtDescricao = new JTextField(20);
        panel.add(txtDescricao, gbc);

        //Painel específico (Livro/Filme)
        cardLayout = new CardLayout();
        panelEspecifico = new JPanel(cardLayout);

        //Campos do Livro
        JPanel panelLivro = new JPanel(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; panelLivro.add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1; txtAutor = new JTextField(20); panelLivro.add(txtAutor, gbc);
        gbc.gridy = 1; gbc.gridx = 0; panelLivro.add(new JLabel("Nº Páginas:"), gbc);
        gbc.gridx = 1; txtNumPaginas = new JTextField(20); panelLivro.add(txtNumPaginas, gbc);
        
        //Campos do Filme
        JPanel panelFilme = new JPanel(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0; panelFilme.add(new JLabel("Diretor:"), gbc);
        gbc.gridx = 1; txtDiretor = new JTextField(20); panelFilme.add(txtDiretor, gbc);
        gbc.gridy = 1; gbc.gridx = 0; panelFilme.add(new JLabel("Duração (min):"), gbc);
        gbc.gridx = 1; txtDuracao = new JTextField(20); panelFilme.add(txtDuracao, gbc);

        panelEspecifico.add(panelLivro, "Livro");
        panelEspecifico.add(panelFilme, "Filme");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(panelEspecifico, gbc);
        
        comboTipo.addActionListener(e -> cardLayout.show(panelEspecifico, (String) comboTipo.getSelectedItem()));

        return panel;
    }

    private JPanel criarPanelBotoesAcao() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnListar = new JButton("Listar Tudo");
        JButton btnExportar = new JButton("Exportar Dados");
        JButton btnImportar = new JButton("Importar Dados");

        for (JButton btn : new JButton[]{btnAdicionar, btnListar, btnExportar, btnImportar}) {
            btn.setBackground(COR_DESTAQUE);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            panel.add(btn);
        }

        btnAdicionar.addActionListener(e -> adicionarItem());
        btnListar.addActionListener(e -> listarItens());
        btnExportar.addActionListener(e -> exportarDados());
        btnImportar.addActionListener(e -> importarDados());
        
        return panel;
    }

    private JPanel criarPanelBusca() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Busca"));
        
        panel.add(new JLabel("Buscar por Título:"));
        txtBusca = new JTextField(30);
        panel.add(txtBusca);
        
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(e -> filtrarItens());
        panel.add(btnFiltrar);

        return panel;
    }

    private void adicionarItem() {
        try {
            String tipo = (String) comboTipo.getSelectedItem();
            String titulo = txtTitulo.getText();
            String descricao = txtDescricao.getText();
            
            if (titulo.trim().isEmpty() || descricao.trim().isEmpty()) {
                throw new IllegalArgumentException("Título e Descrição não podem ser vazios.");
            }

            Item novoItem = null;
            if ("Livro".equals(tipo)) {
                String autor = txtAutor.getText();
                int numPaginas = Integer.parseInt(txtNumPaginas.getText());
                novoItem = new Livro(titulo, descricao, autor, numPaginas, LocalDate.now());
            } else if ("Filme".equals(tipo)) {
                String diretor = txtDiretor.getText();
                int duracao = Integer.parseInt(txtDuracao.getText());
                novoItem = new Filme(titulo, descricao, diretor, duracao, LocalDate.now());
            }

            gerenciador.adicionarItem(novoItem);
            JOptionPane.showMessageDialog(this, "Item adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de páginas ou duração deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | ItemNuloException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listarItens() {
        atualizarAreaResultados(gerenciador.listarItens());
    }

    private void filtrarItens() {
        try {
            String termo = txtBusca.getText();
            atualizarAreaResultados(gerenciador.buscarPorTitulo(termo));
        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Busca", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportarDados() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar como CSV");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoParaSalvar = fileChooser.getSelectedFile();
            String filePath = arquivoParaSalvar.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".csv")) {
                arquivoParaSalvar = new File(filePath + ".csv");
            }
            
            try {
                gerenciador.exportarParaArquivo(arquivoParaSalvar.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Dados exportados com sucesso para:\n" + arquivoParaSalvar.getName(), "Exportação Concluída", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao exportar arquivo: " + e.getMessage(), "Erro de Exportação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void importarDados() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Abrir arquivo CSV");
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoParaAbrir = fileChooser.getSelectedFile();
            try {
                gerenciador.importarDeArquivo(arquivoParaAbrir.getAbsolutePath());
                listarItens();
                JOptionPane.showMessageDialog(this, "Dados importados com sucesso de:\n" + arquivoParaAbrir.getName(), "Importação Concluída", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao importar arquivo: " + e.getMessage(), "Erro de Importação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizarAreaResultados(List<Item> itens) {
        if (itens.isEmpty()) {
            areaResultados.setText("Nenhum item encontrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Total de itens: ").append(itens.size()).append("\n\n");
        for (Item item : itens) {
            sb.append(item.exibirDetalhes());
            sb.append("\n----------------------------------------\n");
        }
        areaResultados.setText(sb.toString());
        areaResultados.setCaretPosition(0);
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtAutor.setText("");
        txtNumPaginas.setText("");
        txtDiretor.setText("");
        txtDuracao.setText("");
        txtBusca.setText("");
    }
}