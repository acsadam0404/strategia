package objects;

/**
 * aki ezt implement�lja, kijel�lhet� lesz
 * @author �cs �d�m
 * 2012.07.19.
 */
public interface ISelectable {
	public void select();
	public boolean isSelected();
	public void deselect();
	public void setSelectable(boolean selectable);
	public void checkForSelection() ;
}
