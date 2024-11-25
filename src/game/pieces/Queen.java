package game.pieces;

import game.ChessPiece;

/**
 * Represents the Queen chess piece.
 * The Queen can move any number of squares in a straight line (vertically, horizontally, or diagonally).
 */
public class Queen extends ChessPiece {

    /**
     * Constructor for the Queen piece.
     *
     * @param isWhite True if the Queen is white, false if black.
     * @param row     Initial row position.
     * @param col     Initial column position.
     */
    public Queen(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    /**
     * Checks if the move is valid for a Queen.
     * A Queen can move any number of squares vertically, horizontally, or diagonally.
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

        // Check if the move is in a straight line or diagonal
        boolean isStraightLine = (currentRow == targetRow || currentCol == targetCol);
        boolean isDiagonal = (rowDiff == colDiff);

        return isStraightLine || isDiagonal;
    }
}
