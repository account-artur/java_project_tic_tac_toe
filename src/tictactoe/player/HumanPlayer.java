package tictactoe.player;

import tictactoe.TicTacToeSymbol;

import java.awt.*;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(TicTacToeSymbol identifyer) {
        super(identifyer);
    }

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Point choosePosition() {
        System.out.print("Enter the coordinates " + getIdentifier() + ": ");
        String[] s = scanner.nextLine().trim().split(" ");
        Point point = new Point(-1, -1);
        try {
            point = new Point(stringToPos(s[1]), Integer.valueOf(s[0]) - 1);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            point = choosePosition();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid input");
            point = choosePosition();
        }
        if (!validatePoint(point)) {
            System.out.println("Coordinates should be from 1 to 3!");
            point = choosePosition();
        }
        return point;
    }

    private int stringToPos(String pos) {
        return (2 - Integer.valueOf(pos) + 1);
    }

    private boolean validatePoint(Point point) {
        return validateRange((int) point.getX()) && validateRange((int) point.getY());
    }

    private boolean validateRange(int x) {
        return x < 3 && x >= 0;
    }
}
