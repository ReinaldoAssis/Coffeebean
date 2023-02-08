import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class DB {
    List<Usuario> userList;
    List<Produto> produtoList;

    public DB()
    {
        userList = new ArrayList<Usuario>();
        produtoList = new ArrayList<Produto>();
    }

    public int getUserIndex(String cpf)
    {
        for(int i=0; i<userList.size(); i++)
        {
            if(userList.get(i).cpf.equals(cpf))
            {
                return i;
            }
        }
        return -1;
    } 

    public void criarUsuario()
    {
        Usuario User1 = new Usuario();

        User1.criarConta();
        //User1.estadoAtual();
        //User1.modificarDados();
        //User1.estadoAtual();

        userList.add(User1);

        User1.estadoAtual();

    }

    public void modificarUsuario(String cpf)
    {
        int i = getUserIndex(cpf);
        userList.get(i).modificarDados();
        userList.get(i).estadoAtual();
        
    }

    public void modificarUsuario()
    {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o CPF do usuario a ser modificado: ");
        String cpf = leitor.nextLine();

        int i = getUserIndex(cpf);
        if(i == -1) System.out.println("Usuario não existe");

        userList.get(i).modificarDados();
        userList.get(i).estadoAtual();
        
    }

    public void removerUsuario(String cpf)
    {
        int i = getUserIndex(cpf);
        if(i == -1) System.out.println("Usuario não existe");
        else userList.remove(i);
    }

    public void removerUsuario()
    {
        System.out.println("Digite o CPF do usuario a ser removido: ");

        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.nextLine();
        int i = getUserIndex(cpf);

        System.out.println("Deseja remover usuario " + userList.get(i).nome + "? [sim/nao]");
        String opcao = leitor.nextLine();
        if(opcao.equals("sim"))
        {
            if(i == -1) System.out.println("Usuario não existe");
            else 
            {
                userList.remove(i);
                System.out.println("Usuario removido :'(");
            }

        }

    }

    public void cadastrarProduto()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("Digite o código do produto: ");
        String Codigo = scanner.nextLine();
        
        System.out.println("Digite o tipo do produto: ");
        String Tipo = scanner.nextLine();
        
        System.out.println("Digite o nome do produto: ");
        String Nome = scanner.nextLine();
        
        System.out.println("Digite a quantidade que vai ser armazenada: ");
        int Quantidade = scanner.nextInt();
        
        System.out.println("Digite o valor de compra produto: ");
        double valorC = scanner.nextDouble();
        
        System.out.println("Digite o valor de venda produto: ");
        double valorV = scanner.nextDouble();

        Produto pd = new Produto(Codigo, Nome, Quantidade, Tipo, valorC, valorV);
        
        produtoList.add(pd);

        System.out.println(Nome+" cadastrado com sucesso :P");

    }

}