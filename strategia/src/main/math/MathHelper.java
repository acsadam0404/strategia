package math;

/**
 * 
 * @author Ács Ádám
 * 2012.07.15.
 */
public final class MathHelper {
	private MathHelper() {
		/* private ctor */
	}
	
	public static int clamp(int val, int min, int max) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		}
		
		return val;
	}
}
