package com.game.Windows;

import com.game.object.OBJ_Door;
import com.game.object.OBJ_Key;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObjects(){
     gamePanel.obj[0] = new OBJ_Key();
     gamePanel.obj[0].worldX = 23*GameFrame.TILE_SIZE;
     gamePanel.obj[0].worldY = 7*GameFrame.TILE_SIZE;

     gamePanel.obj[1] = new OBJ_Key();
     gamePanel.obj[1].worldX = 23*GameFrame.TILE_SIZE;
     gamePanel.obj[1].worldY = 40*GameFrame.TILE_SIZE;

     gamePanel.obj[2] = new OBJ_Key();
     gamePanel.obj[2].worldX = 37*GameFrame.TILE_SIZE;
     gamePanel.obj[2].worldY = 7*GameFrame.TILE_SIZE;

     gamePanel.obj[3] = new OBJ_Door();
     gamePanel.obj[3].worldX = 10*GameFrame.TILE_SIZE;
     gamePanel.obj[3].worldY = 11*GameFrame.TILE_SIZE;

     gamePanel.obj[4] = new OBJ_Door();
     gamePanel.obj[4].worldX = 12*GameFrame.TILE_SIZE;
     gamePanel.obj[4].worldY = 22*GameFrame.TILE_SIZE;

     gamePanel.obj[5] = new OBJ_Door();
     gamePanel.obj[5].worldX = 10*GameFrame.TILE_SIZE;
     gamePanel.obj[5].worldY = 7*GameFrame.TILE_SIZE;


    }

}
