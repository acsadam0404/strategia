package components.animation;

import org.junit.Test;

public class AnimationTest {
    private Animation anim;
    
    @Test
    public void testAnimation()
    {
    	try {
    		anim = AnimationFactory.createAnimation("animations\\test\\animation.xml");
    	}
        catch (Exception e) {
        	e.printStackTrace();
        }
    }    
}
