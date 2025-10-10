package aula7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo de texto (ex: meu_arquivo.txt): ");
        String nomeDoArquivo = scanner.nextLine();

        System.out.println("\n--- Conteúdo do Arquivo ---");

        try (
            FileInputStream fis = new FileInputStream(nomeDoArquivo);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr)
        ) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erro: O arquivo '" + nomeDoArquivo + "' não foi encontrado.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\n--- Fim da Leitura ---");
        }
    }
}