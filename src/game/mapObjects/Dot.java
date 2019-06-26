package game.mapObjects;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.renderer.OvalRenderer;

import java.awt.*;

public class Dot extends GameObject {
    public Dot(){
        hitBox = new BoxCollider(this, (int)(Settings.DOT_DIMENSION*0.9),  (int)(Settings.DOT_DIMENSION*0.9));
        renderer = new OvalRenderer(Settings.DOT_DIMENSION, Settings.DOT_DIMENSION, true);
        borderRenderer = new OvalRenderer(Settings.DOT_DIMENSION, Settings.DOT_DIMENSION, false);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        super.render(g);
    }


}
