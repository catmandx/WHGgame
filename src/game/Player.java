package game;

import game.physics.BoxCollider;

import java.awt.*;

public class Player extends GameObject {
    public Player(){
        this.active = true;
        position.set(100,100);
        hitBox = new BoxCollider(this, 20, 20);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawRect((int)(position.x - 20 * anchor.x), (int)(position.y- 20 * anchor.y), 20, 20);
        g.setColor(Color.cyan);
        ((Graphics2D)g).setStroke(new BasicStroke(1));
        g.drawRect((int)(hitBox.left()),
                (int)(hitBox.top()),
                hitBox.width,
                hitBox.height);
        g.setColor(Color.YELLOW);
        g.fillOval((int) (position.x-3), (int)(position.y-3), 5,5);

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

//
//        if(this.hitBox.intersects(line2)){
//            if(hitBox.checkTopBottom(line2)=="top" && velocity.y <= 0){
//                velocity.y = 0;
//                position.y = line2.bot()+anchor.y * hitBox.height;
//            }else if(hitBox.checkTopBottom(line2)=="bottom" && velocity.y >= 0){
//                velocity.y = 0;
//                position.y = line2.top()- hitBox.height + anchor.y * hitBox.height;
//            }
//        }
        VLine line = GameObject.findIntersects(VLine.class, this.hitBox);
        if(line != null){
            if(hitBox.checkSides(line.hitBox)=="left" && velocity.x <= 0){
                velocity.x = 0;
                position.x = line.hitBox.right()+anchor.x*hitBox.width;
            } else if(hitBox.checkSides(line.hitBox)=="right" && velocity.x >= 0){
                velocity.x = 0;
                position.x = line.hitBox.left()- hitBox.width + anchor.x*hitBox.width;
            }
        }

        HLine hLine = GameObject.findIntersects(HLine.class, this.hitBox);
        if(hLine != null){
            if(hitBox.checkTopBottom(hLine.hitBox)=="top" && velocity.y <= 0){
                velocity.y = 0;
                position.y = hLine.hitBox.bot()+anchor.y * hitBox.height;
            }else if(hitBox.checkTopBottom(hLine.hitBox)=="bottom" && velocity.y >= 0){
                velocity.y = 0;
                position.y = hLine.hitBox.top()- hitBox.height + anchor.y * hitBox.height;
            }
        }
    }
}
