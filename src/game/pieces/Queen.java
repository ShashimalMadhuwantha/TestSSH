package game.pieces;

import game.ChessPiece;

public class Queen extends ChessPiece {

    public Queen(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        boolean isStraightLine = (currentRow == targetRow || currentCol == targetCol);
        boolean isDiagonal = (rowDiff == colDiff);

        return isStraightLine || isDiagonal;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♕" : "♛";  // White Queen is ♕, black Queen is ♛
    }

    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "assets/images/whitequeen.png" : "assets/images/blackqueen.png";
    }
}
