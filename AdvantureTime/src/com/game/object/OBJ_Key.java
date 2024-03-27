package com.game.object;

import static com.game.effect.ImageManager1.SPR_key;

public class OBJ_Key extends SuperObject{
    public OBJ_Key(){
        this.name = "key";
        this.image = SPR_key;
        this.collision = true;
    }
}
