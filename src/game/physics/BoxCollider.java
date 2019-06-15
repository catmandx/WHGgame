package game.physics;

import game.GameObject;
import game.Player;
import game.Vector2D;
import tklibs.Mathx;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D anchor;

    public  BoxCollider(Vector2D position, int width, int height){
        this.position = position;
        this.width = width;
        this.height = height;
        this.anchor = new Vector2D(0.5, 0.5);
    }
    public BoxCollider(GameObject master, int width, int height){
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }
    public boolean intersects(BoxCollider other) {
        return other.right() >= this.left() && other.left() <= this.right()
                && other.bot() >= this.top() && other.top() <= this.bot();
    }

    public String checkSides(BoxCollider other){
        if(intersects(other)){
            if (Math.abs(this.right()-other.right()) > Math.abs(this.left()-other.right())){
                return "left";
            }else if(Math.abs(this.left()-other.left())>Math.abs(this.right()-other.right())){
                return "right";
            }else{
                return "else";
            }
        }else{
            return null;
        }
    }
    public double top(){
        return position.y - anchor.y * height;
    }

    public double bot(){
        return top() + height;
    }

    public double left(){
        return position.x - anchor.x * width;
    }

    public double right(){
        return left() +width;
    }

    public static void main(String[] args) {
        BoxCollider line = new BoxCollider(new Vector2D(5,0), 0,10);

        BoxCollider box = new BoxCollider(new Vector2D(3,3), 5, 5);
        System.out.println(line.intersects(box));


    }
}
