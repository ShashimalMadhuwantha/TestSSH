package game.pieces;

import game.ChessPiece;

public class Rook extends ChessPiece {

    public Rook(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        return (currentRow == targetRow || currentCol == targetCol);
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♖" : "♜";  // White Rook is ♖, black Rook is ♜
    }
    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "assets/images/whitebishop.png" : "assets/images/blackbishop.png";
    }
}
