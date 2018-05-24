/**
 * Date: May 14th 2018
 * 
 * This class is the parent class for all MiniGames.
 *  
 * miniGame class provides each minigame a String variable Name and Rules as attributes. 
 * 
 * @author Sachin Sakthivel and Sasiru Goonatillake
 *
 */

public class miniGame {
	
	/**
	 * String variable for Name of the minigame.
	 */
	private String gameName = "";
	/**
	 * String variable for Rules of the minigame.
	 */
	private String gameRules = "";
	
	
	/**
	 * Constructor method for class miniGame.
	 * Name and Rules are given using input String variables name and rules.
	 * @param name String variable of minigame Name.
	 * @param rules String variable of minigame Rules.
	 */
	public miniGame(String name, String rules) {
		setGameName(name);
		setGameRules(rules);
		
	}

	/**
	 * This method returns the Name of the minigame.
	 * @return Returns String variable gameName.
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * This method updates the Name of the miniGame using the String variable gameName.
	 * @param gameName Input String variable of minigame Name.
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * This method returns the Rules of the minigame.
	 * @return Returns String variable gameRules.
	 */
	public String getGameRules() {
		return gameRules;
	}

	/**
	 * This method updates the Rules of the miniGame using the String variable gameRules.
	 * @param gameRules Input String variable of minigame Rules.
	 */
	public void setGameRules(String gameRules) {
		this.gameRules = gameRules;
	}
	
	public String toString() {
		String output = new String("Chosen Game: "+ this.getGameName());
		output += "\n" + this.getGameRules();
		return output;
	}
	
	/**
	 * Parent method for minigames which allows the User to use a Hero to fight the villain using
	 * the specified minigame.
	 * @param hero Input Hero object, hero which plays the minigame.
	 * @return Returns false by default.
	 */
	public boolean play(Hero hero) {
		return false;
	}
	
	/**
	 * Parent method for minigames which allows a description of a minigame to be obtained for a 
	 * specific minigame. The description will be specified in each minigame.
	 * @return Returns String "Not Implemented Yet" by default.
	 */
	public String gameDescription() {
		return "Not Implemented Yet";
	}
	
	
	

}
