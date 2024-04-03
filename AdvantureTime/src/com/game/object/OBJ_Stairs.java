package com.game.object;

import static com.game.effect.ImageManager1.SPR_stairs;

public class OBJ_Stairs extends SuperObject{
    public OBJ_Stairs(){
        this.name = "stairs";
        this.image = SPR_stairs;
        this.collision = false;
    }
}
