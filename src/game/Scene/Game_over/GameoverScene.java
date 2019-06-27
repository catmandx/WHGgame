package game.Scene.Game_over;

import game.GameObject;
import game.Scene.Scene;
import game.Scene.SceneManager;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class GameoverScene extends Scene {
    Clip music;
    @Override
    public void init() {
        music = AudioUtils.loadSound("assets/Music/deep-voice-game-over_z1dCUBEu (online-audio-converter.com).wav");
        music.loop(Clip.LOOP_CONTINUOUSLY);
        GameObject.recycle(BackgroundGameover.class);
    }
    @Override
    public void clear() {
        music.stop();
        GameObject.clearAll();
    }
}
