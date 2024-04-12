package com.game.Windows;

import com.game.object.*;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObjects(){
     gamePanel.getObj()[0] = new OBJ_Key();
     gamePanel.getObj()[0].worldX = 7*GameFrame.TILE_SIZE;
     gamePanel.getObj()[0].worldY = 17*GameFrame.TILE_SIZE;

     gamePanel.getObj()[1] = new OBJ_Key();
     gamePanel.getObj()[1].worldX = 7*GameFrame.TILE_SIZE;
     gamePanel.getObj()[1].worldY = 27*GameFrame.TILE_SIZE;

     gamePanel.getObj()[2] = new OBJ_Key();
     gamePanel.getObj()[2].worldX = 16*GameFrame.TILE_SIZE;
     gamePanel.getObj()[2].worldY = 13*GameFrame.TILE_SIZE;

     gamePanel.getObj()[3] = new OBJ_Door();
     gamePanel.getObj()[3].worldX = 37*GameFrame.TILE_SIZE;
     gamePanel.getObj()[3].worldY = 28*GameFrame.TILE_SIZE;

     gamePanel.getObj()[4] = new OBJ_Door();
     gamePanel.getObj()[4].worldX = 28*GameFrame.TILE_SIZE;
     gamePanel.getObj()[4].worldY = 36*GameFrame.TILE_SIZE;

     gamePanel.getObj()[5] = new OBJ_Door();
     gamePanel.getObj()[5].worldX = 28*GameFrame.TILE_SIZE;
     gamePanel.getObj()[5].worldY = 19*GameFrame.TILE_SIZE;


     gamePanel.getObj()[6] = new OBJ_Boots();
     gamePanel.getObj()[6].worldX = 23*GameFrame.TILE_SIZE;
     gamePanel.getObj()[6].worldY = 9*GameFrame.TILE_SIZE;

     gamePanel.getObj()[7] = new OBJ_Stairs();
     gamePanel.getObj()[7].worldX = 31*GameFrame.TILE_SIZE;
     gamePanel.getObj()[7].worldY = 45*GameFrame.TILE_SIZE;

     gamePanel.getObj()[8] = gamePanel.getFlag();

     gamePanel.getObj()[9] = gamePanel.getCampf();


    }
    public void setObjectDungeon(){
        gamePanel.getObj()[0] = new OBJ_Key();
        gamePanel.getObj()[0].worldX = 2*GameFrame.TILE_SIZE;
        gamePanel.getObj()[0].worldY = 25*GameFrame.TILE_SIZE;

        gamePanel.getObj()[1] = new OBJ_Key();
        gamePanel.getObj()[1].worldX = 6*GameFrame.TILE_SIZE;
        gamePanel.getObj()[1].worldY = 12*GameFrame.TILE_SIZE;

        gamePanel.getObj()[2] = new OBJ_Key();
        gamePanel.getObj()[2].worldX = 18*GameFrame.TILE_SIZE;
        gamePanel.getObj()[2].worldY = 13*GameFrame.TILE_SIZE;

        gamePanel.getObj()[3] = new OBJ_Door();
        gamePanel.getObj()[3].worldX = 31*GameFrame.TILE_SIZE;
        gamePanel.getObj()[3].worldY = 25*GameFrame.TILE_SIZE;

        gamePanel.getObj()[4] = new OBJ_Door();
        gamePanel.getObj()[4].worldX = 13*GameFrame.TILE_SIZE;
        gamePanel.getObj()[4].worldY = 21*GameFrame.TILE_SIZE;

        gamePanel.getObj()[5] = new OBJ_Door();
        gamePanel.getObj()[5].worldX = 39*GameFrame.TILE_SIZE;
        gamePanel.getObj()[5].worldY = 29*GameFrame.TILE_SIZE;

        gamePanel.getObj()[6] = new OBJ_Key();
        gamePanel.getObj()[6].worldX = 19*GameFrame.TILE_SIZE;
        gamePanel.getObj()[6].worldY = 47*GameFrame.TILE_SIZE;

        gamePanel.getObj()[7] = new OBJ_Door();
        gamePanel.getObj()[7].worldX = 39*GameFrame.TILE_SIZE;
        gamePanel.getObj()[7].worldY = 13*GameFrame.TILE_SIZE;

        gamePanel.getObj()[8] = new OBJ_StairsUp();
        gamePanel.getObj()[8].worldX = 36*GameFrame.TILE_SIZE;
        gamePanel.getObj()[8].worldY = 10*GameFrame.TILE_SIZE;

        gamePanel.getObj()[9] = new OBJ_Door();
        gamePanel.getObj()[9].worldX = 38*GameFrame.TILE_SIZE;
        gamePanel.getObj()[9].worldY = 25*GameFrame.TILE_SIZE;
    }
    public void setObjectWin(){
        gamePanel.getObj()[0] = new OBJ_chest();
        gamePanel.getObj()[0].worldX = 26*GameFrame.TILE_SIZE;
        gamePanel.getObj()[0].worldY = 26*GameFrame.TILE_SIZE;
    }

}
