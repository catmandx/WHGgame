package game;

import game.physics.BoxCollider;

import javax.swing.*;
import java.awt.*;

public class VLine extends Line {

    public VLine(Vector2D position){
        this.active = true;
        this.position = position;


            this.dimensions = new BoxCollider(this,4, 30);
            this.hitBox = new BoxCollider(this, 5, 28);

    }
}
