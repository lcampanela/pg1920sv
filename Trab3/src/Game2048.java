import isel.leic.pg.Console;

import java.awt.event.KeyEvent;

public class Game2048 {
    static final int LINES = 4, COLS = 4;
    static final int MIN_VALUE = 2, MAX_VALUE = 2048;

    private static TopScores top = new TopScores();

    private static int moves = 0;
    private static boolean exit = false;
    private static int key;

    private static int l = LINES / 2, c = COLS / 2;
    private static int value = 16;

    public static void main(String[] args) {
        Panel.open();
        init();
        for (; ; ) {
            key = Console.waitKeyPressed(0);
            if (!processKey(key)) break;
            while (Console.isKeyPressed(key)) ;
        }
        Panel.close();
        top.saveToFile();
    }

    private static void init() {
        Panel.showMessage("Use cursor keys to play");
        Panel.showTile(l,c,value);
        Panel.updateMoves(moves);
        Panel.updateScore(0);
        Panel.updateBestRow(1,"----------",0);
    }

    private static boolean processKey(int key) {
        switch (key) {
            case KeyEvent.VK_UP:    move(-1, 0);    break;
            case KeyEvent.VK_DOWN:  move(+1, 0);    break;
            case KeyEvent.VK_LEFT:  move(0, -1);    break;
            case KeyEvent.VK_RIGHT: move(0, +1);    break;
            case KeyEvent.VK_ESCAPE:
            case 'Q':               quitGame();     break;
            case KeyEvent.VK_PLUS:
            case KeyEvent.VK_ADD:
                if (value < MAX_VALUE) value *= 2;
                Panel.showTile(l, c, value);
                break;
            case KeyEvent.VK_MINUS:
            case KeyEvent.VK_SUBTRACT:
                if (value > MIN_VALUE) value /= 2;
                Panel.showTile(l, c, value);
                break;
        }
        return !exit;
    }

    private static void quitGame() {
        int resp = Panel.questionChar("Exit game (Y/N)");
        if (resp == 'Y')
            exit = true;
        key = 0;
    }

    private static void move(int dLin, int dCol) {
        int lin = l + dLin;
        if (lin < 0 || lin >= LINES) lin = l;
        int col = c + dCol;
        if (col < 0 || col >= COLS) col = c;
        if (lin != l || col != c) {
            Panel.hideTile(l, c);
            Panel.showTile(l = lin, c = col, value);
            Panel.updateMoves(++moves);
        }
    }
}
