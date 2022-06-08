package vsu.cs.server.utils.image_processing;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImageProcessing {
    BufferedImage getImage(String path) throws IOException;
    BufferedImage editImage(BufferedImage image, Float coefficient);
}
