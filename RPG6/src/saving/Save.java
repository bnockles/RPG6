package saving;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Save {

    private String[] tags;
    public static int currentSave = 1;
    public Save(int saveNumber){
        tags = SaveUtility.getAllTagsFromFile();
    }

    public int getTagField(String tag){
        return 0;
    }
}
