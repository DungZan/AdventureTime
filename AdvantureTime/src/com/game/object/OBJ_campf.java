package com.game.object;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.effect.Animation;

import java.awt.*;

import static com.game.effect.ImageManager1.SPR_cf;

public class OBJ_campf extends SuperObject{
    Animation campfire = new Animation();
    public OBJ_campf( ){
        this.name = "campfire";
        this.collision = true;
        campfire.setFrames(SPR_cf);
        campfire.setDelay(100);
        this.worldX=27* GameFrame.TILE_SIZE;
        this.worldY=26* GameFrame.TILE_SIZE;
    }
    public void update(){
        campfire.update();
    }
    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().screenX;
        int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().screenY;

        if (worldX+ GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldX()- gamePanel.getPlayer().screenX &&
                worldX-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldX()+gamePanel.getPlayer().screenX &&
                worldY+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldY()-gamePanel.getPlayer().screenY &&
                worldY-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldY()+gamePanel.getPlayer().screenY){
            g2.drawImage(campfire.getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }
}
