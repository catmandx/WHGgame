package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program {

    public static void main(String[] args) {
	// write your code here
        JFrame window = new JFrame("WHG");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        window.add(panel);
        window.setPreferredSize(new Dimension(800, 600));
        window.pack();

        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }
            }
        });

        window.setVisible(true);
        panel.gameLoop();
    }
}
