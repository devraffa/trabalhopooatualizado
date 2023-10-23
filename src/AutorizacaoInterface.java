public interface AutorizacaoInterface {

    boolean verificarLogin(ContaBancaria conta, String login);

    boolean verificarSenha(ContaBancaria conta);

}

