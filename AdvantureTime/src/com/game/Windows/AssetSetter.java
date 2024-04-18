package com.game.Windows;

import com.game.object.*;

public class AssetSetter {
    GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setObjects(){
     gamePanel.getObj()[0] = new OBJ_Key();
     gamePanel.getObj()[0].setWorldX(7*GameFrame.TILE_SIZE);
     gamePanel.getObj()[0].setWorldY(17*GameFrame.TILE_SIZE);

     gamePanel.getObj()[1] = new OBJ_Key();
     gamePanel.getObj()[1].setWorldX(7*GameFrame.TILE_SIZE);
     gamePanel.getObj()[1].setWorldY(27*GameFrame.TILE_SIZE);

     gamePanel.getObj()[2] = new OBJ_Key();
     gamePanel.getObj()[2].setWorldX(16*GameFrame.TILE_SIZE);
     gamePanel.getObj()[2].setWorldY(13*GameFrame.TILE_SIZE);

     gamePanel.getObj()[3] = new OBJ_Door();
     gamePanel.getObj()[3].setWorldX(37*GameFrame.TILE_SIZE);
     gamePanel.getObj()[3].setWorldY(28*GameFrame.TILE_SIZE);

     gamePanel.getObj()[4] = new OBJ_Door();
     gamePanel.getObj()[4].setWorldX(28*GameFrame.TILE_SIZE);
     gamePanel.getObj()[4].setWorldY(36*GameFrame.TILE_SIZE);

     gamePanel.getObj()[5] = new OBJ_Door();
     gamePanel.getObj()[5].setWorldX(28*GameFrame.TILE_SIZE);
     gamePanel.getObj()[5].setWorldY(19*GameFrame.TILE_SIZE);


     gamePanel.getObj()[6] = new OBJ_Boots();
     gamePanel.getObj()[6].setWorldX(23*GameFrame.TILE_SIZE);
     gamePanel.getObj()[6].setWorldY(9*GameFrame.TILE_SIZE);

     gamePanel.getObj()[7] = new OBJ_Stairs();
     gamePanel.getObj()[7].setWorldX(31*GameFrame.TILE_SIZE);
     gamePanel.getObj()[7].setWorldY(45*GameFrame.TILE_SIZE);

     gamePanel.getObj()[8] = gamePanel.getFlag();

     gamePanel.getObj()[9] = gamePanel.getCampf();


    }
    public void setObjectDungeon(){
        gamePanel.getObj()[0] = new OBJ_Key();
        gamePanel.getObj()[0].setWorldX(2*GameFrame.TILE_SIZE);
        gamePanel.getObj()[0].setWorldY(25*GameFrame.TILE_SIZE);

        gamePanel.getObj()[1] = new OBJ_Key();
        gamePanel.getObj()[1].setWorldX(6*GameFrame.TILE_SIZE);
        gamePanel.getObj()[1].setWorldY(12*GameFrame.TILE_SIZE);

        gamePanel.getObj()[2] = new OBJ_Key();
        gamePanel.getObj()[2].setWorldX(18*GameFrame.TILE_SIZE);
        gamePanel.getObj()[2].setWorldY(13*GameFrame.TILE_SIZE);

        gamePanel.getObj()[3] = new OBJ_Door();
        gamePanel.getObj()[3].setWorldX(31*GameFrame.TILE_SIZE);
        gamePanel.getObj()[3].setWorldY(25*GameFrame.TILE_SIZE);

        gamePanel.getObj()[4] = new OBJ_Door();
        gamePanel.getObj()[4].setWorldX(13*GameFrame.TILE_SIZE);
        gamePanel.getObj()[4].setWorldY(21*GameFrame.TILE_SIZE);

        gamePanel.getObj()[5] = new OBJ_Door();
        gamePanel.getObj()[5].setWorldX(39*GameFrame.TILE_SIZE);
        gamePanel.getObj()[5].setWorldY(29*GameFrame.TILE_SIZE);

        gamePanel.getObj()[6] = new OBJ_Key();
        gamePanel.getObj()[6].setWorldX(19*GameFrame.TILE_SIZE);
        gamePanel.getObj()[6].setWorldY(47*GameFrame.TILE_SIZE);

        gamePanel.getObj()[7] = new OBJ_Door();
        gamePanel.getObj()[7].setWorldX(39*GameFrame.TILE_SIZE);
        gamePanel.getObj()[7].setWorldY(13*GameFrame.TILE_SIZE);

        gamePanel.getObj()[8] = new OBJ_StairsUp();
        gamePanel.getObj()[8].setWorldX(36*GameFrame.TILE_SIZE);
        gamePanel.getObj()[8].setWorldY(10*GameFrame.TILE_SIZE);

        gamePanel.getObj()[9] = new OBJ_Door();
        gamePanel.getObj()[9].setWorldX(38*GameFrame.TILE_SIZE);
        gamePanel.getObj()[9].setWorldY(25*GameFrame.TILE_SIZE);
    }
    public void setObjectWin(){
        gamePanel.getObj()[0] = new OBJ_chest();
        gamePanel.getObj()[0].setWorldX(26*GameFrame.TILE_SIZE);
        gamePanel.getObj()[0].setWorldY(26*GameFrame.TILE_SIZE);
    }

}
