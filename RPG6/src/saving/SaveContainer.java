package saving;

import java.awt.*;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveContainer {

    public SaveContainer(Save save, Graphics2D g,int y){
        g.drawString(save.getSaveName(),50,y);
        g.drawString("HP: " + save.readField("HP"),55,y+12);

    }

}