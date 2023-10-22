


public class ContaBancaria {

    private int codigo;
    private String login;
    private int senha;
    private double saldo;
    private Usuario usuario;
   

public ContaBancaria(int codigo, String login, int senha,Usuario usuario) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.saldo = 0.0;
        this.usuario = usuario;
    }

public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
   
    public void setSenha(int senha) {
        this.senha = senha;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     public double getSaldo() {
        return saldo;
    }

public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException{
    if(getSaldo()>0 && valor>0 && getSaldo()>valor){
        setSaldo(getSaldo()-valor);
       }
    if (valor <= 0) {
        throw new ValorInvalidoException("Valor inválido para saque");
    }
    if (getSaldo() < valor) {
        throw new SaldoInsuficienteException("Saldo insuficiente para saque");
    }
}

public void depositar(double valor) throws ValorInvalidoException {
    if (valor <= 0.0) {
        throw new ValorInvalidoException("Valor de depósito inválido. O valor do depósito deve ser maior que zero.");
    }
    setSaldo(getSaldo() + valor);
}

  /*public void depositar(double valor) throws ValorInvalidoException{
    if(valor<=0){
        throw new ValorInvalidoException("Valor insuficente para o deposito");
  }
        setSaldo(getSaldo()+valor);
}*/

public void setSaldo(double saldo) {
    this.saldo = saldo;
}



@Override
public String toString() {
  return "Conta [saldo=" + saldo + ", usuario=" + getUsuario()+ "]";
}

public int getSenha() {
    return senha;
}


}

