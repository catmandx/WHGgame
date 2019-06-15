package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //quan li doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        anchor = new Vector2D(0.5,0.5);
    }

    public static <E extends GameObject> E findInactive(Class<E> cls){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(object.getClass())
                    && !object.active){
                return (E) object;
            }
        }
        return null;
    }
    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox){
        //E ~Enemy |Player|bullet....
        //cls ~ Enemy.class | Player.class | Enemy.class..
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active
                    && object.hitBox != null
                    && object.hitBox.intersects(hitBox)
                    && cls.isAssignableFrom(object.getClass())){
                return (E) object;
            }
        }
        return null;
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
    }

    public static void runAll(){
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).run();
        }
    }

    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox;
    public boolean active;
    public Vector2D anchor; //vi tri tam anh

    public void paint(Graphics g) {
    }

    public void run(){
        position.add(velocity);
    }
}
