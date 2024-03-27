package com.game.effect;

import java.util.Hashtable;

public class DataLoader {
    private static DataLoader instance =null;
    private Hashtable<String,ImageManager> frameimage;
    private Hashtable<String,Animation> animation;
    private DataLoader(){

    }

    public static DataLoader getInstance() {
        if(instance==null){
            instance = new DataLoader();
        }
        return instance;
    }
}
