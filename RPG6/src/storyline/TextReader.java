package storyline;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class TextReader {
	public static void main(String[] args) {
//		InputStream res = TextReader.class.getResourceAsStream("/test.txt");
	//	BufferedReader reader = new BufferedReader(new InputStreamReader(res));
		
//		String line = null;
//		
//		String dialogId = "hey";
////		boolean inDialog = false;
//		
//		try{
//			//((line = reader.readLine()) != null)
//			while ((line = reader.readLine()) != null) {
//				if(line.indexOf(dialogId+":") >= 0){
//					
//					
//					System.out.println(line.substring(line.indexOf(":")+1, line.indexOf(";")));
//				}
////				else{
////				System.out.println(line);
////				}
//			}
//
//			reader.close();
//		}
//		catch(Exception e){}	
		TextReader y = new TextReader("test");
		System.out.println(y.getDialogue("dialog_id"));
	}
	static InputStream res;
	
	public TextReader(String text){
		res = TextReader.class.getResourceAsStream("/"+text+".txt");
		
	}
	
	public static String getDialogue(String scene){
		BufferedReader reader = new BufferedReader(new InputStreamReader(res));
		String line = null;
		String returnString ="";
		int i = 0;
		try{
			//((line = reader.readLine()) != null)
			while ((line = reader.readLine()) != null) {
				if(line.indexOf(scene+":") >= 0){
					returnString = line.substring(line.indexOf(":")+1);
					if(line.indexOf(";") >= 0){
				
						returnString = line.substring(line.indexOf(":")+1, line.indexOf(";"));
					}else{
						while(line.indexOf(";") < 0){
							line = reader.readLine();
							returnString += " " + line;
						}
					}
				}	
			}
			reader.close();
			
			return returnString.substring(0, returnString.length()-1);
		}
		
		catch(Exception e){}	
		
		
		return "ya failed";
	}

}

