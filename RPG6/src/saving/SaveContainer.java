package saving;

import java.awt.*;

/**
 * Created by pjuda on 5/19/2016.
 */
public class SaveContainer {

    public SaveContainer(Save save, Graphics2D g,int y){
        g.drawString(save.getSaveName(),50,y);
        int field = 1;
        g.drawString("Name: " + save.readField("NAME"),55,y+field*12);
        field++;
        g.drawString("HP: " + save.readField("HP"),55,y+field*12);

    }

}