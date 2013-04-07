package components.animation;

import java.awt.Image;

/**
 * egy képet és egy idõtartamot tárol
 * @author Ács Ádám
 * 2012.07.29.
 */
public class Scene{
	Image pic;
	long endTime;

	public Scene(Image pic, long endTime)
	{
		this.pic = pic;
		this.endTime = endTime;
	}
}