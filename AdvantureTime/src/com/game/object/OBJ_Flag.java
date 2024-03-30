package com.game.object;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.effect.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;

import static com.game.effect.ImageManager1.SPR_flag;

public class OBJ_Flag extends SuperObject{
    GamePanel gamePanel;
    BufferedImage[] image;
    public Animation animation = new Animation(gamePanel);
    public OBJ_Flag(){
        this.name = "flag";
        this.image = SPR_flag;
        this.collision = true;
        animation.setFrames(image);
        animation.setDelay(100);

    }
    public void draw(Graphics2D g2, GamePanel gamePanel){

        int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.screenY;

        if (worldX+ GameFrame.TILE_SIZE>gamePanel.player.getWorldX()- gamePanel.player.screenX &&
                worldX-GameFrame.TILE_SIZE<gamePanel.player.getWorldX()+gamePanel.player.screenX &&
                worldY+GameFrame.TILE_SIZE>gamePanel.player.getWorldY()-gamePanel.player.screenY &&
                worldY-GameFrame.TILE_SIZE<gamePanel.player.getWorldY()+gamePanel.player.screenY){
            g2.drawImage(animation.getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }
    public void update(){
        animation.update();
    }
}
