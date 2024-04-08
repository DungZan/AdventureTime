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
                tilesNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.getTileManager().tiles[tilesNum1].collision==true || gamePanel.getTileManager().tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityBottomRow];
                tilesNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.getTileManager().tiles[tilesNum1].collision==true || gamePanel.getTileManager().tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.getTileManager().tiles[tilesNum1].collision==true || gamePanel.getTileManager().tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.getTileManager().tiles[tilesNum1].collision==true || gamePanel.getTileManager().tiles[tilesNum2].collision==true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
    public int checkObject(Entity entity, boolean havePlayer){
        int index =999;
        for (int i = 0; i <gamePanel.getObj().length ; i++) {
            if (gamePanel.getObj()[i]!=null) {
                //Get entity's solid area position
                entity.solidArea.x = entity.wolrdX + entity.solidArea.x;
                entity.solidArea.y = entity.wolrdY + entity.solidArea.y;
                //get the object's solid area position
                gamePanel.getObj()[i].solidArea.x = gamePanel.getObj()[i].worldX + gamePanel.getObj()[i].solidArea.x;
                gamePanel.getObj()[i].solidArea.y = gamePanel.getObj()[i].worldY + gamePanel.getObj()[i].solidArea.y;

                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.getObj()[i].solidArea)){
                            if (gamePanel.getObj()[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.getObj()[i].solidArea)){
                            if (gamePanel.getObj()[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gamePanel.getObj()[i].solidArea)){
                            if (gamePanel.getObj()[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gamePanel.getObj()[i].solidArea)){
                            if (gamePanel.getObj()[i].collision == true){
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
                gamePanel.getObj()[i].solidArea.x = gamePanel.getObj()[i].solidAreaDefaultX;
                gamePanel.getObj()[i].solidArea.y = gamePanel.getObj()[i].solidAreaDefaultY;
            }
        }
        return index;

    }
}
