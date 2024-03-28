package com.game.Windows;

import com.game.object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gamePanel;
    Font ariral_40;
    BufferedImage keyImage;
    boolean messageOn = false;
    String message = "";
    int messageTime = 0;
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        ariral_40 = new Font("Arial",Font.PLAIN,30);

    }
    public void showMessage(String message){
        this.message = message;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        OBJ_Key obj_key = new OBJ_Key();
        keyImage = obj_key.image;
        g2.setColor(Color.white);
        g2.setFont(ariral_40);
        g2.drawImage(keyImage,30,20,32,32,null);
        g2.drawString("" + gamePanel.player.hasKey,60,50);

        //show message
        if (messageOn){
            g2.drawString(message,40,100);
            messageTime++;
        }
        if (messageTime>100){
            messageOn = false;
            messageTime = 0;
        }
    }
}
