// O gerenciamento dos barcos deve ser feito na classe CadastroBarcos que também deve ser criada.
// Nesta classe, serão armazenados os barcos que a empresa possui, que são objetos da classe Barco.
// Crie um construtor que cria o cadastro (vetor de objetos) que pode armazenar até 10 barcos. Além
// do construtor, esta classe deve ter os seguintes métodos: adicionaBarco (insere um objeto barco
// no vetor para isto, recebe o objeto barco e retorna true se a inserção pode ser realizada ou false se
// a inserção não foi possível), buscaBarcoNome (recebe o nome do barco e retorna o objeto que
// contém o nome do barco recebido), removeBarco (recebe o nome do barco, caso ele exista, remove
// o barco do cadastro e retorna true se a remoção foi realizada ou false se a remoção não foi possível)
// e mostraBarcos (mostra os dados dos objetos armazenados).
public class CadastroBarcos {
    Barco[] barcos;
    int numBarcos = 0;

    public CadastroBarcos() {
        barcos = new Barco[10];
    }

    public boolean adicionaBarco(Barco barco) {
        if (numBarcos < 10) {
            barcos[numBarcos] = barco;
            numBarcos++;
            return true;
        }
        return false;
    }

    public Barco buscaBarcoNome(String nome) {
        for (int i = 0; i < numBarcos; i++) {
            if (barcos[i].getNome().equals(nome)) {
                return barcos[i];
            }
        }
        return null;
    }

    public boolean removeBarco(String nome) {
        for (int i = 0; i < numBarcos; i++) {
            if (barcos[i].getNome().equals(nome)) {
                for (int j = i; j < numBarcos - 1; j++) {
                    barcos[j] = barcos[j + 1];
                }
                numBarcos--;
                return true;
            }
        }
        return false;
    }

    public void mostraBarcos() {
        for (int i = 0; i < numBarcos; i++) {
            System.out.println(barcos[i]);
        }
    }

    
}
