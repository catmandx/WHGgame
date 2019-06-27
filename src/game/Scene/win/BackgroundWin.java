package game.Scene.win;

import game.GameObject;
import game.KeyEventPress;
import game.Scene.PlayScene;
import game.Scene.SceneManager;
import game.Settings;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;

import java.awt.*;

public class BackgroundWin extends GameObject {
    public BackgroundWin() {
        renderer = new AnimationRenderer("assets/Scene/Win",10, false);
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }
    @Override
    public void run() {
        super.run();
        this.checkChangeSence();
    }
    private int counter;
    private void checkChangeSence() {
        counter++;
        if(KeyEventPress.isAnyKeyPress && counter > 120) {
//            SceneManager.signNewScene(new PlayScene());
            System.exit(10);
        }
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        g.setColor(Color.MAGENTA);
        g.drawString("CONGRATULATIONS!!! YOU WIN!!!",200, 100);
        super.render(g);
    }
}
