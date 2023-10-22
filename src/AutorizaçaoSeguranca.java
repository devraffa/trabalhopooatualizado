
import java.util.Scanner;

class AutorizacaoSeguranca {

   
   Scanner sc = new Scanner(System.in);
 
  /*   public boolean autorizarOperacao(String senhaDigitada) {
        if (verificarSenha(getGerencia(), senhaDigitada)) {
            System.out.println("Operação autorizada.");
            return true;
        } else {
            System.out.println("Senha incorreta. Operação não autorizada.");
            return false;
        }
    }*/

    public boolean verificarLogin(ContaBancaria conta,String login){
      while(conta.getLogin().equals(login)){
    System.out.println(" login errado digite novamente");
      String l = sc.nextLine();
      if(l==conta.getLogin()){
       System.out.println("senha correta");
        return true;
      }
     
    }
   return false;
  }

boolean caso = false;
public boolean verificarSenha(ContaBancaria conta) {
    int tentativas = 3;
    Scanner sc = new Scanner(System.in);

    while (tentativas > 0) {
        System.out.println("Digite sua senha: ");
        int s = sc.nextInt();
       
        if (s == conta.getSenha()) {
            System.out.println("Senha correta, Bem vindo");
            caso = true;
            return true;
        } else {
            System.out.println("Senha errada, tentativas restantes: " + (tentativas - 1));
            tentativas--;
        }
    }
    sc.close();

    System.out.println("Limite de tentativas excedido. A conta está bloqueada.");
    return false;
}

    /*public void verificarLogin(ContaBancaria conta){
    Scanner sc = new Scanner(System.in);
    String loginDigitado;

    do {
        System.out.println("Digite seu login: ");
        loginDigitado = sc.nextLine();

        if (conta.getLogin().equals(loginDigitado)) {
            System.out.println("Login correto.");
        } else {
            System.out.println("Login errado, digite novamente.");
        }
    } while (!conta.getLogin().equals(loginDigitado));

    System.out.println("Login verificado com sucesso.");
}*/


  /*public boolean solicitarSenhaNovamente(ContaBancaria conta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua senha novamente: ");
        int senhaDigitada = scanner.nextInt();

        if (verificarSenha(conta, senhaDigitada)) {
            System.out.println("Senha verificada com sucesso.");
            return true;
        } else {
            System.out.println("Senha incorreta. Tente novamente.");
            return false;
        }
    }*/

 


}
