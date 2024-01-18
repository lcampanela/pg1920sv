import isel.leic.pg.Console;
//import java.util.Scanner;
// este import static polui o espaço de nomes, pode haver conflitos destes métodos
// com os métodos da própria classe
import static isel.leic.pg.Console.*;

public class TestConsole {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        System.out.println("Hello");

        // estes têm que ser antes da console ser executada
        //Console.scaleFactor(0.8,1.0);
        scaleFactor(1.0, 1.0);
        //Console.fontSize(40);
        fontSize(20);
        // código da consola corre noutra thread
        Console.open("Test Console", 30, 40);
        Console.cursor(4, 10);
        Console.print("Hello");
        Console.setForeground(Console.CYAN);
        Console.print("CYAN");
        Console.cursor(8, 20);
        Console.setBackground(Console.YELLOW);
        Console.print("YELLOW");

        Console.color(Console.GREEN, Console.BLACK);
        int key = Console.waitKeyPressed(3000);
        if (key>=0) {
            Console.waitKeyReleased(key);
            Console.cursor(29, 0); Console.print(key);
        }
            
        String line = Console.nextLine(20);
        Console.cursor(0, 0);
        Console.print(line);
        //System.out.println(in.nextLine());
        // fazer breakpoint mas definir para Suspend thread - Make default (não suspend All)
        Console.close();
    }
}
