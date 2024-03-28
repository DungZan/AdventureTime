package com.game.entity;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;

import java.awt.*;

public class NPC_monter extends Entity{
    public NPC_monter(GamePanel gamePanel) {
        super(gamePanel);
        direction = "down";
        speed =5;
    }
    public void update(){
        // moveRight();
    }
    public void draw(Graphics2D g2){
       // g.drawImage(monster, getWolrdX(), getWolrdY(), null);
    }
}
