package com.game.effect;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageManager1 {

    private ImageLoader loader;
    private final String spritePath = "/resources/sprites/";

    public static BufferedImage SPR_avatar;
    public static BufferedImage SPR_title_congra;

    public static BufferedImage SPR_sound_on;
    public static BufferedImage SPR_sound_off;
    public static BufferedImage[] SPR_background;

    public static BufferedImage[] playerUp, playerDown;
    public static BufferedImage[] playerLeft, playerRight;
    public static BufferedImage[] player;

    public static BufferedImage[] SPR_wall;
    public static BufferedImage[] SPR_fire_lamp;
    public static BufferedImage[] SPR_flag;
    public static BufferedImage SPR_stairs;
    public static BufferedImage SPR_stairsUp;
    public static BufferedImage SPR_key;
    public static BufferedImage SPR_key_door;
    public static BufferedImage SPR_switch_door;
    public static BufferedImage SPR_switch;
    public static BufferedImage SPR_bolt;
    public static BufferedImage[] SPR_cf;
    public static BufferedImage SPR_chest;

    public ImageManager1() {
        loader = new ImageLoader();
        loadAllSprite();
    }

    private void loadAllSprite() {
        SPR_avatar = loadSprite("avatar");

        SPR_title_congra = loadSprite("Congratulations");

        SPR_sound_on = loadSprite("SoundOn");
        SPR_sound_off = loadSprite("SoundOff");

        SPR_background = loadSprite("background", 2);

        SPR_wall = loadSprite("wall", 8);
        SPR_fire_lamp = loadSprite("fire_lamp", 5);
        SPR_flag = loadSprite("Flag", 6);

        SPR_stairs = loadSprite("Stairs");
        SPR_stairsUp = loadSprite("StairsUp");
        SPR_key = loadSprite("Key");
        SPR_key_door = loadSprite("KeyDoor");
        SPR_bolt = loadSprite("Bolt");
        SPR_cf = loadSprite("cf",6);
        SPR_chest = loadSprite("Chest");

        playerUp = loadSprite("/player/5",6);
        playerDown = loadSprite("/player/3",6);
        playerLeft = loadSprite("/player/left",6);
        playerRight = loadSprite("/player/4",6);
        player = loadSprite("/player/1",6);
    }

    private BufferedImage loadSprite(String name) {
        BufferedImage image = null;
        try {
            image = loader.load(spritePath + name + ".png");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }

    private BufferedImage[] loadSprite(String name, int count) {
        BufferedImage[] list = new BufferedImage[count];
        for (int i = 0; i < count; i++) {
            try {
                list[i] = loader.load(spritePath + name + "/" + i + ".png");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return list;
    }

    public static BufferedImage pixelImage(BufferedImage image, int xPixel, int yPixel) {
        BufferedImage bufferImg = new BufferedImage(xPixel, yPixel, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) bufferImg.getGraphics();
        AffineTransform at = new AffineTransform();
        at.scale((float) xPixel / image.getWidth(), (float) yPixel / image.getHeight());
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        g.drawImage(image, op, 0, 0);
        return bufferImg;
    }

    public static BufferedImage alphaImage(BufferedImage image, int a) {
        if (image == null) {
            return null;
        }
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = tmp.getGraphics();
        g.drawImage(image, 0, 0, null);
        int width = tmp.getWidth();
        int height = tmp.getHeight();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int p, A, R, G, B;
                p = tmp.getRGB(xx, yy);
                A = (p >> 24) & 0xff;
                if (A == 0) {
                    continue;
                }
                R = (p >> 16) & 0xff;
                G = (p >> 8) & 0xff;
                B = p & 0xff;
                p = (a << 24) | (R << 16) | (G << 8) | B;
                tmp.setRGB(xx, yy, p);
            }
        }
        return tmp;
    }

    public static BufferedImage colorImage(BufferedImage image, int R, int G, int B) {
        if (image == null) {
            return null;
        }
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = tmp.getGraphics();
        g.drawImage(image, 0, 0, null);

        int width = tmp.getWidth();
        int height = tmp.getHeight();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int p, a;
                p = tmp.getRGB(xx, yy);
                a = (p >> 24) & 0xff;
                p = (a << 24) | (R << 16) | (G << 8) | B;
                tmp.setRGB(xx, yy, p);
            }
        }
        return tmp;
    }

    public static BufferedImage colorImage(BufferedImage image, Color color) {
        int R = color.getRed(), G = color.getGreen(), B = color.getBlue();
        return colorImage(image, R, G, B);
    }
}
