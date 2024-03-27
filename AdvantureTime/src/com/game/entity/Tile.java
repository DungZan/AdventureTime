package com.game.entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.game.effect.ImageManager1.*;

public class Tile {
    private BufferedImage image;
    public boolean collision=false;
    public Tile(){
    }
    public Tile(BufferedImage image, boolean collision){
        this.image=image;
        this.collision=collision;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

}
