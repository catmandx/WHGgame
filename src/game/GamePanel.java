package game;

import game.Scene.SceneManager;
import game.Scene.Welcome.WelcomeScene;
import game.map.*;
import game.map.MapManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        SceneManager.signNewScene(new WelcomeScene());
        MapManager.currentMap = new Map0();
    }

    public void paint(Graphics g) {
        g.setColor(new Color(181, 181, 255));
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("DEATHS: "+Settings.NUMBER_OF_DEATHS, 100, 100);
//        g.drawString("Press I to be Immortal", 300, 100);
//        g.drawString("Press P to skip level", 300, 50);
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
