package com.game.Windows;

import com.game.object.*;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObjects(){
     gamePanel.obj[0] = new OBJ_Key();
     gamePanel.obj[0].worldX = 7*GameFrame.TILE_SIZE;
     gamePanel.obj[0].worldY = 17*GameFrame.TILE_SIZE;

     gamePanel.obj[1] = new OBJ_Key();
     gamePanel.obj[1].worldX = 7*GameFrame.TILE_SIZE;
     gamePanel.obj[1].worldY = 27*GameFrame.TILE_SIZE;

     gamePanel.obj[2] = new OBJ_Key();
     gamePanel.obj[2].worldX = 16*GameFrame.TILE_SIZE;
     gamePanel.obj[2].worldY = 13*GameFrame.TILE_SIZE;

     gamePanel.obj[3] = new OBJ_Door();
     gamePanel.obj[3].worldX = 37*GameFrame.TILE_SIZE;
     gamePanel.obj[3].worldY = 28*GameFrame.TILE_SIZE;

     gamePanel.obj[4] = new OBJ_Door();
     gamePanel.obj[4].worldX = 28*GameFrame.TILE_SIZE;
     gamePanel.obj[4].worldY = 36*GameFrame.TILE_SIZE;

     gamePanel.obj[5] = new OBJ_Door();
     gamePanel.obj[5].worldX = 28*GameFrame.TILE_SIZE;
     gamePanel.obj[5].worldY = 19*GameFrame.TILE_SIZE;


     gamePanel.obj[6] = new OBJ_Boots();
     gamePanel.obj[6].worldX = 23*GameFrame.TILE_SIZE;
     gamePanel.obj[6].worldY = 9*GameFrame.TILE_SIZE;

     gamePanel.obj[7] = new OBJ_Stairs();
     gamePanel.obj[7].worldX = 31*GameFrame.TILE_SIZE;
     gamePanel.obj[7].worldY = 45*GameFrame.TILE_SIZE;


    }
    public void setObjectDungeon(){
        gamePanel.obj[0] = new OBJ_Key();
        gamePanel.obj[0].worldX = 2*GameFrame.TILE_SIZE;
        gamePanel.obj[0].worldY = 25*GameFrame.TILE_SIZE;

        gamePanel.obj[1] = new OBJ_Key();
        gamePanel.obj[1].worldX = 6*GameFrame.TILE_SIZE;
        gamePanel.obj[1].worldY = 12*GameFrame.TILE_SIZE;

        gamePanel.obj[2] = new OBJ_Key();
        gamePanel.obj[2].worldX = 18*GameFrame.TILE_SIZE;
        gamePanel.obj[2].worldY = 13*GameFrame.TILE_SIZE;

        gamePanel.obj[3] = new OBJ_Door();
        gamePanel.obj[3].worldX = 31*GameFrame.TILE_SIZE;
        gamePanel.obj[3].worldY = 25*GameFrame.TILE_SIZE;

        gamePanel.obj[4] = new OBJ_Door();
        gamePanel.obj[4].worldX = 13*GameFrame.TILE_SIZE;
        gamePanel.obj[4].worldY = 21*GameFrame.TILE_SIZE;

        gamePanel.obj[5] = new OBJ_Door();
        gamePanel.obj[5].worldX = 39*GameFrame.TILE_SIZE;
        gamePanel.obj[5].worldY = 29*GameFrame.TILE_SIZE;

        gamePanel.obj[6] = new OBJ_Key();
        gamePanel.obj[6].worldX = 19*GameFrame.TILE_SIZE;
        gamePanel.obj[6].worldY = 47*GameFrame.TILE_SIZE;

        gamePanel.obj[7] = new OBJ_Door();
        gamePanel.obj[7].worldX = 39*GameFrame.TILE_SIZE;
        gamePanel.obj[7].worldY = 13*GameFrame.TILE_SIZE;

        gamePanel.obj[8] = new OBJ_StairsUp();
        gamePanel.obj[8].worldX = 36*GameFrame.TILE_SIZE;
        gamePanel.obj[8].worldY = 10*GameFrame.TILE_SIZE;

        gamePanel.obj[9] = new OBJ_Door();
        gamePanel.obj[9].worldX = 38*GameFrame.TILE_SIZE;
        gamePanel.obj[9].worldY = 25*GameFrame.TILE_SIZE;
    }

}
