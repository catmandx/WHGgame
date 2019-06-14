package game;

import java.awt.*;
import java.security.Key;

public class Player extends GameObject {

    public Player(){
        position.set(100,100);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect((int)position.x, (int)position.y, 20, 20);
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawRect((int)position.x, (int)position.y, 20, 20);
    }

    @Override
    public void run(){
        this.move();
        super.run();
    }

    private void move() {
        double vx = 0;
        double vy = 0;

        if(KeyEventPress.isUpPress) {
            vy -= 2;
        }
        if(KeyEventPress.isRightPress) {
            vx += 2;
        }
        if(KeyEventPress.isDownPress) {
            vy += 2;
        }
        if(KeyEventPress.isLeftPress) {
            vx -= 2;
        }

        velocity.set(vx, vy);
        velocity.setLength(2);
    }
}
