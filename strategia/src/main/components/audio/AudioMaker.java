package components.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

/**
 * 
 * @author Peter Varga
 * 2012.07.14.
 */
public class AudioMaker {
	private final int BUFFER_SIZE = 128000;
	private File soundFile;
	private AudioInputStream audioStream;
	private AudioFormat audioFormat;
	private SourceDataLine sourceLine;

	public void playSound(String filename) {

		String strFilename = filename;

		try {
			soundFile = new File(strFilename);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			audioStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException uafEx) {
			uafEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
 
		audioFormat = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceLine.open(audioFormat);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

		sourceLine.start();

		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
		while (nBytesRead != -1) {
			try {
				nBytesRead = audioStream.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (nBytesRead >= 0) {
				sourceLine.write(abData, 0, nBytesRead);
			}
		}

		sourceLine.drain();
		sourceLine.close();
	}
}
