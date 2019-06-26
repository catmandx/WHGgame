package game.mapObjects.enemies;

import game.GameObject;
import game.Settings;
import game.mapObjects.Tile;
import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.OvalRenderer;

import java.awt.*;

public class Enemy2 extends GameObject {
    public Vector2D startPosition;
    public Vector2D endPosition;


    public Enemy2(){
        hitBox = new BoxCollider(this, (int)(Settings.ENEMY_DIMENSION * 0.9), (int)(Settings.ENEMY_DIMENSION * 0.9));
        renderer = new OvalRenderer(Settings.ENEMY_DIMENSION, Settings.ENEMY_DIMENSION, true);
        borderRenderer = new OvalRenderer(Settings.ENEMY_DIMENSION, Settings.ENEMY_DIMENSION, false);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        super.render(g);
    }

    @Override
    public void run() {
        this.velocity.set(endPosition.x - startPosition.x, endPosition.y - startPosition.y);
        if (this.velocity.getLength() > Settings.ENEMY_SPEED){
            this.velocity.setLength(Settings.ENEMY_SPEED);
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
        if (Math.abs(position.y - endPosition.y) < 4 ) {
            Vector2D temp = new Vector2D();
            temp.set(endPosition);
            endPosition.set(startPosition);
            startPosition.set(temp);
        }
    }
}