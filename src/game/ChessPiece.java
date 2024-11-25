package game;

/**
 * Abstract base class for all chess pieces.
 * Defines common properties and behavior for all pieces.
 */
public abstract class ChessPiece {
    // Piece color (true = white, false = black)
    private boolean isWhite;

    // Current position of the piece on the board
    private int currentRow;
    private int currentCol;

    /**
     * Constructor for ChessPiece.
     *
     * @param isWhite    True if the piece is white, false if black.
     * @param row        Initial row position.
     * @param col        Initial column position.
     */
    public ChessPiece(boolean isWhite, int row, int col) {
        this.isWhite = isWhite;
        this.currentRow = row;
        this.currentCol = col;
    }

    /**
     * Checks if the piece is white.
     *
     * @return True if the piece is white, false otherwise.
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Gets the current row position of the piece.
     *
     * @return The current row position.
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * Gets the current column position of the piece.
     *
     * @return The current column position.
     */
    public int getCurrentCol() {
        return currentCol;
    }

    /**
     * Sets the position of the piece on the board.
     *
     * @param row New row position.
     * @param col New column position.
     */
    public void setPosition(int row, int col) {
        this.currentRow = row;
        this.currentCol = col;
    }

    /**
     * Abstract method to be implemented by specific piece types.
     * Determines if a move is valid based on the rules for the piece.
     *
     * @param targetRow Target row position.
     * @param targetCol Target column position.
     * @return True if the move is valid, false otherwise.
     */
    public abstract boolean isValidMove(int targetRow, int targetCol);

    /**
     * Abstract method to be implemented by specific piece types.
     * Gets the symbol of the piece (e.g., "♙", "♘").
     *
     * @return The symbol of the piece.
     */
    public abstract String getSymbol();

    public String getImagePath() {
        // Default behavior can be overridden in subclasses like Queen, Rook, etc.
        String color = isWhite() ? "white" : "black";
        String className = this.getClass().getSimpleName().toLowerCase();
        return "/images/" + color + "_" + className + ".png"; // Assuming image naming follows a pattern
    }
}
