package logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy singleton class, ami elvégzi a loggerek fájlba írását. Külön szálon fut, így nem terheli annyira a fõ programot.
 * A regisztrált loggerek automatikusan loggolnak a fájlukba bizonyos idõnként.
 * 
 * @author Ács Ádám
 * 2012.06.28.
 */
public final class LoggerHandler {
	private List<Logger> loggers = new ArrayList<>();
	private boolean logging = false;
	private static final long rest = 5000L; /* mennyi ideig várjon logolások között */

	LoggerHandler() {
		super();
	}

	/**
	 * A beregisztrált loggereknek automatikus logolást tesz lehetõvé.
	 * @param al
	 */
	public final void register(Logger al) {
		if (!loggers.contains(al)) {
			loggers.add(al);
		}
	}

	/**
	 * A megadott loggert kiszedi a regisztrált loggerek közül.
	 * @param al
	 */
	public final void unRegister(Logger al) {
		if (loggers.contains(al)) {
			al.close();
			loggers.remove(al);
		}
	}

	/**
	 * Elkezdi az automatikus logolást. Leállítani a stopLogging metódussal lehet.
	 */
	public void startLogging() {
		logging = true;
		new LoggerThread().start();
	}

	/**
	 * Az automatikus logolás befejezése. Újraindítani a startLogging metódussal lehet.
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
