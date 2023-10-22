
public class Transacoes {
    private ContaBancaria origem;
    private ContaBancaria destino;
    private double valor;

    public Transacoes(ContaBancaria origem, ContaBancaria destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public ContaBancaria getOrigem() {
        return origem;
    }

    public ContaBancaria getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Transação de " + origem.getLogin() + " para " + destino.getLogin() + ", Valor: " + valor;
    }
}


