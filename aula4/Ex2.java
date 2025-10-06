package aula4;


enum TipoAcesso {
    BASICO,
    INTERMEDIARIO,
    ADMIN;
}

public class Ex2 {
    private String nome;
    private TipoAcesso tipoAcesso;

    public Ex2(String nome, TipoAcesso tipoAcesso) {
        this.nome = nome;
        this.tipoAcesso = tipoAcesso;
    }

    public String getNome() {
        return nome;
    }

    public TipoAcesso getTipoAcesso() {
        return tipoAcesso;
    }

public static void main(String[] args) {
    Ex2 user1 = new Ex2("Alice", TipoAcesso.BASICO);
    Ex2 user2 = new Ex2("Bob", TipoAcesso.ADMIN);
    Ex2 user3 = new Ex2("Charlie", TipoAcesso.INTERMEDIARIO);

    System.out.println("Usuário: " + user1.getNome() + ", Acesso: " + user1.getTipoAcesso());
    System.out.println("Usuário: " + user2.getNome() + ", Acesso: " + user2.getTipoAcesso());
    System.out.println("Usuário: " + user3.getNome() + ", Acesso: " + user3.getTipoAcesso());
}
}
