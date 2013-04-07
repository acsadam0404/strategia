package components.audio;

/**
 *
 * @author Peter Varga
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AudioData {

    private String fileName;
    private Map<String, String> sounds;
    
    public Map<String, String> getSounds() {
        return sounds;
    }

    public AudioData(String fileName) {
        this.fileName = fileName;
        sounds = new HashMap<>();
        init();
    }

    private final void init() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String key = br.readLine();
            String value = br.readLine();
            if (key != null && value != null) {
                while (null != key && null != value) {
                    sounds.put(key, value);
                    key = br.readLine();
                    value = br.readLine();
                }
                br.close();
            }
        } catch (FileNotFoundException fnfEx) {
            fnfEx.printStackTrace();
        } catch (IOException ioEx) {
        	ioEx.printStackTrace();
        }
    }
    
    protected void playSound(String name) {
        AudioMaker audioMaker = new AudioMaker();
        if(sounds.containsKey(name)){
            audioMaker.playSound(sounds.get(name));
        }
    }
}