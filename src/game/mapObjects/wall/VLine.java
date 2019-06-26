package game.mapObjects.wall;

import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;

public class VLine extends Line {

    public VLine() {
        renderer = new BoxRenderer(Settings.WALL_THICKNESS, Settings.TILE_SIZE+2, true);
        this.active = true;
        this.position = new Vector2D();
        this.hitBox = new BoxCollider(this, Settings.WALL_THICKNESS, Settings.TILE_SIZE);
    }
}
