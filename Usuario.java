import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    public String nome;
    public String cpf;
    public String email;
    public String numero;
    public boolean status;
    public int fidelidade;

    public List<Produto> carrinho;
    public List<Produto> alugados;

    public Usuario() {
        this.setStatus(false);
        carrinho = new ArrayList<Produto>();
        alugados = new ArrayList<Produto>();
        this.setFidelidade(0);
    }


    public void estadoAtual(){
        System.out.println("-----------------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Numero: " + this.getNumero());
        System.out.println("Status da conta: " + this.isStatus());
        System.out.println("-----------------");

        Utils.awaitInput();

    }



    public void criarConta(){
        System.out.println("-----------------");
        Scanner Leitor = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String Usuario = Leitor.nextLine();
        setNome(Usuario);
        System.out.println("Digite seu CPF:");
        String Cpf = Leitor.nextLine();
        setCpf(Cpf);
        System.out.println("Digite seu Email:");
        String Email = Leitor.nextLine();
        setEmail(Email);
        System.out.println("Digite seu numero:");
        String Numero = Leitor.nextLine();
        setNumero(Numero);

        setFidelidade();
        setStatus(true);

        Utils.awaitInput();
    }

    public void modificarDados(){
        System.out.println("-----------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual dado você quer modificar? ");
        System.out.println("Opções: CPF, Nome, Email e Numero");
        String Dado = scanner.nextLine();
        System.out.println("Digite o novo dado: ");
        String novodado = scanner.next();

        if(Dado.equalsIgnoreCase("CPF")){
            setCpf(novodado);
            //System.out.println(novodado);
        } else if (Dado.equalsIgnoreCase("Nome")) {
            setNome(novodado);
            //System.out.println(novodado);
        } else if (Dado.equalsIgnoreCase("Email")) {
            setEmail(novodado);
            //System.out.println(novodado);
        }else if (Dado.equalsIgnoreCase("Numero")){
            setNumero(novodado);
            //System.out.println(novodado);
        }else {
            System.out.println("Tente novamente. Opções de dados: CPF, Nome, Email, Numero.");
        }

        Utils.awaitInput();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getfidelidade()
    {
        return fidelidade;
    }

    public void setFidelidade()
    {
        this.fidelidade  = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return String.valueOf(numero);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(int fidelidade) {
        this.fidelidade = fidelidade;
    }
}
