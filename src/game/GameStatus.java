package game;

public enum GameStatus {
    PLAYING,      // The game is ongoing
    CHECK,        // The current player is in check
    CHECKMATE,    // The current player is in checkmate
    STALEMATE,    // The game has ended in a stalemate (draw)
    DRAW          // The game has ended in a draw by agreement or other means
}
