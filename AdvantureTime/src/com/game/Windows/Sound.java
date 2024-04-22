package com.game.Windows;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static com.game.effect.ImageManager1.SPR_sound_off;
import static com.game.effect.ImageManager1.SPR_sound_on;

public class Sound {
    private Clip clip;
    private boolean playing=true;
    private BufferedImage image;
    URL soundURL[]=new URL[5];
    private FloatControl volumeControl;
    private float volume = 1.0f; // Mức âm thanh mặc định
    public Sound(){
        soundURL[0]=getClass().getResource("/resources/sounds/door/0.wav");
        soundURL[1]=getClass().getResource("/resources/sounds/Background.wav");
        soundURL[2]=getClass().getResource("/resources/sounds/CollectKey.wav");
        soundURL[3]=getClass().getResource("/resources/sounds/MoveA.wav");
        soundURL[4]=getClass().getResource("/resources/sounds/MoveDownStairs.wav");
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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
