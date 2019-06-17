package game;

import game.GameObject;
import game.physics.BoxCollider;

import java.awt.*;

public class Enemy extends GameObject {
    public Enemy(){
        position.set(200,200);
        hitBox = new BoxCollider(this, 21, 21);
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        g.setColor(Color.black);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawOval((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        ((Graphics2D)g).setStroke(new BasicStroke(1));
        super.render(g);
    }
}
