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
      
      
      Scanner sc = new Scanner(System.in); 
      Barco barco = new Barco(0, "", 0);
      Passageiro passageiro = new Passageiro("", 0, "");
      Passeio passeio = new Passeio(barco, 01);
      
      int seletor = 0;

      while(seletor != 11) {

         System.out.println("Selecione uma das opções:");
         System.out.println("1 – Incluir barco \n"+
                           " 2 – Remover barco \n " +
                           " 3 – Mostrar barcos \n " +
                           " 4 – Pesquisar e mostrar barco por nome \n "+
                           " 5 – Criar passeio \n" + 
                           " 6 – Mostrar passeio \n" +
                           " 7 – Adicionar passageiro no passeio \n"+
                           " 8 – Remover passageiro do passeio \n "+
                           " 9 – Quantidade de passageiros por profissão \n"+
                           " 10 – Valor total arrecadado pelo passeio \n"+
                           " 11 - Sair do programa \n" ); 
                           seletor = sc.nextInt();
                           sc.nextLine();
                           
         
         switch (seletor) {
            case 1:
               cadastroBarcos.adicionaBarco();
               break;
            case 2:
               cadastroBarcos.removeBarco(barco.getNome());
               break;
            case 3:
               cadastroBarcos.mostraBarcos();
               break;
            case 4:
               cadastroBarcos.buscaBarcoNome(barco.getNome());
               break;
            case 5:
               passeio.criaPasseio(barco, seletor);
               break;
            case 6:
               passeio.mostraPasseio();
               break;
            case 7:
               passeio.adicionaPassageiro(passageiro);
               break;
            case 8:
               passeio.removePassageiro(passageiro.getNome());
               break;
            case 9:
               passeio.buscaPasProfissao(passageiro.getProfissao());
               break;
            case 10:
               passeio.buscaValorPasseio();
               break;
            case 11:
               System.out.println("Encerrando o programa... Ate logo!");
               break;
         }
            }
   }
}