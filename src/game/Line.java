package game;

import game.physics.BoxCollider;

import java.awt.*;

public class Line extends GameObject {
    public BoxCollider dimensions;

    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int)(dimensions.position.x - anchor.x * dimensions.width),
                (int)(dimensions.position.y - anchor.y * dimensions.height),
                (int)(dimensions.width),
                (int)(dimensions.height));
        super.paint(g);
    }
}
