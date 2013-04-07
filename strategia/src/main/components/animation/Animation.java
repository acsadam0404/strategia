package components.animation;

import java.awt.*;
import java.util.ArrayList;

import objects.GameObject;
import objects.IGameLoop;

/**
 * 
 * @author �cs �d�m
 * 2012.07.12.
 */
public class Animation implements IGameLoop {
	private ArrayList<Scene> scenes = new ArrayList<>(); //jelenetek lista

	private int sceneIndex;
	private long movieTime;
	private long totalTime;

	private GameObject container; /* XXX XXX nem biztos hogy �gy k�ne kommunik�lni, lehet ink�bb csak post �s sizeot k�ne �tvennie t�le */

	public Animation() {
		super();
	}
	
	public void setContainer(GameObject container) {
		this.container = container;
	}

	//hozz�ad egy jelenetet a jelenet list�hoz
	//a jelenet tulajdonk�ppen egy k�p �s egy id�tartam
	public synchronized void addScene(Image i, long t)
	{
		totalTime += t;
		scenes.add(new Scene(i, totalTime));
	}

	//be�ll�tja az anim�ci�t az elej�re
	public synchronized final void start()
	{
		movieTime = 0;
		sceneIndex = 0;
	}

	//visszaadja a k�pet
	public synchronized Image getImage()
	{
		if (scenes.size() == 0)
			return null;
		return getScene(sceneIndex).pic;
	}

	//visszaadja a scene lista x. elem�t
	private Scene getScene(int x) {
		return scenes.get(x);
	}

	@Override
	public void init() {
		start();
	}

	@Override
	public void update(long gameTime) {
		if (scenes.size() > 1){
			movieTime += gameTime;

			if (movieTime >= totalTime){
				movieTime = 0;
				sceneIndex = 0;
			}

			while (movieTime > getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getImage(), container.getScreenPos().getX(), container.getScreenPos().getY(), null);
	}
}
