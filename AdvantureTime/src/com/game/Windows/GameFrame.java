package com.game.Windows;

import javax.swing.*;
import java.awt.*;

public class
GameFrame extends JFrame {
    public static final int TILE_SIZE = 48;
    public static final int SC_WIDTH=1080;
    public static final int SC_HEIGHT=720;
    private ImageIcon icon = new ImageIcon("src/resources/sprites/player/1/1.png");
    GamePanel gamePanel;
    public GameFrame(){
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width-SC_WIDTH)/2,(dimension.height-SC_HEIGHT)/2,SC_WIDTH,SC_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game 2D");
        gamePanel = new GamePanel();
        add(gamePanel);
        this.addKeyListener(gamePanel);
        this.setFocusable(true);
        setLocationRelativeTo(null);
        setResizable(false);
        // icon
        this.setIconImage(icon.getImage());
        gamePanel.setupGame();
    }

    public void startGame(){
        gamePanel.startGame();
    }


}
