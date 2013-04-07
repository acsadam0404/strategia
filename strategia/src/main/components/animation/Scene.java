package components.animation;

import java.awt.Image;

/**
 * egy k�pet �s egy id�tartamot t�rol
 * @author �cs �d�m
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