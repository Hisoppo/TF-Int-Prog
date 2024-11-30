import java.util.Scanner;

// Crie uma classe Application que deverá ter o método main com as seguintes funcionalidades que
// deverão acionar o(s) métodos adequados para a realização da operação escolhida.
// 1 – Incluir barco
// 2 – Remover barco
// 3 – Mostrar barcos
// 4 – Pesquisar e mostrar barco por nome
// 5 – Criar passeio
// 6 – Mostrar passeio
// 7 – Adicionar passageiro no passeio
// 8 – Remover passageiro do passeio
// 9 – Quantidade de passageiros por profissão
// 10 – Valor total arrecadado pelo passeio
// 11 – Sair do programa
public class Application {
   public static void main(String[] args) {
      CadastroBarcos cadastroBarcos = new CadastroBarcos();
      
      
      try (Scanner sc = new Scanner(System.in)) {
      Barco barco = new Barco(0, "", 0);
      Passageiro passageiro = new Passageiro("", 0, "");
      Passeio passeio = new Passeio(barco, 01);
      
      int seletor = 0;

      while(seletor != 11) {

         System.out.println("Selecione uma das opções:");
         System.out.println("""
            1 – Incluir barco
            2 – Remover barco
            3 – Mostrar barcos
            4 – Pesquisar e mostrar barco por nome
            5 – Criar passeio
            6 – Mostrar passeio
            7 – Adicionar passageiro no passeio
            8 – Remover passageiro do passeio
            9 – Quantidade de passageiros por profissão
            10 – Valor total arrecadado pelo passeio
            11 - Sair do programa
            """);
                           seletor = sc.nextInt();
                           sc.nextLine();
                           
         
         switch (seletor) {
            case 1 -> cadastroBarcos.adicionaBarco();
            case 2 -> cadastroBarcos.removeBarco(barco.getNome());
            case 3 -> cadastroBarcos.mostraBarcos();
            case 4 -> cadastroBarcos.buscaBarcoNome(barco.getNome());
            case 5 -> passeio.criaPasseio(barco, seletor);
            case 6 -> passeio.mostraPasseio();
            case 7 -> {
               System.out.println("Digite o nome do passageiro:");
               String nome = sc.nextLine();
               System.out.println("Digite a idade do passageiro:");
               int idade = sc.nextInt();
               sc.nextLine(); // consume the newline
               System.out.println("Digite a profissão do passageiro:");
               String profissao = sc.nextLine();
               passeio.adicionaPassageiro(nome, idade, profissao);
            }
            case 8 -> passeio.removePassageiro(passageiro.getNome());
            case 9 -> passeio.buscaPasProfissao(passageiro.getProfissao());
            case 10 -> passeio.buscaValorPasseio();
            case 11 -> System.out.println("Encerrando o programa... Ate logo!");
            }
         }
      }
   }
}