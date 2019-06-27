package game.mapObjects;

import game.GameObject;
import game.KeyEventPress;
import game.Scene.Game_over.GameoverScene;
import game.Scene.SceneManager;
import game.Settings;
import game.map.MapManager;
import game.mapObjects.enemies.Enemy;
import game.mapObjects.enemies.Enemy1;
import game.physics.BoxCollider;
import game.renderer.BoxRenderer;
import game.mapObjects.wall.HLine;
import game.mapObjects.wall.VLine;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        this.active = true;
        position.set(300, 200);
        hitBox = new BoxCollider(this, Settings.PLAYER_DIMENSION, Settings.PLAYER_DIMENSION);
        renderer = new BoxRenderer(Settings.PLAYER_DIMENSION, Settings.PLAYER_DIMENSION, true);
        borderRenderer = new BoxRenderer(Settings.PLAYER_DIMENSION, Settings.PLAYER_DIMENSION, false);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        super.render(g);
    }

    @Override
    public void run() {
        this.move();
        this.checkEnemy();
        this.checkDot();
        this.limitPosition();
        super.run();
    }

    private void checkDot(){
        Dot dot = GameObject.findIntersects(Dot.class, this.hitBox);
        if(dot!=null){
            dot.deactive();
            MapManager.currentMap.numberOfDots--;
        }
    }
    private void checkEnemy() {
        if (!KeyEventPress.isImmortal) {
            Enemy enemy1 = GameObject.findIntersects(Enemy.class, this.hitBox);
            if (enemy1 != null) {
                Settings.NUMBER_OF_DEATHS++;
                this.deactive();
            }
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new GameoverScene());
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
//     */
//    private void checkGoal(){
//        Tile goal = GameObject.findIntersects(Tile.class, this.hitBox);
//        if(goal != null){
//            System.out.println("You win!");
//        }
//    }
}
