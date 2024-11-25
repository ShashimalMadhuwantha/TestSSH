

import game.ChessGame;
import gui.ChessGUI;

public class Main {
    public static void main(String[] args) {
        // Create a ChessGame object
        ChessGame game = new ChessGame(null);

        // Create the ChessGUI object, passing in the game object
        ChessGUI gui = new ChessGUI(game);

        // Link the ChessGame object with the GUI
        game = new ChessGame(gui);  // Update game with the GUI reference
    }
}
