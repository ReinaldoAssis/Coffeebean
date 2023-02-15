import java.util.Scanner;

public class Utils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void awaitInput() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("");
        System.out.println("Pressione ENTER para continuar...");
        leitor.nextLine();
    }

}
