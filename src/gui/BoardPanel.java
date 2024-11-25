package gui;

import javax.swing.*;
import java.awt.*;
import game.ChessGame;

public class BoardPanel extends JPanel {
    private ChessGame game;

    public BoardPanel(ChessGame game) {
        this.game = game;
        setLayout(new GridLayout(8, 8)); // 8x8 grid for the chessboard
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.DARK_GRAY);
        initializeBoard();
    }

    private void initializeBoard() {
        boolean isWhite = true;

        // Loop through rows and columns to create the chessboard squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(100, 100));

                // Alternate colors for the squares
                if (isWhite) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.DARK_GRAY);
                }

                // Add the square to the board panel
                add(square);
                isWhite = !isWhite; // Alternate square color
            }
            isWhite = !isWhite; // Alternate starting color for the next row
        }
    }
}
