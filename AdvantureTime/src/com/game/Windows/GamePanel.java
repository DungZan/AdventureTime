package com.game.Windows;

import com.game.effect.Animation;
import com.game.effect.ImageManager1;
import com.game.entity.Player;
import com.game.entity.TileManager;
import com.game.object.SuperObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.game.effect.ImageManager1.*;


public class GamePanel extends JPanel implements Runnable,KeyListener {
    public Animation[] animation = new Animation[]{new Animation(this)};
    private Thread thread;
    private boolean isRunning;
    private InputManager inputManager = new InputManager();
    //player component
    public Player player = new Player(this,inputManager);
    TileManager tileManager = new TileManager(this);
    //collision checker
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public UI ui = new UI(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public SuperObject obj[] = new SuperObject[10];
    //world component setting
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int WorldWidth=maxWorldCol*GameFrame.TILE_SIZE;
    public final int WorldHeight=maxWorldRow*GameFrame.TILE_SIZE;
    //sound
    Sound music = new Sound();
    Sound se = new Sound();
    //game state
    public int gameState;
    public static final int menuState =0;
    public static final int playState =1;
    public static final int pauseState =2;
    public static final int aboutState =3;
    public GamePanel(){
        this.setBackground(Color.darkGray);
        ImageManager1 imageManager1 = new ImageManager1();
        animation[0].setDelay(100);
        animation[0].setFrames(SPR_flag);
        Timer timer = new Timer(10,e -> animation[0].update());
        timer.start();
    }
    public void setupGame(){
        assetSetter.setObjects();
        playMusic(1);
        gameState = menuState;
    }
    public void update(){
        if (gameState == playState){
            player.update();
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
            g2.drawImage(animation[0].getImage(),26*GameFrame.TILE_SIZE-player.getWorldX() + player.screenX,27*GameFrame.TILE_SIZE-player.getWorldY() + player.screenY,48,48,null);
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
