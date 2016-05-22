package saving;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveUtility {

    public static void main(String[] args){
        try {
            addTag(new File("RPG6\\resources\\saves\\Save1.txt"),"HP", 101);
            System.out.println("added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File[] allSaveFiles(){
        ClassLoader cl = getClass().getClassLoader();
        return new File(cl.getResource("saves").getFile()).listFiles();
    }

    private static File[] savesInResources(){
        File f = new File("hello");
        return null;
    }


    private static Save[] getAllSaves(){
        SaveUtility util = new SaveUtility();
        File[] files = util.allSaveFiles();
        ArrayList<Save> saves = new ArrayList<>();
        for (File f :
                files) {
            saves.add(new Save(1));
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
            String tag = line.substring(line.indexOf("<")+1,line.indexOf(">"));

        }
        return null;
    }

    public static void addTag(File f,String tag,int value) throws IOException {
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        bufferedWriter.append("<" + tag + ">" + value + "</" + tag + ">"+System.getProperty("line.separator"));
        bufferedWriter.close();
    }
}
