package game.wall;

import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;

public class HLine extends Line {

    public HLine() {
        renderer = new BoxRenderer(Settings.TILE_SIZE+2, Settings.WALL_THICKNESS, true);
        this.active = true;
        this.position = new Vector2D();
        this.hitBox = new BoxCollider(this, Settings.TILE_SIZE, Settings.WALL_THICKNESS);
    }

}
