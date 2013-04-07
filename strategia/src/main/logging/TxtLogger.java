package logging;

/**
 * Txt fájlba író logger.
 * 
 * @author Ács Ádám
 * 2012.06.28.
 */
public class TxtLogger extends Logger {
	protected TxtLogger(String fileName) {
		super(fileName);
	}
}
