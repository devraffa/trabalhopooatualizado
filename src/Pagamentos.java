
import java.util.Random;
import java.util.Scanner;

public class Pagamentos {
     private Random random;
     private double ultimoValorPago;

    public Pagamentos() {
        random = new Random();
        ultimoValorPago = 0.0;
    }

    public double pagarAgua(ContaBancaria contaPagar) {
   
        double valor = 20 + random.nextDouble() * 80;
        System.out.println("Valor da conta:" + valor);
       
        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return contaPagar.getSaldo();
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return contaPagar.getSaldo();
        }

    }


    public double pagarEnergia( ContaBancaria contaPagar) {
        double valor = 50 + random.nextDouble() * 150;
        System.out.println("Valor da conta:" +valor);

        if(contaPagar.getSaldo()>=valor){
            contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return contaPagar.getSaldo();
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return contaPagar.getSaldo();
        }
    }

 
    public double pagarInternet(ContaBancaria contaPagar) {
        double valor = 30 + random.nextDouble() * 70;
        System.out.println("Valor da conta:" + valor);

        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return contaPagar.getSaldo();
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return contaPagar.getSaldo();
        }
    }

    public double getUltimoValorPago() {
        return ultimoValorPago;
    }

    public void menuPagamentos ( ContaBancaria conta){
        boolean sairDoMenuDeOperacoes = false;
        Scanner sc = new Scanner(System.in);
        while (!sairDoMenuDeOperacoes) {
        System.out.println("------Faturas e Boletos para pagar-------");
        System.out.println("Faturas:");
        System.out.println("1. Conta de Energia");
        System.out.println("2. Conta de Água");
        System.out.println("3. Conta de Internet");
        System.out.println("4. Para sair do menu de pagamentos");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
              

                    System.out.println("Saldo restabte na conta: " + conta.getSaldo());
                break;
            case 2:
               

                    System.out.println("Saldo restante na conta: " + conta.getSaldo());

                break;
            case 3:
 

                    System.out.println("Saldo restante na conta: " + conta.getSaldo());

                break;

            case 4:
            sairDoMenuDeOperacoes = true;
            //metodo de sair desse menu e voltar para o menu de reaizaroperação
            break;
            } 

            
    }
    
}

}


