import isel.leic.pg.Console;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Stars {
    public static final int LINES=30, COLS=40;
    public static final int STAR_TIME=1;
    public static int numStars=0;
    // o array
    // private static int[] stars = new int[LINES*COLS];
    // fica iniciado com valores false mas assim não fica:
    // private static Boolean[] stars = new Boolean[LINES*COLS];      // inicia com nulls
    private static int[] lineStars = new int[LINES];
    private static int[] colStars = new int[COLS];

    public static void main(String[] args) {
        int key,count;
        // abrir console
        Console.open("STARS", LINES, COLS);
        do {
            int l = (int) (Math.random() * LINES);
            int c = (int) (Math.random() * COLS);
            int color = (int) ((Math.random()+1) * Console.MAX_COLORS-1);
            if (lineStars[l]==0 && colStars[c]==0) {
                Console.cursor(l, c);
                Console.setForeground(color);
                Console.print('*');

                lineStars[l] = 1;
                colStars[c] = 1;
                ++numStars;
                System.out.println(numStars);
            }
            /*
            if (stars[l * COLS + c]==0) stars[l * COLS + c] = color;   // 1125 Max 1200
            count=0;
            for (int i = 0; i < stars.length; ++i)
                if (stars[i]!=0) ++count;
             */

            key = Console.waitKeyPressed(STAR_TIME);
        } while ( numStars < LINES*COLS && key != KeyEvent.VK_ESCAPE );

        // fechar console
        Console.close();
    }
}