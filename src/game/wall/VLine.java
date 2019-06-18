package game.wall;

import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;

public class VLine extends Line {

    public VLine() {
        renderer = new BoxRenderer(4, 32, true);
        this.active = true;
        this.position = new Vector2D();
        this.hitBox = new BoxCollider(this, 5, 28);
    }


}
