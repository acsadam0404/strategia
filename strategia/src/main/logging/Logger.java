package logging;

import java.io.*;

/**
 * A loggerek base osztálya, minden logger ebbõl kell származzon. Ezzel a típussal dolgozik a LoggerFactory és a LoggerHandler is.
 *
 * @author Ács Ádám
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
	 * Egy object String értékét írja a logba 
	 * @param o Az írandó érték
	 */
	public void write(Object o) {
		cache.append(o);
	}

	/**
	 * Egy object String értékét és egy üres sort ír a logba 
	 * @param o Az írandó érték
	 */
	public void writeln(Object o) {
		cache.append(o);
		cache.append("\n");
	}

	/**
	 * Ha azonnali logolásra van szükség ezzel meglehet tenni. Ha nincs, jobb megoldás regisztrálni a loggert a Handlerhez.
	 */
	public void log() {
		try {
			fileWriter.write(cache.toString());
			fileWriter.flush();
			cache = new StringBuilder();
		}
		catch (IOException e) { /* üres */ }
	}
	
	/**
	 * Lezárja a loggert.
	 */
	public void close() {
		try {
			log();
			fileWriter.close();
		} catch (IOException ioEx) { /* üres */ }
	}
}
