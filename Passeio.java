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
// multiplicado pelo número de passageiros que o passeio terá).
public class Passeio {
   Barco barco;
   double valorBilhete;
   Passageiro[] passageiros;

   public Passeio(Barco barco, double valorBilhete) {
      this.barco = barco;
      this.valorBilhete = valorBilhete;
      passageiros = new Passageiro[barco.getLotacao()];
   }

   public boolean adicionaPassageiro(Passageiro passageiro) {
      for (int i = 0; i < passageiros.length; i++) {
         if (passageiros[i] == null) {
            passageiros[i] = passageiro;
            return true;
         }
      }
      return false;
   }

   public boolean removePassageiro(String nome) {
      for (int i = 0; i < passageiros.length; i++) {
         if (passageiros[i].getNome().equals(nome)) {
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
      for (int i = 0; i < passageiros.length; i++) {
         if (passageiros[i] != null) {
            System.out.println(passageiros[i]);
         }
      }
   }

   public int buscaPasProfissao(String profissao) {
      int cont = 0;
      for (int i = 0; i < passageiros.length; i++) {
         if (passageiros[i] != null && passageiros[i].getProfissao().equals(profissao)) {
            cont++;
         }
      }
      return cont;
   }

   public double buscaValorPasseio() {
      return valorBilhete * passageiros.length;
   }

}
