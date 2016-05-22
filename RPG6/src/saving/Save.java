package saving;

import java.io.File;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Save {

    private String[] tags;
    private File file;
    public static int currentSave = 1;
    public Save(int saveNumber){
        //tags = SaveUtility.getAllTagsFromFile();
    }

    public static File getFile() {
        return file;
    }

    public int getTagField(String tag){
        return 0;
    }

    public boolean containsTag(String tag){
        for (String s :tags) {
            if (tag.equals(s))
                return true;
        }
        return false;
    }
}