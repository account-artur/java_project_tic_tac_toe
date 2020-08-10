package tictactoe.player;

import tictactoe.TicTacToeSymbol;

import java.awt.*;

public class PlayerManagement {
    private int counter = 0;
    private Player player1;
    private Player player2;

    public PlayerManagement() {
        player1 = new HumanPlayer(TicTacToeSymbol.X);
        player2 = new HumanPlayer(TicTacToeSymbol.O);
    }

    public PlayerManagement(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        Player player = player1;
        if (counter == 1) {
            player = player2;
        }
        return player;
    }

    public void nextPlayer() {
        counter = ++counter % 2;
    }

    public Point nextPlayersTurn() {
        nextPlayer();
        return currentPlayersTurn();
    }

    public Point currentPlayersTurn() {
        return getCurrentPlayer().choosePosition();
    }

}
