package com.game.object;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.effect.Animation;

import java.awt.*;

import static com.game.effect.ImageManager1.SPR_cf;

public class OBJ_campf extends SuperObject{
    private Animation campfire = new Animation();
    public OBJ_campf( ){
        this.setName("campfire");
        this.setCollision(true);
        campfire.setFrames(SPR_cf);
        campfire.setDelay(100);
        this.setWorldX(8* GameFrame.TILE_SIZE);
        this.setWorldY(25* GameFrame.TILE_SIZE);
    }
    public void update(){
        campfire.update();
    }
    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX = getWorldX() - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX();
        int screenY = getWorldY() - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY();

        if (getWorldX()+ GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldX()- gamePanel.getPlayer().getScreenX() &&
                getWorldX()-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldX()+gamePanel.getPlayer().getScreenX() &&
                getWorldY()+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldY()-gamePanel.getPlayer().getScreenY() &&
                getWorldY()-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldY()+gamePanel.getPlayer().getScreenY()){
            g2.drawImage(campfire.getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        }
    }
}
