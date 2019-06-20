package game;

import game.physics.BoxCollider;
import game.renderer.OvalRenderer;

import java.awt.*;

public class Enemy extends GameObject {
    public Enemy(){
        position.set(200,200);
        hitBox = new BoxCollider(this, Settings.ENEMY_DIMENSION, Settings.ENEMY_DIMENSION);
        renderer = new OvalRenderer(Settings.ENEMY_DIMENSION, Settings.ENEMY_DIMENSION, true);
        borderRenderer = new OvalRenderer(Settings.ENEMY_DIMENSION, Settings.ENEMY_DIMENSION, false);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        super.render(g);
    }
}
