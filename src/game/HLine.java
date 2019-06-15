package game;

import game.physics.BoxCollider;

import java.awt.*;

public class HLine extends Line {

    public HLine(Vector2D position){
        this.active = true;
        this.position = position;
            this.dimensions = new BoxCollider(this,30, 4);
            this.hitBox = new BoxCollider(this, 28, 5);
    }
}
