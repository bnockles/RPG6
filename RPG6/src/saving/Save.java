package saving;

import characters.Hero;
import characters.HeroTeam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by pjuda on 5/19/2016.
 */
public class Save {

    private String saveName;
    private HashMap<String,String> tags;
    private File saveFile;
    private Hero hero;
    public Save(String saveName, File saveFile) throws IOException {
        this.saveName = saveName;
        hero = HeroTeam.getHero(HeroTeam.ZELDA);
        this.saveFile = saveFile;
        tags = SaveUtility.retrieveSave(this);
    }

    public File getFile() {
        return saveFile;
    }

    public String getSaveName() {
        return saveName;
    }

    public boolean containsTag(String tag){
        return tags.containsKey(tag.toUpperCase());
    }

    public String readField(String tag){
        return tags.get(tag.toUpperCase());
    }

    public void writeField(String tag, String field){
        tags.put(tag.toUpperCase(),field);
    }

    public void updateTag(String tag, String field){
        tags.replace(tag.toUpperCase(),field);
    }

    public void initNewSave() {
        this.writeField("NAME",hero.getName());
        this.writeField("HP", String.valueOf(hero.getHealth()));
        this.writeField("MANA", String.valueOf(hero.getMana()));
    }

    public void updateSave() {
        Properties properties = new Properties();

        for (HashMap.Entry<String,String> entry : tags.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        try {
            properties.store(new FileOutputStream(saveFile), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}