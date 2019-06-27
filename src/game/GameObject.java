package game;

import game.physics.BoxCollider;
import game.renderer.Renderer;
import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls){
        //1. findInactive >> if found >> reset >> return
        //2. if not found >> create new >> return
        E object  = findInactive(cls);
        if(object != null){
            object.reset();
            return object;
        }

        //cls = PLayer.class
        //cls.getConstructor().newInstance() ~ new PLayer()
        try {
            object = cls.getConstructor().newInstance();
            return object;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (cls.isAssignableFrom(object.getClass())
                    && !object.active) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        //E ~Enemy1 |Player|bullet....
        //cls ~ Enemy1.class | Player.class | Enemy1.class..
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                    && object.hitBox != null
                    && object.hitBox.intersects(hitBox)
                    && cls.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }


    public static void runAll() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void clearAll() {
        objects.clear();
    }

    //khai bao doi tuong
    public Vector2D position;
    public Renderer renderer;
    public Renderer borderRenderer;
    public Vector2D velocity;
    public BoxCollider hitBox;
    public boolean active;
    public Vector2D anchor; //vi tri tam anh

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        anchor = new Vector2D(0.5, 0.5);
        active = true;
    }

    public void render(Graphics g){
        if(renderer != null){
            renderer.render(g, this);
        }
        if(borderRenderer != null){
            g.setColor(Color.BLACK);
            ((Graphics2D) g).setStroke(new BasicStroke(2));
            borderRenderer.render(g, this);
        }
    }

    public void run() {
        position.add(velocity);
    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }
}
