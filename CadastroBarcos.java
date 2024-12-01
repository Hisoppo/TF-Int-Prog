
import java.util.Scanner;

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
    private Barco[] barcos;
    private int numBarcos = 0;
    private Scanner sc = new Scanner(System.in);
    public CadastroBarcos() {
        barcos = new Barco[10];
    }
    
    


    public Barco[] getBarcos() {
        return barcos;
    }




    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }




    public int getNumBarcos() {
        return numBarcos;
    }




    public void setNumBarcos(int numBarcos) {
        this.numBarcos = numBarcos;
    }




    public boolean adicionaBarco() {
        
        System.out.print("Digite o código do barco: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Digite o nome do barco: ");
        String nome = sc.nextLine();
        
        System.out.print("Digite a lotação do barco: ");
        int lotacao = sc.nextInt();
        sc.nextLine();
        
        Barco barco = new Barco(codigo, nome, lotacao);
        
        if (numBarcos < 10) {
            barcos[numBarcos] = barco;
            numBarcos++;
            return true;
        }
        return false;
    }

    public Barco buscaBarcoNome(String nome) { // Busca um barco pelo nome
        for (int i = 0; i < numBarcos; i++) {
            if (barcos[i].getNome().equals(nome)) {
                System.out.println (barcos[i]);
            }
        }
        return null;
    }

    public boolean removeBarco(String nome) { // Remove um barco pelo nome
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

    public void mostraBarcos() { // Mostra todos os barcos
        for (int i = 0; i < numBarcos; i++) {
            System.out.println(barcos[i]);
        }
    }
}
