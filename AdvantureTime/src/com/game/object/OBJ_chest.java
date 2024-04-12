package com.game.object;

import static com.game.effect.ImageManager1.SPR_chest;

public class OBJ_chest extends SuperObject{
    public OBJ_chest(){
        this.name = "chest";
        this.image = SPR_chest;
        this.collision = true;
    }
}
