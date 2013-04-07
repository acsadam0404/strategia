package logging;

import java.util.HashMap;
import java.util.Map;

/**
 * Egy factory class, ami cacheli a loggereket, így ugyanaz a fájl nem nyitható meg kétszer.
 * 
 * @author Ács Ádám
 * 2012.06.28.
 */
public final class LoggerFactory {
	private static Map<String, Logger> loggers = new HashMap<>();
	private static final String TXT = ".txt";
	private static final String XML = ".xml";

	private static LoggerHandler lh = new LoggerHandler();
	
	private LoggerFactory() {
		super();
	}

	/**
	 * Elkezdi az automatikus logolást. Leállítani a stopLogging metódussal lehet.
	 */
	public static void startLogging() {
		lh.startLogging();
	}

	/**
	 * Az automatikus logolás befejezése. Újraindítani a startLogging metódussal lehet.
	 */
	public static void stopLogging() {
		lh.stopLogging();
	}
	
	/**
	 * Létrehoz egy, a megadott nevû, txt logger osztályt. Ha már létezne ilyen, akkor visszaadja a cachebõl, így csak egy létezhet.
	 * @param fileName a fájl ahova logolni kell, kiterjesztés nélkül
	 * @return logger osztály
	 */
	public static final Logger createTxtLogger(String fileName) {
		String fullName = fileName + TXT;
		if (loggers.containsKey(fullName)) {
			return loggers.get(fullName);
		}
		
		Logger logger = new TxtLogger(fullName);
		loggers.put(fullName, logger);
		lh.register(logger);
		return logger;
	}

	/**
	 * Létrehoz egy, a megadott nevû, xml logger osztályt. Ha már létezne ilyen, akkor visszaadja a cachebõl, így csak egy létezhet.
	 * @param fileName a fájl ahova logolni kell, kiterjesztés nélkül
	 * @return logger osztály
	 */
	public static final Logger createXmlLogger(String fileName) {
		String fullName = fileName + XML;
		if (loggers.containsKey(fullName)) {
			return loggers.get(fullName);
		}
		
		Logger logger = new XmlLogger(fullName);
		loggers.put(fullName, logger);
		lh.register(logger);
		return logger;
	}
}
