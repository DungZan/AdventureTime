package com.game.Windows;

import java.awt.event.KeyEvent;

public class InputManager {
    GamePanel gamePanel;
    public static boolean isRight,isLeft,isUp,isDown,isSpace,isEnter;
    public void processKeyPressed(int keyCode,GamePanel gamePanel){
        this.gamePanel= gamePanel;
        if (gamePanel.gameState == gamePanel.menuState){
            switch (keyCode){
                case KeyEvent.VK_W:
                    gamePanel.getUi().commandNum--;
                    if (gamePanel.getUi().commandNum<0)
                        gamePanel.getUi().commandNum=3;
                    break;
                case KeyEvent.VK_S:
                    gamePanel.getUi().commandNum++;
                    if (gamePanel.getUi().commandNum>3)
                        gamePanel.getUi().commandNum=0;
                    break;
                case KeyEvent.VK_ENTER:
                    if (gamePanel.getUi().commandNum==0){
                        gamePanel.getSceneTransition().start();
                        gamePanel.gameState = gamePanel.playState;
                    }
                    if (gamePanel.getUi().commandNum==1){
                        gamePanel.gameState = gamePanel.aboutState;
                    }
                    if (gamePanel.getUi().commandNum==2){
                        System.exit(0);
                    }
                    if (gamePanel.getUi().commandNum==3){
                        if (!gamePanel.getMusic().isPlaying()) {
                            gamePanel.getMusic().playSound();

                        } else if (gamePanel.getMusic().isPlaying()) {gamePanel.stopMusic();}
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
