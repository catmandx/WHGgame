package game.renderer;

import game.GameObject;

import java.awt.*;

public class OvalRenderer extends Renderer {
    int width;
    int height;
    boolean isFill;

    public OvalRenderer(int width, int height, boolean isFill){
        this.width = width;
        this.height = height;
        this.isFill = isFill;
    }

    @Override
    public void render(Graphics g, GameObject master){
        if(isFill){
            g.fillOval(
                    (int) (master.position.x - master.anchor.x * width),
                    (int) (master.position.y - master.anchor.y *height),
                    width,
                    height
            );
        }else{
            g.drawOval(
                    (int) (master.position.x - master.anchor.x * width),
                    (int) (master.position.y - master.anchor.y *height),
                    width,
                    height
            );
        }
        //Vẽ Hitbox và Position
        super.render(g, master);
    }
}
