package com.game.object;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public int worldX,worldY;
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.screenY;

        if (worldX+ GameFrame.TILE_SIZE>gamePanel.player.getWorldX()- gamePanel.player.screenX &&
                worldX-GameFrame.TILE_SIZE<gamePanel.player.getWorldX()+gamePanel.player.screenX &&
                worldY+GameFrame.TILE_SIZE>gamePanel.player.getWorldY()-gamePanel.player.screenY &&
                worldY-GameFrame.TILE_SIZE<gamePanel.player.getWorldY()+gamePanel.player.screenY){
            g2.drawImage(image,screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }
}
