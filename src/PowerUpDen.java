/**
 * Date: May 22nd 2018
 * 
 * This class creates Location, Power Up Den.
 * [Most of the class has been moved to the GUI element 'PowerUpDenSCREN' which interacts with 
 * the user as the Power Up Den.]
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */
public class PowerUpDen extends Locations{
	
	/**
	 * Constructor method for PowerUpDen.
	 * Sets the locations Name to "Power Up Den" using parent class, Locations.
	 */
	public PowerUpDen() {
		super("Power Up Den");
	}
	
	public void travel(GameEnvironment game) {
		travelledto();
		game.launchPowerUpSCREEN(game.getHomeBase());
	}


}
