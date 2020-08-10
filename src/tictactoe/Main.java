package tictactoe;

import java.util.Scanner;

public class Main {
    private static final int ROWS = 3;
    private static final int COLS = 3;

    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String f = new Scanner(System.in).next().toUpperCase();
        print(f);
        System.out.println(getState(f));
    }

    private static GameState getState(String f) {
        GameState state = playingOrError(f);
        if (state == GameState.ERROR) return state;
        char winner = getWinnerCols(f, '_');
        winner = getWinnerRows(f, winner);
        winner = getWinnerDiags(f, winner);
        if (winner == 0) return GameState.ERROR;
        if (winner == 'X') return GameState.X_WINS;
        if (winner == 'O') return GameState.O_WINS;
        return state;
    }

    private static GameState playingOrError(String f) {
        int x = 0;
        int o = 0;
        int empty = 0;
        for (char c : f.toCharArray()) {
            if (c == 'X') x++;
            if (c == 'O') o++;
            if (c == '_') empty++;
        }
        if (Math.abs(x - o) > 1) return GameState.ERROR;
        return empty > 0 ? GameState.PLAYING : GameState.FINISHED;
    }

    private static char getWinner(char o, char n) {
        if (o + n == 'O' + 'X' || o == 0) return 0;
        return (char) (o + n - '_');
    }

    private static char getWinnerDiags(String f, char w) {
        w = getWinner(w, getWinnerDiag(f, true));
        w = getWinner(w, getWinnerDiag(f, false));
        return w;
    }

    private static char getWinnerCols(String f, char w) {
        for (int i = 0; i < COLS && w != 0; i++)
            w = getWinner(w, getWinnerCol(f, i));
        return w;
    }

    private static char getWinnerRows(String f, char w) {
        for (int i = 0; i < ROWS && w != 0; i++)
            w = getWinner(w, getWinnerRow(f, i));
        return w;
    }

    private static char getWinnerDiag(String f, boolean left) {
        int a = left ? 0 : 2;
        char winner = f.charAt(a);
        for (int i = a; i < ROWS * COLS - a; i += COLS - (a - 1))
            if (winner != f.charAt(i)) return '_';
        return winner;
    }

    private static char getWinnerCol(String f, int col) {
        char winner = f.charAt(col);
        for (int i = col; i < ROWS * COLS; i += COLS)
            if (winner != f.charAt(i)) return '_';
        return winner;
    }

    private static char getWinnerRow(String f, int row) {
        char winner = f.charAt(row * COLS);
        for (int i = row * COLS; i < row * COLS + COLS; i++)
            if (winner != f.charAt(i)) return '_';
        return winner;
    }

    private static void print(String f) {
        // hardcoding a bit
        System.out.println("+-------+");
        System.out.printf("| %c %c %c |\n", f.charAt(0), f.charAt(1), f.charAt(2));
        System.out.printf("| %c %c %c |\n", f.charAt(3), f.charAt(4), f.charAt(5));
        System.out.printf("| %c %c %c |\n", f.charAt(6), f.charAt(7), f.charAt(8));
        System.out.println("+-------+");
    }

    enum GameState {
        PLAYING("Game not finished"),
        FINISHED("Draw"),
        X_WINS("X wins"),
        O_WINS("O wins"),
        ERROR("Impossible");
        private final String msg;

        GameState(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return msg;
        }
    }
}