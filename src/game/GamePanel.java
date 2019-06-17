package game;

import game.wall.HLine;
import game.wall.VLine;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    VLine line1;
    HLine line;
    Map1 map1;

    public GamePanel() {
        map1 = new Map1();
        player = GameObject.recycle(Player.class);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(181, 181, 255));
        g.fillRect(0, 0, 800, 600);
        GameObject.renderAll(g);
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 64;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > delay) {
                runAll();
                repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
        GameObject.runAll();
    }
}
