package logging;

import java.util.HashMap;
import java.util.Map;

/**
 * Egy factory class, ami cacheli a loggereket, �gy ugyanaz a f�jl nem nyithat� meg k�tszer.
 * 
 * @author �cs �d�m
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
	 * Elkezdi az automatikus logol�st. Le�ll�tani a stopLogging met�dussal lehet.
	 */
	public static void startLogging() {
		lh.startLogging();
	}

	/**
	 * Az automatikus logol�s befejez�se. �jraind�tani a startLogging met�dussal lehet.
	 */
	public static void stopLogging() {
		lh.stopLogging();
	}
	
	/**
	 * L�trehoz egy, a megadott nev�, txt logger oszt�lyt. Ha m�r l�tezne ilyen, akkor visszaadja a cacheb�l, �gy csak egy l�tezhet.
	 * @param fileName a f�jl ahova logolni kell, kiterjeszt�s n�lk�l
	 * @return logger oszt�ly
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
	 * L�trehoz egy, a megadott nev�, xml logger oszt�lyt. Ha m�r l�tezne ilyen, akkor visszaadja a cacheb�l, �gy csak egy l�tezhet.
	 * @param fileName a f�jl ahova logolni kell, kiterjeszt�s n�lk�l
	 * @return logger oszt�ly
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
