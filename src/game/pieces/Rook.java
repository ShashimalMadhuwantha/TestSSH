package game.pieces;

import game.ChessPiece;

/**
 * Represents the Rook chess piece.
 * The Rook can move any number of squares vertically or horizontally.
 */
public class Rook extends ChessPiece {

    /**
     * Constructor for the Rook piece.
     *
     * @param isWhite True if the Rook is white, false if black.
     * @param row     Initial row position.
     * @param col     Initial column position.
     */
    public Rook(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    /**
     * Checks if the move is valid for a Rook.
     * A Rook can move any number of squares vertically or horizontally.
     *
     * @param targetRow Target row position.
     * @param targetCol Target column position.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        // Check if the move is in a straight line (row or column must be the same)
        return (currentRow == targetRow || currentCol == targetCol);
    }
}
