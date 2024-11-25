package gui;

import javax.swing.*;
import java.awt.*;

public class ChessGUI {
    private JFrame frame; // Main window frame
    private JPanel boardPanel; // Panel for the chessboard
    private JPanel mainPanel; // Panel for the board and labels

    public ChessGUI() {
        // Initialize the main frame
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set fullscreen mode
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);


        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        // Create the board container (fixed size)
        JPanel boardContainer = new JPanel(new BorderLayout());
        boardContainer.setPreferredSize(new Dimension(850, 850)); // Include space for labels
        boardContainer.setBackground(Color.DARK_GRAY);

        // Create the chessboard panel
        boardPanel = new JPanel(new GridLayout(8, 8));
        boardPanel.setPreferredSize(new Dimension(800, 800)); // Fixed board size
        initializeBoard();

        // Add row and column labels
        JPanel rowLabels = createRowLabels();
        JPanel colLabels = createColLabels();

        // Add labels and board to the container
        boardContainer.add(boardPanel, BorderLayout.CENTER);
        boardContainer.add(rowLabels, BorderLayout.WEST);
        boardContainer.add(colLabels, BorderLayout.NORTH);

        // Add the board container to the main panel
        mainPanel.add(boardContainer);

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

                // Alternate colors for squares
                if (isWhite) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.GRAY);
                }

                boardPanel.add(square);
                isWhite = !isWhite; // Switch color
            }
            isWhite = !isWhite; // Switch starting color for next row
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGUI::new);
    }
}
