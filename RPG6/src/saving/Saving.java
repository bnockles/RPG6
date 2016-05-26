package saving;

import directors.Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Saving {


    private static Save activeSave;

    private Saving(){}

    public static void write(String tag, String field){
        tag = tag.toUpperCase();
        if(!activeSave.containsTag(tag))
            activeSave.writeField(tag,field);
        else{
            activeSave.updateTag(tag,field);
        }
    }

    public static String read(String tag){
        return activeSave.readField(tag);
    }

    public static void initSavingClass(){
        activeSave = Game.getCurrentSave();
    }

}
