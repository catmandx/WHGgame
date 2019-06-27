package game.mapObjects.enemies;

import game.Settings;
import game.Vector2D;
import game.mapObjects.Tile;
import game.physics.BoxCollider;
import game.renderer.OvalRenderer;

import java.awt.*;

public class Enemy4 extends Enemy {
    public double circumfrence;
    public Vector2D center;
    public double currentAngle;
    private final double degree = 3.14159 / 180;
    public int angularVelocity;

    public Enemy4(){
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
        position.x =(int) (circumfrence * Math.cos(currentAngle) + center.x);
        position.y =(int) (circumfrence * Math.sin(currentAngle) + center.y);
        currentAngle += (angularVelocity * degree) / (1000/64);
    }

    public void setInfo(double circumfrence, Vector2D center, int angularVelocity, double currentAngle){
        this.circumfrence = circumfrence * Settings.TILE_DIMENSIONS;
        this.center.set(center);
        this.angularVelocity = angularVelocity;
        this.currentAngle = currentAngle;
    }



}
