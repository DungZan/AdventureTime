package com.game.object;

import static com.game.effect.ImageManager1.SPR_stairsUp;

public class OBJ_StairsUp extends SuperObject{
    public OBJ_StairsUp(){
        this.name = "stairsUp";
        this.image = SPR_stairsUp;
        this.collision = false;
    }
}
