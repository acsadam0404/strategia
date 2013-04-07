package components.audio;

import components.audio.AudioHandlerTest;
import components.audio.AudioData;

import org.junit.Test;
/**
 *
 * @author Peter Varga
 */
public class AudioHandlerTest {
      
    private AudioData audioData;
    private AudioData audioData2;
    private AudioHandler audioHandler;
    
    @Test
    public void test(){
        audioData = new AudioData("sounddata\\test\\2.txt");
        //System.out.println("Main(): " + audioData.getSounds().keySet() + " " + audioData.getSounds().values());
        //audioData.playSound("scream");
	
        audioHandler = new AudioHandler(audioData);
	//audioHandler.playSound("fuck"); //és erre mondjuk lejátszik egy sikolyt
        
        audioData2 = new AudioData("sounddata\\test\\1.txt");
        //System.out.println("Main(): " + audioData2.getSounds().keySet() + " " + audioData2.getSounds().values());
        //audioData2.playSound("kill2");
        
        audioHandler.addData(audioData2);
        audioHandler.playSound("walk");
        
        for (int i = 0; i < audioHandler.getDatas().size(); i++) {
            System.out.println("audioHandler 1.txt + 2.txt: " + audioHandler.getDatas().get(i).getSounds().keySet() + " " + audioHandler.getDatas().get(i).getSounds().values());            
        }
    }
    
    public static void main(String[] args) throws Exception {
        AudioHandlerTest test = new AudioHandlerTest();
    }
}
