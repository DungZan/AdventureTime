package com.game.effect;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class SceneTransition {

    private Color color;
    private long startTime;
    private long transitionTime;
    private boolean isTransitioning;
    Font pixelF,pixelF2;

    public SceneTransition(Color color, long transitionTime) {
        this.color = color;
        this.transitionTime = transitionTime;
        this.isTransitioning = false;
        try {
            InputStream is = getClass().getResourceAsStream("/resources/font/StayPixelRegular-EaOxl.ttf");
            pixelF = Font.createFont(Font.TRUETYPE_FONT,is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pixelF = pixelF.deriveFont(Font.PLAIN,80);
        pixelF2 = pixelF.deriveFont(Font.PLAIN,60);
    }

    public void start() {
        this.startTime = System.nanoTime();
        this.isTransitioning = true;
    }

    public void update() {
        if(isTransitioning && (System.nanoTime() - startTime) / 1000000 > transitionTime) {
            isTransitioning = false;
        }
    }

    public void draw(Graphics2D g2) {
        if(isTransitioning) {
            double elapsed = (System.nanoTime() - startTime) / 1000000;
            double alpha = 1 - elapsed / transitionTime;
            g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (255 * alpha)));
            g2.fillRect(0, 0, GameFrame.SC_WIDTH, GameFrame.SC_HEIGHT);
            g2.setFont(pixelF2);

        }
    }

    public boolean isTransitioning() {
        return isTransitioning;
    }
}