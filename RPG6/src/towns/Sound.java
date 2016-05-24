package towns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/** 
 * 
 * @author Khandaker Shayel  
 * 
 */

public class Sound 
{
	static AudioPlayer MGP = AudioPlayer.player;
	static AudioStream BGM;
	static AudioData MD;
	static ContinuousAudioDataStream loop = null;
	static InputStream townAudio;
	
	public static void audio(String resource)
	{
		try 
		{
			townAudio = new FileInputStream(resource);
			BGM = new AudioStream(townAudio);
			AudioPlayer.player.start(BGM);
			//MD = BGM.getData();
			//loop = new ContinuousAudioDataStream(MD);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MGP.start(loop);
	}
	
	public static void stopaudio()
	{
		AudioPlayer.player.stop(BGM);
	}
}
