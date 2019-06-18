package game.wall;

import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;

public class HLine extends Line {

    public HLine() {
        renderer = new BoxRenderer(32, 4, true);
        this.active = true;
        this.position = new Vector2D();
        this.hitBox = new BoxCollider(this, 28, 5);
    }

}
