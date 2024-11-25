package game.pieces;

import game.ChessPiece;

/**
 * Represents the Bishop chess piece.
 * The Bishop can move any number of squares diagonally.
 */
public class Bishop extends ChessPiece {

    /**
     * Constructor for the Bishop piece.
     *
     * @param isWhite True if the Bishop is white, false if black.
     * @param row     Initial row position.
     * @param col     Initial column position.
     */
    public Bishop(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    /**
     * Checks if the move is valid for a Bishop.
     * A Bishop can move any number of squares diagonally.
     *
     * @param targetRow Target row position.
     * @param targetCol Target column position.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        // Calculate the differences between the current and target positions
        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        // A Bishop moves diagonally, so the row and column differences must be equal
        return rowDiff == colDiff;
    }
}
