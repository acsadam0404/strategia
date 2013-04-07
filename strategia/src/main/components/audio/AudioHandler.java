package components.audio;

/**
 *
 * @author Peter Varga
 */
import java.util.ArrayList;
import java.util.List;

public class AudioHandler {

    private List<AudioData> datas;

    public List<AudioData> getDatas() {
        return datas;
    }

    public AudioHandler(AudioData data) {
        datas = new ArrayList<>();
        datas.add(data);
    }

    public void playSound(String name) {       
        
    	AudioPlayer ap = new AudioPlayer(name);
    	Thread playerThread = new Thread(ap);
    	playerThread.start();
    }

    public void addData(AudioData data) {
        datas.add(data);
    }
    

    private class AudioPlayer implements Runnable {
    	String name = "";
    	public AudioPlayer(String name) {
    		this.name = name;
    	}
    	
		@Override
		public void run() {
			for (int i = 0; i < datas.size(); i++) {
				datas.get(i).playSound(name);
			}
		}
    }
}