package game.pieces;

import game.ChessPiece;

public class Knight extends ChessPiece {

    public Knight(boolean isWhite, int row, int col) {
        super(isWhite, row, col);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        int currentRow = getCurrentRow();
        int currentCol = getCurrentCol();

        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "♘" : "♞";  // White Knight is ♘, black Knight is ♞
    }

    @Override
    public String getImagePath() {
        // Override this method to return the image path for the Queen piece
        return isWhite() ? "assets/images/whiteknight.png" : "assets/images/blackknight.png";
    }
}
