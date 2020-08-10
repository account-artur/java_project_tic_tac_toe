package tictactoe;

public enum GameState {
    X_WIN("X wins"), O_WIN("O wins"), DRAW("Draw"), IMPOSSIBLE("Impossible"), UNFINISHED("Game not finished");
    public final String label;

    private GameState(String label) {
        this.label = label;
    }
}
