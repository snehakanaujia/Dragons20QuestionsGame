import javax.swing.JFrame;

/**
 * Creates the frame and runs the program for the restricted version of the Dragons 20 Questions game
 * @author Sneha Kanaujia
 *
 */
public class RestrictedDragonApplication {

	/**
	 * Sets the width of the frame to 900 pixels
	 */
    public static int FRAME_WIDTH = 900;
	
	/**
	 * Sets the height of the frame to 700 pixels
	 */
    public static int FRAME_HEIGHT = 700;

	/**
	 * Creates and draws the frame for the circles
	 * 
	 * @param args not used
	*/
    public static void main(String[] args)
    {
    		//Sets the title of the JFrame to "Here Be Dragons!"
		JFrame dragonFrame = new JFrame("Here Be Dragons!");
		
		//Adds DragonCV panel/object to JFrame
		dragonFrame.add(new DragonCV());
		//Sets JFrame dimensions and sets it to close when exited out of and makes it visible
		dragonFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		dragonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dragonFrame.setVisible(true);
    }
}
