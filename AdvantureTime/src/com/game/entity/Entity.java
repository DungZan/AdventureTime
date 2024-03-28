package com.game.entity;

import com.game.Windows.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import static com.game.effect.ImageManager1.*;

public class Entity {
    public int wolrdX,wolrdY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidDefaultX,solidDefaultY;
    public boolean collisionOn = false;
    public String direction;
    public int speed;
    GamePanel gamePanel;

    public Entity(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void moveUp(){
        wolrdY-=speed;
    }
    public void moveDown(){
        wolrdY+=speed;
    }
    public void moveLeft(){
        wolrdX-=speed;
    }
    public void moveRight(){
        wolrdX+=speed;
    }
    public void setWolrdX(int wolrdX) {
        this.wolrdX = wolrdX;
    }
    public void setWolrdY(int wolrdY) {
        this.wolrdY = wolrdY;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWolrdX() {
        return wolrdX;
    }

    public int getWolrdY() {
        return wolrdY;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }
}
