import java.util.List;

public interface InterfaceCadastroUsuario {
    
    void Cadastro();

    boolean ValidaCpf(String cpf);

    boolean ValidaNumber(String cpf);

    boolean validarDataNascimento(String dataNascimento);

    boolean existirUsuarioCpf(String Cpf);

    boolean existirUsuarioNome(String nome);

    boolean existirUsuarioNascimento(String nascimento);

    boolean existirUsuarioEndereco(String endereco);

    Usuario escolherUsuario(String n);

    Usuario getUsuario();

    void setUsuario(Usuario usuario);

    List<Usuario> getUsuarios();

    void setUsuarios(List<Usuario> usuarios);
}
