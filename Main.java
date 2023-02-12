import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TODO
        // Produto P1 = new Produto();

        // P1.registroProduto();


        DB db = new DB();
        while(true)
        {

            System.out.println("----------------");
            System.out.println("1. Criar usuario");
            System.out.println("2. Deletar usuario");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Verificar produto no estoque");
            System.out.println("7. Adicionar ao carrinho");
            System.out.println(("8. Consultar os pontos de fidelidade"));
            System.out.println("99. Sair");
            System.out.println("----------------");
            
            Scanner leitor = new Scanner(System.in);
            String opcao = leitor.nextLine().toLowerCase();

            switch(opcao)
            {
                case "1":
                    db.criarUsuario();    
                break;

                case "2":
                    db.removerUsuario();

                break;

                case "3":
                    db.modificarUsuario();
                break;

                case "4":
                    db.cadastrarProduto();
                break;
            
                case "5":
                    //TODO: função remover produto
                    System.out.println(":P");
                break;

                case "6":
                    db.verificarEstoque();
                break;

                case "7":
                    db.promptAdicionarAoCarrinho();
                break;

                case "8":
                    db.ConsultaFidelidade();
                 break;    
                    
                case "99":
                    System.exit(0);
                break;
            }
        }
    }
}
