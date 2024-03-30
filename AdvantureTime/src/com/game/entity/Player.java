package com.game.entity;

import com.game.Windows.CollisionChecker;
import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.Windows.InputManager;
import com.game.effect.Animation;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static com.game.effect.ImageManager1.*;

public class Player extends Entity {
    InputManager inputManager;
    private int count=0,test=1;
    public final int screenX=GameFrame.SC_WIDTH/2-(GameFrame.TILE_SIZE/2);
    public final int screenY=GameFrame.SC_HEIGHT/2-(GameFrame.TILE_SIZE/2);
    public int hasKey=0;
    Animation animation = new Animation(gamePanel);

    public Player(GamePanel gamePanel,InputManager inputManager) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        this.inputManager = inputManager;
        this.setDefaultPosition();
        direction ="down";
        solidArea = new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidDefaultX = solidArea.x;
        solidDefaultY = solidArea.y;
        solidArea.width=32;
        solidArea.height=32;
    }
    public void setDefaultPosition() {
        this.setWolrdX(GameFrame.TILE_SIZE*23);
        this.setWolrdY(GameFrame.TILE_SIZE*25);
        this.setSpeed(5);
    }
    public void update(){
       if (inputManager.isRight==true ||
               inputManager.isLeft==true ||
               inputManager.isUp==true ||
               inputManager.isDown==true) {

            if (inputManager.isRight) {
                // moveRight();
                direction = "right";
            }
            if (inputManager.isLeft) {
                // moveLeft();
                direction = "left";
            }
            if (inputManager.isUp) {
                // moveUp();
                direction = "up";
            }
            if (inputManager.isDown) {
                // moveDown();
                direction = "down";
            }

            // check collision
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);
            // check object
            int objIndex = gamePanel.collisionChecker.checkObject(this, true);
            pickUpObject(objIndex);
            // if collision false, player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        moveUp();
                        break;
                    case "down":
                        moveDown();
                        break;
                    case "left":
                        moveLeft();
                        break;
                    case "right":
                        moveRight();
                        break;
                }
            }

            count++;
            if (count > 10) {
                if (test == 1) {
                    test = 2;
                } else if (test == 2) {
                    test = 3;
                } else if (test == 3)
                    test = 1;
                count = 0;
            }

       }
    }
    public void pickUpObject(int index){
        if (index!=999){
            String objName = gamePanel.obj[index].name;
            switch (objName){
                case "key":
                    gamePanel.playSE(2);
                    hasKey++;
                    gamePanel.obj[index]=null;
                    gamePanel.ui.showMessage("You got a key");
                    break;
                case "door":
                    if (hasKey>0){
                        gamePanel.playSE(0);
                        hasKey--;
                        gamePanel.obj[index]=null;
                        gamePanel.ui.showMessage("You opened the door");
                    }else {
                        gamePanel.ui.showMessage("You need a key");
                    }
                    break;
                case "Boots":
                    gamePanel.playSE(3);
                        gamePanel.obj[index]=null;
                        speed+=3;
                    gamePanel.ui.showMessage("You got boots");
                    break;
            }
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "right":
                if (test==1)
                    image = SPR_blue_square[0];
                if (test==2)
                    image = SPR_blue_square[1];
                if (test==3)
                    image = SPR_blue_square[2];
                break;
            case "left":
                if (test==1)
                    image = SPR_blue_square[0];
                if (test==2)
                    image = SPR_blue_square[1];
                if (test==3)
                    image = SPR_blue_square[2];
                break;
            case "up":
                if (test==1)
                    image = SPR_blue_square[0];
                if (test==2)
                    image = SPR_blue_square[1];
                if (test==3)
                    image = SPR_blue_square[2];
                break;
            case "down":
                if (test==1)
                    image = SPR_blue_square[0];
                if (test==2)
                    image = SPR_blue_square[1];
                if (test==3)
                    image = SPR_blue_square[2];
                break;
        }
        g2.drawImage(image,screenX,screenY,GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
        //g2.drawImage(image,screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);

    }


    public int getWorldX() {
        return super.getWolrdX();
    }
    public int getWorldY() {
        return super.getWolrdY();
    }
}
