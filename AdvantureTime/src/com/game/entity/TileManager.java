package com.game.entity;

import com.game.Windows.GameFrame;
import com.game.Windows.GamePanel;
import com.game.Windows.InputManager;
import com.game.effect.ImageManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.game.effect.ImageManager1.*;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int[][] mapTileNum;
    public TileManager(GamePanel gP) {
            this.gamePanel = gP;
            tiles = new Tile[38];
            mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
            this.getImageMap();
            this.loadMap();
    }
    public void loadMap(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/com/game/data/world03.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col=0;
            int row=0;
            while(col<gamePanel.maxWorldCol && row<gamePanel.maxWorldRow){
                String line = bufferedReader.readLine();
                while (col<gamePanel.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col==gamePanel.maxWorldCol){
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
        try {
            tiles[0] = new Tile();
            tiles[0].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/000.png")));

            tiles[1] = new Tile();
            tiles[1].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/001.png")));
            tiles[1].collision = false;

            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/002.png")));
            tiles[2].collision=false;

            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/003.png")));

            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/004.png")));
            tiles[4].setCollision(false);

            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/005.png")));

            tiles[6] = new Tile();
            tiles[6].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/006.png")));

            tiles[7] = new Tile();
            tiles[7].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/007.png")));

            tiles[8] = new Tile();
            tiles[8].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/008.png")));

            tiles[9] = new Tile();
            tiles[9].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/009.png")));

            tiles[10] = new Tile();
            tiles[10].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/010.png")));

            tiles[11] = new Tile();
            tiles[11].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/011.png")));

            tiles[12] = new Tile();
            tiles[12].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/012.png")));

            tiles[13] = new Tile();
            tiles[13].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/013.png")));

            tiles[14] = new Tile();
            tiles[14].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/014.png")));

            tiles[15] = new Tile();
            tiles[15].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/015.png")));

            tiles[16] = new Tile();
            tiles[16].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/016.png")));
            tiles[16].collision=true;

            tiles[17] = new Tile();
            tiles[17].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/017.png")));

            tiles[18] = new Tile();
            tiles[18].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/018.png")));
            tiles[18].collision=true;

            tiles[19] = new Tile();
            tiles[19].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/019.png")));
            tiles[19].collision=true;

            tiles[20] = new Tile();
            tiles[20].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/020.png")));
            tiles[20].collision=true;

            tiles[21] = new Tile();
            tiles[21].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/021.png")));
            tiles[21].collision=true;

            tiles[22] = new Tile();
            tiles[22].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/022.png")));
            tiles[22].collision=true;

            tiles[23] = new Tile();
            tiles[23].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/023.png")));
            tiles[23].collision=true;

            tiles[24] = new Tile();
            tiles[24].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/024.png")));
            tiles[24].collision=true;

            tiles[25] = new Tile();
            tiles[25].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/025.png")));
            tiles[25].collision=true;

            tiles[26] = new Tile();
            tiles[26].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/026.png")));
            tiles[26].collision=true;

            tiles[27] = new Tile();
            tiles[27].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/027.png")));
            tiles[27].collision=true;

            tiles[28] = new Tile();
            tiles[28].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/028.png")));
            tiles[28].collision=true;

            tiles[29] = new Tile();
            tiles[29].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/029.png")));
            tiles[29].collision=true;

            tiles[30] = new Tile();
            tiles[30].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/030.png")));
            tiles[30].collision=true;

            tiles[31] = new Tile();
            tiles[31].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/031.png")));
            tiles[31].collision=true;

            tiles[32] = new Tile();
            tiles[32].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/032.png")));

            tiles[33] = new Tile();
            tiles[33].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/033.png")));

            tiles[34] = new Tile();
            tiles[34].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/034.png")));

            tiles[35] = new Tile();
            tiles[35].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/035.png")));

            tiles[36] = new Tile();
            tiles[36].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/036.png")));

            tiles[37] = new Tile();
            tiles[37].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/tiles/037.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        }
        public void draw(Graphics2D g2){
            int worldCol=0;
            int worldRow=0;

                while(worldRow< gamePanel.maxWorldRow && worldCol<gamePanel.maxWorldCol){
                    int tileType = mapTileNum[worldCol][worldRow];
                    int worldX = worldCol* GameFrame.TILE_SIZE;
                    int worldY = worldRow* GameFrame.TILE_SIZE;
                    int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.screenX;
                    int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.screenY;

                    if (worldX+GameFrame.TILE_SIZE>gamePanel.player.getWorldX()- gamePanel.player.screenX &&
                            worldX-GameFrame.TILE_SIZE<gamePanel.player.getWorldX()+gamePanel.player.screenX &&
                            worldY+GameFrame.TILE_SIZE>gamePanel.player.getWorldY()-gamePanel.player.screenY &&
                            worldY-GameFrame.TILE_SIZE<gamePanel.player.getWorldY()+gamePanel.player.screenY){
                        g2.drawImage(tiles[tileType].getImage(),screenX,screenY, GameFrame.TILE_SIZE,GameFrame.TILE_SIZE,null);
                    }
                    worldCol++;

                    if (worldCol==gamePanel.maxWorldCol){
                        worldCol=0;
                        worldRow++;

                    }
                }

        }
    }
