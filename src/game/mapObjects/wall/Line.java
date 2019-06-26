package game.mapObjects.wall;

import game.GameObject;

import java.awt.*;

public class Line extends GameObject {

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        super.render(g);
    }
}
