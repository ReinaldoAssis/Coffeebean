import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        DB db = new DB();

        //DEFAULTS
        Usuario rei = new Usuario();
        rei.setNome("Rei");
        rei.setCpf("117");
        rei.setEmail("teste@teste.com");
        rei.setNumero("99");
        rei.fidelidade = 0;
        rei.setStatus(true);

        Produto livro = new Produto();
        livro.nome = "Harry Potter";
        livro.codigo = "1";
        livro.tipo = "livro";
        livro.quantidade = 10;
        livro.valorDeCompra = 10;
        livro.valorDeVenda = 300;
        db.compra += 100;

        db.userList.add(rei);
        db.produtoList.add(livro);


        while(true)
        {
            Utils.clearScreen();

            System.out.println("----------------");
            System.out.println("1. Criar usuario");
            System.out.println("2. Deletar usuario");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Verificar produto no estoque");
            System.out.println("7. Carrinho");
            System.out.println("8. Aluguel de livro");
            System.out.println("9. Fluxo de caixa");
            System.out.println("10. Consultar pontos de fidelidade");
            System.out.println("11. Sair");
            System.out.println("----------------");
            
            Scanner leitor = new Scanner(System.in);
            String opcao = leitor.nextLine().toLowerCase();

            switch(opcao)
            {
                case "1":
                    Utils.clearScreen();
                    db.criarUsuario();    
                break;

                case "2":
                    Utils.clearScreen();
                    db.removerUsuario();
                break;

                case "3":
                    Utils.clearScreen();
                    db.modificarUsuario();
                break;

                case "4":
                    Utils.clearScreen();
                    db.cadastrarProduto();
                break;
            
                case "5":
                    Utils.clearScreen();
                    db.removerProduto();
                break;

                case "6":
                    Utils.clearScreen();
                    db.verificarEstoque();
                break;

                case "7":
                    Utils.clearScreen();
                    db.menuCarrinho();
                break;

                case "8":
                    Utils.clearScreen();
                    db.promptAlugarLivro();
                 break;  
                 
                 case "9":
                    Utils.clearScreen();
                    db.fluxoDeCaixa();
                 break;

                 case "10":
                    Utils.clearScreen();
                    db.ConsultaFidelidade();
                 break;
                    
                case "11":
                    Utils.clearScreen();
                    System.exit(0);
                break;
            }
        }
    }

}
