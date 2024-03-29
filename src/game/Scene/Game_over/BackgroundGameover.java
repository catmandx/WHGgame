package game.Scene.Game_over;

import game.GameObject;
import game.KeyEventPress;
import game.Scene.PlayScene;
import game.Scene.Scene;
import game.Scene.SceneManager;
import game.Settings;
import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;

import java.awt.*;
import java.util.Set;

public class BackgroundGameover extends GameObject {
    public BackgroundGameover() {
        renderer = new SingleImageRenderer("assets/Scene/1.jpg");
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
        this.checkChangeScene();
    }

    int count = 0;

    public void checkChangeScene() {
        count++;
        if (KeyEventPress.isAnyKeyPress && count > 30) {
            SceneManager.signNewScene(new PlayScene());
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0,0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        super.render(g);
    }
}
