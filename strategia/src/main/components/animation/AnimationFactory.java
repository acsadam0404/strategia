package components.animation;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FIXME  staticokkal csak a baj van
 * @author Szemõk Balázs
 * 2012.07.29.
 */
public class AnimationFactory
{
    protected static int width;
    protected static int height;
    protected static int count;
    protected static int perrow;
    protected static int rows;
    protected static int cols;
    protected static int posX;
    protected static int posY;
    protected static String mode;
    protected static String extension;
    protected static String file;
    protected static List<Image> images = new ArrayList<>();

    public static Animation createAnimation(String fileName) {
    	try {
    		images.clear();
	        StaXParser parser = new StaXParser();
	        parser.readConfig(fileName);
	        
	
	        Animation anim = new Animation();
	        for (int i = 0; i < images.size(); i++) {
	            anim.addScene(images.get(i), 200); /* XXX itt a 200 az animáció sebessége */
			}
        
	        
	        
	        return anim;
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return null;
    
    }
    
}
