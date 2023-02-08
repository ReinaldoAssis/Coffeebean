import java.util.List;
import java.util.ArrayList;
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
                    System.out.println(":P");
                break;

                case "99":
                    System.exit(0);
                break;
            }

        }




    }
}