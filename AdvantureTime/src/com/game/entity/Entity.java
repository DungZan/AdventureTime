package com.game.entity;

import com.game.Windows.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import static com.game.effect.ImageManager1.*;
import static java.lang.Math.sqrt;

public class Entity {
    private int wolrdX,wolrdY;
    protected Rectangle solidArea = new Rectangle(0,0,48,48);
    private int solidDefaultX,solidDefaultY;
    private boolean collisionOn = false;
    private String direction;
    private int speed;
    GamePanel gamePanel;

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSolidDefaultY() {
        return solidDefaultY;
    }

    public int getSolidDefaultX() {
        return solidDefaultX;
    }

    public void setSolidDefaultY(int solidDefaultY) {
        this.solidDefaultY = solidDefaultY;
    }

    public void setSolidDefaultX(int solidDefaultX) {
        this.solidDefaultX = solidDefaultX;
    }

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
    public void moveRightUp(){
        wolrdX+=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));
        wolrdY-=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));
    }
    public void moveRightDown(){
        wolrdX+=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
        wolrdY+=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
    }
    public void moveLeftUp(){
        wolrdX-=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
        wolrdY-=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
    }
    public void moveLeftDown(){
        wolrdX-=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
        wolrdY+=sqrt(speed*speed-(sqrt(speed*speed+speed*speed)/2)*(sqrt(speed*speed+speed*speed)/2));;
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
