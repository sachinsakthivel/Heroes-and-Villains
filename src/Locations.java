/**
 * Date: May 12th 2018
 * 
 * Locations class is parent class to all locations excluding the HomeBase/City.
 * 
 * This class provides locations attributes such as Names and whether the location has been 
 * discovered in the current City (level), and various methods related to traveling and Name.
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class Locations {
	
	/**
	 * Local String variable containing the Name of the Location.
	 */
	private String name;
	/**
	 * Local Boolean variable which determines if the location has already been discovered by 
	 * the User.
	 */
	boolean discovered;

	
	/**
	 * Constructor method for Locations class which sets the Name to String input 'buildingName'.
	 * The boolean variable 'discovered' is set to false by default.
	 * @param buildingName Input, String variable which determines the Name of the location.
	 */
	public Locations(String buildingName) {
		name = buildingName;
		discovered = false;
	}
	
	/**
	 * This method sets the Boolean variable 'discovered' to true when the location has been 
	 * visiited by the User.
	 */
	public void travelledto() {
		discovered = true;
	}
	
	/**
	 * This method returns the Name of a Location if it has been discovered.
	 * @return Returns String variable Name or "Destination: Unknown" depending on Boolean 
	 * variable 'discovered'.
	 */
	public String getName() {
		if (discovered) {
			return name;
		} else {
			return "Destination: Unknown";
		}
	}
	
	/**
	 * This method is used to check whether the User has previously traveled to the location by 
	 * returning the Boolean variable 'discovered'.
	 * @return Returns Boolean variable 'discovered'.
	 */
	public boolean goneTo() {
		return discovered;
	}
	
	/**
	 * This method is the parent method travel() for subclasses to travel to and from other locations. 
	 * @param game Input variable 'game' of type GameEnvironment.
	 */
	public void travel(GameEnvironment game) {
		
	}

}
