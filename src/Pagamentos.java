
import java.util.Random;

public class Pagamentos {
     private Random random;

    public Pagamentos() {
        random = new Random();
    }

    public double pagarAgua(ContaBancaria contaPagar) {
   
        double valor = 20 + random.nextDouble() * 80;
        System.out.println(valor);
       
        if(contaPagar.getSaldo()>=valor){
          contaPagar.setSaldo(contaPagar.getSaldo()-valor);
            return contaPagar.getSaldo();
        }else{
            System.out.println("valor insuficiente para pagar a conta");
         return contaPagar.getSaldo();
        }

    }


    public double pagarEnergia() {
        double valor = 50 + random.nextDouble() * 150;
        return valor;
    }

 
    public double pagarInternet() {
        double valor = 30 + random.nextDouble() * 70;
        return valor;
    }
    
}

