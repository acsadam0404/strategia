package input;

/**
 * az eg�r gombjait reprezent�lja
 * @author �cs �d�m
 * 2012.07.19.
 */
public enum MouseButtons {
	LEFT(1),  MIDDLE(2), RIGHT(3);

	private int num;
	
	public int getNum() {
		return num;
	}

	public static int getCount() {
		return 3; /* egyel�re ez a megold�s van, nem szabad elfelejteni �t�rni, ha fenn megv�ltozik a dolog */
	}
	
	private MouseButtons(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "button: " + getNum();
	}
}
