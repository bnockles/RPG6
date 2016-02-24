package javaP;

import java.io.File;

/**
 *
 * @author pjuda
 */
public class Saver {
    
    File file;
    String savingTag;
    int ID;
    
    
    //MUST FIND CORRECT SAVE FILE FIRST
    public Saver(File saveTo,String TAG,int ID){
        file = saveTo;
        this.ID = ID;
        savingTag = TAG;
        
    }
    
    
    public void saveData(int data){
        
    }
    
    public void saveData(double data){
        
    }
    
    public void saveData(String data){
        
    }
    
    public void setTag(String TAG){
        savingTag = TAG;
    }

    
    
    
        
    
}
