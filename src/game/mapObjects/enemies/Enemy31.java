package game.mapObjects.enemies;

import game.Settings;
import game.Vector2D;
import game.mapObjects.Tile;
import game.physics.BoxCollider;
import game.renderer.OvalRenderer;

import java.awt.*;
import java.security.PublicKey;

public class Enemy31 extends Enemy{
    public Vector2D startPosition;
    public Vector2D endPosition;
    public int speed = 1;

    public Enemy31(){
        hitBox = new BoxCollider(this, (int)(Settings.ENEMY_DIMENSION * 0.9), (int)(Settings.ENEMY_DIMENSION * 0.9));
        renderer = new OvalRenderer((int)(Settings.ENEMY_DIMENSION * 0.9), (int)(Settings.ENEMY_DIMENSION * 0.9), true);
        borderRenderer = new OvalRenderer((int)(Settings.ENEMY_DIMENSION * 0.9), (int)(Settings.ENEMY_DIMENSION * 0.9), false);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        super.render(g);
    }

    @Override
    public void run() {
        this.velocity.set(endPosition.x - startPosition.x, endPosition.y - startPosition.y);
        if (this.velocity.getLength() > speed){
            this.velocity.setLength(speed);
        }
        this.checkPositions();
        super.run();
    }

    public void setPath(Tile startTile, Tile endTile){
        this.position.set(startTile.position);
        this.startPosition = new Vector2D(startTile.position.x, startTile.position.y);
        this.endPosition = new Vector2D(endTile.position.x, endTile.position.y);
    }

    public void checkPositions(){
        if (Math.abs(position.y - endPosition.y) < speed ) {
            Vector2D temp = new Vector2D();
            temp.set(endPosition);
            endPosition.set(startPosition);
            startPosition.set(temp);
        }
    }
}
