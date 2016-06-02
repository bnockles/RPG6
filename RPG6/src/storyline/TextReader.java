import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class TextReader {
	public static void main(String[] args) {
	}
	static InputStream res;
	
	public TextReader(String text){
		res = TextReader.class.getResourceAsStream("/"+text+".txt");
		
	}
	
	public static String getDialogue(String scene){
		BufferedReader reader = new BufferedReader(new InputStreamReader(res));
		String line = null;
		String returnString ="";
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
		return"";
	}

}
