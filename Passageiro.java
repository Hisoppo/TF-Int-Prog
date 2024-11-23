// Para tanto, crie uma classe chamada Passageiro que terá os seguintes atributos: nome (String),
// idade (int) e profissão (String). Crie, também, uma classe Barco que terá os seguintes atributos:
// codigo (int), nome (String) e lotação (int). Crie os métodos de acesso para os atributos da classe. 

public class Passageiro {
    private String nome;
    private int idade;
    private String profissao;
    
    public Passageiro(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public String getProfissao() {
        return profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Passageiro [nome=" + nome + ", idade=" + idade + ", profissao=" + profissao + "]";
    }
}
