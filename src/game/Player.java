package game;

/**
 * Represents a player in the chess game.
 * Each player has a color (White or Black) and a turn status.
 */
public class Player {

    private boolean isWhite;  // True if the player is White, false if Black
    private boolean isTurn;   // True if it's this player's turn

    /**
     * Constructor for a Player.
     *
     * @param isWhite True if the player is White, false if Black.
     */
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
        this.isTurn = isWhite; // The White player always starts first
    }

    /**
     * Get the color of the player.
     *
     * @return True if the player is White, false if Black.
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Get whether it is this player's turn.
     *
     * @return True if it is this player's turn, false otherwise.
     */
    public boolean isTurn() {
        return isTurn;
    }

    /**
     * Set the turn status of the player.
     *
     * @param isTurn True if it's the player's turn, false otherwise.
     */
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    /**
     * Switch the turn status between two players.
     */
    public void switchTurn() {
        this.isTurn = !this.isTurn;
    }

    /**
     * Provides a string representation of the player's color.
     *
     * @return "White" or "Black" depending on the player's color.
     */
    @Override
    public String toString() {
        return isWhite ? "White" : "Black";
    }
}
