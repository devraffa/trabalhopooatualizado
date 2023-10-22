
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciarConta {

    private boolean deixa;

    private Gerente g1;
    private List<ContaBancaria> contas;
    private ContaBancaria conta;
 
    Scanner teclado = new Scanner(System.in);

    public GerenciarConta(Gerente g1) {
        contas = new ArrayList<>();
        this.g1 = g1;

    }

    public Gerente getG1() {
        return g1;
    }

    public void setG1(Gerente g1) {
        this.g1 = g1;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public boolean isDeixa() {
        return deixa;
    }

    public void setDeixa(boolean deixa) {
        this.deixa = deixa;
    }

    public boolean Permitir() {
        if (deixa == true) {
            System.out.println("pode criar sua conta");
            return true;
        } else {
            System.out.println("não pode criar sua conta");
        }
        return false;
    }

    public void criarConta(ContaBancaria conta) {

        contas.add(conta);

    }

    public int getQuantidadeDeContas() {
        return contas.size();
    }

    public boolean loginDiferente(String login) {
        for (ContaBancaria c : contas) {
            if (c.getLogin().equals(login)) {
                System.out.println("login ja existe digite novamente");
                String l = teclado.nextLine();
                if (!c.getLogin().equals(l)) {
                    System.out.println("seu login e valido");
                    return true;
                }

            } else {
                System.out.println("seu login esta correto");
                return true;
            }

        }
        return false;
    }

    public ContaBancaria encontrarConta(int codigo) {
        for (ContaBancaria c : contas) {
            if (c.getCodigo() == codigo) {
                return c;
            }

        }
        return null;

    }

    public void verSaldo( ContaBancaria conta) {
        System.out.println("Esse é o seu saldo: " + conta.getSaldo());
    }

    public void exibirInfo( ContaBancaria conta) {
            Usuario usuario = conta.getUsuario();
            if (usuario != null) {
                System.out.println("Informações do usuário: " + usuario.toString());
                System.out.println("login: " + conta.getLogin());
                    System.out.println("codigo da conta: " + conta.getCodigo());
                    System.out.println("cpf" + conta.getUsuario().getCpf());
            } else {
                System.out.println("Usuário não encontrado para a conta ");
            }
        }

    public void Encerrar(ContaBancaria contaEncerrar) {
        if (contaEncerrar.getSaldo() == 0.0) {
            contas.remove(contaEncerrar);
            System.out.println("Conta encerrada com sucesso.");
        } else {
            System.out.println("Não é possível encerrar a conta. O saldo não é zero.");
        }
    }

    public List<Transacoes> histransacoes = new ArrayList<>();

    public List<Transacoes> getHistransacoes() {
        return histransacoes;
    }

    public void Transacoes(double valor, ContaBancaria origem)
            throws ContaNaoExisteException, ValorInvalidoException, SaldoInsuficienteException {

        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido para transação");
        }


        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o código da conta de destino: ");
        int codigoDestino = sc.nextInt();
        ContaBancaria contaDestino = encontrarConta(codigoDestino);
        if (!contas.contains(contaDestino)) {
            throw new ContaNaoExisteException("Conta destinatária inexistente");
        }

        if (origem.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transação");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        System.out.println(contaDestino.getSaldo());

        /*
         * if( getSaldo() >= valor){
         * if(contas.contains(destinatario)){
         * setSaldo(getSaldo() - valor);
         * destinatario.setSaldo(destinatario.getSaldo()+valor);
         * System.out.println("Transação ralizada com sucesso");
         * }
         * else{
         * System.out.println("Essa conta não existe");
         * }
         * }else{
         * System.out.println("Saldo insufiecente para realizar transação");
         * }
         */
        histransacoes.add(new Transacoes(origem, contaDestino, valor));
        System.out.println("Transação ralizada com sucesso");

    }

    public void adicionarTransacao(Transacoes transacao) {
        histransacoes.add(transacao);
    }

    double valorSaque =0.0;
    double valorDeposito =0.0;
    public void Extrato( ContaBancaria conta) {
        System.out.println("Extrato da conta do:" + conta.getLogin());
        for (Transacoes transacoes : histransacoes) {
            System.out.println(transacoes.toString());
        }
        System.out.println("Saque de: " + valorSaque);
        System.out.println("Deposito de: " + valorDeposito);
        System.out.println("Pagamento de:" );
    }
 
    /*public void realizarOperacoes(ContaBancaria conta) {
        Scanner scanner = new Scanner(System.in);
  
        while (true) {

            
            try {
                System.out.println("Escolha a operação:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Transação");
                System.out.println("4. Ver informações");
                System.out.println("5. Sair");

                int opcaoOperacoes = scanner.nextInt();

                if (opcaoOperacoes==1) {
                    System.out.print("Digite o valor do depósito: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso.");
                } else if (opcaoOperacoes == 2) {
                    System.out.print("Digite o valor do saque: ");
                    double valor = scanner.nextDouble();
                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso.");
                } else if (opcaoOperacoes == 3) {
                    System.out.print("Digite o valor da transação: ");
                    double valor = scanner.nextDouble();
                    Transacao(null, valor, null);
                } else if (opcaoOperacoes == 4) {
                    System.out.println("login: " + conta.getLogin());
                    System.out.println("codigo da conta: " + conta.getCodigo());
                    System.out.println("cpf" + conta.getUsuario().getCpf());
                    System.out.println("saldo:" + conta.getSaldo());
                } else if (opcaoOperacoes == 5) {
                    System.out.println("Saindo do menu.");
                    
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (ValorInvalidoException | SaldoInsuficienteException | ContaNaoExisteException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }*/
    
    /*public void realizarOperacoes(ContaBancaria contaOperacao,Scanner sc)throws SaldoInsuficienteException, ValorInvalidoException,ContaNaoExisteException {
        boolean sairDoMenuDeOperacoes = false;
       Scanner scanner = new Scanner(System.in);
        while (!sairDoMenuDeOperacoes) {
           
            System.out.println("Escolha a operação:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Transação");
                System.out.println("4. Ver informações");
                System.out.println("5. Sair"); 
            
            int opcaoOperacoes = solicitarOpcao(sc);

            try{
            switch (opcaoOperacoes) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaOperacao.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    contaOperacao.sacar(valorSaque);
                    System.out.println("Saque realizado com sucesso.");
                    break;
             case 3:
                 System.out.print("Digite o valor da transação: ");
                    double valorTransacao = scanner.nextDouble();
                    Transacao(null, valorTransacao, null);

              break;
                case 4:
                exibirInfo();
                verSaldo();
              break;
                    case 5:
                    sairDoMenuDeOperacoes = true; 
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (ContaNaoExisteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número válido.");
            scanner.next();
        }
    }

    scanner.close();
    }*/

    public void realizarOperacoes(ContaBancaria contaOperacao, Scanner sc) throws SaldoInsuficienteException, ValorInvalidoException,ContaNaoExisteException {
        boolean sairDoMenuDeOperacoes = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!sairDoMenuDeOperacoes) {
            System.out.println("Escolha a operação:");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Transação");
            System.out.println("4. Ver informações");
            System.out.println("5. Pagar energia");
            System.out.println("6. Pagar água");
            System.out.println("7. Pagar internet");
            System.out.println("8. Pgamentos");
            System.out.println("9. ver extrato");
            System.out.println("10. Sair");
    
            int opcaoOperacoes = solicitarOpcao(sc);
    
            try {
                switch (opcaoOperacoes) {
                    case 1:
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaOperacao.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                        break;
                        
                    case 2:
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        contaOperacao.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso.");
                        break;
                        
                    case 3:
                        System.out.print("Digite o valor da transação: ");
                        double valorTransacao = scanner.nextDouble();
                        Transacoes(valorTransacao, contaOperacao);
                        break;
                        
                    case 4:
                        
                        exibirInfo(contaOperacao);
                        verSaldo(contaOperacao);

                        break;
                    case 5:


                    break;

                    case 6:


                    
                    break;

                    case 7:



                    break;

                    case 8:



                    break;


                    case 9:

                    Extrato(contaOperacao);
                        
                    case 10:
                        sairDoMenuDeOperacoes = true;
                        break;
                        
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (ValorInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (ContaNaoExisteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número válido.");
                scanner.next(); 
            }
        }
        scanner.close();
    }

    private static int solicitarOpcao(Scanner sc) {
     
        return sc.nextInt();
      
    }

}
