package aula7;

import java.io.File;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho de um arquivo ou diretório: ");
        String caminho = scanner.nextLine();

        File arquivoOuDiretorio = new File(caminho);

        System.out.println("\n--- Análise do Caminho ---");

        if (arquivoOuDiretorio.exists()) {
            System.out.println("Status: O caminho existe.");

            System.out.println("Caminho Absoluto: " + arquivoOuDiretorio.getAbsolutePath());

            if (arquivoOuDiretorio.isDirectory()) {
                System.out.println("Tipo: É um Diretório.");

                System.out.println("\nConteúdo do Diretório:");
                File[] conteudo = arquivoOuDiretorio.listFiles();

                if (conteudo != null && conteudo.length > 0) {
                    for (File item : conteudo) {
                        if (item.isDirectory()) {
                            System.out.println("  [D] " + item.getName());
                        } else {
                            System.out.println("  [A] " + item.getName());
                        }
                    }
                } else {
                    System.out.println("  O diretório está vazio ou não pôde ser lido.");
                }

            } else if (arquivoOuDiretorio.isFile()) {
                System.out.println("Tipo: É um Arquivo.");
                
                long tamanho = arquivoOuDiretorio.length();
                System.out.println("Tamanho: " + tamanho + " bytes.");
            
            } else {
                 System.out.println("Tipo: Não é um arquivo nem um diretório convencional.");
            }

        } else {
            System.out.println("Status: O caminho '" + caminho + "' NÃO existe.");
        }

        scanner.close();
    }
}