package game;

import game.physics.BoxCollider;
import game.renderer.BoxRenderer;
import game.wall.HLine;
import game.wall.VLine;

import java.awt.*;

public class Player extends GameObject {
    int i = 0;

    public Player() {
        this.active = true;
        position.set(300, 200);
        hitBox = new BoxCollider(this, 20, 20);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.PINK);
        g.fillRect((int) (position.x - 20 * anchor.x), (int) (position.y - 20 * anchor.y), 20, 20);
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        g.drawRect((int) (position.x - 20 * anchor.x), (int) (position.y - 20 * anchor.y), 20, 20);
        ((Graphics2D) g).setStroke(new BasicStroke(1));
        super.render(g);


        g.setColor(Color.CYAN);
        try {
            g.drawRect((int) (hitBox.left()),
                    (int) (hitBox.top()),
                    hitBox.width,
                    hitBox.height);
        }catch (Exception e){
        }
        g.setColor(Color.YELLOW);
        g.fillOval((int) (position.x - 3), (int) (position.y - 3), 5, 5);
    }

    @Override
    public void run() {
        this.move();
        this.checkEnemy() ;

//        this.checkGoal();
        this.limitPosition();
        super.run();
    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.hitBox);
        if (enemy != null) {
            System.out.println("collide");
            this.deactive();
        }
    }

    private void move() {
        double vx = 0;
        double vy = 0;

        if (KeyEventPress.isUpPress) {
            vy -= 2;
        }
        if (KeyEventPress.isRightPress) {
            vx += 2;
        }
        if (KeyEventPress.isDownPress) {
            vy += 2;
        }
        if (KeyEventPress.isLeftPress) {
            vx -= 2;
        }

        velocity.set(vx, vy);
        velocity.setLength(2);
    }

    private void limitPosition() {
        //LIMIT X
        VLine vLine = GameObject.findIntersects(VLine.class, this.hitBox);
        if (vLine != null) {
            if (hitBox.checkSides(vLine.hitBox) == "left" && velocity.x <= 0) {
                velocity.x = 0;
                position.x = vLine.hitBox.right() + anchor.x * hitBox.width;
            } else if (hitBox.checkSides(vLine.hitBox) == "right" && velocity.x >= 0) {
                velocity.x = 0;
                position.x = vLine.hitBox.left() - hitBox.width + anchor.x * hitBox.width;
            }
        }
        //LIMIT Y
        HLine hLine = GameObject.findIntersects(HLine.class, this.hitBox);
        if (hLine != null) {
            if (hitBox.checkTopBottom(hLine.hitBox) == "top" && velocity.y <= 0) {
                velocity.y = 0;
                position.y = hLine.hitBox.bot() + anchor.y * hitBox.height;
            } else if (hitBox.checkTopBottom(hLine.hitBox) == "bottom" && velocity.y >= 0) {
                velocity.y = 0;
                position.y = hLine.hitBox.top() - hitBox.height + anchor.y * hitBox.height;
            }
        }
    }

    /**
     * Kiểm tra xem Player có chạm vào Goal Tile hay không.
     */
    private void checkGoal(){
        Tile goal = GameObject.findIntersects(Tile.class, this.hitBox);
        if(goal != null){
            System.out.println("You win!");
        }
    }
}
