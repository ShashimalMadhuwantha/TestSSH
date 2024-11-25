package utils;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class ImageLoader {

    // Loads an image from the assets/images directory
    public static Image loadImage(String imagePath) {
        try {
            URL imageURL = ImageLoader.class.getResource(imagePath);
            if (imageURL != null) {
                return ImageIO.read(imageURL); // Return image as BufferedImage
            } else {
                System.err.println("Image not found: " + imagePath);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
