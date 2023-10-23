import java.util.Scanner;

public class Investimentos {
    private int prazoDeDias;
    private double taxaDeRetornoDiaria;
    private ContaBancaria conta;


    public Investimentos(int prazoDeDias, double taxaDeRetornoDiaria, ContaBancaria conta) {
        this.prazoDeDias = prazoDeDias;
        this.taxaDeRetornoDiaria = taxaDeRetornoDiaria;
        this.conta = conta;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public int getPrazoDeDias() {
        return prazoDeDias;
    }

    public void setPrazoDeDias(int prazoDeDias) {
        this.prazoDeDias = prazoDeDias;
    }

    public double getTaxaDeRetornoDiaria() {
        return taxaDeRetornoDiaria;
    }

    public void setTaxaDeRetornoDiaria(double taxaDeRetornoDiaria) {
        this.taxaDeRetornoDiaria = taxaDeRetornoDiaria;
    }

    double valorInvestido =0.0;   
    
    public void calcularRetornoInvestido(int prazoDeDias, double taxaDeRetornoDiaria, ContaBancaria conta) {
        Scanner sc = new Scanner(System.in);
        
        if (conta.getSaldo() >= 0) {
            System.out.print("Digite o valor do investimento: ");
            double valorInvestimento = sc.nextDouble();
    
            if (valorInvestimento >= 0) {
                double valorFuturo = valorInvestimento;
    
                for (int dia = 0; dia < prazoDeDias; dia++) {
                    valorFuturo += valorFuturo * taxaDeRetornoDiaria;
                }
                
                atualizarSaldo(valorFuturo);
                System.out.println("Saldo com o investimento: " + conta.getSaldo());
            } else {
                System.out.println("Não é possível investir um valor negativo.");
            }
        } else {
            System.out.println("Não pode investir se não tem saldo.");
        }
    }
    

    private void atualizarSaldo(double valorFuturo) {
        double saldoAtual = conta.getSaldo(); 
        saldoAtual += valorFuturo;
        conta.setSaldo(saldoAtual);
    }


        /* 
    public void calcularRetornoInvestido(int prazoDeDias, double taxaDeRetornoDiaria, ContaBancaria conta) throws InvestimentoInvalidoException {
        Scanner sc = new Scanner(System.in);
        
        if (conta.getSaldo() >= 0) {
            System.out.print("Digite o valor do investimento: ");
            double valorInvestimento = sc.nextDouble();
    
            if (valorInvestimento >= 0) {
                double valorFuturo = valorInvestimento;
    
                for (int dia = 0; dia < prazoDeDias; dia++) {
                    valorFuturo += valorFuturo * taxaDeRetornoDiaria;
                }
                
                atualizarSaldo(valorFuturo);
                System.out.println("Saldo com o investimento: " + conta.getSaldo());
            } else {
                throw new InvestimentoInvalidoException("Não é possível investir um valor negativo.");
            }
        } else {
            throw new InvestimentoInvalidoException("Não pode investir se não tem saldo.");
        }
    }*/

    /*public class InvestimentoInvalidoException extends Exception {
    public InvestimentoInvalidoException(String message) {
        super(message);
    }
} */

}

