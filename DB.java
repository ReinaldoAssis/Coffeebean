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

    public int getProdutoIndex(String nome)
    {
        for(int i=0; i<produtoList.size(); i++)
        {
            if(produtoList.get(i).nome.equalsIgnoreCase(nome))
            {
                return i;
            }
        }
        return -1;
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
    
  public void ConsultaFidelidade()
    {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o CPF do usuario que deseja fazer a consulta: ");
        String cpf = leitor.nextLine();

        int i = getUserIndex(cpf);
        if(i == -1) System.out.println("Usuario não existe");
        System.out.println("Pontos de fidelidade:" + this.userList.get(i).fidelidade);
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

    //@Reinaldo
    public void removerProduto()
    {
        //temos que considerar um caso especial: pode existir um carrinho com o produto que será removido
        //neste caso, solicita-se a confirmação

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        int i = getProdutoIndex(nome);
        if(i == -1) System.out.println("O Produto não existe");
        else {

            //verificar se o produto está em algum carrinho
            for(int j=0; j<userList.size(); j++)
                if(userList.get(j).carrinho.contains(produtoList.get(i)))
                {
                    System.out.println("O produto está em um carrinho, deseja remover mesmo assim? [sim/nao]");
                    String opcao = scanner.nextLine();
                    if(opcao.equals("sim"))
                    {
                        System.out.println("O produto "+ produtoList.get(i).nome+ " foi removido" );
                        produtoList.remove(i);
                    }
                    else
                    {
                        System.out.println("O produto "+ produtoList.get(i).nome+ " não foi removido e está contido em ao menos um carrinho (usuario:" + userList.get(j).nome+ " )" );
                    }
                    return;
                }
        }
    }

    //@Adonys
    public void verificarEstoque()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------");
        System.out.println("Digite o nome do produto: "); //sugestão: utilizar o código do produto em vez do nome

        String Nome = scanner.nextLine();

        int i = getProdutoIndex(Nome);

        if(i == -1){
            System.out.println("Produto não listado no estoque");
        }else {
            Produto p1 = this.produtoList.get(i);
            if(p1.quantidade > 0){
                System.out.println("O produto " +Nome+ " (quantidade: "+ p1.quantidade +") está disponível no estoque!");
            }else{
                System.out.println("O produto " +Nome+ " não está disponível no estoque :(");
            }
        }
    }

    //@Reinaldo
    public void adicionarAoCarrinho(Usuario user, Produto produto, int quantidade)
    {
        if(produto.quantidade >= quantidade)
        {
            produto.quantidade -= quantidade;
            user.carrinho.add(produto);
            System.out.println(produto.nome+" adicionado ao carrinho");
        }
        else
        {
            System.out.println("Quantidade indisponivel");
        }
    }

    //@Reinaldo
    public void printarEstoque()
    {
        System.out.println("Nome | Quantidade | Codigo");
        for(int i=0; i<produtoList.size(); i++)
        {
            System.out.println(produtoList.get(i).nome + " | " + produtoList.get(i).quantidade + " | " + produtoList.get(i).codigo);   
        }
        System.out.println("-----------------");
    }

    //@Reinaldo
    //solicita input do usuario e chama adicionarAoCarrinho
    public void promptAdicionarAoCarrinho() {
        Scanner scanner = new Scanner(System.in);

        //primeiro verificamos a existencia do usuario

        System.out.println("-----------------");
        System.out.println("Digite o CPF do usuario: ");

        String cpf = scanner.nextLine();
        int u = getUserIndex(cpf);

        if (u == -1) {
            System.out.println("Usuario não cadastrado");
            return;
        }

        //agora verificamos a existencia do produto

        printarEstoque();

        System.out.println("Digite o nome do produto: ");
        String Nome = scanner.nextLine();
        int i = getProdutoIndex(Nome);
        if (i == -1) {
            System.out.println("Produto não listado no estoque");
        } else {

            Produto p1 = this.produtoList.get(i);
            if (produtoList.get(i).tipo.equalsIgnoreCase("livro")) {
                System.out.println("Você deseja alugar ou comprar?");
                Scanner scanner1 = new Scanner(System.in);
                String tipo = scanner1.nextLine();
                if (tipo.equalsIgnoreCase("alugar")) 
                {
                  this.userList.get(u).fidelidade++;
                }
            }
            System.out.println("Digite a quantidade que deseja adicionar: ");
            Scanner scanner2 = new Scanner(System.in);
            int quantidade = scanner2.nextInt();
            adicionarAoCarrinho(userList.get(u), p1, quantidade);//chama a função no usuário solicitad

        }
    }
}
