package tictactoe;

class AlreadyPlacedException extends RuntimeException {
    AlreadyPlacedException(String message) {
        super(message);
    }
}
