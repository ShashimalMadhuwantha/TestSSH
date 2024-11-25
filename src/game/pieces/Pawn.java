package game.pieces;

import game.ChessPiece;

/**
 * Represents the Pawn chess piece.
 * The Pawn moves forward one square, but it can move two squares on its first move.
 * It captures diagonally.
 */
public class Pawn extends ChessPiece {

    public Pawn(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        int direction = isWhite() ? -1 : 1;  // Direction of pawn's movement

        if (targetCol == currentCol && targetRow == currentRow + direction) {
            return true;
        }

        if ((isWhite() && currentRow == 6 || !isWhite() && currentRow == 1) &&
                targetCol == currentCol && targetRow == currentRow + (2 * direction)) {
            return true;
        }

        if (Math.abs(targetCol - currentCol) == 1 && targetRow == currentRow + direction) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♙" : "♟";  // White pawn is ♙, black pawn is ♟
    }

    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "assets/images/whitepawn.png" : "assets/images/blackpawn.png";
    }
}
