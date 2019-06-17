package game.wall;

import game.GameObject;
import game.physics.BoxCollider;

import java.awt.*;

public class Line extends GameObject {

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        super.render(g);
    }
}
