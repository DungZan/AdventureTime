package com.game.object;

import static com.game.effect.ImageManager1.SPR_key_door;

public class OBJ_Door extends SuperObject {
    public OBJ_Door(){
        this.name = "door";
        this.image = SPR_key_door;
        this.collision = true;
    }

}
