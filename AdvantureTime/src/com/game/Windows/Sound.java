package com.game.Windows;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static com.game.effect.ImageManager1.SPR_sound_off;
import static com.game.effect.ImageManager1.SPR_sound_on;

public class Sound {
    public Clip clip;
    public boolean playing=true;
    public BufferedImage image;
    URL soundURL[]=new URL[30];
    public Sound(){
        soundURL[0]=getClass().getResource("/resources/sounds/door/0.wav");
        soundURL[1]=getClass().getResource("/resources/sounds/Background.wav");
        soundURL[2]=getClass().getResource("/resources/sounds/CollectKey.wav");
        soundURL[3]=getClass().getResource("/resources/sounds/MoveA.wav");
        soundURL[4]=getClass().getResource("/resources/sounds/MoveDownStairs.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void playSound(){
        clip.start();
        playing=true;
        image = SPR_sound_on;
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
        playing=false;
        image = SPR_sound_off;
    }

}
