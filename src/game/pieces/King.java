package game.pieces;

import game.ChessPiece;

public class King extends ChessPiece {

    public King(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        return (rowDiff <= 1 && colDiff <= 1);
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♔" : "♚";  // White King is ♔, black King is ♚
    }

    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "assets/images/whiteking.png" : "assets/images/blackking.png";
    }
}
