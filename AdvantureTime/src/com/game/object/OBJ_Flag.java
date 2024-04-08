package com.game.object;


import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.effect.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.game.effect.ImageManager1.SPR_flag;

public class OBJ_Flag extends SuperObject{
    Animation flag = new Animation();
    public OBJ_Flag( ){
        this.name = "flag";
        this.collision = true;
        flag.setFrames(SPR_flag);
        flag.setDelay(100);
        this.worldX=27* GameFrame.TILE_SIZE;
        this.worldY=27* GameFrame.TILE_SIZE;
    }
    public void update(){
        flag.update();
    }
    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().screenX;
        int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().screenY;

        if (worldX+ GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldX()- gamePanel.getPlayer().screenX &&
                worldX-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldX()+gamePanel.getPlayer().screenX &&
                worldY+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldY()-gamePanel.getPlayer().screenY &&
                worldY-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldY()+gamePanel.getPlayer().screenY){
            g2.drawImage(flag.getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }

}
