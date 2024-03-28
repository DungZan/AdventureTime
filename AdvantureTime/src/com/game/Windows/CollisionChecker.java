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
                entity.solidArea.x = entity.wolrdX + entity.solidArea.x;
                entity.solidArea.y = entity.wolrdY + entity.solidArea.y;
                //get the object's solid area position
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;

                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if (gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidDefaultX;
                entity.solidArea.y = entity.solidDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
            }
        }
        return index;

    }
}
