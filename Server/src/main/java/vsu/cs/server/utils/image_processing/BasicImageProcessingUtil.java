package vsu.cs.server.utils.image_processing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasicImageProcessingUtil implements ImageProcessing {
    @Override
    public BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    @Override
    public BufferedImage editImage(BufferedImage image, Float coefficient) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.getHSBColor(coefficient, coefficient, coefficient));
        return image;
    }
}
