import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        DB db = new DB();
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
            System.out.println("7. Adicionar ao carrinho");
            System.out.println("8. Consultar os pontos de fidelidade");
            System.out.println("99. Sair");
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
                    db.promptAdicionarAoCarrinho();
                break;

                case "8":
                    Utils.clearScreen();
                    db.ConsultaFidelidade();
                 break;    
                    
                case "99":
                    Utils.clearScreen();
                    System.exit(0);
                break;
            }
        }
    }
}
