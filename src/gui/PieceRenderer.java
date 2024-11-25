package gui;

import javax.swing.*;
import java.awt.*;
import game.ChessPiece;
import utils.ImageLoader;

public class PieceRenderer {
    public static void renderPiece(Graphics g, ChessPiece piece, int x, int y) {
        // Check if the piece is not null
        if (piece != null) {
            // Get the image path from the piece and load the image using ImageLoader
            String imagePath = piece.getImagePath();
            Image img = ImageLoader.loadImage(imagePath);  // Use ImageLoader to load the image
            g.drawImage(img, x, y, null);
        }
    }
}
