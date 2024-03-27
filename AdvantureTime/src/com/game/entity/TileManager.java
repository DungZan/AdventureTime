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
            tiles = new Tile[10];
            mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
            this.getImageMap();
            this.loadMap();
    }
    public void loadMap(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/com/game/data/world01.txt");
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
            tiles[0].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/ground/2.png")));

            tiles[1] = new Tile();
            tiles[1].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/wall/0.png")));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/Stairs.png")));
            tiles[2].collision=true;

            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/KeyDoor.png")));

            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/SwitchDoor.png")));
            tiles[4].setCollision(true);

            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/parallax_bg/0.png")));

            tiles[6] = new Tile();
            tiles[6].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/ground/1.png")));

            tiles[7] = new Tile();
            tiles[7].setImage(ImageIO.read(getClass().getResourceAsStream("/resources/sprites/ground/0.png")));

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
