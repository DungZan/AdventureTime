package com.game.Windows;

import java.awt.event.KeyEvent;

public class InputManager {
    GamePanel gamePanel;
    public boolean isRight,isLeft,isUp,isDown,isSpace,isEnter;
    public void processKeyPressed(int keyCode,GamePanel gamePanel){
        this.gamePanel= gamePanel;
        if (gamePanel.gameState == gamePanel.menuState){
            switch (keyCode){
                case KeyEvent.VK_W:
                    gamePanel.ui.commandNum--;
                    if (gamePanel.ui.commandNum<0)
                        gamePanel.ui.commandNum=2;
                    break;
                case KeyEvent.VK_S:
                    gamePanel.ui.commandNum++;
                    if (gamePanel.ui.commandNum>2)
                        gamePanel.ui.commandNum=0;
                    break;
                case KeyEvent.VK_ENTER:
                    if (gamePanel.ui.commandNum==0){
                        gamePanel.gameState = gamePanel.playState;
                    }
                    if (gamePanel.ui.commandNum==1){
                        gamePanel.gameState = gamePanel.aboutState;
                    }
                    if (gamePanel.ui.commandNum==2){
                        System.exit(0);
                    }
                    break;
            }
        }
        if (gamePanel.gameState == gamePanel.aboutState){
            switch (keyCode){
                case KeyEvent.VK_ESCAPE:
                    gamePanel.gameState = gamePanel.menuState;
                    break;}
        }
        if (gamePanel.gameState== gamePanel.playState){
            switch (keyCode){
                case KeyEvent.VK_W:
                    isUp= true;
                    break;
                case KeyEvent.VK_A:
                    isLeft= true;
                    break;
                case KeyEvent.VK_S:
                    isDown=true;
                    break;
                case KeyEvent.VK_D:
                    isRight=true;
                    break;
                case KeyEvent.VK_SPACE:
                    isSpace=true;
                    break;
                case KeyEvent.VK_ESCAPE:
                    if (gamePanel.gameState == gamePanel.playState){
                        gamePanel.gameState = gamePanel.menuState;
                    }
                    break;
            }
        }

    }
    public void processKeyReleased(int keyCode,GamePanel gamePanel){
        this.gamePanel= gamePanel;
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
