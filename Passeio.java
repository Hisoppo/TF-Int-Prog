import java.util.Scanner;

// Os passeios serão organizados em uma classe Passeio que também deve ser criada e terá os
// seguintes atributos: o barco que fará o passeio (objeto do tipo Barco), o valor do bilhete de
// passagem (double) e o vetor de passageiros (vetor de objetos passageiros) em que serão
// armazenados os passageiros que farão o passeio. Crie os métodos de acesso para o atributo barco
// e para o valor do bilhete de passagem. O construtor deve receber como parâmetro o barco que fará
// o passeio, o valor do bilhete e criar o vetor de passageiros com a lotação do barco. Além do
// construtor, esta classe deve ter os seguintes métodos: adicionaPassageiro que insere um objeto
// passageiro no vetor de passageiros (recebe o passageiro e retorna true se a inserção pode ser
// realizada ou false se a inserção não foi possível), removePassageiro (recebe o nome do passageiro
// e retorna true se o passageiro foi removido e false se o passageiro não foi removido) e
// mostraPasseio (mostra os dados do passeio, incluindo os dados dos passageiros que estão
// armazenados), 
//buscaPasProfissao (recebe o nome da profissão e retorna a quantidade de
// passageiros do passeio que possuem a profissão recebida como parâmetro) e buscaValorPasseio
// (retorna o valor arrecadado pelo passeio que corresponde ao valor do bilhete de passagem
// multiplicado pelo número de passageiros que o passeio terá)

   public class Passeio {
      Barco barco;
      double valorBilhete;
      Passageiro[] passageiros;
      CadastroBarcos cadastroBarcos;

      public Passeio(Barco barco, double valorBilhete) {
         this.barco = barco;
         this.valorBilhete = valorBilhete;
         passageiros = new Passageiro[barco.getLotacao()];
      }
         Scanner sc = new Scanner(System.in);

         public void criaPasseio(CadastroBarcos cadastroBarcos) {
            System.out.println("Por gentileza, informe o nome do barco para o passeio:");
            String nomeBarco = sc.nextLine();
            for (int i = 0; i < cadastroBarcos.barcos.length; i++) {
               if (cadastroBarcos.barcos[i] != null && nomeBarco.equals(cadastroBarcos.barcos[i].getNome())) {
                  Barco barcoEscolhido = cadastroBarcos.barcos[i];
                  System.out.println("Barco localizado com sucesso: " + barcoEscolhido.getNome());
                  System.out.println("Lotação do barco: " + barcoEscolhido.getLotacao());
                  System.out.println("Digite o valor do bilhete:");
                  double valorBilhete = sc.nextDouble();
                  sc.nextLine();
                  this.barco = barcoEscolhido;
                  this.valorBilhete = valorBilhete;
                  this.passageiros = new Passageiro[barcoEscolhido.getLotacao()];
                  System.out.println("Passeio criado com sucesso!");
                  return;
               }
            }
            System.out.println("Barco não encontrado. Não foi possível criar o passeio.");
         }

         public boolean adicionaPassageiro(Passageiro passageiro, String nomeBarco) {
            System.out.println("Informe o nome do barco para o passeio:");
            nomeBarco = sc.nextLine();
            // Verifica se o barco está registrado no cadastro
            for (int i = 0; i < cadastroBarcos.barcos.length; i++) {
               if (cadastroBarcos.barcos[i] != null && nomeBarco.equals(cadastroBarcos.barcos[i].getNome())) {
                  Barco barcoEscolhido = cadastroBarcos.barcos[i];
                  System.out.println("Barco localizado com sucesso: " + barcoEscolhido.getNome());
                  System.out.println("Lotação do barco: " + barcoEscolhido.getLotacao());
                            // Procura um espaço vazio no vetor de passageiros
                  for (int j = 0; j < passageiros.length; j++) {
                     if (passageiros[j] == null) {
                     System.out.println("Digite o nome do passageiro:");
                     String nomePassageiro = sc.nextLine();
                     System.out.println("Digite a idade do passageiro:");
                     int idade = sc.nextInt();
                     sc.nextLine(); // Consumir quebra de linha
   
                     System.out.println("Digite a profissão do passageiro:");
                     String profissao = sc.nextLine();
   
                            // Cria o objeto passageiro e adiciona no vetor
                     passageiros[j] = new Passageiro(nomePassageiro, idade, profissao);
                     System.out.println("Passageiro adicionado com sucesso!");
                     return true; // Adicionado com sucesso
                        }
                     }
                     System.out.println("O barco está cheio!");
                     return false; // Não há espaço no barco
                  }
               }
            System.out.println("Barco não encontrado!");
            return false; // Barco não encontrado no cadastro
         }
   

         public boolean removePassageiro(String nome) {
            for (int i = 0; i < passageiros.length; i++) {
               if (passageiros[i] != null && passageiros[i].getNome().equals(nome)) {
                  for (int j = i; j < passageiros.length - 1; j++) {
                        passageiros[j] = passageiros[j + 1];
                  }
                    passageiros[passageiros.length - 1] = null; // Última posição agora é nula
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
