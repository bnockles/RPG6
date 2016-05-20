package saving;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveUtility {

    public static void main(String[] args){
        SaveUtility obj = new SaveUtility();
        obj.findPath();
    }

    private void findPath(){
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource("saves").getFile());
        for (File f :
                file.listFiles()) {
            System.out.println(f.getName());
        }
    }


    public static String[] getAllTagsFromFile(File f){
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> tags = new ArrayList<String>();
        while(in.hasNext()) {
            String line = in.nextLine();

            //Relocate to a function
            String tag = line.substring(line.indexOf("<"),line.indexOf(">"));

        }
        return null;
    }
}
