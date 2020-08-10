package tictactoe;

public class Board {
    private TicTacToeSymbol[][] field;
    private Integer xSize;
    private Integer ySize;

    public Board() {
        field = new TicTacToeSymbol[3][3];
        xSize = 3;
        ySize = 3;
        fillBoard();
    }

    public boolean isPositionEmpty(int xPos, int yPos) {
        return field[xPos][yPos] == null || field[xPos][yPos] == TicTacToeSymbol.U;
    }

    public void placeValue(int xPos, int yPos, TicTacToeSymbol ticTacToeSymbol) throws AlreadyPlacedException {
        if (isPositionEmpty(xPos, yPos)) {
            field[xPos][yPos] = ticTacToeSymbol;
        } else {
            throw new AlreadyPlacedException("Position (" + xPos + "," + yPos + ") is not empty");
        }
    }


    private void fillBoard() throws AlreadyPlacedException {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                placeValue(x, y, TicTacToeSymbol.valueOf("U"));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("---------\n");
        for (TicTacToeSymbol[] ticTacToeSymbols : field) {
            s.append("| ");
            for (TicTacToeSymbol ticTacToeSymbol : ticTacToeSymbols) {
                s.append(ticTacToeSymbol.label + " ");
            }
            s.append("|\n");
        }
        s.append("---------\n");
        return s.toString().trim();
    }

    public boolean hasFreeCells() {
        for (TicTacToeSymbol[] ticTacToeSymbols : field) {
            for (TicTacToeSymbol ticTacToeSymbol : ticTacToeSymbols) {
                if (ticTacToeSymbol == null || ticTacToeSymbol == TicTacToeSymbol.U) return true;
            }
        }
        return false;
    }

    public TicTacToeSymbol[][] getField() {
        return field;
    }

    public void setField(TicTacToeSymbol[][] field) {
        this.field = field;
    }

    public Integer getxSize() {
        return xSize;
    }

    public Integer getySize() {
        return ySize;
    }
}
