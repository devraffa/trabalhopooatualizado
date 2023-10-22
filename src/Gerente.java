

public class Gerente extends Usuario {

    private String cargo;
    private GerenciarConta gerencia;
    private ContaBancaria conta;
    
    public Gerente(String cpf, String nome, String endereco, String dataNascimento, String cargo,
            GerenciarConta gerencia) {
        super(cpf, nome, endereco, dataNascimento);
        this.cargo = cargo;
        this.gerencia = gerencia;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public GerenciarConta getGerencia() {
        return gerencia;
    }
    public void setGerencia(GerenciarConta gerencia) {
        this.gerencia = gerencia;
    }

    public void gerenciando(){

        
        gerencia.verSaldo(conta);
        gerencia.exibirInfo(conta);
        gerencia.Permitir();
       
        
    }

}
