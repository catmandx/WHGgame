package game.renderer;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;

public class BoxRenderer extends Renderer {
    int width;
    int height;
    boolean isFill;

    public BoxRenderer(int width, int height, boolean isFill){
        this.width = width;
        this.height = height;
        this.isFill = isFill;
    }
    @Override
    public void render(Graphics g, GameObject master){
        if(isFill){
            g.fillRect(
                    (int) (master.position.x - master.anchor.x * width),
                    (int) (master.position.y - master.anchor.y *height),
                    width,
                    height
            );
        }else{
            g.drawRect(
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
