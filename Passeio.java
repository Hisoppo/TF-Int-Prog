import java.util.Scanner;

public class Passeio {
   Barco barco;
   double valorBilhete;
   Passageiro[] passageiros;

   public Passeio(Barco barco, double valorBilhete) {
      this.barco = barco;
      this.valorBilhete = valorBilhete;
      this.passageiros = null;
   }

   Scanner sc = new Scanner(System.in);

   public void criaPasseio(CadastroBarcos cadastroBarcos) {
      System.out.println("Por gentileza, informe o nome do barco para o passeio:");
      String nomeBarco = sc.nextLine();
      for (Barco b : cadastroBarcos.barcos) {
         if (b != null && nomeBarco.equals(b.getNome())) {
            this.barco = b;
            System.out.println("Barco localizado com sucesso: " + b.getNome());
            System.out.println("Lotação do barco: " + b.getLotacao());
            System.out.println("Digite o valor do bilhete:");
            this.valorBilhete = sc.nextDouble();
            sc.nextLine();
            this.passageiros = new Passageiro[b.getLotacao()]; // Inicialize o array agora
            System.out.println("Passeio criado com sucesso!");
            return;
         }
      }
      System.out.println("Barco não encontrado. Não foi possível criar o passeio.");
   }

   public boolean adicionaPassageiro(CadastroBarcos cadastroBarcos) {
      System.out.println("Informe o nome do barco para o passeio:");
      String nomeBarco = sc.nextLine();
      for (Barco b : cadastroBarcos.barcos) {
         if (b != null && nomeBarco.equals(b.getNome())) {
            for (int i = 0; i < passageiros.length; i++) {
               if (passageiros[i] == null) {
                  System.out.println("Digite o nome do passageiro:");
                  String nomePassageiro = sc.nextLine();
                  System.out.println("Digite a idade do passageiro:");
                  int idade = sc.nextInt();
                  sc.nextLine(); // Consumir quebra de linha
                  System.out.println("Digite a profissão do passageiro:");
                  String profissao = sc.nextLine();
                  passageiros[i] = new Passageiro(nomePassageiro, idade, profissao);
                  System.out.println("Passageiro adicionado com sucesso!");
                  return true;
               }
            }
            System.out.println("O barco está cheio!");
            return false;
         }
      }
      System.out.println("Barco não encontrado!");
      return false;
   }

   public boolean removePassageiro(String nome) {
      for (int i = 0; i < passageiros.length; i++) {
         if (passageiros[i] != null && passageiros[i].getNome().equals(nome)) {
            passageiros[i] = null;
            return true;
         }
      }
      return false;
   }

   public void mostraPasseio() {
      System.out.println("Barco: " + barco.getNome());
      System.out.println("Valor do bilhete: " + valorBilhete);
      System.out.println("Passageiros:");
      for (Passageiro passageiro : passageiros) {
         if (passageiro != null) {
            System.out.println(passageiro);
         }
      }
   }

   public int buscaPasProfissao(String profissao) {
      int cont = 0;
      for (Passageiro passageiro : passageiros) {
         if (passageiro != null && passageiro.getProfissao().equals(profissao)) {
            cont++;
         }
      }
      return cont;
   }

   public double buscaValorPasseio() {
      double total = 0;
      for (Passageiro passageiro : passageiros) {
         if (passageiro != null) {
            total += valorBilhete;
         }
      }
      return total;
   }
}