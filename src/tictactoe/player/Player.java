package tictactoe.player;

import tictactoe.TicTacToeSymbol;

import java.awt.*;

public abstract class Player {
    private final TicTacToeSymbol identifier;

    public Player(TicTacToeSymbol identifier) {
        this.identifier = identifier;
    }

    public abstract Point choosePosition();

    public TicTacToeSymbol getIdentifier() {
        return identifier;
    }
}
