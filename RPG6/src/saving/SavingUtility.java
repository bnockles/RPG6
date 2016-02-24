package javaP;

import java.io.File;

/**
 *
 * @author pjuda
 */
public final class SavingUtility {
    
    
    private SavingUtility(){ }
    
    
    public static String[] getSaveFileNames(){
        return getSaveFileNames("")
    }
    
    public static String[] getSaveFileNames(String path){
         File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String[] fileList = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            fileList[i] = fileList[i].toString();
        }
        return fileList;
    }
    
    public static File initiateFile(){
        
        return null;
    }
            
            
}
