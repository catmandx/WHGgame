package game.Scene.Welcome;

import game.Background;
import game.GameObject;
import game.KeyEventPress;
import game.Scene.PlayScene;
import game.Scene.Scene;
import game.Scene.SceneManager;
import game.Settings;
import game.renderer.AnimationRenderer;
import game.renderer.BoxRenderer;
import game.renderer.Renderer;
import game.renderer.SingleImageRenderer;

import java.awt.*;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome() {
        renderer = new SingleImageRenderer("assets/Scene/643x0w.png");
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }
    @Override
    public void run() {
        super.run();
        this.checkChangeSence();
    }

    private void checkChangeSence() {
        if(KeyEventPress.isAnyKeyPress) {
            SceneManager.signNewScene(new PlayScene() {
            });

            }
        }
    }

