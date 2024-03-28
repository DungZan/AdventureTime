package com.game.object;

import static com.game.effect.ImageManager1.SPR_bolt;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots(){
        this.name = "Boots";
        this.image = SPR_bolt;
        this.collision = true;
    }

}
