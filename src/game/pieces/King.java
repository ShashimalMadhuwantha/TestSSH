package game.pieces;

import game.ChessPiece;

/**
 * Represents the King chess piece.
 * The King can move one square in any direction.
 */
public class King extends ChessPiece {

    /**
     * Constructor for the King piece.
     *
     * @param isWhite True if the King is white, false if black.
     * @param row     Initial row position.
     * @param col     Initial column position.
     */
    public King(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    /**
     * Checks if the move is valid for a King.
     * A King can move one square in any direction.
     *
     * @param targetRow Target row position.
     * @param targetCol Target column position.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        // Calculate the difference between the current and target positions
        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        // A King can move one square in any direction
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
