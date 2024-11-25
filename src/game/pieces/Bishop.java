package game.pieces;

import game.ChessPiece;

public class Bishop extends ChessPiece {

    public Bishop(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        return rowDiff == colDiff;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♗" : "♝";  // White Bishop is ♗, black Bishop is ♝
    }

    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "/assets/images/whitebishop.png" : "/assets/images/whitebishop.png";
    }
}
