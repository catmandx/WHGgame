package tklibs;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import game.GameObject;
import game.GamePanel;
import game.Scene.Game_over.GameoverScene;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AudioUtils extends Thread {
    private Clip clip;
    public static void main(String[] args) throws Exception {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("assets/Music/Back On Track (online-audio-converter.com).wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        Thread.sleep(100000);
    }

    public static Clip loadSound(String url) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            return clip;
        } catch (Exception ex) {
            return null;
        }
    }
//    public void play() {
//        try {
//            if (clip != null) {
//                new Thread() {
//                    public void run() {
//                        synchronized (clip) {
//                            clip.stop();
//                            clip.setFramePosition(0);
//                            clip.start();
//                        }
//                    }
//                }.start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void loop() {
//        try {
//            if (clip != null) {
//                new Thread() {
//                    public void run() {
//                        synchronized (clip) {
//                            clip.stop();
//                            clip.setFramePosition(0);
//                            clip.loop(Clip.LOOP_CONTINUOUSLY);
//                        }
//                    }
//                }.start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isActive(){
//        return clip.isActive();
//    }

}
