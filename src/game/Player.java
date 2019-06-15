package game;

import game.physics.BoxCollider;
import tklibs.Mathx;

import java.awt.*;

public class Player extends GameObject {
    BoxCollider line;
    public Player(){
        position.set(100,100);
        anchor = new Vector2D(0, 0);
        hitBox = new BoxCollider(this, 20, 20);
        line = new BoxCollider(new Vector2D(90,90), 0,30);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawRect((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        g.drawLine((int)(line.position.x - line.width * line.anchor.x),
                (int)(line.position.y - line.height * line.anchor.y),
                (int)(line.position.x - line.width * line.anchor.x),
                (int)(line.position.y - line.height * line.anchor.y)+line.height);
        g.setColor(Color.cyan);
        g.drawRect((int)(hitBox.position.x - hitBox.width * hitBox.anchor.x),
                (int)(hitBox.position.y - hitBox.height*hitBox.anchor.y),
                hitBox.width,
                hitBox.height);
        g.drawRect((int)(line.position.x - line.width * line.anchor.x),
                (int)(line.position.y - line.height * line.anchor.y),
                line.width,
                line.height);

    }

    @Override
    public void run(){
        this.move();
        this.limitPosition();
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
    int i =0;
    private void limitPosition(){
        if(this.hitBox.intersects(line)){
            if(hitBox.checkSides(line)=="left" && velocity.x < 0){
                velocity.x = 0;
                position.x = line.left();
            }
            if(hitBox.checkSides(line)=="right" && velocity.x > 0){
                velocity.x = 0;
                position.x = line.left()-20;
            }

        }
    }
}
