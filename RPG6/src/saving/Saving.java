package saving;

import directors.Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Saving {


    private static Save save;

    private Saving(){}

    public static void write(String tag, int field) throws IOException {
        save = Game.getCurrentSave();
        if(save == null) {
            System.out.println("No Save Initialized");
            return;
        }
        FileWriter fw = new FileWriter(,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        bufferedWriter.append("<" + tag + ">" + value + "</" + tag + ">"+System.getProperty("line.separator"));
        bufferedWriter.close();
    }

    public static int read(String tag){
        int i = Save.currentSave;
        return 0;
    }
}
