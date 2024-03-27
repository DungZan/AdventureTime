package com.game.Windows;

import java.awt.event.KeyEvent;

public class InputManager {
    public boolean isRight,isLeft,isUp,isDown,isSpace,isEnter;
    public void processKeyPressed(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_W:
                //System.out.println("Pressed W");
                isUp= true;
                break;
            case KeyEvent.VK_A:
                //System.out.println("Pressed A");
                isLeft= true;
                break;
            case KeyEvent.VK_S:
                //System.out.println("Pressed S");
                isDown=true;
                break;
            case KeyEvent.VK_D:
                //System.out.println("Pressed D");
                isRight=true;
                break;
            case KeyEvent.VK_ENTER:
                //System.out.println("Pressed Enter");
                isEnter=true;
                break;
            case KeyEvent.VK_SPACE:
                //System.out.println("Pressed Space");
                isSpace=true;
                break;
        }
    }
    public void processKeyReleased(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_W:
                //System.out.println("Released W");
                isUp= false;
                break;
            case KeyEvent.VK_A:
                //System.out.println("Released A");
                isLeft= false;
                break;
            case KeyEvent.VK_S:
                //System.out.println("Released S");
                isDown=false;
                break;
            case KeyEvent.VK_D:
                //System.out.println("Released D");
                isRight=false;
                break;
            case KeyEvent.VK_ENTER:
                //System.out.println("Released Enter");
                isEnter=false;
                break;
            case KeyEvent.VK_SPACE:
                //System.out.println("Released Space");
                isSpace=false;
                break;
        }
    }
}
