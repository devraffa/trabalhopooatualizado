

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroUsuario  {
 
    private Usuario usuario;
    private List<Usuario> usuarios;
 
 
 
    public CadastroUsuario() {
        usuarios = new ArrayList<>();
    }


  Scanner teclado = new Scanner(System.in);  
   

   

    public void Cadastro(){
   
    System.out.println("Digite seu nome completo");
        String nome = teclado.nextLine();
       System.out.println("Digite sua data de nascimento");
        String nascimento = teclado.nextLine();
        validarDataNascimento(nascimento);
        System.out.println("Digite seu endereço");
        String  endereco = teclado.nextLine();
      System.out.println("Digite seu cpf");
      String Cpf = teclado.nextLine();
   while(validarDataNascimento(nascimento)==false){
     System.out.println("sua data de nascimento nao esta no formato");
     System.out.println("digite novamente");
     nascimento = teclado.nextLine();
     if(validarDataNascimento(nascimento)){
        System.out.println("data de nascimento valida");
       break; 
    }


   }
   while(ValidaCpf(Cpf)==false){
     System.out.println("seu cpf esta incorreto");
     System.out.println("digite novamente");
     Cpf = teclado.nextLine();
     if(ValidaCpf(Cpf)){
        System.out.println("cpf correto");
       break; 
    }


   }
    

        if((!existirUsuarioCpf(Cpf))&&(!existirUsuarioEndereco(endereco))&&(!existirUsuarioNome(nome))){
      Usuario usuario = new Usuario(Cpf, nome, endereco, nascimento);
   
      usuarios.add(usuario);
   

    System.out.println("Usuario cadastrado");
   System.out.println("usuario"+usuario.getNome());
   
 

}else{
    System.out.println("Usuario ja esta cadastrado");
  }
   

}

    public boolean ValidaCpf( String cpf){
        cpf = cpf.replace(".", "").replace("-", "");
       
        if (cpf.length() != 11) {
            return false;
        }

        if ( cpf.equals("00000000000") || cpf.equalsIgnoreCase("1111111111")|| cpf.equals("222222222")||
        cpf.equals("333333333")|| cpf.equals("44444444") || cpf.equals("555555555") || cpf.equals("666666666") || cpf.equals("777777777")
        || cpf.equals("888888888") || cpf.equals("999999999")){
            return false;
        }

        return true;
    }

    public static boolean ValidaNumber(String cpf){
        int [] digitos = new int[11];

        for( int i=0; i<11; i++){
            digitos[i]= Character.getNumericValue(i);
        }

        int soma= 0;
        for( int i =0; i<9; i++){
            soma= digitos[i] * (10-i);
        }

        int primeiroDigito = 11 - (soma%11);

        if( primeiroDigito == 10 || primeiroDigito ==11){
            primeiroDigito = 0;
        }
        if( primeiroDigito != digitos[9]){
            return false;
        }

        for( int i=0; i<10; i++){
            soma = digitos[i] * ( 11-i);
        }

        int segundoDigito = 11- (soma %11);

        if( primeiroDigito == 10 || primeiroDigito ==11){
            primeiroDigito = 0;
        }

        return segundoDigito == digitos[10];
    }

    public static boolean validarDataNascimento(String dataNascimento) {
   
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataNascimento, formato);
            LocalDate dataAtual = LocalDate.now();
           
            // Verificar se a data de nascimento é válida
            if (!data.isAfter(dataAtual)) {
                // Verificar se a pessoa tem menos de 18 anos
                LocalDate dataDezoitoAnosAtras = dataAtual.minusYears(18);
                return !data.isAfter(dataDezoitoAnosAtras);
            } else {
                return false;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
    }
   
    public boolean existirUsuarioCpf(String Cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(Cpf)) {
                return true;
            }
        }
        return false;
    }

   public boolean existirUsuarioNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

   public boolean existirUsuarioNascimento(String nascimento) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDataNascimento().equals(nascimento)) {
                return true;
            }
        }
        return false;
    }
   public boolean existirUsuarioEndereco(String endereco) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEndereco().equals(endereco)) {
                return true;
            }
        }
        return false;
    }

    public Usuario escolherUsuario(String n) {
   
    for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(n)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

public Scanner getTeclado() {
    return teclado;
}

public void setTeclado(Scanner teclado) {
    this.teclado = teclado;
}

public List<Usuario> getUsuarios() {
    return usuarios;
}

public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
}

@Override
public String toString() {
    return  "usuario=" + usuario + ", usuarios=" + usuarios;
           
}

   /*  private String pedirEntradaNaoVazia(String mensagem) {
        String entrada;
        do {
            System.out.print(mensagem);
            entrada = teclado.nextLine().trim();
        } while (entrada.isEmpty());

        return entrada;
    }*/


}
