package com.game.Windows;

import com.game.entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel Gp){
        this.gamePanel = Gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.wolrdX + entity.solidArea.x;
        int entityRightWorldX = entity.wolrdX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.wolrdY + entity.solidArea.y;
        int entityBottomWorldY = entity.wolrdY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GameFrame.TILE_SIZE;
        int entityRightCol = entityRightWorldX / GameFrame.TILE_SIZE;
        int entityTopRow = entityTopWorldY / GameFrame.TILE_SIZE;
        int entityBottomRow = entityBottomWorldY / GameFrame.TILE_SIZE;

        int tilesNum1,tilesNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileManager.tiles[tilesNum1].collision==true || gamePanel.tileManager.tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tilesNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileManager.tiles[tilesNum1].collision==true || gamePanel.tileManager.tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tilesNum1].collision==true || gamePanel.tileManager.tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tilesNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tilesNum1].collision==true || gamePanel.tileManager.tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
    public int checkObject(Entity entity, boolean havePlayer){
        int index =999;
        for (int i = 0; i <gamePanel.obj.length ; i++) {
            if (gamePanel.obj[i]!=null) {
                //Get entity's solid area position
                
            }
        }
        return index;

    }
}
