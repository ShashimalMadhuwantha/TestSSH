package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import game.ChessGame;

public class MenuPanel extends JPanel {
    private ChessGame game;

    public MenuPanel(ChessGame game) {
        this.game = game;
        setLayout(new FlowLayout());
        setBackground(Color.DARK_GRAY);

        // Create buttons for restart and quit options
        JButton restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.PLAIN, 16));
        restartButton.setBackground(Color.GREEN);
        restartButton.setForeground(Color.WHITE);

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);

        // Add buttons to panel
        add(restartButton);
        add(quitButton);
    }

    public void setRestartListener(ActionListener listener) {
        // Add action listener to the restart button
    }

    public void setQuitListener(ActionListener listener) {
        // Add action listener to the quit button
    }
}
