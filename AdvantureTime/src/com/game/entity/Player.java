package com.game.entity;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.Windows.InputManager;
import com.game.effect.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.game.effect.ImageManager1.*;

public class Player extends Entity {
    InputManager inputManager;
    public final int screenX=GameFrame.SC_WIDTH/2-(GameFrame.TILE_SIZE/2);
    public final int screenY=GameFrame.SC_HEIGHT/2-(GameFrame.TILE_SIZE/2);
    public int hasKey=0;

    private int playerState=0;

    private Animation normal,left,right,up,down;

    public int getPlayerState() {
        return playerState;
    }
    public void setPlayerState(int playerState) {
        this.playerState = playerState;
    }

    public Animation getAniNormal() {
        return normal;
    }

    public Player(GamePanel gamePanel, InputManager inputManager) {
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

        normal = new Animation();
        normal.setFrames(player);
        normal.setDelay(100);

        left = new Animation();
        left.setFrames(playerLeft);
        left.setDelay(100);

        right = new Animation();
        right.setFrames(playerRight);
        right.setDelay(100);

        up = new Animation();
        up.setFrames(playerUp);
        up.setDelay(100);

        down = new Animation();
        down.setFrames(playerDown);
        down.setDelay(100);

    }
    public void setDefaultPosition() {
        this.setWolrdX(GameFrame.TILE_SIZE*27);
        this.setWolrdY(GameFrame.TILE_SIZE*25);
        this.setSpeed(5);
    }
    public void update(){
        normal.update();
       if (inputManager.isRight==true ||
               inputManager.isLeft==true ||
               inputManager.isUp==true ||
               inputManager.isDown==true) {
            playerState =1;

            if (inputManager.isRight) {
                // moveRight();
                direction = "right";
                right.update();
            }
            if (inputManager.isLeft) {
                // moveLeft();
                direction = "left";
                left.update();
            }
            if (inputManager.isUp) {
                // moveUp();
                direction = "up";
                up.update();
            }
            if (inputManager.isDown) {
                // moveDown();
                direction = "down";
                down.update();
            }

            // check collision
            collisionOn = false;
            gamePanel.getCollisionChecker().checkTile(this);
            // check object
            int objIndex = gamePanel.getCollisionChecker().checkObject(this, true);
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
       } else {playerState =0;}

    }
    public void pickUpObject(int index){
        if (index!=999){
            String objName = gamePanel.getObj()[index].name;
            switch (objName){
                case "key":
                    gamePanel.playSE(2);
                    hasKey++;
                    gamePanel.getObj()[index]=null;
                    gamePanel.getUi().showMessage("You got a key");
                    break;
                case "door":
                    if (hasKey>0){
                        gamePanel.playSE(0);
                        hasKey--;
                        gamePanel.getObj()[index]=null;
                        gamePanel.getUi().showMessage("You opened the door");
                    }else {
                        gamePanel.getUi().showMessage("You need a key");
                    }
                    break;
                case "Boots":
                    gamePanel.playSE(3);
                        gamePanel.getObj()[index]=null;
                        speed+=3;
                    gamePanel.getUi().showMessage("You got boots");
                    break;
                case "stairs":
                        gamePanel.getTileManager().loadMap("dungeon01");
                        System.out.println("Dungeon");
                        setDefaultPosition();//set player position
                        gamePanel.setupDungeon();
                    break;
                case "stairsUp":
                    gamePanel.getTileManager().loadMap("world01");
                    System.out.println("Dungeon");
                    gamePanel.setupDungeon();
                    setDefaultPosition();
                    gamePanel.clearObjects();
                    break;
            }
        }

    }
    public void draw(Graphics2D g2){
        if (playerState == 1){
            switch (direction){
                case "right":
                    g2.drawImage(right.getImage(),screenX,screenY,34,50,null);
                    break;
                case "left":
                    g2.drawImage(left.getImage(),screenX,screenY,34,50,null);
                    break;
                case "up":
                    g2.drawImage(up.getImage(),screenX,screenY,34,50,null);
                    break;
                case "down":
                    g2.drawImage(down.getImage(),screenX,screenY,34,50,null);
                    break;
            }
        }
        if(playerState == 0) {
            g2.drawImage(normal.getImage(), screenX, screenY, 34, 50, null);
        }
    }


    public int getWorldX() {
        return super.getWolrdX();
    }
    public int getWorldY() {
        return super.getWolrdY();
    }
}
