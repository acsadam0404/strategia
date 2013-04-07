package logging;

import java.io.*;

/**
 * A loggerek base oszt�lya, minden logger ebb�l kell sz�rmazzon. Ezzel a t�pussal dolgozik a LoggerFactory �s a LoggerHandler is.
 *
 * @author �cs �d�m
 * 2012.06.28.
 */
public abstract class Logger {
	public static final String DEFAULT_DIRECTORY = "logs";
	protected String fileName = "";
	protected StringBuilder cache = new StringBuilder();
	protected FileWriter fileWriter;

	protected Logger(String fileName) {
		this.fileName = fileName;
		File file = new File(DEFAULT_DIRECTORY + "\\" + fileName);
		file.getParentFile().mkdirs();
		
		try {
			fileWriter = new FileWriter(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Egy object String �rt�k�t �rja a logba 
	 * @param o Az �rand� �rt�k
	 */
	public void write(Object o) {
		cache.append(o);
	}

	/**
	 * Egy object String �rt�k�t �s egy �res sort �r a logba 
	 * @param o Az �rand� �rt�k
	 */
	public void writeln(Object o) {
		cache.append(o);
		cache.append("\n");
	}

	/**
	 * Ha azonnali logol�sra van sz�ks�g ezzel meglehet tenni. Ha nincs, jobb megold�s regisztr�lni a loggert a Handlerhez.
	 */
	public void log() {
		try {
			fileWriter.write(cache.toString());
			fileWriter.flush();
			cache = new StringBuilder();
		}
		catch (IOException e) { /* �res */ }
	}
	
	/**
	 * Lez�rja a loggert.
	 */
	public void close() {
		try {
			log();
			fileWriter.close();
		} catch (IOException ioEx) { /* �res */ }
	}
}
