package saving;

import directors.Game;
import directors.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveScreen extends Screen implements KeyListener{


    public SaveScreen(Game game) {
        super(game);

    }

    public void paintScreen(Graphics2D g2) {

    }

    public KeyListener getKeyListener() {
        return this;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
