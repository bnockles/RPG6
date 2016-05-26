package saving;

import characters.CharacterScreen;
import directors.Game;
import directors.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveScreen extends Screen implements KeyListener{

    private Game game;
    private ArrayList<Save> saveList;
    private int select;
    private int newSave;

    public SaveScreen(Game game) throws IOException {
        super(game);
        this.game = game;
        saveList = SaveUtility.getAllSaves();
        select = 1;
        newSave = saveList.size() + 1;
    }

    public void paintScreen(Graphics2D g2) {
        int y = 100;
        for (Save s :
                saveList) {
            new SaveContainer(s,g2,y);
            y+= 100;
        }
        if(select!= saveList.size()+1) {
            g2.drawLine(20,select*100 - 5,45,select*100 - 5);
        }
        else{
            g2.drawLine(400, 100-5, 435,100-5);
        }
        createSaveOption(g2);
    }

    private void createSaveOption(Graphics2D g2) {
        g2.drawString("Create New Character", 450, 100);
    }

    public KeyListener getKeyListener() {
        return this;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(select> 1)
                    select--;
                break;
            case KeyEvent.VK_DOWN:
                if(select < saveList.size() + 1)
                    select++;
                break;
            case KeyEvent.VK_ENTER:
                if(select == newSave) {
                    select--;
                    newSave++;
                    game.setCurrentSave(SaveUtility.createNewSave("Save" + (saveList.size() + 1)));
                    Saving.initSavingClass();
                    game.setScreen(new CharacterScreen(game));
                }
                else{
                    game.setCurrentSave(saveList.get(select-1));
                    Saving.initSavingClass();
                    game.setScreen(new CharacterScreen(game));
                }
                break;
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}
