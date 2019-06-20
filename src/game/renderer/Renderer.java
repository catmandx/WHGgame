package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Renderer {
    public void render(Graphics g, GameObject master){

        //Hitbox & Tam
//
//        ((Graphics2D) g).setStroke(new BasicStroke(1));
//        g.setColor(Color.CYAN);
//        try {
//            g.drawRect((int) (master.hitBox.left()),
//                    (int) (master.hitBox.top()),
//                    master.hitBox.width,
//                    master.hitBox.height);
//        }catch(Exception e){
//
//        }
//        g.setColor(Color.YELLOW);
//        g.fillOval((int) (master.position.x - 3), (int) (master.position.y - 3), 5, 5);
    }

    public void drawImage(Graphics g, GameObject master, BufferedImage image) {
        g.drawImage(image,
                (int) (master.position.x - image.getWidth() * master.anchor.x),
                (int) (master.position.y - image.getHeight() * master.anchor.y),
                null);

        g.setColor(Color.CYAN);
        try {
            g.drawRect((int) (master.hitBox.left()),
                    (int) (master.hitBox.top()),
                    master.hitBox.width,
                    master.hitBox.height);
        }catch (Exception e){

        }
        g.setColor(Color.YELLOW);
        g.fillOval((int) (master.position.x - 3), (int) (master.position.y - 3), 5, 5);
    }
}
