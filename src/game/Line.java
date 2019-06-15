package game;

import game.physics.BoxCollider;

import java.awt.*;

public class Line extends GameObject {
    public BoxCollider dimensions;

    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect((int)(dimensions.position.x - anchor.x * dimensions.width),
                (int)(dimensions.position.y - anchor.y * dimensions.height),
                (int)(dimensions.width),
                (int)(dimensions.height));
        g.setColor(Color.CYAN);
        g.drawRect((int)(hitBox.left()),
                (int)(hitBox.top()),
                (int)(hitBox.width),
                (int)(hitBox.height));
        g.setColor(Color.RED);
        g.fillOval((int) (position.x-3), (int)(position.y-3), 5,5);
    }
}
