package game;

import gui.ChessGUI;
import game.pieces.*;

public class ChessGame {
    private GameStatus gameStatus;
    private ChessGUI gui;
    private ChessPiece[][] board;

    public ChessGame(ChessGUI gui) {
        this.gameStatus = GameStatus.PLAYING;
        this.gui = gui;
        initializeBoard(); // Initialize the board with pieces
    }

    private void initializeBoard() {
        board = new ChessPiece[8][8];

        // Set up the back rank for both sides (Rooks, Knights, Bishops, Queen, King, and Pawns)
        board[0][0] = new Rook(false, 0, 0);
        board[0][1] = new Knight(false, 0, 1);
        board[0][2] = new Bishop(false, 0, 2);
        board[0][3] = new Queen(false, 0, 3);
        board[0][4] = new King(false, 0, 4);
        board[0][5] = new Bishop(false, 0, 5);
        board[0][6] = new Knight(false, 0, 6);
        board[0][7] = new Rook(false, 0, 7);

        // Place the black pawns on the second rank
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false, 1, i);
        }

        // Set up the white pieces similarly on the 7th and 8th ranks
        board[7][0] = new Rook(true, 7, 0);
        board[7][1] = new Knight(true, 7, 1);
        board[7][2] = new Bishop(true, 7, 2);
        board[7][3] = new Queen(true, 7, 3);
        board[7][4] = new King(true, 7, 4);
        board[7][5] = new Bishop(true, 7, 5);
        board[7][6] = new Knight(true, 7, 6);
        board[7][7] = new Rook(true, 7, 7);

        // Place the white pawns on the 6th rank
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(true, 6, i);
        }
    }

    public ChessPiece getPieceAt(int row, int col) {
        return board[row][col];
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        updateGameStatusInGUI(gameStatus);
    }

    private void updateGameStatusInGUI(GameStatus gameStatus) {
        if (gui != null) {
            gui.updateGameStatus(gameStatus);
        }
    }

    public void checkForCheck() {
        if (isKingInCheck()) {
            setGameStatus(GameStatus.CHECK);
        }
    }

    public void checkForCheckmate() {
        if (isKingInCheckmate()) {
            setGameStatus(GameStatus.CHECKMATE);
        }
    }

    public void checkForStalemate() {
        if (isStalemate()) {
            setGameStatus(GameStatus.STALEMATE);
        }
    }

    public void declareDraw() {
        setGameStatus(GameStatus.DRAW);
    }

    private boolean isKingInCheck() {
        return false; // Placeholder
    }

    private boolean isKingInCheckmate() {
        return false; // Placeholder
    }

    private boolean isStalemate() {
        return false; // Placeholder
    }


}
