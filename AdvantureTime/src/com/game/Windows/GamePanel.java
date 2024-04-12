package com.game.Windows;

import com.game.effect.ImageManager1;
import com.game.entity.Player;
import com.game.entity.TileManager;
import com.game.object.OBJ_Flag;
import com.game.object.OBJ_campf;
import com.game.object.SuperObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePanel extends JPanel implements Runnable,KeyListener {
    private Thread thread;
    private boolean isRunning;
    private InputManager inputManager = new InputManager();

    //player component
    private Player player;
    private TileManager tileManager = new TileManager(this);

    //collision checker
    private CollisionChecker collisionChecker = new CollisionChecker(this);
    private UI ui = new UI(this);
    private AssetSetter assetSetter = new AssetSetter(this);
    private SuperObject obj[] = new SuperObject[10];

    //world component setting
    private final int maxWorldCol=50;
    private final int maxWorldRow=50;

    //sound
    private Sound music = new Sound();
    private Sound se = new Sound();
    //animation obj
    private OBJ_Flag flag;
    private OBJ_campf campf;

    public Player getPlayer() {
        return player;
    }
    public TileManager getTileManager() {
        return tileManager;
    }
    public CollisionChecker getCollisionChecker() {
        return collisionChecker;
    }
    public UI getUi() {
        return ui;
    }
    public SuperObject[] getObj() {
        return obj;
    }
    public int getMaxWorldCol() {
        return maxWorldCol;
    }
    public int getMaxWorldRow() {
        return maxWorldRow;
    }
    public Sound getSe() {
        return se;
    }
    public Sound getMusic() {
        return music;
    }
    public OBJ_Flag getFlag() {
        return flag;
    }
    public OBJ_campf getCampf() {
        return campf;
    }

    //game state
    public int gameState;
    public static final int menuState =0;
    public static final int playState =1;
    public static final int aboutState =2;
    public GamePanel(){
        this.setBackground(Color.darkGray);
        ImageManager1 imageManager1 = new ImageManager1();
        player = new Player(this,inputManager);
        flag = new OBJ_Flag();
        campf = new OBJ_campf();
    }
    public void setupGame(){
        assetSetter.setObjects();
        playMusic(1);
        gameState = menuState;
    }
    public void setupDungeon(){
        assetSetter.setObjectDungeon();
        gameState = playState;
    }
    public void setupWin(){
        assetSetter.setObjectWin();
        gameState = playState;
    }
    public void clearObjects(){
        for (int i=0;i<obj.length;i++){
            obj[i] = null;
        }
    }
    public void update(){
        if (gameState == playState){
            player.update();
            flag.update();
            campf.update();
        }
        if (gameState == menuState){
            //menu
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == menuState){
            //draw menu
            ui.draw(g2);
        }else {
            // draw tile
            tileManager.draw(g2);
            // draw object
            for (int i=0;i<obj.length;i++){
                if (obj[i]!=null){
                    obj[i].draw(g2,this);
                }
            }
            //draw player
            player.draw(g2);
            //draw UI
            ui.draw(g2);
            g2.dispose();
        }

    }
    public void playMusic(int i){
        music.setFile(i);
        music.playSound();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.playSound();
    }
    public void startGame(){
        if (thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run() {
        int FPS=60;
        double drawInterval = 1e9 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // calculate FPS
        long timer = 0;
        int drawCount = 0;

        while (isRunning) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            // show FPS
            if (timer >= 1e9) {
                System.out.println("FPS: " + drawCount);
                timer = 0;
                drawCount = 0;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //...
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Bạn đang bấm");
        inputManager.processKeyPressed(e.getKeyCode(),this);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Bạn đã bỏ bấm");
        inputManager.processKeyReleased(e.getKeyCode(),this);
    }
}

