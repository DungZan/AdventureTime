package com.game.Windows;

import com.game.object.OBJ_Boots;
import com.game.object.OBJ_Door;
import com.game.object.OBJ_Key;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObjects(){
     gamePanel.obj[0] = new OBJ_Key();
     gamePanel.obj[0].worldX = 27*GameFrame.TILE_SIZE;
     gamePanel.obj[0].worldY = 10*GameFrame.TILE_SIZE;

     gamePanel.obj[1] = new OBJ_Key();
     gamePanel.obj[1].worldX = 31*GameFrame.TILE_SIZE;
     gamePanel.obj[1].worldY = 44*GameFrame.TILE_SIZE;

     gamePanel.obj[2] = new OBJ_Key();
     gamePanel.obj[2].worldX = 30*GameFrame.TILE_SIZE;
     gamePanel.obj[2].worldY = 43*GameFrame.TILE_SIZE;

     gamePanel.obj[3] = new OBJ_Door();
     gamePanel.obj[3].worldX = 34*GameFrame.TILE_SIZE;
     gamePanel.obj[3].worldY = 27*GameFrame.TILE_SIZE;

     gamePanel.obj[4] = new OBJ_Door();
     gamePanel.obj[4].worldX = 18*GameFrame.TILE_SIZE;
     gamePanel.obj[4].worldY = 28*GameFrame.TILE_SIZE;

     gamePanel.obj[5] = new OBJ_Door();
     gamePanel.obj[5].worldX = 8*GameFrame.TILE_SIZE;
     gamePanel.obj[5].worldY = 23*GameFrame.TILE_SIZE;


     gamePanel.obj[6] = new OBJ_Boots();
     gamePanel.obj[6].worldX = 23*GameFrame.TILE_SIZE;
     gamePanel.obj[6].worldY = 9*GameFrame.TILE_SIZE;


    }

}
