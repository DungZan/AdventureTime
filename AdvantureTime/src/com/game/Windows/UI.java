package com.game.Windows;

import com.game.object.OBJ_Boots;
import com.game.object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static com.game.effect.ImageManager1.*;

public class UI {
    GamePanel gamePanel;
    Font pixelF,ariral_40;
    Font ariral_80B,pixelF2;
    Graphics2D g2;
    boolean messageOn = false;
    String message = "";
    int messageTime = 0;
    int commandNum = 0;
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        try {
            InputStream is = getClass().getResourceAsStream("/resources/font/StayPixelRegular-EaOxl.ttf");
            pixelF = Font.createFont(Font.TRUETYPE_FONT,is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pixelF = pixelF.deriveFont(Font.PLAIN,80);
        pixelF2 = pixelF.deriveFont(Font.PLAIN,60);
        ariral_80B = new Font("Arial",Font.BOLD,80);
        ariral_40 = new Font("Arial",Font.PLAIN,40);
    }
    public void showMessage(String message){
        this.message = message;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
       this.g2=g2;
         if (gamePanel.gameState == gamePanel.menuState){
             drawMenu(g2);
         }
         if (gamePanel.gameState == gamePanel.playState){
                OBJ_Key obj_key = new OBJ_Key();
                BufferedImage keyImage = obj_key.image;
                OBJ_Boots obj_boots = new OBJ_Boots();
                BufferedImage bootsImage = obj_boots.image;

                //g2.drawImage(gamePanel.animation.getImage(),100,100,48,48,null);
                g2.setColor(Color.white);
                g2.setFont(ariral_40);
                g2.drawImage(keyImage,30,20,32,32,null);
                g2.drawString("x" + gamePanel.player.hasKey,60,50);

                g2.drawImage(bootsImage,30,70,32,32,null);
                g2.drawString("x" + gamePanel.player.speed,60,100);

                //show message
                if (messageOn){
                    g2.drawString(message,GameFrame.TILE_SIZE*1,GameFrame.TILE_SIZE*4);
                    messageTime++;
                }
                if (messageTime>100){
                    messageOn = false;
                    messageTime = 0;
                }
            }
         if (gamePanel.gameState == gamePanel.aboutState){
             drawAbout(g2);
         }
    }

    public int getXforCenter(String text){
        FontMetrics fm = g2.getFontMetrics();
        int width = fm.stringWidth(text);
        return (GameFrame.SC_WIDTH-width)/2;
    }
    public void drawAbout(Graphics2D g2){
        this.g2 = g2;
        g2.drawImage(SPR_background[1],0,0,GameFrame.SC_WIDTH,GameFrame.SC_HEIGHT,null);
        g2.setFont(ariral_40);

        g2.drawImage(SPR_avatar, 70, 70, 150, 150, null);

        g2.drawString("221230771", getXforCenter("221230771"), 90);
        g2.drawString("Phạm Tiến Dũng", getXforCenter("Phạm Tiến Dũng"), 140);


        g2.drawString("ADVANTURE TIME", getXforCenter("ADVANTURE TIME"), 200);

        g2.drawString("BTL JAVA - Class CNTT4 - K63", getXforCenter("BTL JAVA - Class CNTT4 - K63"), 250);

        g2.drawString("--------------------------------------------------", getXforCenter("--------------------------------------------------"), 300);


        g2.drawString("TUTORIAL", getXforCenter("TUTORIAL"), 370);

        g2.drawString("Use W and A and S and D to control", getXforCenter("Use W and A and S and D to control"), 435);

        g2.setColor(Color.white);
        g2.setFont(new Font("Calibri", Font.CENTER_BASELINE, 18));
        g2.drawString("ESC TO BACK", 950, 30);

    }
    public void drawMenu(Graphics2D g2){
        this.g2 = g2;
        g2.drawImage(SPR_background[0],0,0,GameFrame.SC_WIDTH,GameFrame.SC_HEIGHT,null);
        g2.setFont(pixelF);
        String message = "Advanture Time";
        int x = getXforCenter(message);
        int y = GameFrame.SC_HEIGHT/2-250;
        //shadow text
        g2.setColor(Color.black);
        g2.drawString(message,x+5,y+5);
        //text
        g2.setColor(Color.white);
        g2.drawString(message,x,y);
        //New Game
        g2.setFont(pixelF2);
        g2.setColor(Color.black);
        g2.drawString("New Game",getXforCenter("New Game")+3,GameFrame.SC_HEIGHT/2+50+3);
        g2.setColor(Color.white);
        g2.drawString("New Game",getXforCenter("New Game"),GameFrame.SC_HEIGHT/2+50);
        if (commandNum == 0){
            g2.setColor(Color.black);
            g2.drawString(">",getXforCenter("New Game")-GameFrame.TILE_SIZE,GameFrame.SC_HEIGHT/2+50);
        }
        //About
        g2.setColor(Color.black);
        g2.drawString("About",getXforCenter("About")+3,GameFrame.SC_HEIGHT/2+130+3);
        g2.setColor(Color.white);
        g2.drawString("About",getXforCenter("About"),GameFrame.SC_HEIGHT/2+130);
        if (commandNum == 1){
            g2.setColor(Color.black);
            g2.drawString(">",getXforCenter("About")-GameFrame.TILE_SIZE,GameFrame.SC_HEIGHT/2+130);
        }
        //Exit
        g2.setColor(Color.black);
        g2.drawString("Exit",getXforCenter("Exit")+3,GameFrame.SC_HEIGHT/2+210+3);
        g2.setColor(Color.white);
        g2.drawString("Exit",getXforCenter("Exit"),GameFrame.SC_HEIGHT/2+210);
        if (commandNum == 2){
            g2.setColor(Color.black);
            g2.drawString(">",getXforCenter("Exit")-GameFrame.TILE_SIZE,GameFrame.SC_HEIGHT/2+210);
        }


    }
}
