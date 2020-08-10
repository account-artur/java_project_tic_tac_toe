package tictactoe;

public enum TicTacToeSymbol {
    X('X'), O('O'), U(' ');
    public final char label;

    private TicTacToeSymbol(char label) {
        this.label = label;
    }
}
