package Battles;

public interface Dialogue {
    
    
    //retrieves dialogue for battles only and ensures it are less than 50 characters 
    public String getBattleDialouge(int index);
    
    //retrieves length of battles dialogue array
    public int checkBattleDialogueLength();
    
    //if dialogue is 50 or more characters, then move remaining characters to proceeding index of battle array
    public void seperateDialogue();
    
}
