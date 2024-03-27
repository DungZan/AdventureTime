package com.game.effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageManager {
    private String name;
    private BufferedImage image;
    public ImageManager(String name, BufferedImage image){
        this.name=name;
        this.image=image;

    }
    public ImageManager(ImageManager imageManager){
        image = new BufferedImage(imageManager.getWidthImage(),imageManager.getHeightImage(),imageManager.getImage().getType());
        Graphics g = image.getGraphics();
        g.drawImage(imageManager.image,0,0,null);
    }
    public void drawImage(Graphics2D g2,int x,int y){
        g2.drawImage(image,x-image.getWidth()/2,y-image.getHeight()/2,null);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public int getWidthImage(){
        return image.getWidth();
    }
    public int getHeightImage(){
        return image.getHeight();
    }
}
