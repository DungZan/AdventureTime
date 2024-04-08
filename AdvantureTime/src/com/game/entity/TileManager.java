package com.game.entity;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.Windows.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int[][] mapTileNum;
    public TileManager(GamePanel gP) {
            this.gamePanel = gP;
            tiles = new Tile[50];
            mapTileNum = new int[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldCol()];
            this.getImageMap();
            this.loadMap("world03");
    }
    public void loadMap(String filename){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/com/game/data/"+filename+".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col=0;
            int row=0;
            while(col<gamePanel.getMaxWorldCol() && row<gamePanel.getMaxWorldRow()){
                String line = bufferedReader.readLine();
                while (col<gamePanel.getMaxWorldCol()){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col==gamePanel.getMaxWorldCol()){
                    col=0;
                    row++;
                }
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void getImageMap() {
            setupImage(0,"000",false);
            setupImage(1,"001",false);
            setupImage(2,"002",false);
            setupImage(3,"003",false);
            setupImage(4,"004",false);
            setupImage(5,"005",false);
            setupImage(6,"006",false);
            setupImage(7,"007",false);
            setupImage(8,"008",false);
            setupImage(9,"009",false);
            setupImage(10,"010",false);
            setupImage(11,"011",false);
            setupImage(12,"012",false);
            setupImage(13,"013",false);
            setupImage(14,"014",false);
            setupImage(15,"015",false);
            setupImage(16,"016",true);
            setupImage(17,"017",false);
            setupImage(18,"018",true);
            setupImage(19,"019",true);
            setupImage(20,"020",true);
            setupImage(21,"021",true);
            setupImage(22,"022",true);
            setupImage(23,"023",true);
            setupImage(24,"024",true);
            setupImage(25,"025",true);
            setupImage(26,"026",true);
            setupImage(27,"027",true);
            setupImage(28,"028",true);
            setupImage(29,"029",true);
            setupImage(30,"030",true);
            setupImage(31,"031",true);
            setupImage(32,"032",true);
            setupImage(33,"033",false);
            setupImage(34,"034",false);
            setupImage(35,"035",false);
            setupImage(36,"036",false);
            setupImage(37,"037",false);
            setupImage(38,"038",false);
            setupImage(39,"039",false);
            setupImage(40,"040",true);
            setupImage(41,"041",true);
            setupImage(42,"042",true);
            setupImage(43,"043",true);
            setupImage(44,"044",true);
            setupImage(45,"045",true);
            setupImage(46,"046",false);
            setupImage(47,"047",false);
            setupImage(48,"048",true);

        }
        public void setupImage(int index,String path,boolean collision){
            UtilityTool utilityTool = new UtilityTool();
            try {
                tiles[index] = new Tile();
                tiles[index].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/"+path+".png")));
                tiles[index].setImage(utilityTool.scaleImage(tiles[index].getImage(),GameFrame.TILE_SIZE,GameFrame.TILE_SIZE));
                tiles[index].collision = collision;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        public void draw(Graphics2D g2){
            int worldCol=0;
            int worldRow=0;

                while(worldRow< gamePanel.getMaxWorldRow() && worldCol<gamePanel.getMaxWorldCol()){
                    int tileType = mapTileNum[worldCol][worldRow];
                    int worldX = worldCol* GameFrame.TILE_SIZE;
                    int worldY = worldRow* GameFrame.TILE_SIZE;
                    int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().screenX;
                    int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().screenY;

                    if (worldX+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldX()- gamePanel.getPlayer().screenX &&
                            worldX-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldX()+gamePanel.getPlayer().screenX &&
                            worldY+GameFrame.TILE_SIZE>gamePanel.getPlayer().getWorldY()-gamePanel.getPlayer().screenY &&
                            worldY-GameFrame.TILE_SIZE<gamePanel.getPlayer().getWorldY()+gamePanel.getPlayer().screenY){
                        g2.drawImage(tiles[tileType].getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
                    }
                    worldCol++;

                    if (worldCol==gamePanel.getMaxWorldCol()){
                        worldCol=0;
                        worldRow++;

                    }
                }

        }
    }
