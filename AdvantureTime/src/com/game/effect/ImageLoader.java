package com.game.effect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    private BufferedImage image;

    public BufferedImage load(String path) throws IOException {

        image = ImageIO.read(getClass().getResource(path));
        int w = image.getWidth(null);
        int h = image.getHeight(null);

        BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB); // ARGB để hỗ trợ ảnh trong suốt
        Graphics g = bufImg.getGraphics();
        g.drawImage(image, 0, 0, null);

        return bufImg;
    }
}
