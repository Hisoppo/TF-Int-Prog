import java.util.ArrayList;
import java.util.Scanner;

public class Application {
   public static void main(String[] args) {

      CadastroBarcos cadastroBarcos = new CadastroBarcos();
      ArrayList<Passeio> passeios = new ArrayList<>(); 
      Scanner sc = new Scanner(System.in);

      int seletor = 0;

      while (seletor != 11) {
         System.out.println("Selecione uma das opções:");
         System.out.println("""
                           1 \u2013 Incluir barco
                           2 \u2013 Remover barco
                           3 \u2013 Mostrar barcos
                           4 \u2013 Pesquisar e mostrar barco por nome
                           5 \u2013 Criar passeio
                           6 \u2013 Mostrar passeios
                           7 \u2013 Adicionar passageiro no passeio
                           8 \u2013 Remover passageiro do passeio
                           9 \u2013 Quantidade de passageiros por profiss\u00e3o
                           10 \u2013 Valor total arrecadado pelo passeio
                           11 - Sair do programa
                           """);
         seletor = sc.nextInt();
         sc.nextLine();

         switch (seletor) {
            case 1:
               cadastroBarcos.adicionaBarco();
               break;
            case 2:
               System.out.println("Informe o nome do barco a ser removido:");
               String barcoRemover = sc.nextLine();
               cadastroBarcos.removeBarco(barcoRemover);
               break;
            case 3:
               cadastroBarcos.mostraBarcos();
               break;
            case 4:
               System.out.println("Informe o nome do barco a ser pesquisado:");
               String barcoPesquisar = sc.nextLine();
               cadastroBarcos.buscaBarcoNome(barcoPesquisar);
               break;
            case 5:
               criaPasseio(cadastroBarcos, sc, passeios);
               break;
            case 6:
               if (passeios.isEmpty()) {
                  System.out.println("Nenhum passeio cadastrado.");
               } else {
                  for (int i = 0; i < passeios.size(); i++) {
                     System.out.println("Passeio " + (i + 1) + ":");
                     passeios.get(i).mostraPasseio();
                  }
               }
               break;
            case 7:
               System.out.println("Selecione o passeio para adicionar passageiro (número):");
               for (int i = 0; i < passeios.size(); i++) {
                  System.out.println((i + 1) + " - Barco: " + passeios.get(i).getBarco().getNome());
               }
               int passeioSelecionado = sc.nextInt() - 1;
               sc.nextLine();
               if (passeioSelecionado >= 0 && passeioSelecionado < passeios.size()) {
                  Passeio passeioEscolhido = passeios.get(passeioSelecionado);
                  if (!passeioEscolhido.adicionaPassageiro(cadastroBarcos)) {
                     System.out.println("Não foi possível adicionar o passageiro.");
                  }
               } else {
                  System.out.println("Passeio inválido.");
               }
               break;
            case 8:
               System.out.println("Selecione o passeio para remover passageiro (número):");
               for (int i = 0; i < passeios.size(); i++) {
                  System.out.println((i + 1) + " - Barco: " + passeios.get(i).getBarco().getNome());
               }
               passeioSelecionado = sc.nextInt() - 1;
               sc.nextLine();
               if (passeioSelecionado >= 0 && passeioSelecionado < passeios.size()) {
                  Passeio passeioEscolhido = passeios.get(passeioSelecionado);
                  System.out.println("Informe o nome do passageiro:");
                  String nomePassageiro = sc.nextLine();
                  if (!passeioEscolhido.removePassageiro(nomePassageiro)) {
                     System.out.println("Passageiro não encontrado.");
                  } else {
                     System.out.println("Passageiro removido com sucesso.");
                  }
               } else {
                  System.out.println("Passeio inválido.");
               }
               break;
            case 9:
               System.out.println("Selecione o passeio para buscar por profissão (número):");
               for (int i = 0; i < passeios.size(); i++) {
                  System.out.println((i + 1) + " - Barco: " + passeios.get(i).getBarco().getNome());
               }
               passeioSelecionado = sc.nextInt() - 1;
               sc.nextLine();
               if (passeioSelecionado >= 0 && passeioSelecionado < passeios.size()) {
                  Passeio passeioEscolhido = passeios.get(passeioSelecionado);
                  System.out.println("Informe a profissão a ser buscada:");
                  String profissao = sc.nextLine();
                  int quantidade = passeioEscolhido.buscaPasProfissao(profissao);
                  System.out.println("Quantidade de passageiros com a profissão '" + profissao + "': " + quantidade);
               } else {
                  System.out.println("Passeio inválido.");
               }
               break;
            case 10:
               double totalArrecadado = 0;
               for (Passeio passeio : passeios) {
                  totalArrecadado += passeio.buscaValorPasseio();
               }
               System.out.println("Valor total arrecadado por todos os passeios: " + totalArrecadado);
               break;
            case 11:
               System.out.println("Encerrando o programa... Até logo!");
               break;
            default:
               System.out.println("Opção inválida.");
         }
      }
   }
   public static void criaPasseio(CadastroBarcos cadastroBarcos, Scanner sc, ArrayList<Passeio> passeios) {
      System.out.println("Por gentileza, informe o nome do barco para o passeio:");
      String nomeBarco = sc.nextLine();
      Barco b = cadastroBarcos.buscaBarcoNome(nomeBarco);
      if (b != null) {
         
            System.out.println("Barco localizado com sucesso: " + b.getNome());
            System.out.println("Lotação do barco: " + b.getLotacao());
            System.out.println("Digite o valor do bilhete:");
            double valorBilhete = sc.nextDouble();
            sc.nextLine();
            Passeio passeio = new Passeio(b, valorBilhete); 
            passeios.add(passeio);
            System.out.println("Passeio criado com sucesso!");
            return;
      }
      System.out.println("Barco não encontrado. Não foi possível criar o passeio.");
   }
}