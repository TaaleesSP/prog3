package Trabalho;

public class CampoVazioException extends Exception {
    public CampoVazioException(String nomeDoCampo) {
        super("O campo '" + nomeDoCampo + "' não pode estar vazio.");
    }
}