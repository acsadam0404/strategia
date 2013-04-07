package logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy singleton class, ami elv�gzi a loggerek f�jlba �r�s�t. K�l�n sz�lon fut, �gy nem terheli annyira a f� programot.
 * A regisztr�lt loggerek automatikusan loggolnak a f�jlukba bizonyos id�nk�nt.
 * 
 * @author �cs �d�m
 * 2012.06.28.
 */
public final class LoggerHandler {
	private List<Logger> loggers = new ArrayList<>();
	private boolean logging = false;
	private static final long rest = 5000L; /* mennyi ideig v�rjon logol�sok k�z�tt */

	LoggerHandler() {
		super();
	}

	/**
	 * A beregisztr�lt loggereknek automatikus logol�st tesz lehet�v�.
	 * @param al
	 */
	public final void register(Logger al) {
		if (!loggers.contains(al)) {
			loggers.add(al);
		}
	}

	/**
	 * A megadott loggert kiszedi a regisztr�lt loggerek k�z�l.
	 * @param al
	 */
	public final void unRegister(Logger al) {
		if (loggers.contains(al)) {
			al.close();
			loggers.remove(al);
		}
	}

	/**
	 * Elkezdi az automatikus logol�st. Le�ll�tani a stopLogging met�dussal lehet.
	 */
	public void startLogging() {
		logging = true;
		new LoggerThread().start();
	}

	/**
	 * Az automatikus logol�s befejez�se. �jraind�tani a startLogging met�dussal lehet.
	 */
	public void stopLogging() {
		for (Logger logger : loggers) {
			logger.close();
		}
		
		logging = false;
	}
	
	boolean isLogging() {
		return logging;
	}

	private class LoggerThread extends Thread {
		public LoggerThread() {
			super();
		}

		@Override
		public void run() {
			while (isLogging()) {
				try {
					Thread.sleep(rest);
					log();
				}
				catch (InterruptedException iEx) {
					iEx.printStackTrace();
				}
			}
		}


	}

	final void log() {
		for (Logger logger : loggers) {
			logger.log();
		}
	}
}
