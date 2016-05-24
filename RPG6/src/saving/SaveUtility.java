package saving;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveUtility {

    public static void main(String[] args){

    }

    public String pathToFolder(String directory){
        ClassLoader cl = getClass().getClassLoader();
        return new File(cl.getResource(directory).getFile()).getAbsolutePath();
    }

    public File[] filesInResourcesFolder(String directory){
        ClassLoader cl = getClass().getClassLoader();
        return new File(cl.getResource(directory).getFile()).listFiles();
    }

    public static ArrayList<Save> getAllSaves() throws IOException {
        SaveUtility util = new SaveUtility();
        File[] files = util.filesInResourcesFolder("saves");
        ArrayList<Save> saves = new ArrayList<Save>();
        for (File f :
                files) {
            saves.add(new Save(f.getName(),f));
        }
        return saves;
    }

    public static HashMap<String, String> retrieveSave(Save save) throws IOException {
        HashMap<String,String> tags = new HashMap<String,String>();
        Properties properties = new Properties();
        properties.load(new FileInputStream(save.getFile()));
        for (String key : properties.stringPropertyNames()) {
            tags.put(key, properties.getProperty(key));
        }
        return tags;
    }

    public static Save createNewSave(String saveName){
        SaveUtility util = new SaveUtility();
        File f = new File(util.pathToFolder("saves") + "/" + saveName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Save s = new Save(saveName,f);
            s.initNewSave();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
