package input;

/**
 * az egér gombjait reprezentálja
 * @author Ács Ádám
 * 2012.07.19.
 */
public enum MouseButtons {
	LEFT(1),  MIDDLE(2), RIGHT(3);

	private int num;
	
	public int getNum() {
		return num;
	}

	public static int getCount() {
		return 3; /* egyelõre ez a megoldás van, nem szabad elfelejteni átírni, ha fenn megváltozik a dolog */
	}
	
	private MouseButtons(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "button: " + getNum();
	}
}
