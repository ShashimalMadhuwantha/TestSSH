package gui;

import game.ChessGame;
import game.GameStatus;
import game.ChessPiece;
import utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class ChessGUI {
    private JFrame frame;
    private JPanel boardPanel;
    private JPanel mainPanel;
    private ChessGame game;
    private JLabel statusLabel;

    public ChessGUI(ChessGame game) {
        this.game = game;

        // Initialize the main frame
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set a fixed window size
        frame.setSize(800, 850);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        // Create the chessboard panel with 8x8 grid layout
        boardPanel = new JPanel(new GridLayout(8, 8));
        boardPanel.setPreferredSize(new Dimension(800, 800)); // Board size
        initializeBoard();  // Initialize the chessboard

        // Add row and column labels
        JPanel rowLabels = createRowLabels();
        JPanel colLabels = createColLabels();

        // Add the chessboard and labels to the container
        JPanel boardContainer = new JPanel(new BorderLayout());
        boardContainer.setPreferredSize(new Dimension(800, 800));
        boardContainer.add(boardPanel, BorderLayout.CENTER);
        boardContainer.add(rowLabels, BorderLayout.WEST);
        boardContainer.add(colLabels, BorderLayout.NORTH);

        // Add the board container to the main panel
        mainPanel.add(boardContainer, BorderLayout.CENTER);

        // Add the status label at the bottom to display game status
        statusLabel = new JLabel("Game Status: " + game.getGameStatus(), SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        // Add main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void initializeBoard() {
        boolean isWhite = true;

        // Loop through rows and columns to create chessboard squares
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

                // Get the piece at this position and render it
                ChessPiece piece = game.getPieceAt(row, col);
                if (piece != null) {
                    Image img = ImageLoader.loadImage(piece.getImagePath());
                    square.setIcon(new ImageIcon(img));
                }

                boardPanel.add(square);
                isWhite = !isWhite; // Alternate square color
            }
            isWhite = !isWhite; // Alternate starting color for the next row
        }
    }

    private JPanel createRowLabels() {
        JPanel rowLabels = new JPanel();
        rowLabels.setLayout(new GridLayout(8, 1));

        for (int i = 8; i >= 1; i--) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(Color.WHITE);
            label.setBackground(Color.DARK_GRAY);
            label.setOpaque(true);
            rowLabels.add(label);
        }
        return rowLabels;
    }

    private JPanel createColLabels() {
        JPanel colLabels = new JPanel();
        colLabels.setLayout(new GridLayout(1, 8));

        char[] cols = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        for (char col : cols) {
            JLabel label = new JLabel(String.valueOf(col), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(Color.WHITE);
            label.setBackground(Color.DARK_GRAY);
            label.setOpaque(true);
            colLabels.add(label);
        }
        return colLabels;
    }

    public void updateGameStatus(GameStatus gameStatus) {
        statusLabel.setText("Game Status: " + gameStatus);
    }
}
