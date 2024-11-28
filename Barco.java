// Barco que terá os seguintes atributos:
// codigo (int), nome (String) e lotação (int). Crie os métodos de acesso para os atributos da classe. 

public class Barco {
    int codigo;
    String nome;
    int lotacao;

    public Barco(int codigo, String nome, int lotacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.lotacao = lotacao;
    }

    public int getCodigo() {
        return codigo;
    }   

    public String getNome() {
        return nome;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    

    public String toString() {
        return "Barco [codigo=" + codigo + ", nome=" + nome + ", lotacao=" + lotacao + "]";
    }
}
