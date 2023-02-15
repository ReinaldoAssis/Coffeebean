import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Dictionary;


public class DB {
    List<Usuario> userList;
    List<Produto> produtoList;

    //Dictionary<Usuario, List<Produto>> vendas;
    double venda = 0;
    double compra = 0;

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

    public int getProdutoIndexUser(String nome, Usuario user)
    {
        for(int i=0; i<user.carrinho.size(); i++)
        {
            if(user.carrinho.get(i).nome.equalsIgnoreCase(nome))
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
        Utils.clearScreen();

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
        Utils.clearScreen();
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

        Utils.awaitInput();
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

        Utils.awaitInput();

    }

    //@Adonys
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

        compra += valorC * Quantidade;

        System.out.println(Nome+" cadastrado com sucesso :P");

        Utils.awaitInput();

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

        Utils.awaitInput();
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

        Utils.awaitInput();
    }

    //@Reinaldo
    public void adicionarAoCarrinho(Usuario user, Produto produto, int quantidade)
    {
        if(produto.quantidade >= quantidade)
        {
            produto.quantidade -= quantidade;

            int j = getProdutoIndexUser(produto.nome, user);
            if (j == -1)
            {
                Produto novo = new Produto();
                novo.quantidade = quantidade;
                novo.nome = produto.nome;
                novo.codigo = produto.codigo;
                novo.tipo = produto.tipo;
                novo.valorDeCompra = produto.valorDeCompra;
                novo.valorDeVenda = produto.valorDeVenda;

                user.carrinho.add(novo);
            }else{
                Produto p2 = user.carrinho.get(j);
                p2.quantidade += quantidade;
            }
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
    public void fluxoDeCaixa()
    {
        System.out.println("Fluxo de caixa: " + venda+" - "+compra+" = "+(venda-compra));
        Utils.awaitInput();
    }

    //@Reinaldo
    public void menuCarrinho()
    {
        Scanner scanner = new Scanner(System.in);
        Utils.clearScreen();

        System.out.println("Digite o CPF do usuario: ");
        
        String cpf = scanner.nextLine();
        int u = getUserIndex(cpf);
        
        if (u == -1) {
            System.out.println("Usuario não cadastrado");
            return;
        }
        
        Usuario user = userList.get(u);
        
        while(true)
        {


            Utils.clearScreen();

            System.out.println("-----------------");
            System.out.println("Carrinho de " + user.nome);
            System.out.println();
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Visualizar carrinho");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Voltar ao menu");
            System.out.println("-----------------");

            int opcao = scanner.nextInt();

            switch(opcao)
            {
                case 1:
                    promptAdicionarAoCarrinho(user);
                    break;
                case 2:
                    promptRemoverDoCarrinho(user);
                    break;
                case 3:
                    printarCarrinho(user);
                    break;
                case 4:
                    finalizarCompra(user);
                    break;

                case 5:
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }


    }

    //@Reinaldo
    public void promptAlugarLivro()
    {
        Scanner scanner = new Scanner(System.in);
        Utils.clearScreen();

        System.out.println("Digite o CPF do usuario: ");
        
        String cpf = scanner.nextLine();
        int u = getUserIndex(cpf);
        
        if (u == -1) {
            System.out.println("Usuario não cadastrado");
            return;
        }
        
        Usuario user = userList.get(u);
        
        System.out.println("Digite o nome do livro: ");
        String nome = scanner.nextLine();
        
        int i = getProdutoIndex(nome);
        if(i == -1) System.out.println("O Produto não existe");
        else {
            Produto p = produtoList.get(i);
            if(p.tipo.equalsIgnoreCase("livro"))
            {
                user.alugados.add(p);
            }
            System.out.println("Livro alugado por "+ user.nome+", valor: "+ p.valorDeVenda*0.3);
            venda += p.valorDeVenda*0.3;
        }

        user.fidelidade += 1;
        
        Utils.awaitInput();
    }

    //@Reinaldo
    public void finalizarCompra(Usuario user)
    {
        double total = 0;
        for(int i=0; i<user.carrinho.size(); i++)
        {
            total += user.carrinho.get(i).valorDeVenda*user.carrinho.get(i).quantidade;
        }
        System.out.println("Compra finalizada, total: " + total);
        
        venda += total;

        user.carrinho.clear();

        Utils.awaitInput();
    }

    //@Reinaldo
    public void printarCarrinho(Usuario user)
    {
        System.out.println("Nome | Quantidade | Codigo");
        for(int i=0; i<user.carrinho.size(); i++)
        {
            System.out.println(user.carrinho.get(i).nome + " | " + user.carrinho.get(i).quantidade + " | " + user.carrinho.get(i).codigo);   
        }
        System.out.println("-----------------");

        Utils.awaitInput();
    }

    //@Reinaldo & @Adonys
    //solicita input do usuario e chama adicionarAoCarrinho
    public void promptAdicionarAoCarrinho(Usuario user) {
        Scanner scanner = new Scanner(System.in);
        //verificamos a existencia do produto

        printarEstoque();

        System.out.println("Digite o nome do produto: ");
        String Nome = scanner.nextLine();
        int i = getProdutoIndex(Nome);
        if (i == -1) {
            System.out.println("Produto não listado no estoque");
        } else {

            Produto p1 = this.produtoList.get(i);
            System.out.println("Digite a quantidade que deseja adicionar: ");
            Scanner scanner2 = new Scanner(System.in);
            int quantidade = scanner2.nextInt();
            adicionarAoCarrinho(user, p1, quantidade);//chama a função no usuário solicitad

        }

        Utils.awaitInput();
    }

    //@Reinaldo & @Adonys
    public void promptRemoverDoCarrinho(Usuario user) {
        Scanner scanner = new Scanner(System.in);
        //verificamos a existencia do produto

        printarCarrinho(user);

        System.out.println("Digite o nome do produto: ");
        String Nome = scanner.nextLine();
        int i = getProdutoIndex(Nome);
        int j = getProdutoIndexUser(Nome, user);

        if (j == -1) {
            System.out.println("Produto não listado no carrinho do usuário");
        } else {
            //aqui temos que fazer um teste extra, verificar se o produto está no carrinho do usuário
            Produto p1 = this.produtoList.get(i);
            Produto p2 = user.carrinho.get(j);

                System.out.println("Digite a quantidade que deseja remover: ");
                Scanner scanner2 = new Scanner(System.in);
                int quantidade = scanner2.nextInt();
                //verifica se a quantidade a ser removida é maior que a quantidade do produto no carrinho
                if(p2.quantidade <= quantidade){
                    int quantidadeTemp = p2.quantidade;
                    user.carrinho.remove(p2);
                    p1.quantidade += quantidadeTemp;
                    System.out.println(p1.nome+" removido do carrinho");
                }
                else
                {
                    int q = p2.quantidade;
                    p2.setQuantidade(q - quantidade);
                    p1.quantidade += quantidade;
                    System.out.println(quantidade+" "+p1.nome+" removido do carrinho");
                }


        }

        Utils.awaitInput();
    }
}
