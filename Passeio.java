import java.util.Scanner;

public class Passeio {
   private Barco barco;
   private double valorBilhete;
   private Passageiro[] passageiros;
   private int numPassageiros;
   private Scanner sc = new Scanner(System.in);

   public Passeio(Barco barco, double valorBilhete) {
      this.barco = barco;
      this.valorBilhete = valorBilhete;
      this.passageiros = new Passageiro[barco.getLotacao()];
      this.numPassageiros = 0;
   }

   public Barco getBarco() {
      return barco;
   }

   public double getValorBilhete() {
      return valorBilhete;
   }

   public Passageiro[] getPassageiros() {
      return passageiros;
   }

   public boolean adicionaPassageiro(CadastroBarcos cadastroBarcos) {
      System.out.println("Informe o nome do barco para o passeio:");
      String nomeBarco = sc.nextLine();
      for (Barco b : cadastroBarcos.getBarcos()) {
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
                  numPassageiros++;
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
      for (int i = 0; i < numPassageiros; i++) {
         if (passageiros[i].getNome().equals(nome)) {
            passageiros[i] = null;
            numPassageiros--;
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
      return  numPassageiros * valorBilhete;
      
   }
}