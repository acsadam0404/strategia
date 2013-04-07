package objects;

/**
 * aki ezt implementálja, kijelölhetõ lesz
 * @author Ács Ádám
 * 2012.07.19.
 */
public interface ISelectable {
	public void select();
	public boolean isSelected();
	public void deselect();
	public void setSelectable(boolean selectable);
	public void checkForSelection() ;
}
