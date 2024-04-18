package com.game.Windows;

import com.game.entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel Gp){
        this.gamePanel = Gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.getWolrdX() + entity.getSolidArea().x;
        int entityRightWorldX = entity.getWolrdX() + entity.getSolidArea().x + entity.getSolidArea().width;
        int entityTopWorldY = entity.getWolrdY() + entity.getSolidArea().y;
        int entityBottomWorldY = entity.getWolrdY() + entity.getSolidArea().y + entity.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX / GameFrame.TILE_SIZE;
        int entityRightCol = entityRightWorldX / GameFrame.TILE_SIZE;
        int entityTopRow = entityTopWorldY / GameFrame.TILE_SIZE;
        int entityBottomRow = entityBottomWorldY / GameFrame.TILE_SIZE;

        int tilesNum1,tilesNum2;

        switch (entity.getDirection()){
            case "up":
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true || gamePanel.getTileManager().getTiles()[tilesNum2].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
                tilesNum2 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true || gamePanel.getTileManager().getTiles()[tilesNum2].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true || gamePanel.getTileManager().getTiles()[tilesNum2].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
                tilesNum2 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true || gamePanel.getTileManager().getTiles()[tilesNum2].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "rightUp":
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / GameFrame.TILE_SIZE;
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityTopRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "rightDown":
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / GameFrame.TILE_SIZE;
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityRightCol][entityBottomRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "leftUp":
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / GameFrame.TILE_SIZE;
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityTopRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
            case "leftDown":
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / GameFrame.TILE_SIZE;
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / GameFrame.TILE_SIZE;
                tilesNum1 = gamePanel.getTileManager().getMapTileNum()[entityLeftCol][entityBottomRow];
                if(gamePanel.getTileManager().getTiles()[tilesNum1].isCollision()==true){
                    entity.setCollisionOn(true);
                }
                break;
        }
    }
    public int checkObject(Entity entity, boolean havePlayer){
        int index =999;
        for (int i = 0; i <gamePanel.getObj().length ; i++) {
            if (gamePanel.getObj()[i]!=null) {
                //Get entity's solid area position
                entity.getSolidArea().x = entity.getWolrdX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWolrdY() + entity.getSolidArea().y;
                //get the object's solid area position
                gamePanel.getObj()[i].getSolidArea().x = gamePanel.getObj()[i].getWorldX() + gamePanel.getObj()[i].getSolidArea().x;
                gamePanel.getObj()[i].getSolidArea().y = gamePanel.getObj()[i].getWorldY() + gamePanel.getObj()[i].getSolidArea().y;

                switch (entity.getDirection()){
                    case "up":
                        entity.getSolidArea().y -= entity.getSpeed();
                        if (entity.getSolidArea().intersects(gamePanel.getObj()[i].getSolidArea())){
                            if (gamePanel.getObj()[i].isCollision() == true){
                                entity.setCollisionOn(true);
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.getSolidArea().y += entity.getSpeed();
                        if (entity.getSolidArea().intersects(gamePanel.getObj()[i].getSolidArea())){
                            if (gamePanel.getObj()[i].isCollision() == true){
                                entity.setCollisionOn(true);
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.getSolidArea().x -= entity.getSpeed();
                        if (entity.getSolidArea().intersects(gamePanel.getObj()[i].getSolidArea())){
                            if (gamePanel.getObj()[i].isCollision() == true){
                                entity.setCollisionOn(true);
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.getSolidArea().x += entity.getSpeed();
                        if (entity.getSolidArea().intersects(gamePanel.getObj()[i].getSolidArea())){
                            if (gamePanel.getObj()[i].isCollision() == true){
                                entity.setCollisionOn(true);
                            }
                            if (havePlayer){
                                index = i;
                            }
                        }
                        break;
                    
                }
                entity.getSolidArea().x = entity.getSolidDefaultX();
                entity.getSolidArea().y = entity.getSolidDefaultY();
                gamePanel.getObj()[i].getSolidArea().x = gamePanel.getObj()[i].getSolidAreaDefaultX();
                gamePanel.getObj()[i].getSolidArea().y = gamePanel.getObj()[i].getSolidAreaDefaultY();
            }
        }
        return index;

    }
}
