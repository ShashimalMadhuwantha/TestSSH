package game;

import game.pieces.*;

public class MoveValidator {

    /**
     * Validates the move for a given chess piece.
     *
     * @param piece       The chess piece being moved.
     * @param targetRow   The target row of the move.
     * @param targetCol   The target column of the move.
     * @param board       The chess board (2D array of chess pieces).
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValidMove(ChessPiece piece, int targetRow, int targetCol, ChessPiece[][] board) {
        // Check if the target position is within bounds
        if (targetRow < 0 || targetRow >= 8 || targetCol < 0 || targetCol >= 8) {
            return false;
        }

        // Ensure that the piece is moving to an empty space or capturing an opponent's piece
        ChessPiece targetPiece = board[targetRow][targetCol];
        if (targetPiece != null && targetPiece.isWhite() == piece.isWhite()) {
            return false; // Cannot capture own pieces
        }

        // Validate move based on piece type
        if (piece instanceof King) {
            return isValidKingMove((King) piece, targetRow, targetCol, board);
        } else if (piece instanceof Queen) {
            return isValidQueenMove((Queen) piece, targetRow, targetCol, board);
        } else if (piece instanceof Rook) {
            return isValidRookMove((Rook) piece, targetRow, targetCol, board);
        } else if (piece instanceof Bishop) {
            return isValidBishopMove((Bishop) piece, targetRow, targetCol, board);
        } else if (piece instanceof Knight) {
            return isValidKnightMove((Knight) piece, targetRow, targetCol);
        } else if (piece instanceof Pawn) {
            return isValidPawnMove((Pawn) piece, targetRow, targetCol, board);
        }

        return false;
    }

    // King's move is one square in any direction
    private boolean isValidKingMove(King king, int targetRow, int targetCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(king.getCurrentRow() - targetRow);
        int colDiff = Math.abs(king.getCurrentCol() - targetCol);
        return rowDiff <= 1 && colDiff <= 1;
    }

    // Queen combines the move capabilities of the Rook and Bishop
    private boolean isValidQueenMove(Queen queen, int targetRow, int targetCol, ChessPiece[][] board) {
        // Queen can move like a Rook
        if (isValidRookMove(queen, targetRow, targetCol, board)) {
            return true;
        }
        // Queen can move like a Bishop
        return isValidBishopMove(queen, targetRow, targetCol, board);
    }

    // Queen can move like a Rook
    private boolean isValidRookMove(ChessPiece piece, int targetRow, int targetCol, ChessPiece[][] board) {
        int currentRow = piece.getCurrentRow();
        int currentCol = piece.getCurrentCol();

        // Check if the move is either in the same row or same column
        if (currentRow == targetRow) {
            return isPathClear(currentRow, currentCol, targetCol, true, board); // Horizontal move
        } else if (currentCol == targetCol) {
            return isPathClear(currentRow, currentCol, targetRow, false, board); // Vertical move
        }
        return false;
    }

    // Queen can move like a Bishop
    private boolean isValidBishopMove(ChessPiece piece, int targetRow, int targetCol, ChessPiece[][] board) {
        int rowDiff = Math.abs(piece.getCurrentRow() - targetRow);
        int colDiff = Math.abs(piece.getCurrentCol() - targetCol);

        // Diagonal move validation
        if (rowDiff == colDiff) {
            int rowDirection = targetRow > piece.getCurrentRow() ? 1 : -1;
            int colDirection = targetCol > piece.getCurrentCol() ? 1 : -1;

            // Check if the path is clear
            return isPathClear(piece.getCurrentRow(), piece.getCurrentCol(), targetRow, targetCol, rowDirection, colDirection, board);
        }
        return false;
    }


    // Knight moves in "L" shapes
    private boolean isValidKnightMove(Knight knight, int targetRow, int targetCol) {
        int rowDiff = Math.abs(knight.getCurrentRow() - targetRow);
        int colDiff = Math.abs(knight.getCurrentCol() - targetCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    // Pawn move validation (including promotion and capturing)
    private boolean isValidPawnMove(Pawn pawn, int targetRow, int targetCol, ChessPiece[][] board) {
        int currentRow = pawn.getCurrentRow();
        int currentCol = pawn.getCurrentCol();
        int direction = pawn.isWhite() ? 1 : -1;

        // Simple move forward
        if (targetCol == currentCol && targetRow == currentRow + direction) {
            return board[targetRow][targetCol] == null; // The target square must be empty
        }

        // Capture move
        if (Math.abs(targetCol - currentCol) == 1 && targetRow == currentRow + direction) {
            ChessPiece targetPiece = board[targetRow][targetCol];
            return targetPiece != null && targetPiece.isWhite() != pawn.isWhite(); // Capture opponent's piece
        }

        return false;
    }

    // Utility method to check if the path is clear (for Rook and Queen horizontal/vertical moves)
    private boolean isPathClear(int startRow, int startCol, int endCol, boolean isHorizontal, ChessPiece[][] board) {
        if (isHorizontal) {
            for (int col = Math.min(startCol, endCol) + 1; col < Math.max(startCol, endCol); col++) {
                if (board[startRow][col] != null) {
                    return false;
                }
            }
        } else {
            for (int row = Math.min(startRow, endCol) + 1; row < Math.max(startRow, endCol); row++) {
                if (board[row][startCol] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    // Utility method to check if the diagonal path is clear (for Bishop and Queen diagonal moves)
    private boolean isPathClear(int startRow, int startCol, int endRow, int endCol, int rowDirection, int colDirection, ChessPiece[][] board) {
        int row = startRow + rowDirection;
        int col = startCol + colDirection;

        while (row != endRow && col != endCol) {
            if (board[row][col] != null) {
                return false;
            }
            row += rowDirection;
            col += colDirection;
        }

        return true;
    }
}
