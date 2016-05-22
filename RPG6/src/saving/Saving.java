package saving;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Saving {

    private Saving(){}

    public static void write(String tag, int field){
/*
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        bufferedWriter.append("<" + tag + ">" + value + "</" + tag + ">"+System.getProperty("line.separator"));
        bufferedWriter.close();*/
    }

    public static int read(String tag){
        int i = Save.currentSave;
        return 0;
    }
}
