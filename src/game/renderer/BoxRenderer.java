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
            g.fillRect(
                    (int) (master.position.x - master.anchor.x * width),
                    (int) (master.position.y - master.anchor.y *height),
                    width,
                    height
                    );
        }
        //Vẽ Hitbox và Position
        //Vẽ Hitbox và Position

//        g.setColor(Color.CYAN);
//        try {
//            g.drawRect((int) (master.hitBox.left()),
//                    (int) (master.hitBox.top()),
//                    master.hitBox.width,
//                    master.hitBox.height);
//        }catch (Exception e){
//
//        }
//        g.setColor(Color.YELLOW);
//        g.fillOval((int) (master.position.x - 3), (int) (master.position.y - 3), 5, 5);
    }
}
