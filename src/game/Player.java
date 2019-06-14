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
        if(KeyEventPress.isLeftPress){
            velocity.x = -1;
        }else if(!KeyEventPress.isLeftPress){
            velocity.x=0;
        }
        super.run();
    }
}
