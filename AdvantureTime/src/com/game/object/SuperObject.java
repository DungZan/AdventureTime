package com.game.object;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    protected int worldX,worldY;
    private Rectangle solidArea = new Rectangle(0,0,48,48);
    private int solidAreaDefaultX = 0;
    private int solidAreaDefaultY = 0;
    protected BufferedImage image;
    protected String name;
    protected boolean collision;

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX();
        int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY();

        if (worldX+ GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldX()- gamePanel.getPlayer().getScreenX() &&
                worldX-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldX()+gamePanel.getPlayer().getScreenX() &&
                worldY+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldY()-gamePanel.getPlayer().getScreenY() &&
                worldY-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldY()+gamePanel.getPlayer().getScreenY()){
            g2.drawImage(image,screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }
}
