package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    public BufferedImage image;

    public SingleImageRenderer(BufferedImage image){
        this.image = image;
    }

    public SingleImageRenderer(String url){
        this(SpriteUtils.loadImage(url));
    }
    @Override
    public void render(Graphics g, GameObject master){
        if(image != null){
            this.drawImage(g, master, image);
        }
    }

}
