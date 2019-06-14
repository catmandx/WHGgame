package game;

import java.awt.*;

public class Background extends GameObject{

    public Background(){
        position = new Vector2D(0,0);
        velocity = new Vector2D(0,0);
    }
    public void paint(Graphics g){
        g.setColor(new Color(181,181, 255));
        g.fillRect(0,0,20, 20);
    }
}
